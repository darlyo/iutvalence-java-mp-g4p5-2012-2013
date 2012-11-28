package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * classe Vue pour l'affichage 
 * 
 * @author mainguene kevin marie joris
 */

public class VueConsole implements InterfaceVue
{

	@Override
	public void affichegrille(Grille grille)
	{
		System.out.println(grille);
	}

	@Override
	public void ajoutePion(int ligne, int colone, int valeur) throws CaseInexistanteException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageTour(String nom)
	{
		System.out.println("C'est a "+nom+" de jouer.");
	}

	@Override
	public void messageVictoire(String nom)
	{
		System.out.println(nom+"vous avez gagné cette manche, Bravo !");
		
	}

	@Override
	public void messageColPleine()
	{
		System.out.println("La colonne est pleine, choisissez une autre colonne.");
	}
	
	
	/**
	 * 
	 */
	public void messageDefaite(String nom)
	{
		System.out.println(nom+"vous avez perdu cette manche.");
	}

	public void messageNul()
	{
		System.out.println("Cette manche est nulle");
	}


}
