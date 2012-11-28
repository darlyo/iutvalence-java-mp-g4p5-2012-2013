package fr.iutvalence.java.projets.puissance4.mvc;

import javax.swing.JFrame;

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
	 * @throws CaseInexistanteException gestion d'exception si la colonne n'existe pas
	 */
	void ajoutePion( int ligne, int colone, int valeur)  throws  CaseInexistanteException;
	
	/**
	 * affiche un message qui annonce a qui c'est de jouer
	 * @param nom : nom du joueur à jouer
	 */
	void messageTour(String nom);
	
	/**
	 * affiche un message qui donner le vainqueur
	 * @param nom :nom du vainqueur
	 */
	void messageVictoire(String nom);
	
	/**
	 * affiche un message disant que la colone est pleine
	 */
	void messageColPleine();
	
	
	/**
	 * affiche un message disant que le joueur a perdu la manche
	 * @param nom 
	 */
	public void messageDefaite(String nom);
	
	/**
	 * affiche un message disant que la manche est nulle
	 */
	public void messageNul();
}
