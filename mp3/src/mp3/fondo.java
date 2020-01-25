/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author PERSONAL
 */
public class fondo extends javax.swing.JPanel {
private JFrame jFramePadre;

    public fondo() {
        this.setSize(629, 435);
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio = this.getSize();      
        ImageIcon imagenFondo = new ImageIcon("C:\\Users\\PERSONAL\\Documents\\NetBeansProjects\\mp3\\src\\mp3\\acu.jpg");
        g.drawImage(imagenFondo.getImage(), 0, 0, 
                tamanio.width, tamanio.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }
    public JFrame getjFramePadre() {
        return jFramePadre;
    }

    /**
     * @param jFramePadre the jFramePadre to set
     */
    public void setjFramePadre(JFrame jFramePadre) {
        this.jFramePadre = jFramePadre;
    }
}
