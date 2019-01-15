/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JPanel;

/**
 *
 * @author hoarlos
 */
public class JFCRUD extends javax.swing.JFrame {

    public JFCRUD() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEmpleados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpOpcionesProd = new javax.swing.JPanel();
        btnNuevoProd = new javax.swing.JButton();
        btnRegistrarProd = new javax.swing.JButton();
        btnBuscarProd = new javax.swing.JButton();
        btnActualizarProd = new javax.swing.JButton();
        btnEliminarProd = new javax.swing.JButton();
        jpCardProd = new javax.swing.JPanel();
        jpDatosProd = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtArticuloProd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStockProd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioVentaPro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboMarcaProd = new javax.swing.JComboBox<>();
        cboCategoriaProd = new javax.swing.JComboBox<>();
        jpModificarProd = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtArticuloProdM = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtStockProdM = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPrecioVentaProM = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboMarcaProdM = new javax.swing.JComboBox<>();
        cboCategoriaProdM = new javax.swing.JComboBox<>();
        jpConsultaProd = new javax.swing.JPanel();
        jSPProd = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        btnExtraerProd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnListarProd = new javax.swing.JButton();
        txtFiltroNombreProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));

        jpEmpleados.setBackground(new java.awt.Color(51, 51, 51));
        jpEmpleados.setMaximumSize(new java.awt.Dimension(1000, 600));
        jpEmpleados.setMinimumSize(new java.awt.Dimension(1000, 600));
        jpEmpleados.setPreferredSize(new java.awt.Dimension(1000, 600));
        jpEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANTENIMIENTO DE PRODUCTOS");
        jpEmpleados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 970, 30));

        jpOpcionesProd.setBackground(new java.awt.Color(51, 51, 51));

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
        btnRegistrarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnRegistrarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jpOpcionesProd.add(btnRegistrarProd);

        btnBuscarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search32x32.png"))); // NOI18N
        btnBuscarProd.setText("CONSULTAR");
        btnBuscarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnBuscarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdActionPerformed(evt);
            }
        });
        jpOpcionesProd.add(btnBuscarProd);

        btnActualizarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/update32x32.png"))); // NOI18N
        btnActualizarProd.setText("ACTUALIZAR");
        btnActualizarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnActualizarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jpOpcionesProd.add(btnActualizarProd);

        btnEliminarProd.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete32x32.png"))); // NOI18N
        btnEliminarProd.setText("ELIMINAR");
        btnEliminarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProd.setPreferredSize(new java.awt.Dimension(120, 75));
        btnEliminarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jpOpcionesProd.add(btnEliminarProd);

        jpEmpleados.add(jpOpcionesProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 970, 85));

        jpCardProd.setLayout(new java.awt.CardLayout());

        jpDatosProd.setBackground(new java.awt.Color(255, 255, 255));
        jpDatosProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ARTÍCULO:");
        jpDatosProd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

        txtArticuloProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtArticuloProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArticuloProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtArticuloProd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatosProd.add(txtArticuloProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 300, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("MARCA:");
        jpDatosProd.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("STOCK:");
        jpDatosProd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        txtStockProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStockProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtStockProd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatosProd.add(txtStockProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("PRECIO DE VENTA:");
        jpDatosProd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        txtPrecioVentaPro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPrecioVentaPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrecioVentaPro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpDatosProd.add(txtPrecioVentaPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CATEGORÍA:");
        jpDatosProd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 30));

        cboMarcaProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboMarcaProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "PeziDuri", "Donofrio", "Coca Cola" }));
        cboMarcaProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboMarcaProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboMarcaProd.setEditor(null);
        jpDatosProd.add(cboMarcaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, 30));

        cboCategoriaProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboCategoriaProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Helado", "Detergente" }));
        cboCategoriaProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboCategoriaProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboCategoriaProd.setEditor(null);
        jpDatosProd.add(cboCategoriaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 220, 30));

        jpCardProd.add(jpDatosProd, "card2");

        jpModificarProd.setBackground(new java.awt.Color(255, 255, 255));
        jpModificarProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ARTÍCULO:");
        jpModificarProd.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 30));

        txtArticuloProdM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtArticuloProdM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtArticuloProdM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtArticuloProdM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpModificarProd.add(txtArticuloProdM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 300, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("MARCA:");
        jpModificarProd.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("STOCK:");
        jpModificarProd.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        txtStockProdM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStockProdM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockProdM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtStockProdM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpModificarProd.add(txtStockProdM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 220, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("PRECIO DE VENTA:");
        jpModificarProd.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 30));

        txtPrecioVentaProM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPrecioVentaProM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaProM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrecioVentaProM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jpModificarProd.add(txtPrecioVentaProM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CATEGORÍA:");
        jpModificarProd.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 200, 30));

        cboMarcaProdM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboMarcaProdM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "PeziDuri", "Donofrio", "Coca Cola" }));
        cboMarcaProdM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboMarcaProdM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboMarcaProdM.setEditor(null);
        jpModificarProd.add(cboMarcaProdM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, 30));

        cboCategoriaProdM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboCategoriaProdM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Helado", "Detergente" }));
        cboCategoriaProdM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboCategoriaProdM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboCategoriaProdM.setEditor(null);
        jpModificarProd.add(cboCategoriaProdM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 220, 30));

        jpCardProd.add(jpModificarProd, "card4");

        jpConsultaProd.setBackground(new java.awt.Color(255, 255, 255));
        jpConsultaProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSPProd.setBackground(new java.awt.Color(255, 255, 255));
        jSPProd.setOpaque(false);

        tbProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProducto.setOpaque(false);
        tbProducto.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tbProducto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbProducto.getTableHeader().setResizingAllowed(false);
        tbProducto.getTableHeader().setReorderingAllowed(false);
        jSPProd.setViewportView(tbProducto);

        jpConsultaProd.add(jSPProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 930, 330));

        btnExtraerProd.setBackground(new java.awt.Color(255, 255, 255));
        btnExtraerProd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExtraerProd.setText("MODIFICAR PRODUCTO");
        jpConsultaProd.add(btnExtraerProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 250, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("FILTRAR POR ARTÍCULO:");
        jpConsultaProd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 260, 30));

        btnListarProd.setBackground(new java.awt.Color(255, 255, 255));
        btnListarProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnListarProd.setForeground(new java.awt.Color(51, 51, 51));
        btnListarProd.setText("LISTAR");
        jpConsultaProd.add(btnListarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 15, 120, 40));

        txtFiltroNombreProd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jpConsultaProd.add(txtFiltroNombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, 30));

        jpCardProd.add(jpConsultaProd, "card3");

        jpEmpleados.add(jpCardProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 140, 970, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProdActionPerformed
        
    }//GEN-LAST:event_btnNuevoProdActionPerformed

    private void btnBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdActionPerformed
        
    }//GEN-LAST:event_btnBuscarProdActionPerformed

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
            java.util.logging.Logger.getLogger(JFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizarProd;
    public static javax.swing.JButton btnBuscarProd;
    public static javax.swing.JButton btnEliminarProd;
    public static javax.swing.JButton btnExtraerProd;
    public static javax.swing.JButton btnListarProd;
    public static javax.swing.JButton btnNuevoProd;
    public static javax.swing.JButton btnRegistrarProd;
    public static javax.swing.JComboBox<String> cboCategoriaProd;
    public static javax.swing.JComboBox<String> cboCategoriaProdM;
    public static javax.swing.JComboBox<String> cboMarcaProd;
    public static javax.swing.JComboBox<String> cboMarcaProdM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JScrollPane jSPProd;
    public static javax.swing.JPanel jpCardProd;
    public static javax.swing.JPanel jpConsultaProd;
    public static javax.swing.JPanel jpDatosProd;
    private javax.swing.JPanel jpEmpleados;
    public static javax.swing.JPanel jpModificarProd;
    private javax.swing.JPanel jpOpcionesProd;
    public static javax.swing.JTable tbProducto;
    public static javax.swing.JTextField txtArticuloProd;
    public static javax.swing.JTextField txtArticuloProdM;
    public static javax.swing.JTextField txtFiltroNombreProd;
    public static javax.swing.JTextField txtPrecioVentaPro;
    public static javax.swing.JTextField txtPrecioVentaProM;
    public static javax.swing.JTextField txtStockProd;
    public static javax.swing.JTextField txtStockProdM;
    // End of variables declaration//GEN-END:variables

    
}
