import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.text.*;

public class tambahAnggota extends javax.swing.JDialog { //inheritance
    
    private static Point point = new Point(); //encapsulation

    public tambahAnggota(java.awt.Frame parent, boolean modal) {  //constructor
        super(parent, modal);
        
        this.setUndecorated(true); 
        setResizable(false);
        
        initComponents();
        
        setSize(400, 320);
        setLocationRelativeTo(null);

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
        
        ((AbstractDocument)id_anggota.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d*");
            
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tempat_lahir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tanggal_lahir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Setup body panel
        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // Setup header panel
        header.setBackground(new java.awt.Color(120, 192, 205));
        header.setPreferredSize(new java.awt.Dimension(718, 47));

        // Setup close button
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

        // Layout untuk header
        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        // Setup labels dan text fields
        jLabel1.setText("ID Anggota");
        id_anggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_anggotaKeyPressed(evt);
            }
        });

        jLabel3.setText("Nama Lengkap");
        jLabel4.setText("Tempat Lahir");
        jLabel5.setText("Tanggal Lahir (YYYY-MM-DD)");
        jLabel6.setText("Tanggal Anggota Masuk (YYYY-MM-DD)");

        // Setup save button
        save_btn.setBackground(new java.awt.Color(120, 192, 205));
        save_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Simpan");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt); //polymorphism
            }
        });

        // Layout untuk save button
        javax.swing.GroupLayout save_btnLayout = new javax.swing.GroupLayout(save_btn);
        save_btn.setLayout(save_btnLayout);
        save_btnLayout.setHorizontalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        // Layout utama untuk body panel
        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, bodyLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                // Baris 1: ID Anggota dan Tempat Lahir
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                // Baris 2: Nama Lengkap dan Tanggal Lahir
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                // Baris 3: Tanggal Masuk (di tengah)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                // Button Simpan (di tengah)
                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        // Layout utama dialog
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
    }// </editor-fold>                        
    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.setVisible(false);
    }                                      

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {                                     
        this.setVisible(false);
    }                                    

    // Event handler untuk tombol simpan
    private void saveMouseClicked(java.awt.event.MouseEvent evt) {                                  
        String getid_anggota, getnama, gettempat, gettl, gettanggal;
        getid_anggota = id_anggota.getText();
        getnama = nama.getText();
        gettempat = tempat_lahir.getText();
        gettl = tanggal_lahir.getText();
        gettanggal = tanggal.getText();
        
        // Validasi input kosong
        if (empty(getid_anggota) || empty(getnama) || empty(gettempat) || empty(gettl) || empty(gettanggal)) {
            JOptionPane.showMessageDialog(this, "Data yang Anda masukkan belum lengkap!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int id = Integer.parseInt(getid_anggota);
                if (id < 1 || id > 2147483647) {
                    JOptionPane.showMessageDialog(this, "ID Anggota harus antara 1 dan 2.147.483.647!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                } else {
                    Connection con = null;
                    PreparedStatement pst = null;
                    PreparedStatement stat = null;
                    ResultSet hasil = null;
                    
                    try {
                        con = new database.dbconnection().configDB();
                        if (con == null) {
                            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Cek duplikasi data
                        String get = "SELECT * FROM anggota WHERE id_anggota = ? OR nama = ?";
                        pst = con.prepareStatement(get);
                        pst.setString(1, getid_anggota);
                        pst.setString(2, getnama);
                        hasil = pst.executeQuery();

                        if (hasil.next()) {
                            JOptionPane.showMessageDialog(this, "Data seperti ini sudah pernah Anda masukkan sebelumnya.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Insert data baru
                            String sql = "INSERT INTO anggota (id_anggota, nama, tempat_lahir, tanggal_lahir, tanggal) VALUES (?, ?, ?, ?, ?)";
                            stat = con.prepareStatement(sql);
                            stat.setString(1, getid_anggota);
                            stat.setString(2, getnama);
                            stat.setString(3, gettempat);
                            stat.setString(4, gettl);
                            stat.setString(5, gettanggal);
                            
                            int rowsAffected = stat.executeUpdate();
                            
                            if (rowsAffected > 0) {
                                // Clear form setelah berhasil menyimpan
                                clearForm();
                                this.setVisible(false);
                                JOptionPane.showMessageDialog(this, "Data BERHASIL Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "GAGAL Menambahkan Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error database: " + e.getMessage(), "Kesalahan Database", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    } finally {
                        try {
                            if (hasil != null) hasil.close();
                            if (pst != null) pst.close();
                            if (stat != null) stat.close();
                            if (con != null) con.close();
                        } catch (SQLException e) {
                            System.err.println("Error saat menutup koneksi database: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID Anggota harus berupa angka!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }                                 

    // Event handler untuk key press di field ID anggota
    private void id_anggotaKeyPressed(java.awt.event.KeyEvent evt) {                               
        
    }                              

    // Method untuk membersihkan form
    private void clearForm() {
        id_anggota.setText("");
        nama.setText("");
        tempat_lahir.setText("");
        tanggal_lahir.setText("");
        tanggal.setText("");
    }

    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tambahAnggota dialog = new tambahAnggota(new javax.swing.JFrame(), true);
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
             
    private javax.swing.JPanel body;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel header;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tanggal_lahir;
    private javax.swing.JTextField tempat_lahir;                  
}