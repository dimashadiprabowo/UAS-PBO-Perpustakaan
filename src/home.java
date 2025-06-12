import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

public class home extends javax.swing.JFrame {

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
    DefaultTableModel tbl3 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel tbl4 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public home() {
        super("Perpustakaan");
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screen.width,screen.height);
        setResizable(false);
        initComponents();
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        timenow();
        tampil_peminjaman();
        tampil_buku();
        tampil_anggota();
        tampil_pengembalian();
    }

    @SuppressWarnings("unchecked")
                         
    private void initComponents() {

        body = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        kelolabuku = new javax.swing.JPanel();
        search_buku = new placeholder.cari_buku();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_buku = new javax.swing.JTable();
        result_buku = new javax.swing.JLabel();
        tambah2 = new javax.swing.JPanel();
        tambah2_value = new javax.swing.JLabel();
        ubah2 = new javax.swing.JPanel();
        ubah2_value = new javax.swing.JLabel();
        hapus2 = new javax.swing.JPanel();
        hapus2_value = new javax.swing.JLabel();
        segarkan2 = new javax.swing.JPanel();
        segarkan2_value = new javax.swing.JLabel();
        kelolaanggota = new javax.swing.JPanel();
        search_anggota = new placeholder.cari_anggota();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_anggota = new javax.swing.JTable();
        result_anggota = new javax.swing.JLabel();
        tambah3 = new javax.swing.JPanel();
        tambah3_value = new javax.swing.JLabel();
        ubah3 = new javax.swing.JPanel();
        ubah3_value = new javax.swing.JLabel();
        hapus3 = new javax.swing.JPanel();
        hapus3_value = new javax.swing.JLabel();
        segarkan3 = new javax.swing.JPanel();
        segarkan3_value = new javax.swing.JLabel();
        peminjaman = new javax.swing.JPanel();
        search_peminjaman = new placeholder.riwayat_transaksi();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_peminjaman = new javax.swing.JTable();
        result_peminjaman = new javax.swing.JLabel();
        tambah1 = new javax.swing.JPanel();
        tambah1_value = new javax.swing.JLabel();
        ubah1 = new javax.swing.JPanel();
        ubah1_value = new javax.swing.JLabel();
        hapus1 = new javax.swing.JPanel();
        hapus1_value = new javax.swing.JLabel();
        segarkan1 = new javax.swing.JPanel();
        segarkan1_value = new javax.swing.JLabel();
        
        pengembalian = new javax.swing.JPanel();
        search_pengembalian = new placeholder.riwayat_transaksi();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_pengembalian = new javax.swing.JTable();
        result_pengembalian = new javax.swing.JLabel();
        ubah4 = new javax.swing.JPanel();
        ubah4_value = new javax.swing.JLabel();
        hapus4 = new javax.swing.JPanel();
        hapus4_value = new javax.swing.JLabel();
        segarkan4 = new javax.swing.JPanel();
        segarkan4_value = new javax.swing.JLabel();
        
        userinfo = new javax.swing.JPanel();
        footer = new javax.swing.JPanel();
        timenow = new javax.swing.JLabel();
        timenow.setFont(new java.awt.Font("Segoe UI", 1, 12));
        timenow.setText("Memuat waktu...");
        header.add(timenow);
        timenow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int x = JOptionPane.showConfirmDialog(
                    null,
                    "Anda yakin ingin keluar dari program?",
                    "Keluar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
                );
                if (x == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        header.setBackground(new java.awt.Color(120, 192, 250));
        header.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("Litera");
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 

        header.add(title, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
        headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap() 
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(20, 20, 20)) 
        );

        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        ));

        kelolabuku.setBackground(new java.awt.Color(255, 255, 255));

        search_buku.setToolTipText("Cari Buku");
        search_buku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_bukuKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_bukuKeyTyped(evt);
            }
        });

        tb_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Jenis", "Tanggal Input", "Pengarang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_buku);

        result_buku.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        result_buku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        tambah2.setBackground(new java.awt.Color(242,242,242));
        tambah2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tambah2_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tambah2_value.setForeground(new java.awt.Color(0,0,0));
        tambah2_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah2_value.setText("Tambah Data");
        tambah2_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah2_valueMouseClicked(evt);
            }
        });
        
        javax.swing.GroupLayout tambah2Layout = new javax.swing.GroupLayout(tambah2);
        tambah2.setLayout(tambah2Layout);
        tambah2Layout.setHorizontalGroup(
            tambah2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tambah2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        tambah2Layout.setVerticalGroup(
            tambah2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tambah2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        ubah2.setBackground(new java.awt.Color(242,242,242));
        ubah2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ubah2_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ubah2_value.setForeground(new java.awt.Color(0,0,0));
        ubah2_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ubah2_value.setText("Ubah Data");
        ubah2_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubah2_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubah2Layout = new javax.swing.GroupLayout(ubah2);
        ubah2.setLayout(ubah2Layout);
        ubah2Layout.setHorizontalGroup(
            ubah2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubah2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        ubah2Layout.setVerticalGroup(
            ubah2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubah2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        hapus2.setBackground(new java.awt.Color(242,242,242));
        hapus2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hapus2_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        hapus2_value.setForeground(new java.awt.Color(0,0,0));
        hapus2_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus2_value.setText("Hapus Data");
        hapus2_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus2_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapus2Layout = new javax.swing.GroupLayout(hapus2);
        hapus2.setLayout(hapus2Layout);
        hapus2Layout.setHorizontalGroup(
            hapus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hapus2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        hapus2Layout.setVerticalGroup(
            hapus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hapus2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        segarkan2.setBackground(new java.awt.Color(242,242,242));
        segarkan2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        segarkan2_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        segarkan2_value.setForeground(new java.awt.Color(0,0,0));
        segarkan2_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segarkan2_value.setText("Refresh");
        segarkan2_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segarkan2_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout segarkan2Layout = new javax.swing.GroupLayout(segarkan2);
        segarkan2.setLayout(segarkan2Layout);
        segarkan2Layout.setHorizontalGroup(
            segarkan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(segarkan2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        segarkan2Layout.setVerticalGroup(
            segarkan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(segarkan2_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kelolabukuLayout = new javax.swing.GroupLayout(kelolabuku);
        kelolabuku.setLayout(kelolabukuLayout);
        kelolabukuLayout.setHorizontalGroup(
            kelolabukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelolabukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelolabukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kelolabukuLayout.createSequentialGroup()
                        .addComponent(result_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                    .addGroup(kelolabukuLayout.createSequentialGroup()
                        .addComponent(tambah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(segarkan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kelolabukuLayout.setVerticalGroup(
            kelolabukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelolabukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelolabukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_buku, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(result_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kelolabukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segarkan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tab.addTab("Kelola Buku", null, kelolabuku, "Kelola Buku");
        kelolabuku.getAccessibleContext().setAccessibleName("Kelola Buku");

        kelolaanggota.setBackground(new java.awt.Color(255, 255, 255));

        search_anggota.setToolTipText("Cari Data Anggota");
        search_anggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_anggotaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_anggotaKeyTyped(evt);
            }
        });

        tb_anggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_nggota", "Nama Lengkap", "Tempat Lahir", "Tanggal Lahir", "Tanggal Terdaftar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_anggota);

        result_anggota.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        result_anggota.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        tambah3.setBackground(new java.awt.Color(242,242,242));
        tambah3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tambah3_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tambah3_value.setForeground(new java.awt.Color(0,0,0));
        tambah3_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah3_value.setText("Tambah Data");
        tambah3_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah3_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambah3Layout = new javax.swing.GroupLayout(tambah3);
        tambah3.setLayout(tambah3Layout);
        tambah3Layout.setHorizontalGroup(
            tambah3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tambah3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        tambah3Layout.setVerticalGroup(
            tambah3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tambah3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );
        ubah3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ubah3_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ubah3_value.setForeground(new java.awt.Color(0,0,0));
        ubah3_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ubah3_value.setText("Ubah Data");
        ubah3_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubah3_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubah3Layout = new javax.swing.GroupLayout(ubah3);
        ubah3.setLayout(ubah3Layout);
        ubah3Layout.setHorizontalGroup(
            ubah3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubah3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        ubah3Layout.setVerticalGroup(
            ubah3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ubah3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        hapus3.setBackground(new java.awt.Color(242,242,242));
        hapus3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hapus3_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        hapus3_value.setForeground(new java.awt.Color(0,0,0));
        hapus3_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus3_value.setText("Hapus Data");
        hapus3_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus3_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapus3Layout = new javax.swing.GroupLayout(hapus3);
        hapus3.setLayout(hapus3Layout);
        hapus3Layout.setHorizontalGroup(
            hapus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hapus3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        hapus3Layout.setVerticalGroup(
            hapus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hapus3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        segarkan3.setBackground(new java.awt.Color(242,242,242));
        segarkan3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        segarkan3_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        segarkan3_value.setForeground(new java.awt.Color(0,0,0));
        segarkan3_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segarkan3_value.setText("Refresh");
        segarkan3_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segarkan3_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout segarkan3Layout = new javax.swing.GroupLayout(segarkan3);
        segarkan3.setLayout(segarkan3Layout);
        segarkan3Layout.setHorizontalGroup(
            segarkan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(segarkan3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        segarkan3Layout.setVerticalGroup(
            segarkan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(segarkan3_value, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kelolaanggotaLayout = new javax.swing.GroupLayout(kelolaanggota);
        kelolaanggota.setLayout(kelolaanggotaLayout);
        kelolaanggotaLayout.setHorizontalGroup(
            kelolaanggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelolaanggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelolaanggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kelolaanggotaLayout.createSequentialGroup()
                        .addComponent(result_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                    .addGroup(kelolaanggotaLayout.createSequentialGroup()
                        .addComponent(tambah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(segarkan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kelolaanggotaLayout.setVerticalGroup(
            kelolaanggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelolaanggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelolaanggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(result_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kelolaanggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segarkan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tab.addTab("Kelola Anggota", null, kelolaanggota, "Kelola Anggota");
        kelolaanggota.getAccessibleContext().setAccessibleName("Kelola Anggota");

        peminjaman.setBackground(new java.awt.Color(255, 255, 255));

        search_peminjaman.setToolTipText("Cari Data Anggota");
        search_peminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_peminjamanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_peminjamanKeyTyped(evt);
            }
        });

        tb_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_anggota", "Nama", "Kode Buku", "Judul Buku", "Tanggal Pinjam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_peminjaman);

        result_peminjaman.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        result_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        tambah1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tambah1_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tambah1_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambah1_value.setText("Tambah Data");
        tambah1_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambah1_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tambah1Layout = new javax.swing.GroupLayout(tambah1);
        tambah1.setLayout(tambah1Layout);
        tambah1Layout.setHorizontalGroup(
            tambah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambah1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambah1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        tambah1Layout.setVerticalGroup(
            tambah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambah1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambah1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        ubah1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ubah1_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ubah1_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ubah1_value.setText("Ubah Data");
        ubah1_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubah1_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubah1Layout = new javax.swing.GroupLayout(ubah1);
        ubah1.setLayout(ubah1Layout);
        ubah1Layout.setHorizontalGroup(
            ubah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ubah1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubah1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        ubah1Layout.setVerticalGroup(
            ubah1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ubah1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubah1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        hapus1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hapus1_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        hapus1_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus1_value.setText("Hapus Data");
        hapus1_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus1_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapus1Layout = new javax.swing.GroupLayout(hapus1);
        hapus1.setLayout(hapus1Layout);
        hapus1Layout.setHorizontalGroup(
            hapus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hapus1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hapus1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        hapus1Layout.setVerticalGroup(
            hapus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hapus1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hapus1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        segarkan1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        segarkan1_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        segarkan1_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segarkan1_value.setText("Refresh");
        segarkan1_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segarkan1_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout segarkan1Layout = new javax.swing.GroupLayout(segarkan1);
        segarkan1.setLayout(segarkan1Layout);
        segarkan1Layout.setHorizontalGroup(
            segarkan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(segarkan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(segarkan1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        segarkan1Layout.setVerticalGroup(
            segarkan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(segarkan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(segarkan1_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout peminjamanLayout = new javax.swing.GroupLayout(peminjaman);
        peminjaman.setLayout(peminjamanLayout);
        peminjamanLayout.setHorizontalGroup(
            peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(peminjamanLayout.createSequentialGroup()
                        .addComponent(result_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(peminjamanLayout.createSequentialGroup()
                        .addComponent(tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(segarkan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        peminjamanLayout.setVerticalGroup(
            peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peminjamanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(peminjamanLayout.createSequentialGroup()
                        .addGroup(peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(result_peminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(peminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segarkan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tab.addTab("Peminjaman", null, peminjaman, "Peminjaman");
        peminjaman.getAccessibleContext().setAccessibleName("Peminjaman");
        
        pengembalian.setBackground(new java.awt.Color(255, 255, 255));

        search_pengembalian.setToolTipText("Cari Data Anggota");
        search_pengembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_pengembalianKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_pengembalianKeyTyped(evt);
            }
        });

        tb_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_anggota", "Nama", "Kode Buku", "Judul Buku", "Tanggal Pinjam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tb_pengembalian);

        result_pengembalian.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        result_pengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ubah4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ubah4_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ubah4_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ubah4_value.setText("Ubah Data");
        ubah4_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubah4_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ubah4Layout = new javax.swing.GroupLayout(ubah4);
        ubah4.setLayout(ubah4Layout);
        ubah4Layout.setHorizontalGroup(
            ubah4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ubah4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubah4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        ubah4Layout.setVerticalGroup(
            ubah4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ubah4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ubah4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        hapus4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        hapus4_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        hapus4_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hapus4_value.setText("Hapus Data");
        hapus4_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus4_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout hapus4Layout = new javax.swing.GroupLayout(hapus4);
        hapus4.setLayout(hapus4Layout);
        hapus4Layout.setHorizontalGroup(
            hapus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hapus4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hapus4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        hapus4Layout.setVerticalGroup(
            hapus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hapus4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hapus4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        segarkan4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        segarkan4_value.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        segarkan4_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segarkan4_value.setText("Refresh");
        segarkan4_value.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                segarkan4_valueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout segarkan4Layout = new javax.swing.GroupLayout(segarkan4);
        segarkan4.setLayout(segarkan4Layout);
        segarkan4Layout.setHorizontalGroup(
            segarkan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(segarkan4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(segarkan4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        segarkan4Layout.setVerticalGroup(
            segarkan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(segarkan4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(segarkan4_value, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pengembalianLayout = new javax.swing.GroupLayout(pengembalian);
        pengembalian.setLayout(pengembalianLayout);
        pengembalianLayout.setHorizontalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pengembalianLayout.createSequentialGroup()
                        .addComponent(result_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pengembalianLayout.createSequentialGroup()
                        .addComponent(ubah4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(segarkan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        pengembalianLayout.setVerticalGroup(
            pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengembalianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pengembalianLayout.createSequentialGroup()
                        .addGroup(pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(result_pengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ubah4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segarkan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tab.addTab("Pengembalian", null, pengembalian, "Pengembalian");
        pengembalian.getAccessibleContext().setAccessibleName("Pengembalian");


        userinfo.setBackground(new java.awt.Color(255, 255, 255));
        userinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userinfoMouseClicked(evt);
            }
        });
        userinfo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                userinfoComponentShown(evt);
            }
        });

        javax.swing.GroupLayout userinfoLayout = new javax.swing.GroupLayout(userinfo);
        userinfo.setLayout(userinfoLayout);
        userinfoLayout.setHorizontalGroup(
            userinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        userinfoLayout.setVerticalGroup(
            userinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        tab.addTab("Informasi Login", null, userinfo, "Informasi Login");
        userinfo.getAccessibleContext().setAccessibleName("Informasi Login");

        footer.setBackground(new java.awt.Color(120, 192, 250));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab.getAccessibleContext().setAccessibleName("");

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
    
    private void search_peminjamanKeyTyped(java.awt.event.KeyEvent evt) {                                           
        search_peminjaman();
    }                                          

    private void search_peminjamanKeyPressed(java.awt.event.KeyEvent evt) {                                             
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_peminjaman();
        }
    }                                            

    private void segarkan1_valueMouseClicked(java.awt.event.MouseEvent evt) {                                             
        search_peminjaman.setText("");
        result_peminjaman.setText("");
        tampil_peminjaman();
    }                                            

private void hapus1_valueMouseClicked(java.awt.event.MouseEvent evt) {                                          
    int baris = tb_peminjaman.getSelectedRow();
    if (baris >= 0) {
        String id_anggota = tbl1.getValueAt(baris, 0).toString();
        String kode = tbl1.getValueAt(baris, 2).toString();
        String tanggal = tbl1.getValueAt(baris, 4).toString(); 

        int x = JOptionPane.showConfirmDialog(null, 
            "Data Peminjaman Buku dengan\n\nKode Buku: "+kode+
            "\nID Anggota: "+id_anggota+
            "\nTanggal Peminjaman: "+tanggal+
            "\n\nakan Anda hapus, yakin?", 
            "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (x == JOptionPane.YES_OPTION) {
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "DELETE FROM peminjaman WHERE id_anggota = ? AND kode = ? AND tanggal = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id_anggota);
                ps.setString(2, kode);
                ps.setString(3, tanggal); 

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    tampil_peminjaman();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan. Pastikan tanggal, ID, dan kode sesuai!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data!\n" + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}

    private void ubah1_valueMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int baris = tb_peminjaman.getSelectedRow();
        if (baris >= 0) {
            String id_anggota = tbl1.getValueAt(baris, 0).toString();
            String kode = tbl1.getValueAt(baris, 2).toString();
            String tanggal = tbl1.getValueAt(baris, 4).toString();
            
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "SELECT * FROM peminjaman WHERE id_anggota = '"+id_anggota+"' AND kode = '"+kode+"' AND tanggal = '"+tanggal+"'";
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                
                if (rs.next()) {
                    String id_peminjaman = rs.getString("id_peminjaman");
                    new edit_peminjaman(this, rootPaneCheckingEnabled, id_peminjaman).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal menyeleksi data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                        

    private void tambah1_valueMouseClicked(java.awt.event.MouseEvent evt) {                                           
        new tambahPeminjaman(this, rootPaneCheckingEnabled).setVisible(true);
    }                                          

    private void search_pengembalianKeyTyped(java.awt.event.KeyEvent evt) {                                           
        search_pengembalian();
    }                                          

    private void search_pengembalianKeyPressed(java.awt.event.KeyEvent evt) {                                             
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_pengembalian();
        }
    }                                            

    private void segarkan4_valueMouseClicked(java.awt.event.MouseEvent evt) {                                             
        search_pengembalian.setText("");
        result_pengembalian.setText("");
        tampil_pengembalian();
    }                                            

    private void hapus4_valueMouseClicked(java.awt.event.MouseEvent evt) {                                          
    int baris = tb_pengembalian.getSelectedRow();
    if (baris >= 0) {
        String id_anggota = tbl4.getValueAt(baris, 0).toString();  
        String nama = tbl4.getValueAt(baris, 1).toString();         
        String tanggal = tbl4.getValueAt(baris, 3).toString();     

        int x = JOptionPane.showConfirmDialog(
            null,
            "Data Pengembalian Buku dengan\n\nID Anggota: " + id_anggota + 
            "\nNama: " + nama + 
            "\nTanggal Peminjaman: " + tanggal + 
            "\n\nakan Anda hapus, yakin?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (x == JOptionPane.YES_OPTION) {
            try {
                Connection con = new database.dbconnection().configDB();
                
                String cariSQL = "SELECT id_peminjaman FROM peminjaman WHERE id_anggota = ? AND nama = ? AND tanggal = ?";
                PreparedStatement pstCari = con.prepareStatement(cariSQL);
                pstCari.setString(1, id_anggota);
                pstCari.setString(2, nama);
                pstCari.setString(3, tanggal);
                ResultSet rs = pstCari.executeQuery();

                if (rs.next()) {
                    String id_peminjaman = rs.getString("id_peminjaman");

                    String hapusPengembalianSQL = "DELETE FROM pengembalian WHERE id_peminjaman = ?";
                    PreparedStatement pstHapusPengembalian = con.prepareStatement(hapusPengembalianSQL);
                    pstHapusPengembalian.setString(1, id_peminjaman);
                    pstHapusPengembalian.executeUpdate();

                    String hapusPeminjamanSQL = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
                    PreparedStatement pstHapusPeminjaman = con.prepareStatement(hapusPeminjamanSQL);
                    pstHapusPeminjaman.setString(1, id_peminjaman);
                    pstHapusPeminjaman.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data pengembalian berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    tampil_pengembalian(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Data peminjaman tidak ditemukan!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
                         

private void ubah4_valueMouseClicked(java.awt.event.MouseEvent evt) {                                         
    int baris = tb_pengembalian.getSelectedRow();
    if (baris >= 0) {
        String id_anggota = tbl4.getValueAt(baris, 0).toString(); 
        String nama = tbl4.getValueAt(baris, 1).toString();       
        String tanggal = tbl4.getValueAt(baris, 3).toString();   

        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT id_peminjaman FROM peminjaman WHERE id_anggota = ? AND nama = ? AND tanggal = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id_anggota);
            pst.setString(2, nama);
            pst.setString(3, tanggal);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String id_peminjaman = rs.getString("id_peminjaman");
                new edit_pengembalian(this, rootPaneCheckingEnabled, id_peminjaman).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Data peminjaman tidak ditemukan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
                            

    private void search_bukuKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_buku();
        }
    }                                      

    private void search_bukuKeyTyped(java.awt.event.KeyEvent evt) {                                     
        search_buku();
    }                                    

    private void tambah2_valueMouseClicked(java.awt.event.MouseEvent evt) {                                           
        new tambahBuku(this, rootPaneCheckingEnabled).setVisible(true);
    }                                          

    private void ubah2_valueMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int baris = tb_buku.getSelectedRow();
        if (baris >= 0) {
            String kode = tbl2.getValueAt(baris, 0).toString();
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "SELECT * FROM buku WHERE kode = '"+kode+"'";
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                
                if (rs.next()) {
                    String id_buku = rs.getString("id_buku");
                    new edit_buku(this, rootPaneCheckingEnabled, id_buku).setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyeleksi data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                        

    private void hapus2_valueMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int baris = tb_buku.getSelectedRow();
        if (baris >= 0) {
            String kode = tbl2.getValueAt(baris, 0).toString();
            String judul = tbl2.getValueAt(baris, 1).toString();

            int x = JOptionPane.showConfirmDialog(null, "Data Buku dengan\n\nJudul: "+judul+"\nKode Buku: "+kode+"\n\nakan Anda hapus, yakin?\nData peminjaman dengan BUKU ini juga akan ikut terhapus!", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new database.dbconnection().configDB();
                    String sql = "DELETE FROM buku WHERE kode = '"+kode+"'";
                    String sql2 = "DELETE FROM peminjaman WHERE kode = '"+kode+"' AND judul = '"+judul+"'";
                    java.sql.Statement st = con.createStatement();
                    st.executeUpdate(sql);
                    st.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    tampil_buku();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                         

    private void segarkan2_valueMouseClicked(java.awt.event.MouseEvent evt) {                                             
        search_buku.setText("");
        result_buku.setText("");
        tampil_buku();
    }                                            

    private void search_anggotaKeyPressed(java.awt.event.KeyEvent evt) {                                        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_anggota();
        }
    }                                       

    private void search_anggotaKeyTyped(java.awt.event.KeyEvent evt) {                                      
        search_anggota();
    }                                     

    private void tambah3_valueMouseClicked(java.awt.event.MouseEvent evt) {                                           
        new tambahAnggota(this, rootPaneCheckingEnabled).setVisible(true);
    }                                          
    
    private void ubah3_valueMouseClicked(java.awt.event.MouseEvent evt) {                                         
        int baris = tb_anggota.getSelectedRow();
        if (baris >= 0) {
            String id_anggota = tbl3.getValueAt(baris, 0).toString();
            try {
                Connection con = new database.dbconnection().configDB();
                String sql = "SELECT * FROM anggota WHERE id_anggota = '"+id_anggota+"'";
                java.sql.Statement st = con.createStatement();
                java.sql.ResultSet rs = st.executeQuery(sql);
                
                if (rs.next()) {
                    String nama = rs.getString("nama");
                    new edit_anggota(this, rootPaneCheckingEnabled, nama).setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal menyeleksi data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                        

    private void hapus3_valueMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int baris = tb_anggota.getSelectedRow();
        if (baris >= 0) {
            String id_anggota = tbl3.getValueAt(baris, 0).toString();
            String nama = tbl3.getValueAt(baris, 1).toString();

            int x = JOptionPane.showConfirmDialog(null, "Data anggota dengan\n\nID Anggota: "+id_anggota+"\nNama Lengkap: "+nama+"\n\nakan Anda hapus, yakin?\nData peminjaman dengan anggota ini juga akan ikut terhapus!", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                try {
                    Connection con = new database.dbconnection().configDB();
                    String sql = "DELETE FROM anggota WHERE id_anggota = '"+id_anggota+"'";
                    String sql2 = "DELETE FROM peminjaman WHERE id_anggota = '"+id_anggota+"'";
                    java.sql.Statement st = con.createStatement();
                    st.executeUpdate(sql);
                    st.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    tampil_anggota();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                         

    private void segarkan3_valueMouseClicked(java.awt.event.MouseEvent evt) {                                             
        search_anggota.setText("");
        result_anggota.setText("");
        tampil_anggota();
    }                                            

private void userinfoMouseClicked(java.awt.event.MouseEvent evt) {                                      
}                                     

private void userinfoComponentShown(java.awt.event.ComponentEvent evt) {                                        
    this.dispose();
    new user(this, rootPaneCheckingEnabled).setVisible(true);
}                                       

public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new home().setVisible(true);
        }
    });
} 

private void timenow() {
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            String nol_jam = "";
            String nol_menit = "";
            String nol_detik = "";

            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("EEEE, dd MMMMM yyyy");
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

            timenow.setText(kal.format(dt) + "     " + jam + ":" + menit + ":" + detik + "                                   ");
        }
    };
    new javax.swing.Timer(1000, taskPerformer).start();
}

private void tampil_peminjaman() {
    Object[] baris = {"ID Anggota", "Nama", "Kode Buku", "Judul Buku", "Tanggal Peminjaman"};
    tbl1 = new DefaultTableModel(null, baris) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tb_peminjaman.setModel(tbl1);

    try {
        Connection con = new database.dbconnection().configDB();
        String sql = "SELECT * FROM peminjaman ORDER BY id_peminjaman ASC";
        java.sql.Statement stat = con.createStatement();
        java.sql.ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String id_anggota = hasil.getString("id_anggota");
            String nama = hasil.getString("nama");
            String kode = hasil.getString("kode");
            String judul = hasil.getString("judul");
            String tanggal = hasil.getString("tanggal");

            String[] data = {id_anggota, nama, kode, judul, tanggal};
            tbl1.addRow(data);
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        dispose();
    }
}
    private void tampil_pengembalian() {
    Object[] baris = {"ID Anggota", "Nama", "Judul Buku",
            "Tanggal Pinjam", "Tanggal Pengembalian",
            "Status", "Telat (hari)", "Denda"};
    tbl4 = new DefaultTableModel(null, baris) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tb_pengembalian.setModel(tbl4);

    try {
        Connection con = new database.dbconnection().configDB();
        String sql = """
                SELECT p.id_anggota, p.nama, p.judul, p.tanggal,
                       g.tanggal_pengembalian, g.status_pengembalian, g.lama_keterlambatan, g.denda
                FROM peminjaman p
                LEFT JOIN pengembalian g ON p.id_peminjaman = g.id_peminjaman
                ORDER BY p.id_peminjaman ASC
            """;
        java.sql.Statement stat = con.createStatement();
        java.sql.ResultSet hasil = stat.executeQuery(sql);

        while (hasil.next()) {
            String[] data = {
                    hasil.getString("id_anggota"),
                    hasil.getString("nama"),
                    hasil.getString("judul"),
                    hasil.getString("tanggal"),
                    hasil.getString("tanggal_pengembalian"),
                    hasil.getString("status_pengembalian"),
                    hasil.getString("lama_keterlambatan"),
                    hasil.getString("denda")
                };
            tbl4.addRow(data);
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        dispose();
    }
}

    private void tampil_buku() {
        Object []baris = {"Kode Buku", "Judul Buku", "Jenis", "Tanggal Input", "Pengarang"};
        tbl2 = new DefaultTableModel(null, baris) {
        public boolean isCellEditable(int row, int column) {
        return false;
        }
    };
    tb_buku.setModel(tbl2);
    
         try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM buku ORDER BY id_buku ASC";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            while (hasil.next()) {
                String jenis = null;
                String kode = hasil.getString("kode");
                String judul = hasil.getString("judul");
                String tanggal = hasil.getString("tanggal");
                String pengarang = hasil.getString("pengarang");
                
                if (hasil.getString("jenis").equals("1")) {
                    jenis = "Ensiklopedia";
                } else if (hasil.getString("jenis").equals("2")) {
                    jenis = "Novel";
                } else if (hasil.getString("jenis").equals("3")) {
                    jenis = "Komik";
                } else if (hasil.getString("jenis").equals("4")) {
                    jenis = "Biografi";
                } else if (hasil.getString("jenis").equals("5")) {
                    jenis = "Dongeng";
                } else if (hasil.getString("jenis").equals("6")) {
                    jenis = "Karya Ilmiah";
               }
                
                String[] data = {kode, judul, jenis, tanggal, pengarang};
                tbl2.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DaTA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            dispose();
        }
    }
    
    private void tampil_anggota() {
        Object []baris = {"ID Anggota", "Nama Lengkap", "Tempat Lahir", "Tanggal Lahir", "Tanggal Masuk"};
        tbl3 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_anggota.setModel(tbl3);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM anggota ORDER BY id_anggota ASC";
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            while (hasil.next()) {
                String id_anggota = hasil.getString("id_anggota");
                String nama = hasil.getString("nama");
                String tempat_lahir = hasil.getString("tempat_lahir");
                String tanggal_lahir = hasil.getString("tanggal_lahir");
                String tanggal = hasil.getString("tanggal");
                
                String[] data = {id_anggota, nama, tempat_lahir, tanggal_lahir, tanggal};
                tbl3.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATa!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            dispose();
        }
    }
    
    private void search_peminjaman() {
        String query = search_peminjaman.getText();
        
        Object []baris = {"ID Anggota", "Nama", "Kode Buku", "Judul Buku", "Tanggal Peminjaman"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_peminjaman.setModel(tbl1);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM peminjaman WHERE BINARY "
                    + "id_anggota LIKE '%"+query+"%' "
                    + "OR nama LIKE '%"+query+"%' "
                    + "OR kode LIKE '%"+query+"%' "
                    + "OR judul LIKE '%"+query+"%' "
                    + "OR tanggal LIKE '%"+query+"%' "
                    + "ORDER BY id_peminjaman ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String id_anggota = hasil.getString("id_anggota");
                String nama = hasil.getString("nama");
                String kode = hasil.getString("kode");
                String judul = hasil.getString("judul");
                String tanggal = hasil.getString("tanggal");
                
                String[] data = {id_anggota, nama, kode, judul, tanggal};
                tbl1.addRow(data);
            }
            
            if (!query.equals("")) {
                result_peminjaman.setText("Hasil pencarian dari: '"+query+"'");
            } else {
                result_peminjaman.setText("");
            }
        } catch (Exception e) {}
    }
    
    private void search_pengembalian() {
    String query = search_pengembalian.getText();

    Object[] baris = {"ID Anggota", "Nama", "Judul Buku",
        "Tanggal Pinjam", "Tanggal Pengembalian",
        "Status", "Telat (hari)", "Denda"};
    tbl4 = new DefaultTableModel(null, baris) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tb_pengembalian.setModel(tbl4);

    try {
        Connection con = new database.dbconnection().configDB();
        String sql = "SELECT p.id_anggota, p.nama, p.judul, p.tanggal, " +
                     "k.tanggal_pengembalian, k.status_pengembalian, k.lama_keterlambatan, k.denda " +
                     "FROM peminjaman p " +
                     "LEFT JOIN pengembalian k ON p.id_peminjaman = k.id_peminjaman " +
                     "WHERE BINARY " +
                     "p.id_anggota LIKE ? OR p.nama LIKE ? OR p.judul LIKE ? OR p.tanggal LIKE ? " +
                     "ORDER BY p.id_peminjaman ASC";

        PreparedStatement pst = con.prepareStatement(sql);
        String likeQuery = "%" + query + "%";
        pst.setString(1, likeQuery);
        pst.setString(2, likeQuery);
        pst.setString(3, likeQuery);
        pst.setString(4, likeQuery);

        ResultSet hasil = pst.executeQuery();

        while (hasil.next()) {
            String tanggalPengembalian = hasil.getString("tanggal_pengembalian");
            if (tanggalPengembalian == null) {
                tanggalPengembalian = "-"; 
            }
            String status = hasil.getString("status_pengembalian");
            if (status == null) {
                status = "-";
            }
            String telat = hasil.getString("lama_keterlambatan");
            if (telat == null) {
                telat = "0";
            }
            String denda = hasil.getString("denda");
            if (denda == null) {
                denda = "0";
            }

            String[] data = {
                hasil.getString("id_anggota"),
                hasil.getString("nama"),
                hasil.getString("judul"),
                hasil.getString("tanggal"),
                tanggalPengembalian,
                status,
                telat,
                denda
            };
            tbl4.addRow(data);
        }

        if (!query.equals("")) {
            result_pengembalian.setText("Hasil pencarian dari: '" + query + "'");
        } else {
            result_pengembalian.setText("");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal pencarian: " + e.getMessage());
    }
}

    private void search_buku() {
        String query = search_buku.getText();
        
        Object []baris = {"Kode Buku", "Judul Buku", "Jenis", "Tanggal Input", "Pengarang"};
        tbl2 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_buku.setModel(tbl2);
        
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
                String jenis = null;
                String kode = hasil.getString("kode");
                String judul = hasil.getString("judul");
                String tanggal = hasil.getString("tanggal");
                String pengarang = hasil.getString("pengarang");
                
                if (hasil.getString("jenis").equals("1")) {
                    jenis = "Ensiklopedia";
                } else if (hasil.getString("jenis").equals("2")) {
                    jenis = "Novel";
                } else if (hasil.getString("jenis").equals("3")) {
                    jenis = "Komik";
                } else if (hasil.getString("jenis").equals("4")) {
                    jenis = "Biografi";
                } else if (hasil.getString("jenis").equals("5")) {
                    jenis = "Dongeng";
                } else if (hasil.getString("jenis").equals("6")) {
                    jenis = "Karya Ilmiah";
                }
                
                String[] data = {kode, judul, jenis, tanggal, pengarang};
                tbl2.addRow(data);
            }
            
            if (!query.equals("")) {
                result_buku.setText("Hasil pencarian dari: '"+query+"'");
            } else {
                result_buku.setText("");
            }
        } catch (Exception e) {}
    }
    
    private void search_anggota() {
        String query = search_anggota.getText();
        
        Object []baris = {"ID Angota", "Nama Lengkap", "Tempat Lahir", "Tanggal Lahir", "Tanggal Masuk"};
        tbl3 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tb_anggota.setModel(tbl3);
        
        try {
            Connection con = new database.dbconnection().configDB();
            String sql = "SELECT * FROM anggota WHERE BINARY "
                    + "id_anggota LIKE '%"+query+"%' "
                    + "OR nama LIKE '%"+query+"%' "
                    + "OR tempat_lahir LIKE '%"+query+"%' "
                    + "OR tanggal_lahir LIKE '%"+query+"%' "
                    + "OR tanggal LIKE '%"+query+"%' "
                    + "ORDER BY id_anggota ASC";
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet hasil = stmt.executeQuery(sql);
            
            while (hasil.next()) {
                String id_anggota = hasil.getString("id_anggota");
                String nama = hasil.getString("nama");
                String tempat_lahir = hasil.getString("tempat_lahir");
                String tanggal_lahir = hasil.getString("tanggal_lahir");
                String tanggal = hasil.getString("tanggal");
                
                String[] data = {id_anggota, nama, tempat_lahir, tanggal_lahir, tanggal};
                tbl3.addRow(data);
            }
            
            if (!query.equals("")) {
                result_anggota.setText("Hasil pencarian dari: '"+query+"'");
            } else {
                result_anggota.setText("");
            }
        } catch (Exception e) {}
    }
                    
    private javax.swing.JPanel body;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel hapus1;
    private javax.swing.JLabel hapus1_value;
    private javax.swing.JPanel hapus2;
    private javax.swing.JLabel hapus2_value;
    private javax.swing.JPanel hapus3;
    private javax.swing.JLabel hapus3_value;
     private javax.swing.JPanel hapus4;
    private javax.swing.JLabel hapus4_value;
    private javax.swing.JPanel header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel kelolabuku;
    private javax.swing.JPanel kelolaanggota;
    private javax.swing.JPanel peminjaman;
    private javax.swing.JPanel pengembalian;
    private javax.swing.JLabel result_buku;
    private javax.swing.JLabel result_peminjaman;
    private javax.swing.JLabel result_pengembalian;
    private javax.swing.JLabel result_anggota;
    private javax.swing.JTextField search_buku;
    private javax.swing.JTextField search_peminjaman;
    private javax.swing.JTextField search_pengembalian;
    private javax.swing.JTextField search_anggota;
    private javax.swing.JPanel segarkan1;
    private javax.swing.JLabel segarkan1_value;
    private javax.swing.JPanel segarkan2;
    private javax.swing.JLabel segarkan2_value;
    private javax.swing.JPanel segarkan3;
    private javax.swing.JLabel segarkan3_value;
    private javax.swing.JPanel segarkan4;
    private javax.swing.JLabel segarkan4_value;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JPanel tambah1;
    private javax.swing.JLabel tambah1_value;
    private javax.swing.JPanel tambah2;
    private javax.swing.JLabel tambah2_value;
    private javax.swing.JPanel tambah3;
    private javax.swing.JLabel tambah3_value;
    private javax.swing.JTable tb_buku;
    private javax.swing.JTable tb_peminjaman;
    private javax.swing.JTable tb_pengembalian;
    private javax.swing.JTable tb_anggota;
    private javax.swing.JLabel title;
    private javax.swing.JPanel ubah1;
    private javax.swing.JLabel ubah1_value;
    private javax.swing.JPanel ubah2;
    private javax.swing.JLabel ubah2_value;
    private javax.swing.JPanel ubah3;
    private javax.swing.JLabel ubah3_value;
    private javax.swing.JPanel ubah4;
    private javax.swing.JLabel ubah4_value;
    private javax.swing.JPanel userinfo;   
    private javax.swing.JLabel timenow;
   }
    
