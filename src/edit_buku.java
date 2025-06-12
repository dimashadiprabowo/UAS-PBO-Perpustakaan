import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class edit_buku extends javax.swing.JDialog {
    
    private static Point point = new Point();
    public edit_buku(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        
        setSize(540, 225);
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
        
        tampilin(id);
        idnya.setText(id);
        idnya.setVisible(false);
        kode.setEnabled(false);
        judul.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        pengarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        save_btn = new javax.swing.JPanel();
        save = new javax.swing.JLabel();
        idnya = new javax.swing.JLabel();
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
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel1.setText("Kode Buku");

        kode.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Judul Buku");

        judul.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Jenis Buku");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensiklopedia", "Novel", "Komik", "Biografi", "Dongeng", "Karya Ilmiah" }));

        jLabel5.setText("Pengarang");

        jLabel6.setText("Tanggal Input (YYYY-MM-DD)");

        save_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_btnLayout.createSequentialGroup()
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
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jenis, 0, 245, Short.MAX_VALUE)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                      
                        .addComponent(idnya))
                    .addComponent(judul)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(kode))
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(pengarang, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(kode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(judul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idnya))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {                                  
        String getpengarang, gettanggal;
        getpengarang = pengarang.getText();
        gettanggal = tanggal.getText();
        int getjenis = jenis.getSelectedIndex()+1;
        
        if (!empty(gettanggal)) {
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "UPDATE buku SET jenis = ?, tanggal = ?, pengarang = ? WHERE id_buku = '"+idnya.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, getjenis+"");
                stat.setString(2, gettanggal);
                stat.setString(3, getpengarang);
                stat.executeUpdate();

                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Data BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "GAGAL Mengubah Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan masukkan Tanggal Peminjaman!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        }
    }                                 

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {                                   
        tampilin(idnya.getText());
    }                                  

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                edit_buku dialog = new edit_buku(new javax.swing.JFrame(), true, "0");
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
    
    private void tampilin(String id) {
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku WHERE id_buku = '"+id+"'";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            if (hasil.next()) {
                kode.setText(hasil.getString("kode"));
                judul.setText(hasil.getString("judul"));
                pengarang.setText(hasil.getString("pengarang"));
                tanggal.setText(hasil.getString("tanggal"));
                jenis.setSelectedIndex(hasil.getInt("jenis")-1);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField pengarang;
    private javax.swing.JLabel reset;
    private javax.swing.JPanel reset_btn;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;                 
}
