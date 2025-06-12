import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class tambahPeminjaman extends javax.swing.JDialog { //inheritance
    
    private static Point point = new Point(); //encapsulation
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

    public tambahPeminjaman(java.awt.Frame parent, boolean modal) {  //constructor
        super(parent, modal);
        
        setSize(300, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.addMouseListener(new MouseAdapter() {  //polymorphism
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
        
        id_anggota.setEnabled(true);
        nama.setEnabled(true);
        kode.setEnabled(true);
        judul.setEnabled(true);
        
        tampil_buku();
        tampil_anggota();
        thisdate();
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
        jLabel6 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        header.setBackground(new java.awt.Color(120, 192, 205));
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

        id_anggota.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nama");

        nama.setBackground(new java.awt.Color(255, 255, 255));

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

        kode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Judul Buku");

        judul.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Tanggal Peminjaman (YYYY-MM-DD)");

        javax.swing.GroupLayout data_bukuLayout = new javax.swing.GroupLayout(data_buku);
        data_buku.setLayout(data_bukuLayout);
        data_bukuLayout.setHorizontalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kode)
            .addComponent(judul)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addGroup(data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap(167, Short.MAX_VALUE))
            .addComponent(tanggal)
        );
        data_bukuLayout.setVerticalGroup(
            data_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_bukuLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
        
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Simpan");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        
        save_btn.setLayout(save_btnLayout);
        save_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save_btnLayout.setHorizontalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_btnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

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

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.setVisible(false);
    }                                      

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {                                     
        this.setVisible(false);
    }                                    

    private void tbl_anggotaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        clicktbl_anggota();
    }                                      

    private void cari_anggotaKeyPressed(java.awt.event.KeyEvent evt) {                                      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cari_anggota();
        }
    }                                     

    private void cari_anggotaKeyTyped(java.awt.event.KeyEvent evt) {                                    
        cari_anggota();
    }                                   

    private void cari_bukuKeyPressed(java.awt.event.KeyEvent evt) {                                     
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cari_buku();
        }
    }                                    

    private void cari_bukuKeyTyped(java.awt.event.KeyEvent evt) {                                   
        cari_buku();
    }                                  

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {                                  
        save();
    }
    
 
    private void tbl_bukuMouseClicked(java.awt.event.MouseEvent evt) {                                      
        clicktbl_buku();
    }                                     

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tambahPeminjaman dialog = new tambahPeminjaman(new javax.swing.JFrame(), true);
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
    
    private void thisdate() {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd") ;
        tanggal.setText(""+kal.format(sekarang));
    }
    
    private void tampil_buku() {
    Object[] baris = {"Kode Buku", "Judul Buku", "Tanggal Terbit"};
    tbl1 = new DefaultTableModel(null, baris) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tbl_buku.setModel(tbl1);

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        con = new database.dbconnection().configDB();
        String sql = "SELECT * FROM buku ORDER BY kode ASC";
        st = con.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            String kode = rs.getString("kode");
            String judul = rs.getString("judul");
            String tanggal = rs.getString("tanggal");

            String[] data = {kode, judul, tanggal};
            tbl1.addRow(data);
        }
    }   catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!\n" + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
    }   finally {
        try {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (con != null) con.close();
            }   catch (SQLException e) { e.printStackTrace(); }
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
            String sql = "SELECT * FROM anggota ORDER BY id_anggota ASC";
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String id_anggota = rs.getString("id_anggota");
                String nama = rs.getString("nama");
                
                String[] data = {id_anggota, nama};
                tbl2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void cari_buku() {
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
                    + "ORDER BY id_buku ASC";
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
    
    private void cari_anggota() {
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
                    + "id_anggota LIKE '%"+query+"%' "
                    + "OR nama LIKE '%"+query+"%' "
                    + "ORDER BY id_anggota ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String id_anggota = hasil.getString("id_anggota");
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
        thisdate();
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku WHERE kode = '"+(String)tbl1.getValueAt(baris, 0)+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet rs = stat.executeQuery(sql);
        } catch (Exception e) {}
    }
    
    private void save() {
    String id = id_anggota.getText();
    String nama = this.nama.getText();
    String kode = this.kode.getText();
    String judul = this.judul.getText();
    String tanggal = this.tanggal.getText();

    if (id.isEmpty() || nama.isEmpty() || kode.isEmpty() || judul.isEmpty() || tanggal.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
        return;
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new database.dbconnection().configDB();
        String sql = "INSERT INTO peminjaman (id_anggota, nama, kode, judul, tanggal) VALUES (?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, nama);
        ps.setString(3, kode);
        ps.setString(4, judul);
        ps.setString(5, tanggal);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saat menyimpan: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    private void edit() {
    String id = id_anggota.getText();
    String nama = this.nama.getText();
    String kode = this.kode.getText();
    String judul = this.judul.getText();
    String tanggal = this.tanggal.getText();

    if (id.isEmpty() || nama.isEmpty() || kode.isEmpty() || judul.isEmpty() || tanggal.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
        return;
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new database.dbconnection().configDB();
        String sql = "UPDATE peminjaman SET nama=?, kode_buku=?, judul=?, tanggal_pinjam=? WHERE id_anggota=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, kode);
        ps.setString(3, judul);
        ps.setString(4, tanggal);
        ps.setString(5, id);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengedit data: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTable tbl_buku;
    private javax.swing.JTable tbl_anggota;                  
}