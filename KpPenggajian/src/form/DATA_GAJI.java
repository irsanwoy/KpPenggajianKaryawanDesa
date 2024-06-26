
package form;
import database.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DATA_GAJI extends javax.swing.JFrame {
private DefaultTableModel model;

    public DATA_GAJI() {
        initComponents();
        setLocationRelativeTo(this);
        model = new DefaultTableModel();
        tblGaji.setModel(model);
        model.addColumn("ID Gaji");
        model.addColumn("Gaji Pokok");
        model.addColumn("Tunjangan");
        model.addColumn("Potongan");
        model.addColumn("Total Gaji");
        loadDataPegawai();
    }
    
    private void loadDataPegawai(){
    try {
        Connection connection = Koneksi.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, gaji_pokok, tunjangan, potongan, total_gaji FROM data_gaji");

        while (resultSet.next()) {
            Object[] row = {
                resultSet.getString("id"),
                resultSet.getString("gaji_pokok"),
                resultSet.getString("tunjangan"),
                resultSet.getString("potongan"),
                resultSet.getString("total_gaji")
            };
            model.addRow(row);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void updateDataGaji() {
    String id_gaji = tfIdGaji.getText();
    String gajiPokok = tfGajiPokok.getText();
    String tunjangan = tfTunjangan.getText();
    String potongan = tfPotongan.getText();

    try {
        Connection connection = Koneksi.getConnection();

        String query = "UPDATE data_gaji SET gaji_pokok = ?, tunjangan = ?, potongan = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, gajiPokok);
        preparedStatement.setString(2, tunjangan);
        preparedStatement.setString(3, potongan);
        preparedStatement.setString(4, id_gaji);

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Data berhasil diubah.");
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        }

        preparedStatement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfIdGaji = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfGajiPokok = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTunjangan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bUbah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        tfPotongan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGaji = new javax.swing.JTable();
        tfCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1002, 558));

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("APLIKASI PENGGAJIAN PEGAWAI KARYAWAN DESA");

        jLabel3.setText("USERNAME");

        jLabel4.setText("PASSWORD");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/logoSub.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 578, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(326, 326, 326)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        jButton1.setText("DATA PEGAWAI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UBAH PASSWORD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel5.setText("MENU");

        jButton3.setText("DATA GAJI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("PENGGAJIAN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("LAPORAN PENGGAJIAN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("LOGOUT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jPanel4.setBackground(new java.awt.Color(0, 204, 0));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel6.setText("DATA GAJI");

        jLabel7.setText("ID Gaji");

        tfIdGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdGajiActionPerformed(evt);
            }
        });

        jLabel8.setText("Gaji Pokok");

        tfGajiPokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGajiPokokActionPerformed(evt);
            }
        });

        jLabel9.setText("Tunjangan");

        tfTunjangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTunjanganActionPerformed(evt);
            }
        });

        jLabel10.setText("Potongan");

        bUbah.setText("UBAH");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bSimpan.setText("SIMPAN");
        bSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSimpanMouseClicked(evt);
            }
        });
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bHapus.setText("HAPUS");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("BATAL");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        tfPotongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPotonganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIdGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPotongan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdGaji, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPotongan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bUbah)
                    .addComponent(bSimpan)
                    .addComponent(bHapus)
                    .addComponent(bBatal))
                .addContainerGap(354, Short.MAX_VALUE))
        );

        tblGaji.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGajiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGaji);

        bCari.setText("CARI");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCari, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdGajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdGajiActionPerformed

    private void tfGajiPokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGajiPokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGajiPokokActionPerformed

    private void tfTunjanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTunjanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTunjanganActionPerformed

    private void tfPotonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPotonganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPotonganActionPerformed

    private void tblGajiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGajiMouseClicked
        // TODO add your handling code here:
        int baris = tblGaji.rowAtPoint(evt.getPoint());
        String id_gaji = tblGaji.getValueAt(baris, 0).toString();
        tfIdGaji.setText(id_gaji);
        String jabatan = tblGaji.getValueAt(baris, 1).toString();
        tfGajiPokok.setText(jabatan);
        String gajiPokok = tblGaji.getValueAt(baris, 2).toString();
        tfTunjangan.setText(gajiPokok);
        String tunjangan = tblGaji.getValueAt(baris, 3).toString();
        tfPotongan.setText(tunjangan);
    }//GEN-LAST:event_tblGajiMouseClicked

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:

    try {
        // Mendapatkan data dari input field
        String idGaji = tfIdGaji.getText();
        String jabatan = tfGajiPokok.getText();
        String gajiPokok = tfTunjangan.getText();
        String tunjangan = tfPotongan.getText();

        // Membuat koneksi ke database
        Connection connection = Koneksi.getConnection();

        // Membuat query untuk insert data dengan PreparedStatement
        String query = "INSERT INTO data_gaji (id, gaji_pokok, tunjangan, potongan) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, idGaji); // Memasukkan pegawai_id, bukan id
        preparedStatement.setString(2, jabatan);
        preparedStatement.setString(3, gajiPokok);
        preparedStatement.setString(4, tunjangan); // Jika tidak ada potongan


        // Menjalankan query
        preparedStatement.executeUpdate();

        // Menutup koneksi
        preparedStatement.close();
        connection.close();

        // Refresh data tabel
        model.setRowCount(0); // Membersihkan data yang ada
        loadDataPegawai(); // Memuat data yang baru
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_bSimpanActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
         updateDataGaji();
         model.setRowCount(0); // Membersihkan data yang ada
         loadDataPegawai(); // Memuat data yang baru
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM data_gaji WHERE id='" + tfIdGaji.getText() + "'";

            Connection con = (Connection) Koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            model.setRowCount(0);
            loadDataPegawai();
        } catch (Exception e) {
            // Tanggapan terhadap eksepsi
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
            e.printStackTrace(); // Menampilkan jejak stack trace

            // Tambahkan pesan debug
            System.out.println("Pesan Debug: " + e.getMessage());
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        tfIdGaji.setText("");
        tfGajiPokok.setText("");
        tfPotongan.setText("");
        tfTunjangan.setText("");
    }//GEN-LAST:event_bBatalActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0); // Membersihkan data yang ada
        try {
            Connection connection = Koneksi.getConnection();
           
            String query = "SELECT * FROM data_gaji WHERE id LIKE ? OR gaji_pokok LIKE ? OR tunjangan LIKE ? OR potongan LIKE ? OR total_gaji LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String searchText = "%" + tfCari.getText() + "%";
            preparedStatement.setString(1, searchText);
            preparedStatement.setString(2, searchText);
            preparedStatement.setString(3, searchText);
            preparedStatement.setString(4, searchText);
            preparedStatement.setString(5, searchText);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("id"),
                    resultSet.getString("gaji_pokok"),
                    resultSet.getString("tunjangan"),
                    resultSet.getString("potongan"), // Sesuaikan tipe data sesuai kolom di database
                    resultSet.getString("total_gaji")
                };
                model.addRow(row);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bCariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DATA_PEGAWAI dataPegawaiForm = new DATA_PEGAWAI();
        dataPegawaiForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DATA_GAJI dataGaji = new DATA_GAJI();
        dataGaji.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DATA_PENGGAJIAN dataPenggajian = new DATA_PENGGAJIAN();
        dataPenggajian.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LAPORAN_PENGGAJIAN laporanPenggajian = new LAPORAN_PENGGAJIAN();
        laporanPenggajian.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSimpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bSimpanMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        LOGIN login = new LOGIN();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DATA_GAJI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DATA_GAJI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DATA_GAJI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DATA_GAJI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DATA_GAJI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bUbah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblGaji;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfGajiPokok;
    private javax.swing.JTextField tfIdGaji;
    private javax.swing.JTextField tfPotongan;
    private javax.swing.JTextField tfTunjangan;
    // End of variables declaration//GEN-END:variables
}
