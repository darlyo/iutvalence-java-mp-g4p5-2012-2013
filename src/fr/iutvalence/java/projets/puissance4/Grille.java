package fr.iutvalence.java.projets.puissance4;


// FIXME (FIXED) corriger le commentaire
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
	// FIXME (FIXED) corriger le commentaire
	/**
	 * constante renvoyer par la méthode joue indicant que la colone joue est pleine
	 */
	public static final int PLEIN = -1;
	
	// FIXME (FIXED) définir une constante pour "vide"
	/**
	 * Constante définisant une case vide dans la grille par 0
	 */
	public static final int VIDE = 0;

	// FIXME (FIXED) corriger le commentaire
	/**
	 * constante ok supprimer
	 */

	// FIXME (FIXED) corriger le commentaire
	/**
	 * constante continue supprimer
	 */


	// FIXME (FIXED) corriger le commentaire
	// FIXME (FIXED) définir des constantes pour la taille
	/**
	 * définition d'une grille de 7 colonnes et 6 lignes
	 * on place 0;0 en bas a gauche contenant des entiers:
	 * 0 pour vide ou 1 et 2 pour un joueur
	 */
	public int[][] grille;
	
	// FIXME (FIXED) préciser (inutile ?)
	/**
	 * taille de l'abscisse d'une grille
	 */
	public static final int XMAX = 7;

	// FIXME (FIXED) préciser
	/**
	 * taille de l'ordonnée d'un grille
	 */
	public static final int YMAX = 6;
	
	
	/**
	 * crée une grille vide
	 */
	public Grille()
	{
		int x,y;
		this.grille = new int[XMAX][YMAX];
		// FIXME (FIXED) variable locale ?
		x=0;
		while (x !=XMAX)
		{
			y=0;
			while(y !=YMAX)
			{
				this.grille[x][y] = VIDE;
				y = y+1;
			}
			x = x+1;
		}
		System.out.println("1");
	}
	
	// FIXME gérer les cas d'erreur avec des exceptions
	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * @param joueur : 1 ou 2 en fonvtion du joueur qui joue
	 * @param numColone : numero de la colonne ou on ajoute un jeton
	 * @return numero de la case libre ou PLEIN si la colone est pleine.
	 * @throws ColonnePleineEx  traite le cas ou la colonne est pleine
	 */
	public int Joue (int joueur, int numColone) throws ColonnePleineEx
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
		if (i == YMAX) 
			throw new ColonnePleineEx();
		return i;
	}
	
	// FIXME (FIXED) corriger le commentaire
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
}
