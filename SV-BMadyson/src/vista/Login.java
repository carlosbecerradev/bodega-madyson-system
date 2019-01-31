/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import dao.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author hoarlos
 */
public class Login extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    MenuPrincipal mnp = new MenuPrincipal();
    CRUDProducto crudProd = new CRUDProducto();
    CRUDEmpleado crudEmp = new CRUDEmpleado();

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpIniciarSesion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        icoPass = new javax.swing.JLabel();
        icoUser = new javax.swing.JLabel();
        lblMensajeLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jpIniciarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");
        jpIniciarSesion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 279, 26));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users.png"))); // NOI18N
        jpIniciarSesion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 250));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("USUARIO:");
        jpIniciarSesion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CONTRASEÑA:");
        jpIniciarSesion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 140, 30));

        txtContrasenia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasenia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseniaKeyTyped(evt);
            }
        });
        jpIniciarSesion.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 200, 30));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpIniciarSesion.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 200, 30));

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(51, 51, 51));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jpIniciarSesion.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 300, 40));
        jpIniciarSesion.add(icoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 193, 26, 26));
        jpIniciarSesion.add(icoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 114, 26, 26));

        lblMensajeLogin.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblMensajeLogin.setForeground(new java.awt.Color(255, 0, 0));
        lblMensajeLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpIniciarSesion.add(lblMensajeLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 600, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseniaKeyTyped
        // Ingresar con la tecla enter
        Character c = evt.getKeyChar();
        if (c == '\n') {
            iniciarSesion();
        }
    }//GEN-LAST:event_txtContraseniaKeyTyped

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnIngresar;
    private javax.swing.JLabel icoPass;
    private javax.swing.JLabel icoUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jpIniciarSesion;
    public static javax.swing.JLabel lblMensajeLogin;
    public static javax.swing.JPasswordField txtContrasenia;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void iniciarSesion() {
        try {
            cc.conectarBD();
            PreparedStatement ps = cc.conexion.prepareStatement("select usuEmp, contraEmp, cargoEmp, estado, nombApeEmp,codEmp from Empleado");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (usuario().equals(rs.getString(1)) && contrasenia().equals(rs.getString(2))) {
                    if (rs.getInt(4) == 1) {//activo o inactivo
                        mnp.lblNombUser.setText(rs.getString(3));//poner el cargo
                        mnp.lblAtendidoPor.setText(rs.getString(5));//poner nombres y apellidos
                        mnp.lblSCodEmpleado.setText(rs.getString(6));//poner codigo
                        if (rs.getString(3).equals("Administrador")) {
                            privilegiosAdmin();
                            mnp.setVisible(true);
                            this.dispose();
                        } else {
                            privilegiosCajero();
                            mnp.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        lblMensajeLogin.setText("El usuario esta desactivado.");
                    }
                } else {
                    lblMensajeLogin.setText("Usuario o contraseña incorrecto.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cc.desconectarBD();
        }

    }

    private String usuario() {
        return txtUsuario.getText();
    }

    private String contrasenia() {
        return txtContrasenia.getText();
    }
    /*permitir todas los opciontes*/
    public void privilegiosAdmin() {
        /*Al iniciar */
        cambiarJPanel(mnp.jpCardOpc, mnp.jpRealizarVenta);
        /* Menu */
        mnp.btnJpReportes.setEnabled(true);        
        mnp.btnJpMClientes.setEnabled(true);
        mnp.btnJpMProductos.setEnabled(true);
        mnp.btnJpMEmpleados.setEnabled(true);
    }
    /* solo permitir realizar ventas, consultar */
    public void privilegiosCajero() {
        /*Al iniciar */
        cambiarJPanel(mnp.jpCardOpc, mnp.jpRealizarVenta);
        /* Menu */
        mnp.btnJpReportes.setEnabled(false);
        mnp.btnJpMClientes.setEnabled(true);
        mnp.btnJpMProductos.setEnabled(true);
        mnp.btnJpMEmpleados.setEnabled(false);
    }

    public void cambiarJPanel(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }
}