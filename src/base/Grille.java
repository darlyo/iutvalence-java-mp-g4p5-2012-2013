package base;


// FIXME corriger le commentaire
/**
 * 
 * @author mainguene kevin 		marie joris
 *	definition de la grille de jeux
 *	initialisation de la grille
 *	check de victoire
 *	ajout du pion j1
 *	ajout du pion j2
 */
public class Grille
{
	// FIXME corriger le commentaire
	/**
	 * Une colonne est plein on ne pas pose un jeton
	 */
	public static final int PLEIN = -1;

	// FIXME corriger le commentaire
	/**
	 * Renvoie 1 pour dire que le joueur a bien joué
	 */
	public static final int OK = 1;

	// FIXME corriger le commentaire
	/**
	 * Pas de gagnant la parti continue.
	 */
	public static final int CONTINU = 0;

	// FIXME corriger le commentaire
	/**
	 * définition d'une grille de 7 colonnes et 6 lignes
	 * on place 0;0 en bas a gauche
	 */
	public int[][] grille;
	
	// FIXME préciser
	/**
	 * abscisse de la grille
	 */
	public int x;

	// FIXME préciser
	/**
	 * ordonnée de la grille
	 */
	public int y;
	
	
	/**
	 * crée une grille vide
	 */
	public Grille()
	{
		this.grille = new int[7][6];
		 
		this.x=0;
		while (this.x!=7)
		{
			this.y=0;
			while(this.y!=6)
			{
				this.grille[this.x][this.y]=0;
				this.y = this.y+1;
			}
			this.x =this.x+1;
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
			if (this.grille[numColone][i] == 0)
			{
				this.grille[numColone][i] = joueur;
				break;
			}
		}
		if (i == 6) return PLEIN;
		return i;
	}
	
	/**
	 * affiche une grille
	 */
	public void ToString()
	{
		int x,y;
		
		for (y=5; y >= 0; y--)
		{
			System.out.print("|");
			for (x=0; x < 7; x++)
			{
				System.out.print(" "+this.grille[x][y]+" |");
			}
			System.out.print("\n|---|---|---|---|---|---|---|\n");
		}
	}
}
