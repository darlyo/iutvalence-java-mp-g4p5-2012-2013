package fr.iutvalence.java.projets.puissance4.tests;

import fr.iutvalence.java.projets.puissance4.Joueur;
import fr.iutvalence.java.projets.puissance4.Partie;


/**
 * La classe contenant le lancement du jeu
 * 
 * @author mainguene kevin Marie joris
 */
public class Puissance4TestV2
{

	/**
	 * Menu et lancement des fonctionnalités du jeux
	 * 
	 * @param args
	 *            parametre vide
	 */
	public static void main(String[] args)
	{

	

		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();


					Partie partie = new Partie( j1.getName(),j2.getName());
						
					partie.lancer();
					
}
}
