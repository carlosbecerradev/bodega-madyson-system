/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloMnPri;
import vista.JFMenuPrincipal;

/**
 *
 * @author hoarlos
 */
public class ControladorMnPri implements ActionListener{

    public JFMenuPrincipal vstMnPri;
    public ModeloMnPri mdlMnPri;
    
    public ControladorMnPri(JFMenuPrincipal vstMnPri, ModeloMnPri mdlMnPri) {
        this.vstMnPri = vstMnPri;
        this.mdlMnPri = mdlMnPri;
        this.vstMnPri.btnJpMantenimiento.addActionListener(this);
    }
    
    public void iniciar(){
        vstMnPri.pack();
        vstMnPri.setVisible(true);
        vstMnPri.setTitle("SISTEMA DE VENTA");
        vstMnPri.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (vstMnPri.btnJpMantenimiento == evt.getSource()) {
            try {
                 mdlMnPri.jpMantenimiento();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
}
