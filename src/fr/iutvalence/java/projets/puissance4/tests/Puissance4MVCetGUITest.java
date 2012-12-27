package fr.iutvalence.java.projets.puissance4.tests;


import fr.iutvalence.java.projets.puissance4.Menu;
import fr.iutvalence.java.projets.puissance4.MenuPleinException;
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
public class Puissance4MVCetGUITest
{

	/**
	 * Partie simple avec deux joueur gere pas l'ordi
	 * @param args  parametre vide
	 */
	public static void main(String[] args)
	{
		//creation du joueur principal
		InterfaceControl cj1 = new VueGUI();
		InterfaceVue vj1 = (InterfaceVue) cj1;
		//InterfaceVue vj1 = new VueConsole();
		Joueur j1 = new Joueur("Joueur", cj1, vj1);

		//creation d'un menu
		String[] choix = {"Jouer","Quitter"};
		Menu accueil = null;
	    try
		{
			accueil = new Menu(2,"Accueil", choix);
		}
		catch (MenuPleinException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("menu non initialiser: " + choix.length);
		}
	    
	    j1.getVue().afficheMenu(accueil);
	    
		InterfaceControl cj2 = new ControlIA();
		InterfaceVue vj2 = new VueConsole();
		
		Joueur j2 = new Joueur("IA", cj2, vj2);

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
