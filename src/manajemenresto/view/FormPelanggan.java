/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package manajemenresto.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import manajemenresto.controller.UserController;
import manajemenresto.model.User;

/**
 *
 * @author vincentexelcio
 */
public class FormPelanggan extends javax.swing.JPanel {

    /**
     * Creates new form FormPelanggan
     */
    public FormPelanggan() {
        initComponents();
        fillCombobox();
        fillTabelUser();
        buttonBatal.setVisible(false);
    }
    UserController userController = new UserController();
    User SELECTED_USER = new User();

    public void fillCombobox() {
        comboBoxUser.removeAllItems();
        comboBoxUser.addItem("pilih user");
        ArrayList<User> userList = userController.getAllUser();
        
        if (userList != null) {
            for (User user: userList) {
                comboBoxUser.addItem(user.getUsername());
            }
        }
    }
    
    public void resetState() {
        textUsername.setText("");
        textNomorTelepon.setText("");
        textPassword.setText("");
        SELECTED_USER = new User();
        comboBoxUser.setSelectedItem("pilih user");
        fillCombobox();
        fillTabelUser();
    }
    
    public void fillTabelUser() {
        DefaultTableModel df = (DefaultTableModel)tabelUser.getModel();
        df.getDataVector().removeAllElements();
        ArrayList<User> userList = userController.getAllUser();
        
        if (userList != null) {
            int no = 1;
            for (User user: userList) {
                Object[] obj = new Object[4];
                obj[0] = no;
                obj[1] = user.getUsername();
                obj[2] = user.getNoTelp();
                obj[3] = user.getRole();
                ++no;
                df.addRow(obj);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNomorTelepon = new javax.swing.JTextField();
        buttonHapus = new javax.swing.JToggleButton();
        comboBoxUser = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buttonCari = new javax.swing.JToggleButton();
        buttonTambah = new javax.swing.JToggleButton();
        buttonEdit = new javax.swing.JToggleButton();
        buttonBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        logout = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 40, 50));

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Nomor telepon", "Role"
            }
        ));
        jScrollPane1.setViewportView(tabelUser);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nomor Telepon");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        buttonHapus.setText("hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        comboBoxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUserActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cari Pelanggan");

        buttonCari.setText("cari");
        buttonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariActionPerformed(evt);
            }
        });

        buttonTambah.setText("tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonEdit.setText("edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonBatal.setText("batal");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Pelanggan");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textNomorTelepon)
                                    .addComponent(textPassword)
                                    .addComponent(textUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonBatal)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonCari))
                                    .addComponent(comboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(logout)
                                .addGap(25, 25, 25))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logout)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonHapus)
                            .addComponent(buttonTambah)
                            .addComponent(buttonEdit)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCari)
                            .addComponent(buttonBatal))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        
        String username = textUsername.getText();
        String noTelp = textNomorTelepon.getText();
        String password = new String(textPassword.getPassword());
        boolean status = userController.createUser(username, noTelp, password);
        
        if (!status) {
            JOptionPane.showMessageDialog(this, "User gagal tersimpan");
            return;
        }
        JOptionPane.showMessageDialog(this, "User berhasil ditambahkan");
        resetState();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariActionPerformed
        String pilihanUser = comboBoxUser.getSelectedItem().toString();
        
        if (pilihanUser.equals("pilih user")) {
            JOptionPane.showMessageDialog(this, "Silahkan memilih menu terlebih dahulu");
            return;
        }
        
        SELECTED_USER = userController.getUserByUsername(pilihanUser);
        
        if (SELECTED_USER == null) {
            JOptionPane.showMessageDialog(this, "Gagal mendapatkan menu");
        }
        
        textUsername.setText(SELECTED_USER.getUsername());
        textNomorTelepon.setText(SELECTED_USER.getNoTelp());
        textPassword.setText(SELECTED_USER.getPassword());
    }//GEN-LAST:event_buttonCariActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        User userBaru = new User();
        
        if (SELECTED_USER.getUsername() == null) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih User terlebih dahulu");
            return;
        }
        
        userBaru.setUsername(textUsername.getText());
        userBaru.setNoTelp(textNomorTelepon.getText());
        userBaru.setPassword(new String(textPassword.getPassword()));
        userBaru.setRole(SELECTED_USER.getRole());
        
        boolean status = userController.updateUserByUsername(SELECTED_USER.getUsername(), userBaru);
        
        if (!status) {
            JOptionPane.showMessageDialog(this, "User gagal diubah");
            return;
        }
        JOptionPane.showMessageDialog(this, "User berhasil diubah");
        resetState();
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        if (SELECTED_USER.getUsername()== null) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih User terlebih dahulu");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin?");
        if (confirm == JOptionPane.CANCEL_OPTION || confirm == JOptionPane.NO_OPTION) {
            return;
        }
        boolean status = userController.deleteUserByUsername(SELECTED_USER.getUsername().toString());
        
        if (!status) {
            JOptionPane.showMessageDialog(this, "User gagal dihapus");
            return;
        }
        JOptionPane.showMessageDialog(this, "User berhasil dihapus");
        resetState();
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        resetState();
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void comboBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUserActionPerformed
        Object pilihanUser = comboBoxUser.getSelectedItem();

        if (pilihanUser != null && !pilihanUser.toString().equals("pilih user")){
            buttonBatal.setVisible(true);
        }
        else {
            buttonBatal.setVisible(false);
        }
    }//GEN-LAST:event_comboBoxUserActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.setVisible(false);
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JToggleButton buttonCari;
    private javax.swing.JToggleButton buttonEdit;
    private javax.swing.JToggleButton buttonHapus;
    private javax.swing.JToggleButton buttonTambah;
    private javax.swing.JComboBox<String> comboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField textNomorTelepon;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables

   
}
