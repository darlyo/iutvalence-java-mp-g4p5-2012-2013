package fr.iutvalence.java.projets.puissance4;

/**
 * definition d'une grille de jeu avec le point d'origine en bas a gauche
 * 
 * @author mainguene kevin marie joris
 */
public class Grille
{
	/**
	 * Constante repr�sentant un contenu "vide" pour une case de la grille
	 */
	public static final int VIDE = 0;

	/**
	 * Informe qu'il n'y a pas encore de gagnant, permet de continuer la partie.
	 */
	public static final int CONTINU = 0;
	
	/**
	 * largeur de la grille
	 */
	public static final int X_MAX = 7;

	/**
	 * hauteur de la grille
	 */
	public static final int Y_MAX = 6;

	
	/**
	 * d�finition d'une grille de 7 colonnes et 6 lignes on place 0;0 en bas a gauche contenant des entiers: 0 pour vide
	 * ou 1 et 2 pour un joueur
	 */
	private int[][] grille;

	/**
	 * cr�e une grille vide
	 */
	public Grille()
	{
		int x, y;
		this.grille = new int[X_MAX][Y_MAX];
		x = 0;
		while (x != X_MAX)
		{
			y = 0;
			while (y != Y_MAX)
			{
				this.grille[x][y] = VIDE;
				y = y + 1;
			}
			x = x + 1;
		}
	}

	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * 
	 * @param joueur
	 *            : 1 ou 2 en fonction du joueur qui joue
	 * @param numColone
	 *            : numero de la colonne ou on ajoute un jeton
	 * @return la ligne dans la quelle le pion est ins�rer
	 * @throws ColonnePleineException
	 *             traite le cas ou la colonne est pleine
	 * @throws ColonneInexistanteException 
	 * 				traite le cas ou la colone n'existe pas
	 */
	public int joue(int joueur, int numColone) throws ColonnePleineException, ColonneInexistanteException
	{
		int i = 0;
		if ((numColone < 0 ) || ( numColone > 6))
				throw new ColonneInexistanteException();

		for (i = 0; i < Y_MAX; i++)
		{
			if (this.grille[numColone][i] == VIDE)
			{
				this.grille[numColone][i] = joueur;
				break;
			}
		}
		if (i == Y_MAX)
			throw new ColonnePleineException();
		return i;
	}
	 
	/**
	 * Red�finition de la m�thode toString pour afficher le contenu de l'objet grille a 
	 * l'aide d'une chaine sous la forme d'un tableau
	 * @see java.lang.Object#toString()
	 *
	 */
	public String toString()
	{
		int x, y;

		String chaine = "";

		for (y = Y_MAX - 1; y >= 0; y--)
		{
			chaine = chaine + "|";
			for (x = 0; x < X_MAX; x++)
			{
				chaine = chaine + " ";
				if (this.grille[x][y] == VIDE)
				{
					chaine = chaine + " ";
				}
				else if (this.grille[x][y] == 1)
				{
					chaine = chaine + "X";
				}
				else 
				{
					chaine = chaine + "O";
				}
				chaine = chaine + " |";
			}
			chaine = chaine + "\n|---|---|---|---|---|---|---|\n";
		}
		chaine = chaine + "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n";
		return chaine;
	}

	/**
	 * donne la valeur d'une case
	 * 
	 * @param x
	 *            abscisse de la case
	 * @param y
	 *            ordonn�e de la case
	 * @return valeur de la case
	 * @throws CaseInexistanteException cr�e une exception si la case n'existe pas
	 */
	public int getCase(int x, int y) throws CaseInexistanteException
	{
		if ((x < 0) || (x > X_MAX) || (y < 0) || (y > Y_MAX))
			throw new CaseInexistanteException();
		else
			return this.grille[x][y];
	}

	
	/**
	 * @param x	colonne a tester	
	 * @return	vrai si la colonne est pleinne sinon faux
	 * @throws ColonneInexistanteException exception si la colonne est en dehors du tableau
	 */
	public boolean colPleine(int x) throws ColonneInexistanteException
	{
		if ((x < 0) || (x > X_MAX))
			throw new ColonneInexistanteException();
		else
			return (this.grille[x][Y_MAX-1] != VIDE);
	}
	/**
	 * modifie la valeur d'une case de la grille
	 * 
	 * @param x
	 *            l'abscisse de la case
	 * @param y
	 *            ordonn�e de la case
	 * @param v
	 *            valeur de la case
	 * @throws CaseInexistanteException cr�e une exception si la case n'existe pas
	 */

	public void setCase(int x, int y, int v) throws CaseInexistanteException
	{
		if ((x < 0) || (x > X_MAX) || (y < 0) || (y > Y_MAX))
			throw new CaseInexistanteException();
		else
			this.grille[x][y] = v;
	}

