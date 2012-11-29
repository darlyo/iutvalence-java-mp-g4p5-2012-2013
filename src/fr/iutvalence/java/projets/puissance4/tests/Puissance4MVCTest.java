package fr.iutvalence.java.projets.puissance4.tests;

import fr.iutvalence.java.projets.puissance4.mvc.ControlClavier;
import fr.iutvalence.java.projets.puissance4.mvc.ControlIA;
import fr.iutvalence.java.projets.puissance4.mvc.InterfaceControl;
import fr.iutvalence.java.projets.puissance4.mvc.InterfaceVue;
import fr.iutvalence.java.projets.puissance4.mvc.Joueur;
import fr.iutvalence.java.projets.puissance4.mvc.Partie;
import fr.iutvalence.java.projets.puissance4.mvc.VueConsole;
import fr.iutvalence.java.projets.puissance4.mvc.VueGUI;

/**
 * La classe contenant le lancement du jeu version la plus simple
 * 
 * @author mainguene kevin Marie joris
 */
public class Puissance4MVCTest
{

	/**
	 * Partie simple avec deux joueur gere pas l'ordi
	 * @param args  parametre vide
	 */
	public static void main(String[] args)
	{
		InterfaceControl cj1 = new ControlIA();
		InterfaceControl cj2 = new ControlClavier();
		InterfaceVue vj1 = new VueConsole();
		InterfaceVue vj2 = new VueGUI();
		
		Joueur j1 = new Joueur("IA", cj1, vj1);
		Joueur j2 = new Joueur("Joueur", cj2, vj2);

		Partie partie;
		int ordre = (int) Math.round(Math.random());

		if (ordre == 1)
		{
		partie = new Partie(j1, j2);
		}
		else
		{
		partie = new Partie(j2, j1);
		}
		partie.lancer();
		
	}
}
