package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.iutvalence.java.projets.puissance4.Grille;
 
/**
 * @author mainguek
 *
 */
@SuppressWarnings("serial")
public class Panneau extends JPanel 
{
	/**
	 * boolean qui définit si l'on est a l'initialiqation ou non
	 */
	private boolean init;
	
	/**
	 * taille d'un pion en px
	 */
	private static final int tailPion = 64;
	
	/**
	 * Image du pion jouer
	 */
	private Image image;
	
	/**
	 * colonne du pion joue a ajouter
	 */
	private int colonne;
	
	/**
	 * la ligne du pion joue a ajouter
	 */
	private int ligne;
	
	/**
	 * corps du message
	 */
	private String msg = "";
	
	/**
	* @param g graph
    */
	public void paintComponent(Graphics g)
    {
	   if (this.init)
	   {
		   try
		{
			Image img = ImageIO.read(new File("./Image/fondp4.png"));
			   g.drawImage(img, 10, 13, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	   }
	   else
	   {
		   int x = (this.colonne)*75 + 18;
		   int y = (Grille.Y_MAX - this.ligne-1)*75 + 18;
		   g.drawImage(this.image, x, y, this);
	   }
	   g.setColor(Color.white);
	   g.fillRect(200, 525, 100, 20);
	   Font font = new Font("Courier", Font.BOLD, 20);
	   g.setFont(font);
	   g.setColor(Color.red);          
	   g.drawString(this.msg, 200, 525);
		   
	}      
	
	/**
	 * Place la variable etat a true pour initialiser la fenetre
	 */
	public void paintInit()
	{
		this.init = true;
	}
	
	/**
	 * initialisatin de variable pour l'insertion d'un pions
	 * @param ligne	la ligne du pion a insérer
	 * @param colonne la colonne du pions a inserer
	 * @param valeur un entier 1 ou 2 en fonction du joueur.
	 */
	public void paintPion(int ligne, int colonne, int valeur)
	{
		this.init = false;
		this.colonne = colonne;
		this.ligne = ligne;
		
		try
		{
			if (valeur == 1)
				this.image = ImageIO.read(new File("./Image/croix.png"));
			else 
				this.image = ImageIO.read(new File("./Image/rond.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param msg : redéfinition du message
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}