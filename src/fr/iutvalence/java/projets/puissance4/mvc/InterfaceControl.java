package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * Interface pour le controle 
 * 
 * @author mainguene kevin marie joris
 */

public interface InterfaceControl
{	
	/**
	 * @param borne la borne maximale pour la saisie
	 * @param grille la partie en cour
	 * @return valeur saisie par l'utilisateur -1 pour correspondre au tableau
	 */
	public int saisie(int borne, Grille grille);
}
