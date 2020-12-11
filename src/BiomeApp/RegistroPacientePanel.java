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
public class RegistroPacientePanel extends javax.swing.JFrame {

    final String cargo = "paciente";
    String idPaciente = "";

    /**
     * Creates new form Enfermero
     */
    public RegistroPacientePanel() {
        initComponents();
        this.setTitle("Paciente");
        this.setLocation(250, 50);
        this.setResizable(false);
        groupButton();
        update_buttom.setVisible(false);
        create_buttom.setVisible(true);
        initEnfermero();
    }

    public RegistroPacientePanel(String id) {
        initComponents();
        this.setTitle("Editar Paciente");
        this.setLocation(250, 50);
        this.setResizable(false);
        groupButton();
        titulo.setText("Editar Paciente");
        idPaciente = id;
        InitEdit(id);
        update_buttom.setVisible(true);
        create_buttom.setVisible(false);
        initEnfermero();
    }

    private void initEnfermero() {
        try {
            Connection con;
            Conexion registercon = new Conexion();
            con = registercon.getConnection();
            String query = "select * from enfermero";
            PreparedStatement pstm;
            pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                combo_enfermero.addItem(rs.getString("Nombre") + " " + rs.getString("Apellido"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPacientePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void InitEdit(String id) {
        try {
            Connection con;
            Conexion registercon = new Conexion();
            con = registercon.getConnection();
            String query = "select * from paciente where id=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nom.setText(rs.getString("Nombre"));
                ape.setText(rs.getString("Apellido"));
                text_codigo.setText(rs.getString("Codigo_paciente"));
                text_motivo.setText(rs.getString("Consulta_descripcion"));
                text_diagnostico.setText(rs.getString("Diagnostico"));
                combo_enfermero.setSelectedItem(rs.getString("Codigo_enfermero"));
                if (rs.getString("Sexo").equals("M")) {
                    masculino.setSelected(true);
                } else {
                    femenino.setSelected(true);
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
        bg1.add(masculino);
        bg1.add(femenino);
    }

    public String getUserGenre() {

        String radioText = "";
        if (masculino.isSelected()) {
            radioText = masculino.getText();
        }
        if (femenino.isSelected()) {
            radioText = femenino.getText();
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
        ape = new javax.swing.JTextField();
        text_codigo = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        jbl_Contraseña = new javax.swing.JLabel();
        jbl_Contraseña1 = new javax.swing.JLabel();
        jbl_Contraseña3 = new javax.swing.JLabel();
        campo_fecha = new com.toedter.calendar.JDateChooser();
        jbl_Especialidad1 = new javax.swing.JLabel();
        masculino = new javax.swing.JRadioButton();
        femenino = new javax.swing.JRadioButton();
        create_buttom = new javax.swing.JButton();
        jbl_Especialidad3 = new javax.swing.JLabel();
        jbl_Contraseña5 = new javax.swing.JLabel();
        jbl_Contraseña6 = new javax.swing.JLabel();
        combo_enfermero = new javax.swing.JComboBox<>();
        jbl_Contraseña7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_diagnostico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_motivo = new javax.swing.JTextArea();
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
        titulo.setText("Registro Paciente");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 20));

        ape.setBackground(new java.awt.Color(102, 0, 102));
        ape.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ape.setForeground(new java.awt.Color(255, 255, 255));
        ape.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ape.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        ape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apeKeyTyped(evt);
            }
        });
        jPanel2.add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, -1));

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

        nom.setBackground(new java.awt.Color(102, 0, 102));
        nom.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });
        jPanel2.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, -1));

        jbl_Contraseña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña.setText("Nombre:");
        jPanel2.add(jbl_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jbl_Contraseña1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña1.setText("Apellidos:");
        jPanel2.add(jbl_Contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jbl_Contraseña3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña3.setText("Codigo Paciente");
        jPanel2.add(jbl_Contraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        campo_fecha.setBackground(new java.awt.Color(102, 0, 102));
        campo_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(campo_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 210, -1));

        jbl_Especialidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad1.setText("Sexo");
        jPanel2.add(jbl_Especialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        masculino.setBackground(new java.awt.Color(153, 0, 153));
        masculino.setForeground(new java.awt.Color(255, 255, 255));
        masculino.setText("M");
        masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoActionPerformed(evt);
            }
        });
        jPanel2.add(masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        femenino.setBackground(new java.awt.Color(153, 0, 153));
        femenino.setForeground(new java.awt.Color(255, 255, 255));
        femenino.setText("F");
        jPanel2.add(femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        create_buttom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        create_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(create_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jbl_Especialidad3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad3.setText("Fecha de Nacimiento:");
        jPanel2.add(jbl_Especialidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jbl_Contraseña5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña5.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña5.setText("Enfermero/a");
        jPanel2.add(jbl_Contraseña5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        jbl_Contraseña6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña6.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña6.setText("Motivo Consulta");
        jPanel2.add(jbl_Contraseña6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        combo_enfermero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_enfermeroActionPerformed(evt);
            }
        });
        jPanel2.add(combo_enfermero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 210, -1));

        jbl_Contraseña7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña7.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña7.setText("Diagnostico");
        jPanel2.add(jbl_Contraseña7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, -1));

        text_diagnostico.setColumns(20);
        text_diagnostico.setRows(5);
        jScrollPane1.setViewportView(text_diagnostico);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 250, 80));

        text_motivo.setColumns(20);
        text_motivo.setRows(5);
        jScrollPane2.setViewportView(text_motivo);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 220, 110));

        update_buttom.setText("Actualizar");
        update_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(update_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, -1));

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
        new AdministradorPanel("paciente").setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed

    private void text_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_codigoActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void masculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoActionPerformed

    private void create_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttomActionPerformed
        String nombre = nom.getText();
        String apellido = ape.getText().trim();
        String consulta_descripcion = text_motivo.getText().trim();
        String genero = getUserGenre();
        String codigo_paciente = text_codigo.getText();
        String condigo_enfermero = combo_enfermero.getSelectedItem().toString();
        String diagnostico = text_diagnostico.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || consulta_descripcion.isEmpty() || codigo_paciente.isEmpty() || condigo_enfermero.isEmpty() || diagnostico.isEmpty() || apellido.isEmpty() || genero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                Date fecha = campo_fecha.getCalendar().getTime();
                java.sql.Date dateDB = new java.sql.Date(fecha.getTime());

                Connection con;
                Conexion registercon = new Conexion();
                con = registercon.getConnection();
                String query = "insert into paciente (Nombre, Apellido, Sexo, Fecha, Codigo_paciente, Codigo_enfermero, Consulta_descripcion, Diagnostico, Cargo) values" + "( ?, ?, ?, ?, ?, ? ,? ,? , ?)";

                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, nombre);
                pstm.setString(2, apellido);
                pstm.setString(3, genero);
                pstm.setDate(4, dateDB);
                pstm.setString(5, codigo_paciente);
                pstm.setString(6, condigo_enfermero);
                pstm.setString(7, consulta_descripcion);
                pstm.setString(8, diagnostico);
                pstm.setString(9, cargo);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                new AdministradorPanel(cargo).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPacientePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_create_buttomActionPerformed

    private void nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_nomKeyTyped

    private void apeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apeKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_apeKeyTyped

    private void combo_enfermeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_enfermeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_enfermeroActionPerformed

    private void update_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttomActionPerformed
        String nombre = nom.getText();
        String apellido = ape.getText().trim();
        String consulta_descripcion = text_motivo.getText().trim();
        String genero = getUserGenre();
        String codigo_paciente = text_codigo.getText();
        String condigo_enfermero = combo_enfermero.getSelectedItem().toString();
        String diagnostico = text_diagnostico.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || consulta_descripcion.isEmpty() || codigo_paciente.isEmpty() || condigo_enfermero.isEmpty() || diagnostico.isEmpty() || apellido.isEmpty() || genero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                Date fecha = campo_fecha.getCalendar().getTime();
                java.sql.Date dateDB = new java.sql.Date(fecha.getTime());
                Connection con;
                Conexion registercon = new Conexion();
                con = registercon.getConnection();
                String query = "UPDATE paciente SET Nombre=?, Apellido=?, Sexo=?, Fecha=?, Codigo_paciente=?, Codigo_enfermero=?, Consulta_descripcion=?, Diagnostico=? WHERE id=?;";
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, nombre);
                pstm.setString(2, apellido);
                pstm.setString(3, genero);
                pstm.setDate(4, dateDB);
                pstm.setString(5, codigo_paciente);
                pstm.setString(6, condigo_enfermero);
                pstm.setString(7, consulta_descripcion);
                pstm.setString(8, diagnostico);
                pstm.setString(9, idPaciente);
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Actualizacion Exitoso");
                new GestorUsuarios(cargo).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(RegistroPacientePanel.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(RegistroPacientePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPacientePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape;
    private com.toedter.calendar.JDateChooser campo_fecha;
    private javax.swing.JComboBox<String> combo_enfermero;
    private javax.swing.JButton create_buttom;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jbl_Contraseña;
    private javax.swing.JLabel jbl_Contraseña1;
    private javax.swing.JLabel jbl_Contraseña3;
    private javax.swing.JLabel jbl_Contraseña5;
    private javax.swing.JLabel jbl_Contraseña6;
    private javax.swing.JLabel jbl_Contraseña7;
    private javax.swing.JLabel jbl_Especialidad1;
    private javax.swing.JLabel jbl_Especialidad3;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField text_codigo;
    private javax.swing.JTextArea text_diagnostico;
    private javax.swing.JTextArea text_motivo;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton update_buttom;
    // End of variables declaration//GEN-END:variables
}
