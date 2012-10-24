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
	public int[][] grille;

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

	// FIXME remplacer le type de retour par void puisqu'une exception est d�j� soulev�e en cas d'erreur (et modifier la documentation)
	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * 
	 * @param joueur
	 *            : 1 ou 2 en fonction du joueur qui joue
	 * @param numColone
	 *            : numero de la colonne ou on ajoute un jeton
	 * @return numero de la case libre ou PLEIN si la colone est pleine.
	 * @throws ColonnePleineException
	 *             traite le cas ou la colonne est pleine
	 */
	// FIXME soulever une autre exception si la colonne n'existe pas
	public int Joue(int joueur, int numColone) throws ColonnePleineException
	{
		int i;
		for (i = 0; i < Y_MAX; i++)
		{
			if (this.grille[numColone][i] == VIDE)
			{
				this.grille[numColone][i] = joueur;
				// FIXME return au lieu de break;
				break;
			}
		}
		if (i == Y_MAX)
			throw new ColonnePleineException();
		return i;
	}

	// FIXME (NOT FIXED) corriger le commentaire : indiquer le contenu de la cha�ne retourn�e
	
	 // red�finition de la m�thode toString pour afficher le contenu de l'objet grille a l'aide d'une chaine
	 
	/**
	 * @see java.lang.Object#toString()
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
				chaine = chaine + " " + this.grille[x][y] + " |";
			}
			chaine = chaine + "\n|---|---|---|---|---|---|---|\n";
		}
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
	 */
	// FIXME soulever une exception si la case n'existe pas 
	public int getCase(int x, int y)
	{
		return this.grille[x][y];
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
	 */
	// FIXME (FIXED) ajouter une m�thode pour modifier le contenu d'une case de la grille

	public void setCase(int x, int y, int v)
	{
		this.grille[x][y] = v;
	}

}
