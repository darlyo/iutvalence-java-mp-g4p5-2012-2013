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
	// FIXME  (FIXED) respecter les conventions d'écriture
	// FIXME  (FIXED) renommer l'attribut
	private int nbVictoire;
	
	//*********** CONSTRUCTEUR *****************
	
	// FIXME  (FIXED) réfléchir à la pertinence de ce constructeur
	/**
	* Création d'un joueur pour sauvegarder ses partie
	*/
	public Joueur()
	{			
		this.playerName = "Player";
		this.nbVictoire = 0;
	}
		
	/**
	* Création d'un joueur avec un nom
	* @param nom nom du joueur
	*/
	public Joueur(String nom)
	{
		this.playerName = nom;
		this.nbVictoire = 0;
	}
		
	//********* METHODE ********************	
	
	/**
	 * Donne le nombre de victoires d'un joueur
	 * @return nombre de victoires
	 */
	// FIXME (FIXED) renommer la méthode
	public int getNbVictoire ()
	{
		return this.nbVictoire;
	}
	
	
	// FIXME (FIXED) corriger le commentaire
	/**
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.playerName;
	}
	
	// FIXME (FIXED) corriger le commentaire
	/**
	 * Change le nom du joueur
	 * @param name : nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.playerName = name;
	}
	
	

	// FIXME (FIXED) corriger le commentaire 
	/**
	 * le joueur vient de gagner un match
	 */
	public void gagne()
	{
		this.nbVictoire++;	
	}
	
	
	// FIXME (FIXED) à supprimer, pas de sens ici
	
}
