package fr.iutvalence.java.projets.puissance4.mvc;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * gestiond e l'affiche graphique pour un joueur
 * 
 * @author mainguene kevin marie joris
 */
public class VueGUI implements InterfaceVue 
{

	@Override
	public void affichegrille(Grille grille, JFrame fenetre)
	{
		
		
	}

	@Override
	public void ajoutePion(int ligne, int colone, int valeur, JFrame fenetre, Grille grille) throws CaseInexistanteException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void messageTour(String nom)
	{
		String str = "Tour de "+nom;
		JFrame fenetre = new JFrame();

		JOptionPane.showMessageDialog(fenetre, str, "Message", JOptionPane.PLAIN_MESSAGE);

	}

	@Override
	public void messageVictoire(String nom)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageColPleine()
	{
		String str = "La colonne est pleine";
		JFrame fenetre = new JFrame();

		JOptionPane.showMessageDialog(fenetre, str, "Message", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void messageDefaite(String nom)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageNul()
	{
		// TODO Auto-generated method stub
		
	}


}
