package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * gestiond e l'affiche graphique pour un joueur
 * 
 * @author mainguene kevin marie joris
 */
public class VueGUI implements InterfaceVue 
{
	/**
	 * 
	 */
	private Panneau pan;
	
	/**
	 * 
	 */
	private Box cmd;
	/**
	 * Fenetre associe au joueur
	 */
	private JFrame fenetre;
	
	@Override
	public void affichegrille(Grille grille)
	{
        this.fenetre = new JFrame();
		
		this.fenetre.setTitle("Puissance 4");
		this.fenetre.setSize(600, 600);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setResizable(false);
		
		this.pan = new Panneau();
		this.pan.paintInit();
		
		this.cmd = Box.createHorizontalBox();
	    //On ajoute le bouton au content pane de la JFrame
	    this.cmd.add(new JButton("1"));
	    this.cmd.add(new JButton("2"));
	    this.cmd.add(new JButton("3"));
	    this.cmd.add(new JButton("4"));
	    this.cmd.add(new JButton("5"));
	    this.cmd.add(new JButton("6"));
	    this.cmd.add(new JButton("7"));

	    Box box = Box.createVerticalBox();
	    box.add(this.cmd);
	    box.add(this.pan);
	    
		this.fenetre.setContentPane(box);
		this.fenetre.repaint();
		this.fenetre.setVisible(true);
	}

	@Override
	public void ajoutePion(int ligne, int colone, int valeur, Grille grille) throws CaseInexistanteException
	{	
		this.pan.paintPion(ligne, colone, valeur);
		this.pan.repaint();
	}

	@Override
	public void message(String msg)
	{
		this.pan.setMsg(msg);
		this.pan.repaint();
	}
	
}
