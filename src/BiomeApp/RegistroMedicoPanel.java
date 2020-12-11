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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
public class RegistroMedicoPanel extends javax.swing.JFrame {

    File imageFile = null;
    final String cargo = "Medico";
    String medicoId = "";

    /**
     * Creates new form Administrador
     */
    public RegistroMedicoPanel() {
        initComponents();
        this.setTitle("Medico");
        this.setLocation(250, 50);
        this.setResizable(false);
        groupButton();
        update_buttom.setVisible(false);
        create_buttom.setVisible(true);

    }

    public RegistroMedicoPanel(String id) {
        initComponents();
        this.setTitle("Edit Medico");
        this.setLocation(250, 50);
        this.setResizable(false);
        titulo.setText("Editar Medico");
        medicoId = id;
        InitEdit(id);
        update_buttom.setVisible(true);
        create_buttom.setVisible(false);

    }

    public void InitEdit(String id) {

        try {
            Connection con;
            Conexion registercon = new Conexion();
            con = registercon.getConnection();
            String query = "select * from medico where id=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nom.setText(rs.getString("Nombre"));
                ape.setText(rs.getString("Apellido"));
                usuario_name.setText(rs.getString("Usuario"));
                pass.setText(rs.getString("Contraseña"));
                espe.setSelectedItem(rs.getString("Especialidad"));
                if (rs.getString("Sexo").equals("Hombre")) {
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

                byte[] img = rs.getBytes("Imagen");
                //Resize The ImageIcon
                ImageIcon imagen = new ImageIcon(img);
                Image im = imagen.getImage();
                Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                image.setIcon(newImage);
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

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jButton8 = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        ape = new javax.swing.JTextField();
        usuario_name = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        jbl_Contraseña = new javax.swing.JLabel();
        jbl_Contraseña1 = new javax.swing.JLabel();
        jbl_Contraseña2 = new javax.swing.JLabel();
        jbl_Contraseña3 = new javax.swing.JLabel();
        espe = new javax.swing.JComboBox<>();
        jbl_Especialidad = new javax.swing.JLabel();
        campo_fecha = new com.toedter.calendar.JDateChooser();
        jbl_Especialidad1 = new javax.swing.JLabel();
        jbl_Especialidad2 = new javax.swing.JLabel();
        masculino = new javax.swing.JRadioButton();
        femenino = new javax.swing.JRadioButton();
        create_buttom = new javax.swing.JButton();
        jbl_Especialidad3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        update_buttom = new javax.swing.JButton();
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

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, -1));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Registro Medico");
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
        jPanel2.add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        usuario_name.setBackground(new java.awt.Color(102, 0, 102));
        usuario_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        usuario_name.setForeground(new java.awt.Color(255, 255, 255));
        usuario_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usuario_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_nameActionPerformed(evt);
            }
        });
        jPanel2.add(usuario_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, -1));

        pass.setBackground(new java.awt.Color(102, 0, 102));
        pass.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, -1));

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
        jPanel2.add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, -1));

        jbl_Contraseña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña.setText("Nombre:");
        jPanel2.add(jbl_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jbl_Contraseña1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña1.setText("Apellidos:");
        jPanel2.add(jbl_Contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jbl_Contraseña2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña2.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña2.setText("Nombre de Usuario:");
        jPanel2.add(jbl_Contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jbl_Contraseña3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Contraseña3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Contraseña3.setText("Contraseña:");
        jPanel2.add(jbl_Contraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        espe.setBackground(new java.awt.Color(102, 0, 102));
        espe.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        espe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General", "Pediatria ", "Cirugia", "Cardiologia", "Hematologia" }));
        espe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(espe, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 140, -1));

        jbl_Especialidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad.setText("Image:");
        jPanel2.add(jbl_Especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        campo_fecha.setBackground(new java.awt.Color(102, 0, 102));
        campo_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(campo_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 210, -1));

        jbl_Especialidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad1.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad1.setText("Sexo");
        jPanel2.add(jbl_Especialidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jbl_Especialidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad2.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad2.setText("Especialidad:");
        jPanel2.add(jbl_Especialidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, 10));

        masculino.setBackground(new java.awt.Color(153, 0, 153));
        masculino.setForeground(new java.awt.Color(255, 255, 255));
        masculino.setText("M");
        masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoActionPerformed(evt);
            }
        });
        jPanel2.add(masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        femenino.setBackground(new java.awt.Color(153, 0, 153));
        femenino.setForeground(new java.awt.Color(255, 255, 255));
        femenino.setText("F");
        jPanel2.add(femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        create_buttom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        create_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(create_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jbl_Especialidad3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbl_Especialidad3.setForeground(new java.awt.Color(255, 255, 255));
        jbl_Especialidad3.setText("Fecha de Nacimiento:");
        jPanel2.add(jbl_Especialidad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jButton2.setText("Cargar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        image.setForeground(new java.awt.Color(255, 255, 255));
        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 190, 70));

        update_buttom.setText("Update ");
        update_buttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttomActionPerformed(evt);
            }
        });
        jPanel2.add(update_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new AdministradorPanel("medico").setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed

    private void usuario_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuario_nameActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void masculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            imageFile = file.getSelectedFile();
            String path = imageFile.getAbsolutePath();
            image.setIcon(ResizeImage(path));
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Este archivo no es una imagen");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void create_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttomActionPerformed
        String nombre = nom.getText();
        String password = pass.getText().trim();
        String usuario = usuario_name.getText();
        String apellido = ape.getText().trim();
        String especialidad = espe.getSelectedItem().toString();
        String genero = getUserGenre();

        if (nombre.isEmpty() || password.isEmpty() || usuario.isEmpty()
                || apellido.isEmpty() || especialidad.isEmpty()
                || genero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                FileInputStream fin = new FileInputStream(imageFile);
                Date fecha = campo_fecha.getCalendar().getTime();
                java.sql.Date dateDB = new java.sql.Date(fecha.getTime());

                Connection con;
                Conexion registercon = new Conexion();
                con = registercon.getConnection();
                String query = "insert into medico (Nombre, Apellido, Usuario, Contraseña, Especialidad, Sexo, Fecha, Imagen, Cargo) values" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setString(1, nombre);
                pstm.setString(2, apellido);
                pstm.setString(3, usuario);
                pstm.setString(4, password);
                pstm.setString(5, especialidad);
                pstm.setString(6, genero);
                pstm.setDate(7, dateDB);
                pstm.setBinaryStream(8, (InputStream) fin, (int) imageFile.length());
                pstm.setString(9, cargo);
                pstm.execute();

                nom.setText("");
                pass.setText("");
                ape.setText("");

                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            } catch (SQLException ex) {
                Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
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

    private void update_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttomActionPerformed

        String nombre = nom.getText();
        String password = pass.getText().trim();
        String usuario = usuario_name.getText();
        String apellido = ape.getText().trim();
        String especialidad = espe.getSelectedItem().toString();
        String genero = getUserGenre();

        if (nombre.isEmpty() || password.isEmpty() || usuario.isEmpty()
                || apellido.isEmpty() || especialidad.isEmpty()
                || genero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los datos necesarios");
        } else {
            try {
                if (imageFile == null) {
                    Date fecha = campo_fecha.getCalendar().getTime();
                    java.sql.Date dateDB = new java.sql.Date(fecha.getTime());
                    Connection con;
                    Conexion registercon = new Conexion();
                    con = registercon.getConnection();
                    String query = "update medico set Nombre=? , Apellido=?, Usuario=?, Contraseña=?, Especialidad=?, Sexo=?, Fecha=? where id=?";
                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setString(1, nombre);
                    pstm.setString(2, apellido);
                    pstm.setString(3, usuario);
                    pstm.setString(4, password);
                    pstm.setString(5, especialidad);
                    pstm.setString(6, genero);
                    pstm.setDate(7, dateDB);
                    pstm.setString(8, medicoId);
                    pstm.executeUpdate();

                    nom.setText("");
                    pass.setText("");
                    ape.setText("");
                } else {
                    FileInputStream fin = new FileInputStream(imageFile);
                    Date fecha = campo_fecha.getCalendar().getTime();
                    java.sql.Date dateDB = new java.sql.Date(fecha.getTime());

                    Connection con;
                    Conexion registercon = new Conexion();
                    con = registercon.getConnection();
                    String query = "update medico set Nombre=? , Apellido=?, Usuario=?, Contraseña=?, Especialidad=?, Sexo=?, Fecha=? Imagen=? where id=?";

                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setString(1, nombre);
                    pstm.setString(2, apellido);
                    pstm.setString(3, usuario);
                    pstm.setString(4, password);
                    pstm.setString(5, especialidad);
                    pstm.setString(6, genero);
                    pstm.setDate(7, dateDB);
                    pstm.setBinaryStream(8, (InputStream) fin, (int) imageFile.length());
                    pstm.setString(9, medicoId);
                    pstm.executeUpdate();

                    nom.setText("");
                    pass.setText("");
                    ape.setText("");

                }

                JOptionPane.showMessageDialog(null, "Actualizar datos Exitoso");
            } catch (SQLException ex) {
                Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RegistroMedicoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_update_buttomActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroMedicoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistroMedicoPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape;
    private com.toedter.calendar.JDateChooser campo_fecha;
    private javax.swing.JButton create_buttom;
    private javax.swing.JComboBox<String> espe;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jbl_Contraseña;
    private javax.swing.JLabel jbl_Contraseña1;
    private javax.swing.JLabel jbl_Contraseña2;
    private javax.swing.JLabel jbl_Contraseña3;
    private javax.swing.JLabel jbl_Especialidad;
    private javax.swing.JLabel jbl_Especialidad1;
    private javax.swing.JLabel jbl_Especialidad2;
    private javax.swing.JLabel jbl_Especialidad3;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField pass;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton update_buttom;
    private javax.swing.JTextField usuario_name;
    // End of variables declaration//GEN-END:variables
}
