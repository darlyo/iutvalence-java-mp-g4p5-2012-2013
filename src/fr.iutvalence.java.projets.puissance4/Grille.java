package fr.iutvalence.java.projets.puissance4;


// FIXME corriger le commentaire
/**
 * 
 * @author mainguene kevin 		marie joris
 *	definition de la grille de jeu
 *	initialisation de la grille
 *	check de victoire
 *	ajout du pion j1
 *	ajout du pion j2
 */
public class Grille
{
	// FIXME corriger le commentaire
	/**
	 * Une colonne est pleine on ne pas pose un jeton
	 */
	public static final int PLEIN = -1;
	
	// FIXME (fixed)définir une constante pour "vide"
	/**
	 * Constante définisant une case vide dans la grille par 0
	 */
	public static final int VIDE = 0;

	// FIXME (fixed) corriger le commentaire
	/**
	 * constante ok supprimer
	 */

	// FIXME corriger le commentaire
	/**
	 * constante continue supprimer
	 */


	// FIXME(fixed) corriger le commentaire
	// FIXME (fixed) définir des constantes pour la taille
	/**
	 * définition d'une grille de 7 colonnes et 6 lignes
	 * on place 0;0 en bas a gauche contenant des entiers:
	 * 0 pour vide ou 1 et 2 pour un joueur
	 */
	public int[][] grille;
	
	// FIXME (fixed) préciser (inutile ?)
	/**
	 * taille de l'abscisse d'une grille
	 */
	public static final int xMax;

	// FIXME (fixed) préciser
	/**
	 * taille de l'ordonnée d'un grille
	 */
	public static final int yMax;
	
	
	/**
	 * crée une grille vide
	 */
	public Grille()
	{
		int x,y;
		
		this.grille = new int[xMax][yMax];
		 
		// FIXME variable locale ?
		x=0;
		while (x!=7)
		{
			y=0;
			while(y!=6)
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
		
		for (i=0; i<6; i++)
		{
			if (this.grille[numColone][i] == VIDE)
			{
				this.grille[numColone][i] = joueur;
				break;
			}
		}
		if (i == 6) return PLEIN;
		return i;
	}
	
	// FIXME corriger le commentaire
	/**
	 * redéfinition de la méthode toString pour afficher une grille
	 */
	public String toString()
	{
		int x,y;
		
		String chaine = "";
		
		for (y=5; y >= 0; y--)
		{
			chaine = chaine+"|";
			for (x=0; x < 7; x++)
			{
				chaine = chaine+" "+this.grille[x][y]+" |";
			}
			chaine = chaine+"\n|---|---|---|---|---|---|---|\n";
		}
		return chaine;
	}
}
