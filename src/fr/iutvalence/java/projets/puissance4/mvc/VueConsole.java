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
	public void ajoutePion(int ligne, int colone, int valeur, Grille grille) throws CaseInexistanteException
	{
		System.out.println(grille);
	}

	@Override
	public void message(String msg)
	{
		System.out.println(msg);
	}
}
