package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;

/**
 * Interface pour l'affichage 
 * 
 * @author mainguene kevin marie joris
 */
public interface InterfaceVue
{
	/**
	 * affiche une grille vide
	 */
	void affichegrille();
	
	/**
	 * @param ligne ligne ou est ajoute le pion
	 * @param colone colonne ou l'on ajoute le pion
	 * @param valeur entier qui permet de déterminer la couleur du pions
	 * @throws CaseInexistanteException gestion d'exception si la colonne n'existe pas
	 */
	void ajoutePion(int ligne, int colone, int valeur)  throws  CaseInexistanteException;
	
	/**
	 * affiche un popup qui annonce a qui c'est de jouer
	 * @param nom : nom du joueur à jouer
	 */
	void messageTour(String nom);
	
	/**
	 * affiche un popup qui donner le vainqueur
	 * @param nom :nom du vainqueur
	 */
	void messageVictoire(String nom);
}
