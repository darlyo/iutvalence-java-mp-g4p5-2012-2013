package base;
// FIXME d�placer dans un paquetage

// FIXME compl�ter le commentaire
/**
 * 
 * @author mainguek
 *
 */
public class Joueur
{
	//**************** VARIABLE ******************************	
	
	// FIXME le joueur peut-il changer de nom ? oui
	/**
	 * nom du joueur
	 */
	private String player_name;
	
	/**
	 * nombre de victoires
	 */
	private int nbvictoire;
	
	//*********** CONSTRUCTEUR *****************
	
	// FIXME r�fl�chir � la pertinence de ce constructeur
	/**
	* Cr�ation d'un joueur
	*/
	public Joueur()
	{			
		this.player_name = "";
		this.nbvictoire = 0;
	}
		
	/**
	* Cr�ation d'un joueur avec un nom
	* @param nom nom du joueur
	*/
	public Joueur(String nom)
	{

		this.player_name = nom;
		this.nbvictoire = 0;

	}
		
	//********* METHODE ********************	
	
	/**
	 * Donne le nombre de victoires d'un joueur
	 * @return nombre de victoires
	 */
	public int getVictoire ()
	{
		return this.nbvictoire;
	}
	
	
	// FIXME corriger le commentaire
	/**
	 * donne le nom d'un joueur
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.player_name;
	}
	
	// FIXME corriger le commentaire
	/**
	 * Change le nom d'un joueur par name
	 * @param name : nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.player_name = name;
	}
	
	

	// FIXME corriger le commentaire 
	/**
	 * le joueur vient de gagner un match
	 */
	public void gagne()
	{
		this.nbvictoire++;	
	}
	
	
	// FIXME � supprimer, pas de sens ici
	
}
