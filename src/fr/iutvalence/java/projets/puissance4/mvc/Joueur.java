package fr.iutvalence.java.projets.puissance4.mvc;


import fr.iutvalence.java.projets.puissance4.mvc.InterfaceControl;
import fr.iutvalence.java.projets.puissance4.mvc.InterfaceVue;

/**
 * definition d'une classe joueur avec un nom et un nombre de victoire et defini les méthode pour modifier le nom et
 * augmenter le nb de victoire ainsi que les afficher
 * 
 * @author mainguene kevin marie joris
 */
public class Joueur
{
	// **************** VARIABLE ******************************

	/**
	 * nom du joueur par defaut playeurX mais peut etre modifier
	 */
	private String playerName;

	/**
	 * nombre de victoires
	 */
	private int nbVictoires;
	
	/**
	 * l'interface de control du joueur
	 */
	private InterfaceControl cj;
	
	/**
	 * l'interface d'affichage du joueur
	 */
	private InterfaceVue vj;

	// *********** CONSTRUCTEUR *****************

	/**
	 * Création d'un joueur pour sauvegarder ses parties
	 * @param cj l'interface de controle utilise pour le joueur
	 * @param vj l'interface d'affiche pour le joueur
	 */
	public Joueur(InterfaceControl cj, InterfaceVue vj)
	{
		this.playerName = "";
		this.nbVictoires = 0;
		this.cj = cj;
		this.vj = vj;
	}

	/**
	 * Création d'un joueur avec un nom
	 * @param nom  nom du joueur
	 * @param cj l'interface de controle utilise pour le joueur
	 * @param vj l'interface d'affiche pour le joueur
	 */
	public Joueur(String nom, InterfaceControl cj, InterfaceVue vj)
	{
		this.playerName = nom;
		this.nbVictoires = 0;
	}

	// ********* METHODE ********************

	/**
	 * Donne le nombre de victoires d'un joueur
	 * 
	 * @return nombre de victoires
	 */
	public int getNbVictoires()
	{
		return this.nbVictoires;
	}

	/**
	 * permet d'obtenir le nom du joueur
	 * 
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.playerName;
	}

	/**
	 * Change le nom du joueur
	 * 
	 * @param name
	 *            : nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.playerName = name;
	}

	/**
	 * le joueur vient de gagner un match
	 */
	public void gagne()
	{
		this.nbVictoires++;
	}
	
	/**
	 * @return l'interface de controle utiliser
	 */
	public InterfaceControl getCtrl()
	{
		return this.cj;
	}
	
	/**
	 * @return l'interfca d'affichage utiiser
	 */
	public InterfaceVue getVue()
	{
		return this.vj;
	}

}
