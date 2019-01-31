/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.Conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class CRUDCliente extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    DefaultTableModel mdlTblCli;

    public CRUDCliente() {
        initComponents();
        tabla();
        this.setLocationRelativeTo(null);
        traerCodCli();
    }

    public void tabla() {
        mdlTblCli = (DefaultTableModel) tblCliente.getModel();
        jSPCli.getViewport().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpOpcionesCli = new javax.swing.JPanel();
        btnNuevoCli = new javax.swing.JButton();
        btnRegistrarCli = new javax.swing.JButton();
        btnConsultarCli = new javax.swing.JButton();
        btnActualizarCli = new javax.swing.JButton();
        btnEliminarCli = new javax.swing.JButton();
        jpCardCli = new javax.swing.JPanel();
        jpConsultaCli = new javax.swing.JPanel();
        jSPCli = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnExtraerCli = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnListarCli = new javax.swing.JButton();
        txtFiltroNombre = new javax.swing.JTextField();
        jpDatos = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtNombreCli = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDniCli = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCorreoCli = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cboGeneroCli = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoCli = new javax.swing.JTextField();
        cboArroba = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpMClientes.setBackground(new java.awt.Color(51, 51, 51));
        jpMClientes.setPreferredSize(new java.awt.Dimension(380, 150));
        jpMClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cliente125x125.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(130, 130));
        jLabel1.setMinimumSize(new java.awt.Dimension(130, 130));
        jLabel1.setPreferredSize(new java.awt.Dimension(130, 130));
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpMClientes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 10, 130, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANTENIMIENTO DE CLIENTES");
        jpMClientes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 15, 970, 30));

        jpOpcionesCli.setBackground(new java.awt.Color(51, 51, 51));

        btnNuevoCli.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevoCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new32x32.png"))); // NOI18N
        btnNuevoCli.setText("NUEVO");
        btnNuevoCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCli.setPreferredSize(new java.awt.Dimension(120, 75));
        btnNuevoCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliActionPerformed(evt);
            }
        });
        jpOpcionesCli.add(btnNuevoCli);

        btnRegistrarCli.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrarCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save32x32.png"))); // NOI18N
        btnRegistrarCli.setText("REGISTRAR");
        btnRegistrarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCli.setEnabled(false);
        btnRegistrarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarCli.setPreferredSize(new java.awt.Dimension(120, 75));
        btnRegistrarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCliActionPerformed(evt);
            }
        });
        jpOpcionesCli.add(btnRegistrarCli);

        btnConsultarCli.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultarCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search32x32.png"))); // NOI18N
        btnConsultarCli.setText("CONSULTAR");
        btnConsultarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarCli.setPreferredSize(new java.awt.Dimension(120, 75));
        btnConsultarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCliActionPerformed(evt);
            }
        });
        jpOpcionesCli.add(btnConsultarCli);

        btnActualizarCli.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizarCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/update32x32.png"))); // NOI18N
        btnActualizarCli.setText("ACTUALIZAR");
        btnActualizarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCli.setEnabled(false);
        btnActualizarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarCli.setPreferredSize(new java.awt.Dimension(120, 75));
        btnActualizarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCliActionPerformed(evt);
            }
        });
        jpOpcionesCli.add(btnActualizarCli);

        btnEliminarCli.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminarCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete32x32.png"))); // NOI18N
        btnEliminarCli.setText("ELIMINAR");
        btnEliminarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarCli.setPreferredSize(new java.awt.Dimension(120, 75));
        btnEliminarCli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCliActionPerformed(evt);
            }
        });
        jpOpcionesCli.add(btnEliminarCli);

        jpMClientes.add(jpOpcionesCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 50, 970, 85));

        jpCardCli.setLayout(new java.awt.CardLayout());

        jpConsultaCli.setBackground(new java.awt.Color(255, 255, 255));
        jpConsultaCli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSPCli.setBackground(new java.awt.Color(255, 255, 255));
        jSPCli.setOpaque(false);

        tblCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOMBRES Y APELLIDOS", "DNI", "CORREO", "GÉNERO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.setOpaque(false);
        tblCliente.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tblCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCliente.getTableHeader().setResizingAllowed(false);
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jSPCli.setViewportView(tblCliente);

        jpConsultaCli.add(jSPCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 930, 280));

        btnExtraerCli.setBackground(new java.awt.Color(255, 255, 255));
        btnExtraerCli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExtraerCli.setText("MODIFICAR CLIENTE");
        btnExtraerCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerCliActionPerformed(evt);
            }
        });
        jpConsultaCli.add(btnExtraerCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 220, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("FILTRAR POR NOMBRE O APELLIDO:");
        jpConsultaCli.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 260, 30));

        btnListarCli.setBackground(new java.awt.Color(255, 255, 255));
        btnListarCli.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnListarCli.setText("LISTAR");
        btnListarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCliActionPerformed(evt);
            }
        });
        jpConsultaCli.add(btnListarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 15, 120, 40));

        txtFiltroNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jpConsultaCli.add(txtFiltroNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, 30));

        jpCardCli.add(jpConsultaCli, "card3");

        jpDatos.setBackground(new java.awt.Color(255, 255, 255));
        jpDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("NOMBRES Y APELLIDOS:");
        jpDatos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        txtNombreCli.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNombreCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombreCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCliKeyTyped(evt);
            }
        });
        jpDatos.add(txtNombreCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 300, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("D.N.I.:");
        jpDatos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        txtDniCli.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDniCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDniCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDniCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDniCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniCliKeyTyped(evt);
            }
        });
        jpDatos.add(txtDniCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("CORREO:");
        jpDatos.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        txtCorreoCli.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCorreoCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreoCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatos.add(txtCorreoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 220, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("GÉNERO:");
        jpDatos.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 30));

        cboGeneroCli.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboGeneroCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Masculino", "Femenino" }));
        cboGeneroCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboGeneroCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboGeneroCli.setEditor(null);
        jpDatos.add(cboGeneroCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 220, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("CÓDIGO:");
        jpDatos.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

        txtCodigoCli.setEditable(false);
        txtCodigoCli.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCodigoCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCodigoCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatos.add(txtCodigoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 220, 30));

        cboArroba.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboArroba.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com" }));
        jpDatos.add(cboArroba, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 200, 30));

        jpCardCli.add(jpDatos, "card4");

        jpMClientes.add(jpCardCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 140, 970, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpMClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 1135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpMClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoCliActionPerformed

    private void btnConsultarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCliActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarCliActionPerformed

    private void txtNombreCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCliKeyTyped
        soloLetras(evt);
    }//GEN-LAST:event_txtNombreCliKeyTyped

    private void txtDniCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniCliKeyTyped
        soloDni(evt);
    }//GEN-LAST:event_txtDniCliKeyTyped

    private void btnRegistrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCliActionPerformed
        registrar();
    }//GEN-LAST:event_btnRegistrarCliActionPerformed

    private void btnActualizarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCliActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarCliActionPerformed

    private void btnEliminarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCliActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarCliActionPerformed

    private void btnListarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCliActionPerformed
        listar();
    }//GEN-LAST:event_btnListarCliActionPerformed

    private void btnExtraerCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerCliActionPerformed
        extraer();
    }//GEN-LAST:event_btnExtraerCliActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                enviarCliente();
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnSeleccionarProd" + e);
            }
        }
    }//GEN-LAST:event_tblClienteMouseClicked

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
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizarCli;
    public static javax.swing.JButton btnConsultarCli;
    public static javax.swing.JButton btnEliminarCli;
    public static javax.swing.JButton btnExtraerCli;
    public static javax.swing.JButton btnListarCli;
    public static javax.swing.JButton btnNuevoCli;
    public static javax.swing.JButton btnRegistrarCli;
    private javax.swing.JComboBox<String> cboArroba;
    public static javax.swing.JComboBox<String> cboGeneroCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JScrollPane jSPCli;
    public static javax.swing.JPanel jpCardCli;
    public static javax.swing.JPanel jpConsultaCli;
    public static javax.swing.JPanel jpDatos;
    public static javax.swing.JPanel jpMClientes;
    public static javax.swing.JPanel jpOpcionesCli;
    public static javax.swing.JTable tblCliente;
    public static javax.swing.JTextField txtCodigoCli;
    public static javax.swing.JTextField txtCorreoCli;
    public static javax.swing.JTextField txtDniCli;
    public static javax.swing.JTextField txtFiltroNombre;
    public static javax.swing.JTextField txtNombreCli;
    // End of variables declaration//GEN-END:variables
    private boolean validarCampos() {
        boolean verificar = nombres().equals("")
                || dni().equals("")
                || cboGeneroCli.getSelectedIndex() == 0;
        return verificar;
    }

    private void registrar() {
        try {
            if (!validarCampos()) {
                cc.conectarBD();
                PreparedStatement ps = cc.conexion.prepareStatement("insert into Cliente values (?, ?, ?, ?)");
                ps.setString(1, nombres());
                ps.setString(2, dni());
                ps.setString(3, correo());
                ps.setString(4, genero());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente Registrado");
                btnRegistrarCli.setEnabled(false);
                traerCodCli();
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "registrar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void extraer() {
        try {

            int fila = tblCliente.getSelectedRow();
            if (fila >= 0) {
                String cod = (String) tblCliente.getValueAt(fila, 0);
                cc.conectarBD();
                Statement st = cc.conexion.createStatement();
                ResultSet rs = st.executeQuery("select * from Cliente where codCli = " + cod);
                String datos[] = new String[4];
                rs.next();
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);

                txtCodigoCli.setText(cod);
                txtNombreCli.setText(datos[0]);
                txtDniCli.setText(datos[1]);
                String[] separarCorreo = datos[2].split("@");
                txtCorreoCli.setText(separarCorreo[0]);
                cboArroba.setSelectedItem("@" + separarCorreo[1]);
                switch (datos[3]) {
                    case "M":
                        cboGeneroCli.setSelectedIndex(1);
                        break;
                    case "F":
                        cboGeneroCli.setSelectedIndex(2);
                        break;
                    default:
                        break;
                }
                /**/
                btnActualizarCli.setEnabled(true);
                btnEliminarCli.setEnabled(false);
                cambiarJPanel(jpCardCli, jpDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla para modificar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "extraer " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void actualizar() {
        try {
            if (!validarCampos()) {
                cc.conectarBD();
            PreparedStatement ps = cc.conexion.prepareStatement("update Cliente set nombApeCli = '" + nombres()
                    + "', dniCli = '" + dni() + "', correoCli = '" + correo() + "', genCli = '" + genero()
                    + "'  where codCli = " + codigo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            btnActualizarCli.setEnabled(false);
            btnNuevoCli.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Rellene los campos faltantes.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "actualizar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void eliminar() {
        int fila = tblCliente.getSelectedRow();
        if (fila >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este empleado?");
            if (confirmar == 0) {
                String cod = (String) tblCliente.getValueAt(fila, 0);
                try {
                    cc.conectarBD();
                    PreparedStatement ps = cc.conexion.prepareStatement("delete from Cliente where codCli = " + cod);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cliente eliminado");
                    listar();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "eliminar " + e);
                } finally {
                    cc.desconectarBD();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }
    }

    private void listar() {
        //limpiar la tabla
        int filas = mdlTblCli.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblCli.removeRow(0);
        }
        /**
         * ** TRAER DATOS DE SQL SERVER HACIA LA TABLA ***
         */
        try {
            String datos[] = new String[5];
            cc.conectarBD();
            Statement st = cc.conexion.createStatement();
            ResultSet rs = st.executeQuery(buscar());

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                mdlTblCli.addRow(datos);
            }
            txtFiltroNombre.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void consultar() {
        cambiarJPanel(jpCardCli, jpConsultaCli);
        listar();
        btnActualizarCli.setEnabled(false);
        btnRegistrarCli.setEnabled(false);
        btnEliminarCli.setEnabled(true);
        btnNuevoCli.setEnabled(true);
    }

    private String buscar() {
        String consultar = "";
        try {
            if (filtroNombre().equals("")) {
                consultar = "select * from Cliente";
            } else {
                consultar = "select * from Cliente where nombApeCli  like '%" + filtroNombre() + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
    }

    private void nuevo() {
        cambiarJPanel(jpCardCli, jpDatos);
        traerCodCli();
        txtNombreCli.setText("");
        txtDniCli.setText("");
        txtCorreoCli.setText("");
        cboGeneroCli.setSelectedIndex(0);
        btnRegistrarCli.setEnabled(true);
        btnActualizarCli.setEnabled(false);
        btnEliminarCli.setEnabled(false);
    }

    /* Modificar */
    private int codigo() {
        return Integer.parseInt(txtCodigoCli.getText());
    }

    /* Registrar */
    private String nombres() {
        String tr = txtNombreCli.getText();
        return tr;
    }

    private String dni() {
        String tr = txtDniCli.getText();
        return tr;
    }

    private String correo() {
        String tr = txtCorreoCli.getText() + (String) cboArroba.getSelectedItem();
        return tr;
    }

    private String genero() {
        int genero = cboGeneroCli.getSelectedIndex();
        String gen = null;
        switch (genero) {
            case 1:
                gen = "M";
                break;
            case 2:
                gen = "F";
                break;
            default:
                break;
        }
        return gen;
    }

    /* Filtros de busqueda */
    private String filtroNombre() {
        return txtFiltroNombre.getText();
    }

    private void cambiarJPanel(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

    private void traerCodCli() {
        int nextCli = 0;
        try {
            cc.conectarBD();
            Statement st = cc.conexion.createStatement();
            ResultSet rs = st.executeQuery("select codCli from Cliente");
            while (rs.next()) {
                nextCli = rs.getInt(1);
            }
            nextCli += 1;
            txtCodigoCli.setText(String.valueOf(nextCli));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void soloLetras(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {

        } else {
            evt.consume();
        }
    }

    private void soloDni(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            if (txtDniCli.getText().length() == 8) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }

    public void enviarCliente() {

        int fila = tblCliente.getSelectedRow();
        if (fila >= 0) {
            String cod = (String) tblCliente.getValueAt(fila, 0);
            try {
                cc.conectarBD();
                PreparedStatement ps = cc.conexion.prepareStatement("select nombApeCli from Cliente where codCli = " + cod);
                ResultSet rs = ps.executeQuery();
                rs.next();
                MenuPrincipal.txtSCodCli.setText(cod);
                MenuPrincipal.txtSNombreCli.setText(rs.getString(1));
                cambiarJPanel(MenuPrincipal.jpCardOpc, MenuPrincipal.jpRealizarVenta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                cc.desconectarBD();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la Tabla para enviar los datos");
        }
    }

}
