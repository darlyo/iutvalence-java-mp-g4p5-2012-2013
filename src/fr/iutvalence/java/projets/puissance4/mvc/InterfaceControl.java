package fr.iutvalence.java.projets.puissance4.mvc;

/**
 * Interface pour le controle 
 * 
 * @author mainguene kevin marie joris
 */

public interface InterfaceControl
{	
	/**
	 * @param borne la borne maximale pour la saisie
	 * @param partie la partie en cour
	 * @return valeur saisie par l'utilisateur -1 pour correspondre au tableau
	 */
	public int saisie(int borne, Partie partie);
}