	/**
	 * v�rification de la grille pour voir si le dernier joueur a gagner ou non
	 * @param nbPions le nombre de pions necessaire pour gagner
	 * @return le vainqueur ou 0 pour continuer la partie
	 */
	public int checkVictoire(int nbPions)
	{
		int x, y;	// variable pour se d�placer dans le tableau ordonne et abscisse
		int i;
		int couleur;	// variable de v�rification et r�sultat (joueur gagnant)

		try
		{
			for (x = 0; x < X_MAX ; x++)		// check des colonnes de gauche a droite
			{
				for(y = 0; y < (Y_MAX - nbPions +1) ; y++)
				{
					if (this.getCase(x, y)!= VIDE)
					{
						i = 1;
						couleur = this.getCase(x, y);
						while((i < nbPions-1) && (this.getCase(x, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.getCase(x, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}

			for (y = 0; y < Y_MAX ; y++) 	// check des lignes de bas en haut
			{
				for(x = 0; x < (X_MAX - nbPions +1) ; x++)
				{
					if (this.getCase(x, y)!= VIDE)
					{
						i = 1;
						couleur = this.getCase(x, y);
						while((i < nbPions-1) && (this.getCase(x+i, y)== couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.getCase(x+i, y) == couleur))
						{
							return couleur;
						}
					}
				}
			}

			for (y = 0; y < (Y_MAX - nbPions +1) ; y++) 	// check diagonale de gauche a droite
			{
				for(x = 0; x < (X_MAX - nbPions +1) ; x++)
				{
					if (this.getCase(x, y) != VIDE)
					{
						i = 1;
						couleur = this.getCase(x, y);
						while((i < nbPions-1) && (this.getCase(x+i, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.getCase(x+i, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}
			
			for (y = 0; y < (Y_MAX - nbPions +1) ; y++) 	// check diagonale de droite a gauche
																//Probleme diagonal non reconnue comme gagnante
			{
				for(x = X_MAX-1 ; x >= (nbPions -1) ; x--)
				{
					if (this.getCase(x, y) != VIDE)
					{
						i = 1;
						couleur = this.getCase(x, y);
						while((i < nbPions-1) && (this.getCase(x-i, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.getCase(x-i, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}
		}
		catch (CaseInexistanteException e)
		{
			// case correcte car control� avant
			//on ignore donc l'erreur
		}		

		return CONTINU;
	}
	

	/**
	 * @param x l'abscisse du pions a checker
	 * @param y l'ordonn�e du pion a checker
	 * @param nbPions le nombre de pions a aligner pour gagner
	 * @return le gagnant ou 0  pour continuer ou -1 si le case n'existe pas ( plus ou moins impossible )
	 */
	public int checkvictoryV2(int x, int y, int nbPions) 
	{   
		int couleur;
		
		try
		{
			couleur = this.getCase(x,y);   
			if ((x+3 < X_MAX) && (this.getCase(x+1,y) == couleur) && (this.getCase(x+2,y) == couleur) && (this.getCase(x+3,y) == couleur))
				return couleur;
			if ((x-1 >= 0) && (x+2 < X_MAX) && (this.getCase(x-1,y) == couleur) && (this.getCase(x+1,y) == couleur) && (this.getCase(x+2,y) == couleur))
				return couleur;
			if ((x-2 >= 0) && (x+1 < X_MAX) && (this.getCase(x-2,y) == couleur) && (this.getCase(x-1,y) == couleur) && (this.getCase(x+1,y) == couleur))
				return couleur;
			if ((x-3 >= 0) &&(this.getCase(x-3,y) == couleur) && (this.getCase(x-2,y) == couleur) && (this.getCase(x-1,y) == couleur))
				return couleur; //ligne horizontale check
			
			
			if ((y-3 >= 0) &&(this.getCase(x,y-3) == couleur) &&  (this.getCase(x,y-2) == couleur) && (this.getCase(x,y-1) == couleur))
				return couleur; //ligne verticale check
		
			
			if ((x+3 < X_MAX) && (y+3 < Y_MAX) && (this.getCase(x+1,y+1) == couleur) && (this.getCase(x+2,y+2) == couleur) && (this.getCase(x+3,y+3) == couleur))
				return couleur;
			if ((x+2 < X_MAX) && (y+2 < Y_MAX) && (x-1 >= 0) && (y-1 >= 0) && (this.getCase(x-1,y-1)== couleur) && (this.getCase(x+1,y+1)== couleur) && (this.getCase(x+2,y+2)== couleur))
				return couleur;
			if ((x+1 < X_MAX) && (y+1 < Y_MAX) && (x-2 >= 0) && (y-2 >= 0) && (this.getCase(x-2,y-2)== couleur) && (this.getCase(x-1,y-1)== couleur) && (this.getCase(x+1,y+1)== couleur))
				return couleur;
			if ((x-3 >= 0) && (y-3 >-1) && (this.getCase(x-3,y-3)== couleur) && (this.getCase(x-2,y-2)== couleur) && (this.getCase(x-1,y-1)== couleur))
				return couleur; // Diagonnale gauche droite check
			
			
			if ((x-3 >= 0) && (y+3 <Y_MAX) && (this.getCase(x-3,y+3) == couleur) && (this.getCase(x-2,y+2) == couleur) && (this.getCase(x-1,y+1) == couleur))
				return couleur;
			if ((x-2 >= 0) && (y-1 >= 0) && (y+2 <Y_MAX) && (x+1 < X_MAX) && (this.getCase(x-2,y+2) == couleur) && (this.getCase(x-1,y+1) == couleur) && (this.getCase(x+1,y-1) == couleur))
				return couleur;
			if ((x-1 >= 0) && (y-2 >= 0) && (y+1 <Y_MAX) && (x+2 < X_MAX) && (this.getCase(x-1,y+1) == couleur) && (this.getCase(x+1,y-1) == couleur) && (this.getCase(x+2,y-2) == couleur))
				return couleur;
			if ( (y-2 >= 0) && (x+2 < X_MAX) && (this.getCase(x+1,y-1)== couleur) && (this.getCase(x+2,y-2) == couleur) && (this.getCase(x+3,y-3) == couleur))
				return couleur; // diagonale droite gauche check
		}
		catch (CaseInexistanteException e)
		{
			// case correcte car control� avant
			//on ignore donc l'erreur
		}
		
		
		return 0;
		
	}
	
}
