package fr.iutvalence.java.projets.puissance4.tests;

import fr.iutvalence.java.projets.puissance4.mvc.ControlAlea;
import fr.iutvalence.java.projets.puissance4.mvc.InterfaceControl;
import fr.iutvalence.java.projets.puissance4.mvc.InterfaceVue;
import fr.iutvalence.java.projets.puissance4.mvc.Joueur;
import fr.iutvalence.java.projets.puissance4.mvc.VueConsole;
import fr.iutvalence.java.projets.puissance4.nonmvc.Partie;

/**
 * La classe contenant le lancement du jeu version la plus simple
 * 
 * @author mainguene kevin Marie joris
 */
public class Puissance4nonMVCTest
{

	/**
	 * Partie simple avec deux joueur gere pas l'ordi
	 * @param args  parametre vide
	 */
	public static void main(String[] args)
	{
		InterfaceControl cj1 = new ControlAlea();
		InterfaceControl cj2 = new ControlAlea();
		InterfaceVue vj1 = new VueConsole();
		InterfaceVue vj2 = new VueConsole();
		
		Joueur j1 = new Joueur(cj1, vj1);
		Joueur j2 = new Joueur(cj2, vj2);

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
