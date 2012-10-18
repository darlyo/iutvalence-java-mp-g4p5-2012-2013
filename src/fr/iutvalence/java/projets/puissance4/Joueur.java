package fr.iutvalence.java.projets.puissance4;
// FIXME (FIXED) déplacer dans un paquetage

// FIXME (FIXED) compléter le commentaire
/**
 * definition d'une classe joueur avec un nom et un nombre de victoire
 * et defini les méthode pour modifier le nom et augmenter le nb de 
 * victoire ainsi que les afficher
 * @author mainguene kevin 		marie joris
 */
public class Joueur
{
	//**************** VARIABLE ******************************	
	
	// FIXME (FIXED) le joueur peut-il changer de nom ? oui
	// FIXME (FIXED) respecter les conventions d'écriture
	/**
	 * nom du joueur
	 * par defaut playeurX
	 * mais peut etre modifier
	 */
	private String playerName;
	
	/**
	 * nombre de victoires
	 */
	// FIXME  (NOT FIXED)(REFIXED) renommer l'attribut (il peut y avoir plusieurs victoires ;-) )
	private int nbVictoires;
	
	//*********** CONSTRUCTEUR *****************
	
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
	* @param nom nom du joueur
	*/
	public Joueur(String nom)
	{
		this.playerName = nom;
		this.nbVictoires = 0;
	}
		
	//********* METHODE ********************	
	
	/**
	 * Donne le nombre de victoires d'un joueur
	 * @return nombre de victoires
	 */
	// FIXME renommer la méthode
	public int getNbVictoire ()
	{
		return this.nbVictoires;
	}
	
	
	// FIXME (NOT FIXED)(FIXED) corriger le commentaire (il faut 2 lignes : 1 pour la description, une pour la balise @return)
	/**
	 * permet d'obtenir le nom du joueur 
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.playerName;
	}
	
	/**
	 * Change le nom du joueur
	 * @param name : nouveau nom du joueur
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
