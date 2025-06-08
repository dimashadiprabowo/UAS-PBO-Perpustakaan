import java.sql.*;
import javax.swing.*;

public class user extends javax.swing.JDialog {
    public user(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        setSize(319, 235);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        initComponents();
        
        username.setEditable(false);
        password.setEditable(false);
        userlawas.setVisible(false);
        passlawas.setVisible(false);
        tampil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header2 = new javax.swing.JPanel();
        close_btn2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        esbtn = new javax.swing.JPanel();
        edit_save = new javax.swing.JLabel();
        userlawas = new javax.swing.JLabel();
        passlawas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        header2.setBackground(new java.awt.Color(120, 192, 250));
        header2.setPreferredSize(new java.awt.Dimension(718, 47));

        close_btn2.setFont(new java.awt.Font("Tahoma", 1, 20)); 
        close_btn2.setForeground(new java.awt.Color(0,0,0));
        close_btn2.setText("×");
        close_btn2.setToolTipText("Keluar?");
        close_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btn2MouseClicked(evt);
            }
        });
        close_btn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                close_btn2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header2Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(close_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close_btn2)
        );

        jLabel1.setText("Nama Pengguna");

        jLabel2.setText("Kata Sandi");
        
        edit_save.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        edit_save.setForeground(new java.awt.Color(0,0,0));
        edit_save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit_save.setText("Ubah");
        edit_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_saveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout esbtnLayout = new javax.swing.GroupLayout(esbtn);
        esbtn.setLayout(esbtnLayout);
        esbtnLayout.setHorizontalGroup(
            esbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit_save, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        esbtnLayout.setVerticalGroup(
            esbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edit_save, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(esbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passlawas))
                        .addComponent(username)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userlawas))
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userlawas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passlawas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(esbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                        
    private void close_btn2MouseClicked(java.awt.event.MouseEvent evt) {                                        
        home n = new home();
        this.setVisible(false);
        n.setVisible(true);
    }                                       

    private void close_btn2KeyPressed(java.awt.event.KeyEvent evt) {                                      
        home n = new home();
        this.setVisible(false);
        n.setVisible(true);
    }                                     

    private void edit_saveMouseClicked(java.awt.event.MouseEvent evt) {                                       
        if (edit_save.getText().equals("Ubah")) {
            username.setEditable(true);
            password.setEditable(true);
            edit_save.setText("Simpan");
        } else if (edit_save.getText().equals("Simpan")) {
            String pengguna = userlawas.getText();
            String sandi = passlawas.getText();
            String user = username.getText();
            String pass = password.getText();
            
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "UPDATE petugas SET username = ?, password = ? WHERE username = '"+pengguna+"' AND password = '"+sandi+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, user);
                stat.setString(2, pass);
                stat.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data login BERHASIL Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                
                login n = new login();
                this.setVisible(false);
                n.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data login GAGAL Diubah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                
                home n = new home();
                this.setVisible(false);
                n.setVisible(true);
            }
        }
    }                                      

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                user dialog = new user(new javax.swing.JFrame(), true);
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
    
    private void tampil() {
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM petugas";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            if (hasil.next()) {
                username.setText(hasil.getString("username"));
                password.setText(hasil.getString("password"));
                userlawas.setText(hasil.getString("username"));
                passlawas.setText(hasil.getString("password"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            dispose();
        }
    }
                  
    private javax.swing.JLabel close_btn;
    private javax.swing.JLabel close_btn1;
    private javax.swing.JLabel close_btn2;
    private javax.swing.JLabel edit_save;
    private javax.swing.JPanel esbtn;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passlawas;
    private javax.swing.JTextField password;
    private javax.swing.JLabel userlawas;
    private javax.swing.JTextField username;                 
}
