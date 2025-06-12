import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeParseException;

public class edit_pengembalian extends JDialog {
    JTextField tfIdAnggota, tfNama, tfJudulBuku, tfTanggalPinjam;
    JTextField tfTanggalKembali, tfLamaKeterlambatan, tfDenda;
    JComboBox<String> cbStatus;
    JButton btnSimpan;

    Connection conn;
    int idPeminjaman;
    LocalDate tanggalPinjam;
    final int DENDA_PER_HARI = 5000;

    public edit_pengembalian(Frame parent, boolean modal, String id_peminjaman) {
        super(parent, "Form Pengembalian", modal);
        this.idPeminjaman = Integer.parseInt(id_peminjaman);

        tfIdAnggota = new JTextField(); tfIdAnggota.setEditable(false);
        tfNama = new JTextField(); tfNama.setEditable(false);
        tfJudulBuku = new JTextField(); tfJudulBuku.setEditable(false);
        tfTanggalPinjam = new JTextField(); tfTanggalPinjam.setEditable(false);
        tfTanggalKembali = new JTextField();
        tfLamaKeterlambatan = new JTextField(); tfLamaKeterlambatan.setEditable(false);
        tfDenda = new JTextField(); tfDenda.setEditable(false);
        cbStatus = new JComboBox<>(new String[]{"Tepat Waktu", "Terlambat"});
        btnSimpan = new JButton("Simpan");

        try {
            conn = new database.dbconnection().configDB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal koneksi database: " + e.getMessage());
        }

        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelUtama.setBackground(Color.WHITE);

        JPanel panelGrid = new JPanel(new GridLayout(1, 2, 30, 0));
        panelGrid.setOpaque(false);

        JPanel panelKiri = new JPanel(new GridLayout(4, 1, 10, 10));
        JPanel panelKanan = new JPanel(new GridLayout(4, 1, 10, 10));
        panelKiri.setOpaque(false);
        panelKanan.setOpaque(false);

        panelKiri.add(createLabeledField("ID Anggota:", tfIdAnggota));
        panelKiri.add(createLabeledField("Nama:", tfNama));
        panelKiri.add(createLabeledField("Judul Buku:", tfJudulBuku));
        panelKiri.add(createLabeledField("Tanggal Peminjaman:", tfTanggalPinjam));

        panelKanan.add(createLabeledField("Tanggal Pengembalian (YYYY-MM-DD):", tfTanggalKembali));
        panelKanan.add(createLabeledField("Status:", cbStatus));
        panelKanan.add(createLabeledField("Lama Keterlambatan (hari):", tfLamaKeterlambatan));
        panelKanan.add(createLabeledField("Denda (Rp):", tfDenda));

        panelGrid.add(panelKiri);
        panelGrid.add(panelKanan);

        JPanel panelTombol = new JPanel();
        panelTombol.setOpaque(false);
        panelTombol.add(btnSimpan);

        panelUtama.add(panelGrid, BorderLayout.CENTER);
        panelUtama.add(panelTombol, BorderLayout.SOUTH);

        setContentPane(panelUtama);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(parent);

        loadData();
        tfTanggalKembali.addActionListener(e -> hitungKeterlambatan());
        tfTanggalKembali.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                hitungKeterlambatan();
            }
        });
        btnSimpan.addActionListener(e -> simpanPengembalian());

        setVisible(true);
    }

    private JPanel createLabeledField(String label, Component field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setOpaque(false);
        JLabel lbl = new JLabel(label);
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    void loadData() {
        try {
            String sql = "SELECT a.id_anggota, ag.nama, b.judul, a.tanggal " +
                         "FROM peminjaman a JOIN anggota ag ON a.id_anggota = ag.id_anggota " +
                         "JOIN buku b ON a.judul = b.judul WHERE a.id_peminjaman = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPeminjaman);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tfIdAnggota.setText(rs.getString("id_anggota"));
                tfNama.setText(rs.getString("nama"));
                tfJudulBuku.setText(rs.getString("judul"));
                String tgl = rs.getString("tanggal");
                tfTanggalPinjam.setText(tgl);
                tanggalPinjam = LocalDate.parse(tgl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        }
    }

    void hitungKeterlambatan() {
        try {
            String input = tfTanggalKembali.getText().trim();
            if (input.isEmpty()) return;

            LocalDate tanggalKembali = LocalDate.parse(input);
            if (tanggalKembali.isBefore(tanggalPinjam)) {
                JOptionPane.showMessageDialog(this, "Tanggal pengembalian tidak boleh sebelum tanggal pinjam.");
                return;
            }

            long selisih = Duration.between(tanggalPinjam.atStartOfDay(), tanggalKembali.atStartOfDay()).toDays();

            if (selisih <= 7) {
                tfLamaKeterlambatan.setText("0");
                tfDenda.setText("0");
                cbStatus.setSelectedItem("Tepat Waktu");
            } else {
                long terlambat = selisih - 7;
                tfLamaKeterlambatan.setText(String.valueOf(terlambat));
                tfDenda.setText(String.valueOf(terlambat * DENDA_PER_HARI));
                cbStatus.setSelectedItem("Terlambat");
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid. Gunakan format YYYY-MM-DD.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghitung keterlambatan: " + e.getMessage());
        }
    }

    void simpanPengembalian() {
        try {
            String tanggalKembali = tfTanggalKembali.getText().trim();
            if (tanggalKembali.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tanggal pengembalian harus diisi.");
                return;
            }

            String status = cbStatus.getSelectedItem().toString();
            int lama = Integer.parseInt(tfLamaKeterlambatan.getText().trim());
            int denda = Integer.parseInt(tfDenda.getText().trim());

            String sql = "INSERT INTO pengembalian (id_peminjaman, tanggal_pengembalian, status_pengembalian, lama_keterlambatan, denda) " +
                         "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPeminjaman);
            ps.setString(2, tanggalKembali);
            ps.setString(3, status);
            ps.setInt(4, lama);
            ps.setInt(5, denda);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data pengembalian berhasil disimpan.");
                dispose(); // Ini menutup JDialog setelah berhasil simpan
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat menyimpan: " + e.getMessage());
        }
    }
}
