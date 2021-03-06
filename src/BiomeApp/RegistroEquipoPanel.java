/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiomeApp;

import Conexion.Conexion;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;

/**
 *
 * @author alvar
 */
public class RegistroEquipoPanel extends javax.swing.JFrame {

    final String cargo = "equipo";
    String idEquipo = "";
    String cargoUsuario = "";
    boolean edit = false;

    /**
     * Creates new form Enfermero
     */
    public RegistroEquipoPanel(String cargo) {
        initComponents();
        this.setTitle("Equipo");
        this.setLocation(250, 50);
        this.setResizable(false);
        groupButton();
        cargoUsuario = cargo;
        update_buttom.setVisible(false);
        create_buttom.setVisible(true);
    }

    public RegistroEquipoPanel(String id, String cargo) {
        initComponents();
        this.setTitle("Equipo");
        this.setLocation(250, 50);
        this.setResizable(false);
        groupButton();
        titulo.setText("Editar Equipo");
        idEquipo = id;
        cargoUsuario = cargo;
        edit = true;
        InitEdit(id);
        update_buttom.setVisible(true);
        create_buttom.setVisible(false);
    }

    private RegistroEquipoPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void InitEdit(String id) {
        try {
            Connection con;
            Conexion registercon = new Conexion();
            con = registercon.getConnection();
            String query = "select * from equipo where id=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                text_Equipo.setText(rs.getString("Equipo"));
                text_estado.setText(rs.getString("Estado"));
                text_descripcion.setText(rs.getString("Descripcion"));
                text_codigo.setText(rs.getString("Codigo"));
                if (rs.getString("Estado_descripcion").equals("En Uso")) {
                    check_uso.setSelected(true);
                } else if (rs.getString("Estado_descripcion").equals("En Mantenimiento")) {
                    check_mantenimiento.setSelected(true);
                } else if (rs.getString("Estado_descripcion").equals("En Deuso")) {
                    check_deuso.setSelected(true);
                }
                try {
                    String fecha = rs.getString("Fecha");
                    Date date = new SimpleDateFormat("yy-mm-dd").parse(fecha);
                    campo_fecha.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void groupButton() {
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(check_mantenimiento);
        bg1.add(check_uso);
        bg1.add(check_deuso);
    }

    public String getEquipoEstado() {

        String radioText = "";
        if (check_mantenimiento.isSelected()) {
            radioText = check_mantenimiento.getText();
        }
        if (check_uso.isSelected()) {
            radioText = check_uso.getText();
        }
        if (check_deuso.isSelected()) {
            radioText = check_deuso.getText();
        }
        return radioText;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        text_estado = new javax.swing.JTextField();
        text_codigo = new javax.swing.JTextField();
        text_Equipo = new javax.swing.JTextField();
        jbl_Contraseña = new javax.swing.JLabel();
        jbl_Contraseña1 = new javax.swing.JLabel();
        jbl_Contraseña3 = new javax.swing.JLabel();
        campo_fecha = new com.toedter.calendar.JDateChooser();
        jbl_Especialidad1 = new javax.swing.JLabel();
        check_mantenimiento = new javax.swing.JRadioButton();
        check_uso = new javax.swing.JRadioButton();
        create_buttom = new javax.swing.JButton();
        jbl_Especialidad3 = new javax.swing.JLabel();
        jbl_Contraseña6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_descripcion = new javax.swing.JTextArea();
        check_deuso = new javax.swing.JRadioButton();
        update_buttom = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(72, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("Atras");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Registro Equipos");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 20));

        text_estado.setBackground(new java.awt.Color(102, 0, 102));
        text_estado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        text_estado.setForeground(new java.awt.Color(255, 255, 255));
        text_estado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_estado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_estadoActionPerformed(evt);
            }
        });
        text_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_estadoKeyTyped(evt);
            }
        });
        jPanel2.add(text_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 210, -1));

        text_codigo.setBackground(new java.awt.Color(102, 0, 102));
        text_codigo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        text_codigo.setForeground(new java.awt.Color(255, 255, 255));
        text_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_codigoActionPerformed(evt);
            }
        });
        jPanel2.add(text_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 210, -1));

        text_Equipo.setBackground(new java.awt.Color(102, 0, 102));
        text_Equipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        text_Equipo.setForeground(new java.awt.Color(255, 255, 255));
        text_Equipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_Equipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_EquipoActionPerformed(evt);
            }
        });
        text_Equipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_EquipoKeyTyped(evt);
            }
        });
        jPanel2.add(text_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, -1));

        jbl_Contraseña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña.setText("Equipo:");
        jPanel2.add(jbl_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jbl_Contraseña1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña1.setText("Estado:");
        jPanel2.add(jbl_Contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jbl_Contraseña3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña3.setText("Codigo ");
        jPanel2.add(jbl_Contraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        campo_fecha.setBackground(new java.awt.Color(102, 0, 102));
        campo_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(campo_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 210, -1));

        jbl_Especialidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad1.setText("Estado");
        jPanel2.add(jbl_Especialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        check_mantenimiento.setBackground(new java.awt.Color(153, 0, 153));
        check_mantenimiento.setForeground(new java.awt.Color(255, 255, 255));
        check_mantenimiento.setText("En Mantenimiento");
        check_mantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_mantenimientoActionPerformed(evt);
            }
        });
        jPanel2.add(check_mantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 30));

        check_uso.setBackground(new java.awt.Color(153, 0, 153));
        check_uso.setForeground(new java.awt.Color(255, 255, 255));
        check_uso.setText("En Uso");
        jPanel2.add(check_uso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        create_buttom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        create_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(create_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jbl_Especialidad3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad3.setText("Fecha Instalacion");
        jPanel2.add(jbl_Especialidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jbl_Contraseña6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña6.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña6.setText("Descripcion");
        jPanel2.add(jbl_Contraseña6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        text_descripcion.setColumns(20);
        text_descripcion.setRows(5);
        jScrollPane2.setViewportView(text_descripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 220, 110));

        check_deuso.setBackground(new java.awt.Color(153, 0, 153));
        check_deuso.setForeground(new java.awt.Color(255, 255, 255));
        check_deuso.setText("En Deuso");
        jPanel2.add(check_deuso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        update_buttom.setText("Actualizar");
        update_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(update_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jButton1.setText("logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (edit) {
            new GestorUsuarios(cargoUsuario).setVisible(true);
            dispose();
        } else {
            new AdministradorPanel(cargoUsuario).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void text_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_estadoActionPerformed

    private void text_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_codigoActionPerformed

    private void text_EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_EquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_EquipoActionPerformed

    private void check_mantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_mantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_mantenimientoActionPerformed

    private void create_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttomActionPerformed
        String equipo = text_Equipo.getText();
        String estado = text_estado.getText().trim();
        String descripcion = text_descripcion.getText().trim();
        String estado_equipo = getEquipoEstado();
        String codigo_equipo = text_codigo.getText();

        if (equipo.isEmpty() || estado.isEmpty() || descripcion.isEmpty() || estado_equipo.isEmpty() || codigo_equipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                Date fecha = campo_fecha.getCalendar().getTime();
                java.sql.Date dateDB = new java.sql.Date(fecha.getTime());
                Connection con;
                Conexion registercon = new Conexion();
                con = registercon.getConnection();
                String query = "insert into equipo (Equipo, Estado, Estado_descripcion, Fecha, Codigo, descripcion) values" + "( ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, equipo);
                pstm.setString(2, estado);
                pstm.setString(3, estado_equipo);
                pstm.setDate(4, dateDB);
                pstm.setString(5, codigo_equipo);
                pstm.setString(6, descripcion);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                new AdministradorPanel(cargoUsuario).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEquipoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_create_buttomActionPerformed

    private void text_EquipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_EquipoKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_text_EquipoKeyTyped

    private void text_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_estadoKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_text_estadoKeyTyped

    private void update_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttomActionPerformed
        String equipo = text_Equipo.getText();
        String estado = text_estado.getText().trim();
        String descripcion = text_descripcion.getText().trim();
        String estado_equipo = getEquipoEstado();
        String codigo_equipo = text_codigo.getText();

        if (equipo.isEmpty() || estado.isEmpty() || descripcion.isEmpty() || estado_equipo.isEmpty() || codigo_equipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                Date fecha = campo_fecha.getCalendar().getTime();
                java.sql.Date dateDB = new java.sql.Date(fecha.getTime());
                Connection con;
                Conexion registercon = new Conexion();
                con = registercon.getConnection();
                String query = "update equipo set Equipo=?, Estado=?, Estado_descripcion=?, Fecha=?, Codigo=?, descripcion=? where id=?";
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, equipo);
                pstm.setString(2, estado);
                pstm.setString(3, estado_equipo);
                pstm.setDate(4, dateDB);
                pstm.setString(5, codigo_equipo);
                pstm.setString(6, descripcion);
                pstm.setString(7, idEquipo);
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actulizacion Exitoso");
                new GestorUsuarios(cargoUsuario).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEquipoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_update_buttomActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new LoginPanel().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new RegistroEquipoPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser campo_fecha;
    private javax.swing.JRadioButton check_deuso;
    private javax.swing.JRadioButton check_mantenimiento;
    private javax.swing.JRadioButton check_uso;
    private javax.swing.JButton create_buttom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbl_Contraseña;
    private javax.swing.JLabel jbl_Contraseña1;
    private javax.swing.JLabel jbl_Contraseña3;
    private javax.swing.JLabel jbl_Contraseña6;
    private javax.swing.JLabel jbl_Especialidad1;
    private javax.swing.JLabel jbl_Especialidad3;
    private javax.swing.JTextField text_Equipo;
    private javax.swing.JTextField text_codigo;
    private javax.swing.JTextArea text_descripcion;
    private javax.swing.JTextField text_estado;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton update_buttom;
    // End of variables declaration//GEN-END:variables
}
