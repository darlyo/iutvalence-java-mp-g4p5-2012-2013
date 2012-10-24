package fr.iutvalence.java.projets.puissance4;

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

	// *********** CONSTRUCTEUR *****************

	/**
	 * Création d'un joueur pour sauvegarder ses parties
	 */
	public Joueur()
	{
		this.playerName = "Player";
		this.nbVictoires = 0;
	}

	/**
	 * Création d'un joueur avec un nom
	 * 
	 * @param nom
	 *            nom du joueur
	 */
	public Joueur(String nom)
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
	// FIXME renommer la méthode
	public int getNbVictoire()
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

}
