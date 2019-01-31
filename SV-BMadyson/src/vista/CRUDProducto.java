/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.Conexion;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static vista.CRUDCliente.btnActualizarCli;
import static vista.CRUDCliente.btnEliminarCli;
import static vista.CRUDCliente.btnNuevoCli;
import static vista.CRUDCliente.btnRegistrarCli;
import static vista.CRUDCliente.cboGeneroCli;
import static vista.CRUDCliente.jpCardCli;
import static vista.CRUDCliente.jpConsultaCli;
import static vista.CRUDCliente.jpDatos;
import static vista.CRUDCliente.tblCliente;
import static vista.CRUDCliente.txtCodigoCli;
import static vista.CRUDCliente.txtCorreoCli;
import static vista.CRUDCliente.txtDniCli;
import static vista.CRUDCliente.txtFiltroNombre;
import static vista.CRUDCliente.txtNombreCli;

/**
 *
 * @author hoarlos
 */
public class CRUDProducto extends javax.swing.JFrame {

    DefaultTableModel mdlTblProd;
    Conexion cc = new Conexion();

    public CRUDProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        tabla();
        traerCodProd();
    }

    public void tabla() {
        mdlTblProd = (DefaultTableModel) tblProducto.getModel();
        jSPProd.getViewport().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMProductos = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jpOpcionesProd = new javax.swing.JPanel();
        btnNuevoProd = new javax.swing.JButton();
        btnRegistrarProd = new javax.swing.JButton();
        btnConsultarProd = new javax.swing.JButton();
        btnActualizarProd = new javax.swing.JButton();
        btnEliminarProd = new javax.swing.JButton();
        jpCardProd = new javax.swing.JPanel();
        jpDatosProd = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtArticuloProd = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtStockProd = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtPrecioVentaPro = new javax.swing.JTextField();
        cboMarcaProd = new javax.swing.JComboBox<>();
        txtCodigoProd = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jpConsultaProd = new javax.swing.JPanel();
        jSPProd = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnExtraerProd = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        btnListarProd = new javax.swing.JButton();
        txtFiltroNombreProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpMProductos.setBackground(new java.awt.Color(102, 0, 0));
        jpMProductos.setPreferredSize(new java.awt.Dimension(400, 150));
        jpMProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/productos125x125.png"))); // NOI18N
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel22.setMaximumSize(new java.awt.Dimension(130, 130));
        jLabel22.setMinimumSize(new java.awt.Dimension(130, 130));
        jLabel22.setPreferredSize(new java.awt.Dimension(130, 130));
        jLabel22.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpMProductos.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 10, 130, 130));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MANTENIMIENTO DE PRODUCTOS");
        jpMProductos.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 15, 970, 30));

        jpOpcionesProd.setBackground(new java.awt.Color(102, 0, 0));

        btnNuevoProd.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevoProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new32x32.png"))); // NOI18N
        btnNuevoProd.setText("NUEVO");
        btnNuevoProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnNuevoProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnNuevoProd);

        btnRegistrarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistrarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save32x32.png"))); // NOI18N
        btnRegistrarProd.setText("REGISTRAR");
        btnRegistrarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarProd.setEnabled(false);
        btnRegistrarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnRegistrarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnRegistrarProd);

        btnConsultarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search32x32.png"))); // NOI18N
        btnConsultarProd.setText("CONSULTAR");
        btnConsultarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnConsultarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnConsultarProd);

        btnActualizarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/update32x32.png"))); // NOI18N
        btnActualizarProd.setText("ACTUALIZAR");
        btnActualizarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarProd.setEnabled(false);
        btnActualizarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnActualizarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnActualizarProd);

        btnEliminarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete32x32.png"))); // NOI18N
        btnEliminarProd.setText("ELIMINAR");
        btnEliminarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnEliminarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnEliminarProd);

        jpMProductos.add(jpOpcionesProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 50, 970, 85));

        jpCardProd.setLayout(new java.awt.CardLayout());

        jpDatosProd.setBackground(new java.awt.Color(255, 255, 255));
        jpDatosProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("ARTÍCULO:");
        jpDatosProd.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        txtArticuloProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtArticuloProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArticuloProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtArticuloProd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtArticuloProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArticuloProdKeyTyped(evt);
            }
        });
        jpDatosProd.add(txtArticuloProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 300, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("MARCA:");
        jpDatosProd.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("STOCK:");
        jpDatosProd.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 30));

        txtStockProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStockProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtStockProd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtStockProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockProdKeyTyped(evt);
            }
        });
        jpDatosProd.add(txtStockProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 220, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("PRECIO DE VENTA:");
        jpDatosProd.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        txtPrecioVentaPro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPrecioVentaPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrecioVentaPro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecioVentaPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaProKeyTyped(evt);
            }
        });
        jpDatosProd.add(txtPrecioVentaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 220, 30));

        cboMarcaProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboMarcaProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Bolivar", "Coca Cola", "Donofrio" }));
        cboMarcaProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboMarcaProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboMarcaProd.setEditor(null);
        jpDatosProd.add(cboMarcaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, 30));

        txtCodigoProd.setEditable(false);
        txtCodigoProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCodigoProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCodigoProd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatosProd.add(txtCodigoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 200, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("CÓDIGO:");
        jpDatosProd.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

        jpCardProd.add(jpDatosProd, "card4");

        jpConsultaProd.setBackground(new java.awt.Color(255, 255, 255));
        jpConsultaProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSPProd.setBackground(new java.awt.Color(255, 255, 255));
        jSPProd.setOpaque(false);

        tblProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "ARTÍCULO", "MARCA", "PRECIO VENTA", "STOCK", "CATEGORÍA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducto.setOpaque(false);
        tblProducto.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tblProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProducto.getTableHeader().setResizingAllowed(false);
        tblProducto.getTableHeader().setReorderingAllowed(false);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jSPProd.setViewportView(tblProducto);

        jpConsultaProd.add(jSPProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 930, 280));

        btnExtraerProd.setBackground(new java.awt.Color(255, 255, 255));
        btnExtraerProd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExtraerProd.setText("MODIFICAR PRODUCTO");
        btnExtraerProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerProdActionPerformed(evt);
            }
        });
        jpConsultaProd.add(btnExtraerProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 250, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("FILTRAR POR ARTÍCULO:");
        jpConsultaProd.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 260, 30));

        btnListarProd.setBackground(new java.awt.Color(255, 255, 255));
        btnListarProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnListarProd.setForeground(new java.awt.Color(51, 51, 51));
        btnListarProd.setText("LISTAR");
        btnListarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProdActionPerformed(evt);
            }
        });
        jpConsultaProd.add(btnListarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 15, 120, 40));

        txtFiltroNombreProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jpConsultaProd.add(txtFiltroNombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, 30));

        jpCardProd.add(jpConsultaProd, "card3");

        jpMProductos.add(jpCardProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 140, 970, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpMProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 1135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpMProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProdActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoProdActionPerformed

    private void btnConsultarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProdActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarProdActionPerformed

    private void btnExtraerProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerProdActionPerformed
        extraer();
    }//GEN-LAST:event_btnExtraerProdActionPerformed

    private void btnListarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProdActionPerformed
        listar();
    }//GEN-LAST:event_btnListarProdActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                enviarProducto();
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnSeleccionarProd" + e);
            }
        }
    }//GEN-LAST:event_tblProductoMouseClicked

    private void btnEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarProdActionPerformed

    private void btnActualizarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProdActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarProdActionPerformed

    private void btnRegistrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProdActionPerformed
        registrar();
    }//GEN-LAST:event_btnRegistrarProdActionPerformed

    private void txtArticuloProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArticuloProdKeyTyped
        soloLetrasDigitos(evt);
    }//GEN-LAST:event_txtArticuloProdKeyTyped

    private void txtPrecioVentaProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaProKeyTyped
        soloFloat(evt);
    }//GEN-LAST:event_txtPrecioVentaProKeyTyped

    private void txtStockProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockProdKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_txtStockProdKeyTyped

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
            java.util.logging.Logger.getLogger(CRUDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizarProd;
    public static javax.swing.JButton btnConsultarProd;
    public static javax.swing.JButton btnEliminarProd;
    public static javax.swing.JButton btnExtraerProd;
    public static javax.swing.JButton btnListarProd;
    public static javax.swing.JButton btnNuevoProd;
    public static javax.swing.JButton btnRegistrarProd;
    public static javax.swing.JComboBox<String> cboMarcaProd;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    public static javax.swing.JScrollPane jSPProd;
    public static javax.swing.JPanel jpCardProd;
    public static javax.swing.JPanel jpConsultaProd;
    public static javax.swing.JPanel jpDatosProd;
    public static javax.swing.JPanel jpMProductos;
    private javax.swing.JPanel jpOpcionesProd;
    public static javax.swing.JTable tblProducto;
    public static javax.swing.JTextField txtArticuloProd;
    public static javax.swing.JTextField txtCodigoProd;
    public static javax.swing.JTextField txtFiltroNombreProd;
    public static javax.swing.JTextField txtPrecioVentaPro;
    public static javax.swing.JTextField txtStockProd;
    // End of variables declaration//GEN-END:variables
    private void registrar() {
        try {
            cc.conectarBD();
            PreparedStatement ps = cc.conexion.prepareStatement("insert into Producto values (?, ?, ?, ?)");
            ps.setString(1, articulo());
            ps.setString(2, marca());
            ps.setString(3, precioVenta());
            ps.setString(4, stock());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Registrado");
            btnRegistrarProd.setEnabled(false);
            traerCodProd();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "registrar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void extraer() {
        try {

            int fila = tblProducto.getSelectedRow();
            if (fila >= 0) {
                String cod = (String) tblProducto.getValueAt(fila, 0);
                cc.conectarBD();
                Statement st = cc.conexion.createStatement();
                ResultSet rs = st.executeQuery("select * from Producto where codProd = " + cod);
                String datos[] = new String[4];
                rs.next();
                datos[0] = rs.getString(2);//articulo
                datos[1] = rs.getString(3);//marca
                datos[2] = rs.getString(4);//precioVenta
                datos[3] = rs.getString(5);//stock

                txtCodigoProd.setText(cod);
                txtArticuloProd.setText(datos[0]);
                cboMarcaProd.setSelectedItem(datos[1]);
                txtPrecioVentaPro.setText(datos[2]);
                txtStockProd.setText(datos[3]);
                /**/
                btnActualizarProd.setEnabled(true);
                btnEliminarProd.setEnabled(false);
                cambiarJPanel(jpCardProd,jpDatosProd);
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
            cc.conectarBD();
            PreparedStatement ps = cc.conexion.prepareStatement("update Producto set articulo = '" + 
                    articulo() + "', marca = '" + marca() + "', precioVenta = '" + precioVenta() + 
                    "', stock = '" + stock() + "'  where codProd = " + codigo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            btnActualizarProd.setEnabled(false);
            btnNuevoProd.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "actualizar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void eliminar() {
        int fila = tblProducto.getSelectedRow();
        if (fila >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el producto?");
            if (confirmar == 0) {
                String cod = (String)tblProducto.getValueAt(fila, 0);
                try {
                    cc.conectarBD();
                    PreparedStatement ps = cc.conexion.prepareStatement("delete from Producto where codProd = " + cod);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
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
        int filas = mdlTblProd.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblProd.removeRow(0);
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
                mdlTblProd.addRow(datos);
            }
            txtFiltroNombreProd.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar " + e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void consultar() {
        cambiarJPanel(jpCardProd, jpConsultaProd);
        listar();
        btnActualizarProd.setEnabled(false);
        btnRegistrarProd.setEnabled(false);
        btnEliminarProd.setEnabled(true);
        btnNuevoProd.setEnabled(true);
        
    }

    private String buscar() {
        String consultar = "";
        try {
            if (filtroNombre().equals("")) {
                consultar = "select * from Producto";
            } else {
                consultar = "select * from Producto where articulo  like '%" + filtroNombre() + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
    }

    private void nuevo() {
        cambiarJPanel(jpCardProd, jpDatosProd);
        traerCodProd();
        txtArticuloProd.setText("");
        cboMarcaProd.setSelectedIndex(0);
        txtPrecioVentaPro.setText("");
        txtStockProd.setText("");
        btnRegistrarProd.setEnabled(true);
        btnActualizarProd.setEnabled(false);
    }


    /* Modificar */
    private int codigo() {
        return Integer.parseInt(txtCodigoProd.getText());
    }

    /* Registrar */
    private String articulo() {
        return txtArticuloProd.getText();
    }

    private String marca() {
        return (String) cboMarcaProd.getSelectedItem();
    }

    private String precioVenta() {
        return txtPrecioVentaPro.getText();
    }

    private String stock() {
        return txtStockProd.getText();
    }

    /* Filtros */
    private String filtroNombre() {
        return txtFiltroNombreProd.getText();
    }

    private void cambiarJPanel(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

    private void traerCodProd() {
        int nextProd = 0;
        try {
            cc.conectarBD();
            Statement st = cc.conexion.createStatement();
            ResultSet rs = st.executeQuery("select codProd from Producto");
            while (rs.next()) {
                nextProd = rs.getInt(1);
            }
            nextProd += 1;
            txtCodigoProd.setText(String.valueOf(nextProd));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cc.desconectarBD();
        }
    }

    private void soloLetrasDigitos(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isWhitespace(c) || Character.isDigit(c)) {

        } else {
            evt.consume();
        }
    }

    private void soloFloat(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isDigit(c) || c.equals('.')) {
            if (c.equals('.')) {
                if (txtPrecioVentaPro.getText().contains(".")) {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        } else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void soloNumeros(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }
    }

    public void enviarProducto() {

        int fila = tblProducto.getSelectedRow();
        if (fila >= 0) {
            String cod = (String) tblProducto.getValueAt(fila, 0);
            try {
                cc.conectarBD();
                PreparedStatement ps = cc.conexion.prepareStatement("select articulo,precioVenta,stock from Producto where codProd = " + cod);
                ResultSet rs = ps.executeQuery();
                rs.next();
                MenuPrincipal.txtSCodPro.setText(cod);
                MenuPrincipal.txtSNombreProd.setText(rs.getString(1));
                MenuPrincipal.txtSPrecioProd.setText(rs.getString(2));
                MenuPrincipal.txtSStock.setText(rs.getString(3));
                cambiarJPanel(MenuPrincipal.jpCardOpc, MenuPrincipal.jpRealizarVenta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "enviarProducto" + e);
            } finally {
                cc.desconectarBD();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la Tabla para enviar los datos");
        }
    }
}