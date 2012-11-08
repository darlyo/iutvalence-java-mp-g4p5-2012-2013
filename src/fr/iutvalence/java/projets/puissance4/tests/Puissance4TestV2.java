package fr.iutvalence.java.projets.puissance4.tests;

import fr.iutvalence.java.projets.puissance4.Joueur;
import fr.iutvalence.java.projets.puissance4.Partie;

// TO DELETE : TEST DE PUSH
/**
 * La classe contenant le lancement du jeu version la plus simple
 * 
 * @author mainguene kevin Marie joris
 */
public class Puissance4TestV2
{

	/**
	 * Partie simple avec deux joueur gere pas l'ordi
	 * @param args  parametre vide
	 */
	public static void main(String[] args)
	{
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();

		Partie partie;
		int ordre = (int) Math.round(Math.random());

		if (ordre == 1)
		{
		partie = new Partie(j1.getName(), j2.getName());
		}
		else
		{
		partie = new Partie(j2.getName(), j1.getName());
		}
		partie.lancer();
		
	}
}
