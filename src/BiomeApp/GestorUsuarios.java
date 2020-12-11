/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BiomeApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alvar
 */
public class GestorUsuarios extends javax.swing.JFrame {

    Statement stmt = null;
    Connection con = null;
    String usuario_seleccionado = "";
    String cargo_seleccionado = "";

    String titulos_usuarios[] = {"id", "Nombre", "Apellido", "Usuario", "Sexo", "Fecha", "Cargo"};
    String fila_usuarios[] = new String[7];
    DefaultTableModel modelo_usuario;

    String titulos_paciente[] = {"id", "Nombre", "Apellido", "Sexo", "Fecha", "Codigo", "Enfermero"};
    String fila_pacientes[] = new String[7];
    DefaultTableModel modelo_paciente;

    String titulos_equipo[] = {"id", "Equipo", "Estado", "Fecha", "Codigo"};
    String fila_equipo[] = new String[5];
    DefaultTableModel modelo_equipo;

    /**
     * Creates new form GestorUsuarios
     */
    public GestorUsuarios() {
        initComponents();
        this.setTitle("consulta usuarios");
        this.setLocation(250, 50);
        this.setResizable(false);
        connection();
        inicializarTablaUsuarios();
        inicializarTablaEquipo();
        inicializarTablaPaciente();

    }

    public GestorUsuarios(String cargo) {
        initComponents();
        this.setTitle("consulta usuarios");
        this.setLocation(250, 50);
        this.setResizable(false);
        connection();
        inicializarTablaUsuarios();
        inicializarTablaEquipo();
        inicializarTablaPaciente();
    }

    private void connection() {
        try {
            String url = "jdbc:mysql://localhost:3306/bd_administrador";
            String usuario = "root";
            String contraseña = "";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, usuario, contraseña);
            if (con != null) {
                System.out.println("Se ha establecido una conexion a la base de datos" + "\n" + url);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla" + e);
        }
    }

    private void editarUsuarios() {
        if (cargo_seleccionado.equals("medico")) {
            new RegistroMedicoPanel(usuario_seleccionado).setVisible(true);
            dispose();
        }
        if (cargo_seleccionado.equals("enfermero")) {
            new RegistroEnfermeroPanel(usuario_seleccionado).setVisible(true);
            dispose();
        }
        if (cargo_seleccionado.equals("biomedico")) {
            new RegistroBiomedicoPanel(usuario_seleccionado).setVisible(true);
            dispose();
        }
        if (cargo_seleccionado.equals("paciente")) {
            new RegistroPacientePanel(usuario_seleccionado).setVisible(true);
            dispose();
        }
        if (cargo_seleccionado.equals("equipo")) {
            new RegistroEquipoPanel(usuario_seleccionado).setVisible(true);
            dispose();
        }
    }

