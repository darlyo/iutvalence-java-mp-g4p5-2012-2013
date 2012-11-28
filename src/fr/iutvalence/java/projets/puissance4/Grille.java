package fr.iutvalence.java.projets.puissance4;

/**
 * definition d'une grille de jeu avec le point d'origine en bas a gauche
 * 
 * @author mainguene kevin marie joris
 */
public class Grille
{
	/**
	 * Constante représentant un contenu "vide" pour une case de la grille
	 */
	public static final int VIDE = 0;

	/**
	 * largeur de la grille
	 */
	public static final int X_MAX = 7;

	/**
	 * hauteur de la grille
	 */
	public static final int Y_MAX = 6;

	
	/**
	 * définition d'une grille de 7 colonnes et 6 lignes on place 0;0 en bas a gauche contenant des entiers: 0 pour vide
	 * ou 1 et 2 pour un joueur
	 */
	private int[][] grille;

	/**
	 * crée une grille vide
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
	 * @return la ligne dans la quelle le pion est insérer
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
	 * Redéfinition de la méthode toString pour afficher le contenu de l'objet grille a 
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
	 *            ordonnée de la case
	 * @return valeur de la case
	 * @throws CaseInexistanteException crée une exception si la case n'existe pas
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
	 *            ordonnée de la case
	 * @param v
	 *            valeur de la case
	 * @throws CaseInexistanteException crée une exception si la case n'existe pas
	 */

	public void setCase(int x, int y, int v) throws CaseInexistanteException
	{
		if ((x < 0) || (x > X_MAX) || (y < 0) || (y > Y_MAX))
			throw new CaseInexistanteException();
		else
			this.grille[x][y] = v;
	}

}
