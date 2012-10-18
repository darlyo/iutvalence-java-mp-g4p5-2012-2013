package fr.iutvalence.java.projets.puissance4;


// FIXME (NOT FIXED !) corriger le commentaire (juste indiquer à quoi sert la classe, éventuellement comment est placé le repère (numéros de lignes et colonnes)
/**
 *	definition de la grille de jeu
 *	initialisation de la grille
 *	check de victoire
 *	ajout du pion j1
 *	ajout du pion j2
 * @author mainguene kevin 		marie joris
 */
public class Grille
{
	// FIXME (NOT FIXED!) corriger le commentaire : ne pas indiquer par quelle méthode la constante est utilisée mais juste quel sens elle véhicule
	/**
	 * constante renvoyer par la méthode joue indicant que la colone joue est pleine
	 */
	public static final int PLEIN = -1;
	
	/**
	 * Constante représentant un contenu "vide" pour une case de la grille
	 */
	public static final int VIDE = 0;

	/**
	 * définition d'une grille de 7 colonnes et 6 lignes
	 * on place 0;0 en bas a gauche contenant des entiers:
	 * 0 pour vide ou 1 et 2 pour un joueur
	 */
	public int[][] grille;
	
	
	// FIXME regrouper les définitions des constantes avant celles des attributs
	/**
	 * largeur de la grille
	 */
	// FIXME renommer la constante
	public static final int XMAX = 7;

	// FIXME (FIXED) préciser
	/**
	 * hauteur de la grille
	 */
	// FIXME renommer la constante
	public static final int YMAX = 6;
	
	
	/**
	 * crée une grille vide
	 */
	public Grille()
	{
		int x,y;
	
		this.grille = new int[XMAX][YMAX];
		 
		x=0;
		while (x!=XMAX)
		{
			y=0;
			while(y!=YMAX)
			{
				this.grille[x][y] = VIDE;
				y = +1;
			}
			x = x+1;
		}
	}
	
	// FIXME gérer les cas d'erreur avec des exceptions
	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * @param joueur : 1 ou 2 en fonvtion du joueur qui joue
	 * @param numColone : numero de la colonne ou on ajoute un jeton
	 * @return numero de la case libre ou PLEIN si la colone est pleine.
	 */
	public int Joue (int joueur, int numColone)
	{
		int i ;
		
		for (i=0; i<YMAX; i++)
		{
			if (this.grille[numColone][i] == VIDE)
			{
				this.grille[numColone][i] = joueur;
				break;
			}
		}
		if (i == YMAX) return PLEIN;
		return i;
	}
	
	// FIXME (NOT FIXED) corriger le commentaire : indiquer le contenu de la chaîne retournée
	/**
	 * redéfinition de la méthode toString pour afficher une grille
	 */
	public String toString()
	{
		int x,y;
		
		String chaine = "";
		
		for (y=YMAX-1; y >= 0; y--)
		{
			chaine = chaine+"|";
			for (x=0; x < XMAX; x++)
			{
				chaine = chaine+" "+this.grille[x][y]+" |";
			}
			chaine = chaine+"\n|---|---|---|---|---|---|---|\n";
		}
		return chaine;
	}
	
	// FIXME ajouter une méthode pour obtenir le contenu d'une case de la grille
	// FIXME ajouter une méthode pour modifier le contenu d'une case de la grille
}
