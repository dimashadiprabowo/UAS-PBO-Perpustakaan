import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class login extends javax.swing.JFrame {
    
    private static Point point = new Point();
    public login() {
        super("Perpustakaan");
        setSize(642, 443);
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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        thisday();
        timenow();
    }

    @SuppressWarnings("unchecked")
                        
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        close_btn = new javax.swing.JLabel();
        thisday = new javax.swing.JLabel();
        timenow = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        username = new placeholder.username();
        password = new placeholder.password();
        button = new javax.swing.JPanel();
        submit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        body.setForeground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(120, 195, 250));

        close_btn.setFont(new java.awt.Font("Tahoma", 1, 20)); 
        close_btn.setForeground(new java.awt.Color(255, 255, 255));
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

        thisday.setForeground(new java.awt.Color(255, 255, 255));
        thisday.setText("Hari, Tanggal Bulan Tahun");

        timenow.setForeground(new java.awt.Color(255, 255, 255));
        timenow.setText("Jam:Menit:Detik");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(thisday)
                .addGap(69, 69, 69)
                .addComponent(timenow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(timenow, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addComponent(thisday, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
        );

        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("LOGIN");

        label2.setFont(new java.awt.Font("Tahoma", 1, 28)); 
        label2.setForeground(new java.awt.Color(120, 195, 250));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("Litera");

        username.setToolTipText("masukkan nama pengguna kamu");
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
        });

        password.setToolTipText("masukkan kata sandi kamu");
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        button.setBackground(new java.awt.Color(120, 195, 250));
        button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        submit.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        submit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submit.setText("MASUK");
        submit.setToolTipText("Masuk Ke Litera");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout buttonLayout = new javax.swing.GroupLayout(button);
        button.setLayout(buttonLayout);
        buttonLayout.setHorizontalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        buttonLayout.setVerticalGroup(
            buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2)
                            .addComponent(label1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(label1)
                .addGap(18, 18, 18)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
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

    private void close_btnKeyPressed(java.awt.event.KeyEvent evt) {                                     
        int x = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar dari program?", "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
            dispose();
        }
    }                                    

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        int x = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar dari program?", "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
            dispose();
        }
    }                                      

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {                                    
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            submit();
        }
    }                                   

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {                                    
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            submit();
        }
    }                                   

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {                                    
        submit();
    }                                   

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
    private void submit() {
        if (username.getText().equals("") || password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama pengguna dan Kata sandi tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String sql = "SELECT * FROM petugas WHERE username = '"+username.getText()+"' AND password = '"+password.getText()+"'";
                Connection con = new database.dbconnection().configDB();
                java.sql.Statement stat = con.createStatement();
                java.sql.ResultSet rs = stat.executeQuery(sql);

                if (rs.next()) {
                    if (username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))) {
                        home n = new home();
                        n.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nama pengguna atau Kata sandi yang Anda masukkan salah.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    private void thisday() {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("EEEE, dd MMMMM yyyy") ;
        thisday.setText(""+kal.format(sekarang));
    }
    
    private void timenow() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "";
                String nol_menit = "";
                String nol_detik = "";
                java.util.Date dt = new java.util.Date();

                int nilai_jam = dt.getHours();
                int nilai_menit = dt.getMinutes();
                int nilai_detik = dt.getSeconds();
                
                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                
                if (nilai_menit <= 9) {
                    nol_menit = "0";
                }

                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }

                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                timenow.setText(jam + ":" + menit + ":" + detik);
            }
        };
        new javax.swing.Timer(1000, taskPerformer).start();
    }
                  
    private javax.swing.JPanel body;
    private javax.swing.JPanel button;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField password;
    private javax.swing.JLabel submit;
    private javax.swing.JLabel thisday;
    private javax.swing.JLabel timenow;
    private javax.swing.JTextField username;              
}
