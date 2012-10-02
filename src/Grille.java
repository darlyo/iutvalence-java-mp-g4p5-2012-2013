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
	/**
	 * Une colonne est plein on ne pas pose un jeton
	 */
	public static final int PLEIN = -1;

	/**
	 * Renvoie 1 pour dire que le joueur a bien joué
	 */
	public static final int OK = 1;

	/**
	 * Pas de gagnant la parti continue.
	 */
	public static final int CONTINU = 0;

	/**
	 * définition d'une grille de 7 colonne et 6 ligne
	 * on place 0;0 en bas a gauche
	public final static int[][] GRILLE;
	
	 * abscisse de la grille
	 */
	public int x;
	
	/**
	 * ordonnée de la grille
	 */
	public int y;
	
	/**
	 * définie une grille 
	 */
	public int[][] grille;

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
	
	/**
	 * regarde si on peut rajouter un jeton dans une colonne
	 * @param Joueur Numero du joueur 1 ou 2
	 * @param numColone numero de la colonne a test
	 * @return numero de la case libre ou PLEIN si il n'y a plus de place.
	 */
	public int Joue (int Joueur, int numColone)
	{
		int i ;
		for (i=0; i<6; i++)
		{
			if (this.grille[numColone][i] == 0)
			{
				this.grille[numColone][i] = Joueur;
				break;
			}
		}
		if (i == 6) return PLEIN;
		return i;
	}
	
	/**
	 * @return le vainqueur ou 0 pour continuer la partie 
	 */
	public int Check()// les diagonale de fonctionne pas
	{
		int x, y;	//variable pour se déplacer dans le tableau
		int i;			
		int couleur;	//variable de vérification et résultat (joueur gagnant)
		for (x=0;x <7;x++)		//check des colonnes
		{
			if ((this.grille[x][2] != 0) && (this.grille[x][2] == this.grille[x][3]))
				{
					couleur = this.grille[x][2];
					if (couleur == this.grille[x][4])
					{
						if ((couleur == this.grille[x][5]) || (couleur == this.grille[x][1]))
							return couleur;
					}
					else 
						if ((couleur == this.grille[x][1])&&(couleur == this.grille[x][0]))
							return couleur;
				}	
		}
		
		for (y=0; y<6; y++) 	//check des lignes
		{
			if (this.grille[3][y] != 0)
			{
				couleur = this.grille[3][y];
				if ((couleur == this.grille[2][y])&&(couleur == this.grille[1][y])&&(couleur == this.grille[0][y]))
					return couleur;
				if ((couleur == this.grille[2][y])&&(couleur == this.grille[1][y])&&(couleur == this.grille[4][y]))
					return couleur;
				if ((couleur == this.grille[2][y])&&(couleur == this.grille[4][y])&&(couleur == this.grille[5][y]))
					return couleur;
				if ((couleur == this.grille[4][y])&&(couleur == this.grille[5][y])&&(couleur == this.grille[6][y]))
					return couleur;
			}
		}
		
		for(x=0; x<4;x++)	// check diagonale de gauche a droite
		{
			for(i=0; i<3;i++)
			{
				couleur = this.grille[x][0];
				if((couleur == this.grille[x][i]) && (couleur == this.grille[x+1][1+i]) && (couleur == this.grille[x+2][2+i]) && (couleur == this.grille[x+3][3+i]))
					return couleur;
			}
		}
		
		for(x=6; x>3;x++)	// check diagonale de droite a gauche
		{
			for(i=0; i<3;i++)
			{
				couleur = this.grille[x][0];
				if((couleur == this.grille[x][i]) && (couleur == this.grille[x-1][1+i]) && (couleur == this.grille[x-2][2+i]) && (couleur == this.grille[x-3][3+i]))
					return couleur;
			}
		}
		
		return CONTINU;
	}
	
	/**
	 * Test une grille et regarde si c'est gagné 
	 * @param x	:numero de la collone du dernier jeton poser
	 * @param y :numero de la ligne du derier jeton poser
	 * @return le vainqueur ou 0
	 */
	//public int Check(int x, int y)
	//{
	//	for 
	//}
	
	/**
	 * affiche une grille
	 */
	public void affiche()
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
