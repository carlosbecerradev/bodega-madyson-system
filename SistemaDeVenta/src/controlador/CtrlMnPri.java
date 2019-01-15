/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.ModeloMnPri;
import vista.JFMenuPrincipal;

/**
 *
 * @author Administrador
 */
public class CtrlMnPri implements ActionListener {

    private JFMenuPrincipal vstMnPri;
    private ModeloMnPri mdlMnPri;
    
    public CtrlMnPri(JFMenuPrincipal vstMnPri, ModeloMnPri mdlMnPti){
        this.vstMnPri = vstMnPri;
        this.mdlMnPri = mdlMnPti;
        this.vstMnPri.btnJpMantenimiento.addActionListener(this);
    }    
    
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (vstMnPri.btnJpMantenimiento == evt.getSource()) {
            try {
                 jpMantenimiento();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese los caracteres correctos");
            }
        }
    }
    
        public void jpMantenimiento(){
        cambiarCard(vstMnPri.jpCarrusel, vstMnPri.jpMantenimiento);
    }
    
    
    public void cambiarCard(JPanel card,JPanel panel) {
        card.removeAll();
        card.repaint();
        card.revalidate();

        card.add(panel);
        card.repaint();
        card.revalidate();
    }
    
}
