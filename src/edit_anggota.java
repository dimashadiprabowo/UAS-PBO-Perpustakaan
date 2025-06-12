import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.text.*;

public class edit_anggota extends javax.swing.JDialog {
    
    private static Point point = new Point();

    public edit_anggota(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        
        setSize(540, 281);
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
        
        ((AbstractDocument)id_anggota.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d*");
            
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        
       //id_anggota.setEnabled(false);
        idnya.setVisible(false);
        //tanggal.setEnabled(false);
        idnya.setText(id);
        tampil(id);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tempat_lahir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tanggal_lahir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btn = new javax.swing.JPanel();
        reset = new javax.swing.JLabel();
        idnya = new javax.swing.JLabel();

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
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
        );

        jLabel1.setText("ID Anggota");

        id_anggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_anggotaKeyPressed(evt);
            }
        });

        jLabel3.setText("Nama Lengkap");

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tanggal Lahir (YYYY-MM-DD)");

        jLabel2.setText("Tanggal Anggota Masuk (YYYY-MM-DD)");

        save_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save_btn.setBackground(new java.awt.Color(0, 153, 255));
save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
save.setForeground(Color.WHITE); // agar tulisan terlihat


        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("Simpan");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn.addMouseListener(new java.awt.event.MouseAdapter() {
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
                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        reset_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
reset_btn.setBackground(new java.awt.Color(0, 153, 255));
reset.setForeground(Color.WHITE);

        
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
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        reset_btnLayout.setVerticalGroup(
            reset_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reset_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idnya, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(id_anggota))
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(tempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tempat_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(id_anggota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(nama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(idnya)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
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

    private void id_anggotaKeyPressed(java.awt.event.KeyEvent evt) {                               
    }                              

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {   
        System.out.println("Tombol Simpan diklik!");
        
        String getid_anggota = id_anggota.getText();
        String getnama = nama.getText();
        String gettempat = tempat_lahir.getText();
        String gettl = tanggal_lahir.getText();
        String gettanggal = tanggal.getText();
        
        if (!empty(getnama) && !empty(gettempat) && !empty(gettl)) {


            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "UPDATE anggota SET nama = ?, tempat_lahir = ?, tanggal_lahir = ?, tanggal = ? WHERE id_anggota = ?";
PreparedStatement stat = con.prepareStatement(sql);
stat.setString(1, getnama);
stat.setString(2, gettempat);
stat.setString(3, gettl);
stat.setString(4, gettanggal);
stat.setString(5, getid_anggota);
                stat.executeUpdate(); // update anggota
                
                // update nama juga di tabel peminjaman
                String sql2 = "UPDATE peminjaman SET nama = ? WHERE id_anggota = ?";
PreparedStatement stat2 = con.prepareStatement(sql2);
stat2.setString(1, getnama);
stat2.setString(2, getid_anggota);
stat2.executeUpdate();

                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(null, "GAGAL Mengubah Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                 

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {                                   
    nama.setText("");
    tempat_lahir.setText("");
    tanggal_lahir.setText("");
    tanggal.setText("");
}
                                

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                edit_anggota dialog = new edit_anggota(new javax.swing.JFrame(), true, "0");
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
    
    public void tampil(String id) {
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM anggota WHERE id_anggota = '"+id+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            if (hasil.next()) {
                id_anggota.setText(hasil.getString("id_anggota"));
                nama.setText(hasil.getString("nama"));
                tempat_lahir.setText(hasil.getString("tempat_lahir"));
                tanggal_lahir.setText(hasil.getString("tanggal_lahir"));
                tanggal.setText(hasil.getString("tanggal"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan Frame!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
                   
    private javax.swing.JPanel body;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel idnya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel reset_btn;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tanggal_lahir;
    private javax.swing.JTextField tempat_lahir;                 
}