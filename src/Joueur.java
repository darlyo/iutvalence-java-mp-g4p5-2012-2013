/**
 * 
 * @author mainguek
 *
 */
public class Joueur
{
	/**
	 * Nombre de joueur
	 */
	private static int joueur = 0;
	
	/**
	 * Valeur du joueur 
	 */
	private int valeur;
	
	/**
	 * nom du joueur
	 */
	private String name;
	
	/**
	 * nombre de victoire
	 */
	private int victoire;
	
	/**
	 * Donne le nombre de victoire d'un joueur
	 * @return nombre de victoire
	 */
	public int getVictoire ()
	{
		return this.victoire;
	}
	
	/**
	 * donne la valeur du joueur 
	 * @return la valeur
	 */
	public int getValeur()
	{
		return this.valeur;
	}
	/**
	 * donne le nom d'un joueur
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Change le nom d'un joueur
	 * @param name : nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Création d'un joueur
	 */
	public Joueur()
	{
		int i;
		for (i=0; i <= joueur;i++)
			
		this.valeur = i+1;
		this.name = "Joueur "+ i;
		this.victoire = 0;
		joueur++;
	}
	
	/**
	 * Création d'un joueur avec un nom
	 * @param nom nom du joueur
	 */
	public Joueur(String nom)
	{
		int i;
		for (i=0; i <= joueur;i++)
			
		this.valeur = i+1;
		this.name = nom;
		this.victoire = 0;
		joueur++;
	}

	/**
	 * le joueur vient de gagné un match
	 */
	public void gagne()
	{
		this.victoire++;	
	}
	
	/**
	 * Affiche le score de 2 joueur
	 * @param j1 Joueur 1
	 * @param j2 Joueur 2
	 */
	public void score(Joueur j1, Joueur j2)
	{
		System.out.println("Bilan du match entre: "+j1.name+" et "+j2.name);
		if (j1.victoire < j2.victoire)
			System.out.println("Victoire de "+j2.name+" par "+j2.victoire+" a "+j1.victoire);
		if (j1.victoire > j2.victoire)
			System.out.println("Victoire de "+j1.name+" par "+j1.victoire+" a "+j2.victoire);
		else
			System.out.println("Le score est de "+j1.victoire+"partout." );
	}
}
