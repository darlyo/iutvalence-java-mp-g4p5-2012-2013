package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * @author mainguek
 *
 */
public class ControlAlea implements InterfaceControl
{
	
	public int saisie(int borne, Grille grille )
	{
		return (int)(Math.round(Math.random()*(borne-1)));
	}
}