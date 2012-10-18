package fr.iutvalence.java.projets.puissance4;
// FIXME (FIXED) d�placer dans un paquetage

// FIXME (FIXED) compl�ter le commentaire
/**
 * definition d'une classe joueur avec un nom et un nombre de victoire
 * et defini les m�thode pour modifier le nom et augmenter le nb de 
 * victoire ainsi que les afficher
 * @author mainguene kevin 		marie joris
 */
public class Joueur
{
	//**************** VARIABLE ******************************	
	
	// FIXME (FIXED) le joueur peut-il changer de nom ? oui
	// FIXME (FIXED) respecter les conventions d'�criture
	/**
	 * nom du joueur
	 * par defaut playeurX
	 * mais peut etre modifier
	 */
	private String playerName;
	
	/**
	 * nombre de victoires
	 */
	// FIXME  (FIXED) respecter les conventions d'�criture
	// FIXME  (FIXED) renommer l'attribut
	private int nbVictoire;
	
	//*********** CONSTRUCTEUR *****************
	
	// FIXME  (FIXED) r�fl�chir � la pertinence de ce constructeur
	/**
	* Cr�ation d'un joueur pour sauvegarder ses partie
	*/
	public Joueur()
	{			
		this.playerName = "Player";
		this.nbVictoire = 0;
	}
		
	/**
	* Cr�ation d'un joueur avec un nom
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
	// FIXME (FIXED) renommer la m�thode
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
	
	
	// FIXME (FIXED) � supprimer, pas de sens ici
	
}
