package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * Interface pour l'affichage 
 * 
 * @author mainguene kevin marie joris
 */
public interface InterfaceVue
{
	/**
	 * affiche une grille vide
	 * @param grille la grille a afficher
	 */
	void affichegrille(Grille grille);
	
	/**
	 * @param ligne ligne ou est ajoute le pion
	 * @param colone colonne ou l'on ajoute le pion
	 * @param valeur entier qui permet de déterminer la couleur du pions
	 * @param grille la grille a afficher
	 * @throws CaseInexistanteException gestion d'exception si la colonne n'existe pas
	 */
	void ajoutePion( int ligne, int colone, int valeur, Grille grille)  throws  CaseInexistanteException;
	
	/**
	 * affiche un message 
	 * @param msg : intitulé du message
	 */
	void message(String msg);
	
}
