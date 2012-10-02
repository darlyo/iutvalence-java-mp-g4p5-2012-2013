// FIXME déplacer dans un paquetage

// FIXME compléter le commentaire
/**
 * 
 * @author mainguek
 *
 */
public class Joueur
{
	// FIXME réfléchir à l'endroit le plus judicieux pour définir cet attribut
	// FIXME réfléchir au caractère statique ou non de l'attribut
	// FIXME renommer l'attribut
	/**
	 * Nombre de joueur
	 */
	private static int joueur = 0;
	
	// FIXME réfléchir à l'endroit le plus judicieux pour définir cet attribut
	/**
	 * Valeur du joueur 
	 */
	private int valeur;
	
	// FIXME renommer l'attribut
	// FIXME le joueur peut-il changer de nom ?
	/**
	 * nom du joueur
	 */
	private String name;
	
	// FIXME renommer l'attribut
	/**
	 * nombre de victoires
	 */
	private int victoire;
	
	/**
	 * Donne le nombre de victoires d'un joueur
	 * @return nombre de victoires
	 */
	public int getVictoire ()
	{
		return this.victoire;
	}
	
	// FIXME corriger le commentaire
	/**
	 * donne la valeur du joueur 
	 * @return la valeur
	 */
	public int getValeur()
	{
		return this.valeur;
	}
	
	// FIXME corriger le commentaire
	/**
	 * donne le nom d'un joueur
	 * @return le nom du joueur
	 */
	public String getName()
	{
		return this.name;
	}
	
	// FIXME corriger le commentaire
	/**
	 * Change le nom d'un joueur
	 * @param name : nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	// FIXME placer le constructeur avant les méthodes
	// FIXME réfléchir à la pertinence de ce constructeur
	/**
	 * Création d'un joueur
	 */
	public Joueur()
	{
		int i;
		
		// FIXME ne pas utiliser le compteur d'instances pour affecter un nom au joueur
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

	// FIXME corriger le commentaire 
	/**
	 * le joueur vient de gagner un match
	 */
	public void gagne()
	{
		this.victoire++;	
	}
	
	
	// FIXME à supprimer, pas de sens ici
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
		else if (j1.victoire > j2.victoire)
			System.out.println("Victoire de "+j1.name+" par "+j1.victoire+" a "+j2.victoire);
		else
			System.out.println("Le score est de "+j1.victoire+"partout." );
	}
}