    private void deleteUser() {
        try {
            String input = javax.swing.JOptionPane.showInputDialog(this, "Confirmar", "Escribe SI para eliminar al Usuario", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (input.equals("SI")) {
                String query = "delete from " + cargo_seleccionado + " where id=" + usuario_seleccionado + ";";
                int rdelete = stmt.executeUpdate(query);
                if (rdelete != 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El Usuario ha sido eliminado", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    inicializarTablaUsuarios();
                    inicializarTablaEquipo();
                    inicializarTablaPaciente();
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Ha sido cancelado \n", "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El proceso de eliminacion cancelado \n", "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inicializarTablaUsuarios() {
        try {

            String selected_user = cargo.getSelectedItem().toString();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from " + selected_user);

            modelo_usuario = new DefaultTableModel(null, titulos_usuarios);

            while (rs.next()) {
                fila_usuarios[0] = rs.getString("id");
                fila_usuarios[1] = rs.getString("Nombre");
                fila_usuarios[2] = rs.getString("Apellido");
                fila_usuarios[3] = rs.getString("Usuario");
                fila_usuarios[4] = rs.getString("Sexo");
                fila_usuarios[5] = rs.getString("Fecha");
                fila_usuarios[6] = rs.getString("Cargo");
                modelo_usuario.addRow(fila_usuarios);
            }
            tabla_usuarios.setModel(modelo_usuario);

            tabla_usuarios.setModel(modelo_usuario);
            TableColumn cid = tabla_usuarios.getColumn("id");
            cid.setMaxWidth(50);
            TableColumn cn = tabla_usuarios.getColumn("Nombre");
            cn.setMaxWidth(165);
            TableColumn cd = tabla_usuarios.getColumn("Apellido");
            cd.setMaxWidth(160);
            TableColumn cuser = tabla_usuarios.getColumn("Usuario");
            cuser.setMaxWidth(160);
            TableColumn cp = tabla_usuarios.getColumn("Sexo");
            cp.setMaxWidth(72);
            TableColumn ctipo = tabla_usuarios.getColumn("Fecha");
            ctipo.setMaxWidth(95);
            TableColumn ccargo = tabla_usuarios.getColumn("Cargo");
            ccargo.setMaxWidth(95);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla usuarios" + e);
        }
    }

    private void inicializarTablaEquipo() {
        try {

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from equipo");

            modelo_equipo = new DefaultTableModel(null, titulos_equipo);

            while (rs.next()) {
                fila_equipo[0] = rs.getString("id");
                fila_equipo[1] = rs.getString("Equipo");
                fila_equipo[2] = rs.getString("Estado");
                fila_equipo[3] = rs.getString("Fecha");
                fila_equipo[4] = rs.getString("Codigo");
                modelo_equipo.addRow(fila_equipo);
            }
            tabla_equipo.setModel(modelo_equipo);

            tabla_equipo.setModel(modelo_equipo);
            TableColumn cid = tabla_equipo.getColumn("id");
            cid.setMaxWidth(50);
            TableColumn cn = tabla_equipo.getColumn("Equipo");
            cn.setMaxWidth(165);
            TableColumn cd = tabla_equipo.getColumn("Estado");
            cd.setMaxWidth(160);
            TableColumn cuser = tabla_equipo.getColumn("Fecha");
            cuser.setMaxWidth(160);
            TableColumn cp = tabla_equipo.getColumn("Codigo");
            cp.setMaxWidth(72);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla equipo " + e);
        }
    }

    private void inicializarTablaPaciente() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from paciente");

            modelo_paciente = new DefaultTableModel(null, titulos_paciente);

            while (rs.next()) {
                fila_pacientes[0] = rs.getString("id");
                fila_pacientes[1] = rs.getString("Nombre");
                fila_pacientes[2] = rs.getString("Apellido");
                fila_pacientes[3] = rs.getString("Sexo");
                fila_pacientes[4] = rs.getString("Fecha");
                fila_pacientes[5] = rs.getString("Codigo_paciente");
                fila_pacientes[6] = rs.getString("Codigo_Enfermero");
                modelo_paciente.addRow(fila_pacientes);
            }
            tabla_paciente.setModel(modelo_paciente);

            tabla_paciente.setModel(modelo_paciente);
            TableColumn cid = tabla_paciente.getColumn("id");
            cid.setMaxWidth(50);
            TableColumn cn = tabla_paciente.getColumn("Nombre");
            cn.setMaxWidth(165);
            TableColumn cd = tabla_paciente.getColumn("Apellido");
            cd.setMaxWidth(160);
            TableColumn cuser = tabla_paciente.getColumn("Sexo");
            cuser.setMaxWidth(160);
            TableColumn cp = tabla_paciente.getColumn("Fecha");
            cp.setMaxWidth(72);
            TableColumn ctipo = tabla_paciente.getColumn("Codigo");
            ctipo.setMaxWidth(95);
            TableColumn ccargo = tabla_paciente.getColumn("Enfermero");
            ccargo.setMaxWidth(95);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al extraer los datos de la tabla paciente" + e);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_paciente = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        cargo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_equipo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

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

        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, -1, -1));

        tabla_paciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_paciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_pacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_paciente);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 520, 120));

        jButton8.setText("Atras");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "medico", "enfermero", "biomedico" }));
        cargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cargoItemStateChanged(evt);
            }
        });
        jPanel2.add(cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestor Paciente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 120, -1));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestor Usuario");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_usuarios);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 520, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gestor Equipo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        tabla_equipo.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_equipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_equipoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_equipo);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 520, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 610));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new AdministradorPanel("admnistrador").setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cargoItemStateChanged
        inicializarTablaUsuarios();

    }//GEN-LAST:event_cargoItemStateChanged

    private void tabla_pacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pacienteMouseClicked
        tabla_usuarios.clearSelection();
        tabla_equipo.clearSelection();
        int columnID = 0;
        int row = tabla_paciente.getSelectedRow();
        usuario_seleccionado = tabla_paciente.getModel().getValueAt(row, columnID).toString();
        cargo_seleccionado = "paciente";
    }//GEN-LAST:event_tabla_pacienteMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        deleteUser();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        editarUsuarios();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked
        tabla_paciente.clearSelection();
        tabla_equipo.clearSelection();
        int columnID = 0;
        int columCargo = 6;
        int row = tabla_usuarios.getSelectedRow();
        usuario_seleccionado = tabla_usuarios.getModel().getValueAt(row, columnID).toString();
        cargo_seleccionado = tabla_usuarios.getModel().getValueAt(row, columCargo).toString();
    }//GEN-LAST:event_tabla_usuariosMouseClicked

    private void tabla_equipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_equipoMouseClicked
        tabla_usuarios.clearSelection();
        tabla_paciente.clearSelection();
        int columnID = 0;
        int row = tabla_equipo.getSelectedRow();
        usuario_seleccionado = tabla_equipo.getModel().getValueAt(row, columnID).toString();
        cargo_seleccionado = "equipo";
    }//GEN-LAST:event_tabla_equipoMouseClicked

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
            java.util.logging.Logger.getLogger(GestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new GestorUsuarios().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla_equipo;
    private javax.swing.JTable tabla_paciente;
    private javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables
}
