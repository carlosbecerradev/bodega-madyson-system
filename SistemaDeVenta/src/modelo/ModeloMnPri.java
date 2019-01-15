/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JPanel;
import vista.JFMenuPrincipal;

/**
 *
 * @author Administrador
 */
public class ModeloMnPri {
    
    public JFMenuPrincipal v;
    
    public void jpMantenimiento() {
        cambiarCard(v.jpCard, v.jpMantenimiento);
    }

    public void cambiarCard(JPanel card, JPanel panel) {
        card.removeAll();
        card.repaint();
        card.revalidate();
        card.add(panel);/**/
        card.repaint();
        card.revalidate();
    }
}
