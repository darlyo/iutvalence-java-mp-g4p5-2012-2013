package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
/**
 * @author mainguek
 *
 */
@SuppressWarnings("serial")
public class Panneau extends JPanel {
 
        /**
         * @param g graph
         * @param str image
         */
        public void paintComponent(Graphics g, String str)
        {
                try {
                        Image img = ImageIO.read(new File(str));
                        g.drawImage(img, 0, 0, this);
                        //Pour une image de fond
                        //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }               
}