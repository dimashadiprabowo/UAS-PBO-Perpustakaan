import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class edit_peminjaman extends javax.swing.JDialog {
    
    private static Point point = new Point();
    
    DefaultTableModel tbl1 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel tbl2 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public edit_peminjaman(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
 
        try {
    Connection con = new database.dbconnection().configDB();
    String sql = "SELECT * FROM peminjaman WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, id);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        id_anggota.setText(rs.getString("id_anggota"));
        nama.setText(rs.getString("nama"));
        kode.setText(rs.getString("kode"));
        judul.setText(rs.getString("judul"));
        jenis.setSelectedItem(rs.getString("jenis")); // pastikan jenis disimpan sebagai teks
        tanggal.setText(rs.getString("tanggal"));
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Gagal mengambil data!\n" + e.getMessage());
}
        
        setSize(760, 578);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
        
        initComponents();
                
        id_anggota.setEnabled(false);
        nama.setEnabled(false);
        kode.setEnabled(false);
        judul.setEnabled(false);
        jenis.setEnabled(false);
        id_peminjaman.setVisible(false);
        
        tampil_data(id);
        tampil_buku();
        tampil_anggota();
    }
    
    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_anggota = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_buku = new javax.swing.JTable();
        cari_anggota = new placeholder.cari_anggota();
        cari_buku = new placeholder.cari_buku();
        data_anggota = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        data_buku = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        id_peminjaman = new javax.swing.JLabel();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();
        reset_btn = new javax.swing.JPanel();
        reset = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        header.setBackground(new java.awt.Color(120, 195, 250));
        header.setPreferredSize(new java.awt.Dimension(718, 47));

        close_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); 
        close_btn.setText("×");
        close_btn.setToolTipText("Keluar?");
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btnMouseClicked(evt);
            }
        });
        close_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                close_btnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
        );

        tbl_anggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Anggota", "Nama"
            }
        ));
        tbl_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_anggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_anggota);

        tbl_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Tanggal Terbit"
            }
        ));
        tbl_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_buku);

        cari_anggota.setToolTipText("Cari Anggota");
        cari_anggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_anggotaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cari_anggotaKeyTyped(evt);
            }
        });

        cari_buku.setToolTipText("Cari Buku");
        cari_buku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_bukuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cari_bukuKeyTyped(evt);
            }
        });

        data_anggota.setBackground(new java.awt.Color(255, 255, 255));
        data_anggota.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Anggota"));

        jLabel1.setText("ID Anggota");

        id_anggota.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Nama");

        nama.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout data_anggotaLayout = new javax.swing.GroupLayout(data_anggota);
        data_anggota.setLayout(data_anggotaLayout);
        data_anggotaLayout.setHorizontalGroup(
            data_anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(id_anggota)
            .addComponent(nama)
            .addGroup(data_anggotaLayout.createSequentialGroup()
                .addGroup(data_anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        data_anggotaLayout.setVerticalGroup(
            data_anggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_anggotaLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_buku.setBackground(new java.awt.Color(255, 255, 255));
        data_buku.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Buku"));

        jLabel4.setText("Kode Buku");

        kode.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Jenis Buku");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensiklopedia", "Novel", "Komik", "Biografi", "Dongeng", "Karya Ilmiah" }));

        jLabel6.setText("Judul Buku");

        judul.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Tanggal Peminjaman (YYYY-MM-DD)");

        javax.swing.GroupLayout data_bukuLayout = new javax.swing.GroupLayout(data_buku);
        data_buku.setLayout(data_bukuLayout);
        data_bukuLayout.setHorizontalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kode)
            .addComponent(jenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(judul)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_bukuLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_peminjaman))
                    .addGroup(data_bukuLayout.createSequentialGroup()
                        .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tanggal)
        );
        data_bukuLayout.setVerticalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Simpan");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout save_btnLayout = new javax.swing.GroupLayout(save_btn);
        save_btn.setLayout(save_btnLayout);
        save_btnLayout.setHorizontalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        reset_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        reset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reset.setText("Reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout reset_btnLayout = new javax.swing.GroupLayout(reset_btn);
        reset_btn.setLayout(reset_btnLayout);
        reset_btnLayout.setHorizontalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reset_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        reset_btnLayout.setVerticalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reset_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari_anggota)
                    .addComponent(cari_buku)
                    .addComponent(data_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(cari_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        data_anggota.getAccessibleContext().setAccessibleName("Ubah Data");
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {                                  
        save();
    }                                 

    private void cari_bukuKeyTyped(java.awt.event.KeyEvent evt) {                                   
        search_book();
    }                                  

    private void cari_bukuKeyPressed(java.awt.event.KeyEvent evt) {                                     
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_book();
        }
    }                                    

    private void cari_anggotaKeyTyped(java.awt.event.KeyEvent evt) {                                    
        search_anggota();
    }                                   

    private void cari_anggotaKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_anggota();
        }
    }                                     

    private void tbl_anggotaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        clicktbl_anggota();
    }                                      

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {                                     
        this.setVisible(false);
    }                                    

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.setVisible(false);
    }                                      

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {                                   
        String id = id_peminjaman.getText();
        tampil_data(id);
    }                                  

    private void tbl_bukuMouseClicked(java.awt.event.MouseEvent evt) {                                      
        clicktbl_buku();
    }                                     

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                edit_peminjaman dialog = new edit_peminjaman(new javax.swing.JFrame(), true, 0+"");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void tampil_data(String id) {
        id_peminjaman.setText(id);
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM peminjaman WHERE id = '"+id+"'";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                id_anggota.setText(rs.getString("ID Anggota"));
                nama.setText(rs.getString("nama"));
                kode.setText(rs.getString("kode"));
                judul.setText(rs.getString("judul"));
                tanggal.setText(rs.getString("tanggal"));
                
                try {
                    String sql2 = "SELECT * FROM buku WHERE kode = '"+rs.getString("kode")+"'";
                    java.sql.ResultSet hasil = st.executeQuery(sql2);
                    
                    if (hasil.next()) {
                        jenis.setSelectedIndex(hasil.getInt("jenis")-1);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void tampil_buku() {
        Object []baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_buku.setModel(tbl1);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku ORDER BY id ASC";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String kode = rs.getString("kode");
                String judul = rs.getString("judul");
                String tanggal = rs.getString("tanggal");
                
                String[] data = {kode, judul, tanggal};
                tbl1.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void tampil_anggota() {
        Object []baris = {"ID Anggota", "Nama"};
        tbl2 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_anggota.setModel(tbl2);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM anggota ORDER BY id ASC";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String id_anggota = rs.getString("ID Anggota");
                String nama = rs.getString("nama");
                
                String[] data = {id_anggota, nama};
                tbl2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void search_book() {
        String query = cari_buku.getText();
        
        Object []baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_buku.setModel(tbl1);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku WHERE BINARY "
                    + "kode LIKE '%"+query+"%' "
                    + "OR judul LIKE '%"+query+"%' "
                    + "OR tanggal LIKE '%"+query+"%' "
                    + "OR pengarang LIKE '%"+query+"%' "
                    + "ORDER BY id ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String kode = hasil.getString("kode");
                String judul = hasil.getString("judul");
                String tanggal = hasil.getString("tanggal");
                
                String[] data = {kode, judul, tanggal};
                tbl1.addRow(data);
            }
        } catch (Exception e) {}
    }
    
    private void search_anggota() {
        String query = cari_anggota.getText();
        
        Object []baris = {"ID Anggota", "Nama"};
        tbl2 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl_anggota.setModel(tbl2);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM anggota WHERE BINARY "
                    + "ID Anggota LIKE '%"+query+"%' "
                    + "OR nama LIKE '%"+query+"%' "
                    + "ORDER BY id ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String id_anggota = hasil.getString("ID Anggota");
                String nama = hasil.getString("nama");  
                
                String[] data = {id_anggota, nama};
                tbl2.addRow(data);
            }
        } catch (Exception e) {}
    }
    
    private void clicktbl_anggota() {
        int baris = tbl_anggota.getSelectedRow();
        
        id_anggota.setText((String)tbl2.getValueAt(baris, 0));
        nama.setText((String)tbl2.getValueAt(baris, 1));
    }
    
    private void clicktbl_buku() {
        int baris = tbl_buku.getSelectedRow();
        
        kode.setText((String)tbl1.getValueAt(baris, 0));
        judul.setText((String)tbl1.getValueAt(baris, 1));
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku WHERE kode = '"+(String)tbl1.getValueAt(baris, 0)+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()) {
                jenis.setSelectedIndex(rs.getInt("jenis")-1);
            }
            
        } catch (Exception e) {}
    }
    
    private void save() {
        String id, getid_anggota, getnama, getkode, getjudul, gettanggal;
        
        getid_anggota = id_anggota.getText();
        getnama = nama.getText();
        getkode = kode.getText();
        getjudul = judul.getText();
        gettanggal = tanggal.getText();
        
        id = id_peminjaman.getText();
        
        if (!empty(gettanggal)) {
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "UPDATE peminjaman SET id_anggota = ?, nama = ?, kode = ?, judul = ?, tanggal = ? WHERE id = '"+id+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, getid_anggota);
                stat.setString(2, getnama);
                stat.setString(3, getkode);
                stat.setString(4, getjudul);
                stat.setString(5, gettanggal);
                stat.executeUpdate();
                
                int affected = stat.executeUpdate();
                if (affected > 0) {
                this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID tidak ditemukan. Data tidak diubah.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }

                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL Mengubah Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan masukkan Tanggal Peminjaman!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
                  
    private javax.swing.JPanel body;
    private javax.swing.JTextField cari_buku;
    private javax.swing.JTextField cari_anggota;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel data_buku;
    private javax.swing.JPanel data_anggota;
    private javax.swing.JPanel header;
    private javax.swing.JLabel id_peminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel reset_btn;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTable tbl_buku;
    private javax.swing.JTable tbl_anggota;                  
}
