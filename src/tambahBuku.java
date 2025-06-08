import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class tambahBuku extends javax.swing.JDialog {
    
    private static Point point = new Point();
    
    private char[] chars = "12ABCDEF34GHIJKL56MNOPQR78STUVW90XYZ".toCharArray();
    private StringBuilder stringBuilder = new StringBuilder();
    private Random random = new Random();
    private String output;

    public tambahBuku(java.awt.Frame parent, boolean modal) {
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
        thisdate();
        
        kode.setText(getRandom());
        kode.setEnabled(false);
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
                .addContainerGap(512, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
        );

        jLabel1.setText("Kode Buku");

        kode.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Judul Buku");

        jLabel4.setText("Jenis Buku");

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ensiklopedia", "Novel", "Komik", "Biografi", "Dongeng", "Karya Ilmiah" }));

        jLabel5.setText("Pengarang");

        jLabel6.setText("Tanggal Input (YYYY-MM-DD)");

        save_btn.setBackground(new java.awt.Color(120, 192, 205));
        save_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        save.setBackground(new java.awt.Color(120, 192, 205));
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
                .addGap(16, 16, 16)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        save_btnLayout.setVerticalGroup(
            save_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(save_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
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
                    .addComponent(jLabel4)
                    .addComponent(judul)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(kode))
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
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
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String getkode, getjudul, getpengarang, gettanggal;
        
        getkode = kode.getText();
        getjudul = judul.getText();
        getpengarang = pengarang.getText();
        gettanggal = tanggal.getText();
        int getjenis = jenis.getSelectedIndex()+1;
        
        if (empty(getjudul) || empty(gettanggal) || empty(getpengarang)) {
            JOptionPane.showMessageDialog(null, "Data yang Anda masukkan belum lengkap!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Connection con = new database.dbconnection().configDB();
                String get = "SELECT * FROM buku WHERE judul = '"+getjudul+"'";
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet hasil = st.executeQuery(get);
                
                if (hasil.next()) {
                    JOptionPane.showMessageDialog(null, "Judul buku tidak boleh ada yang sama.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        String sql = "INSERT INTO buku VALUES (null, ?, ?, ?, ?, ?)";
                        java.sql.PreparedStatement stat = (PreparedStatement)con.prepareStatement(sql);
                        stat.setString(1, getkode);
                        stat.setString(2, getjenis+"");
                        stat.setString(3, getjudul);
                        stat.setString(4, gettanggal);
                        stat.setString(5, getpengarang);
                        stat.executeUpdate();

                        this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Data BERHASIL Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "GAGAL Menambahkan Data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {}
        }
    }                                 

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tambahBuku dialog = new tambahBuku(new javax.swing.JFrame(), true);
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
    
    private String getRandom() {
        for (int length = 0; length < 8; length++) {
            Character character = chars[random.nextInt(chars.length)];
            stringBuilder.append(character);
        }
        output = stringBuilder.toString();
        stringBuilder.delete(0, 9);
        return output;
    }
    
    private static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
                    
    private javax.swing.JPanel body;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> jenis;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField pengarang;
    private javax.swing.JLabel save;
    private javax.swing.JPanel save_btn;
    private javax.swing.JTextField tanggal;                 
}
