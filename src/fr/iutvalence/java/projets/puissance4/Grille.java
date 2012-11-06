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
	public int[][] grille;

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

	// FIXME (FIXED) remplacer le type de retour par void puisqu'une exception est déjà soulevée en cas d'erreur (et modifier la documentation)
	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * 
	 * @param joueur
	 *            : 1 ou 2 en fonction du joueur qui joue
	 * @param numColone
	 *            : numero de la colonne ou on ajoute un jeton
	 * @throws ColonnePleineException
	 *             traite le cas ou la colonne est pleine
	 * @throws ColonneNotExisteException 
	 * 				traite le cas ou la colone n'existe pas
	 */
	// FIXME  (FIXED) soulever une autre exception si la colonne n'existe pas
	public void joue(int joueur, int numColone) throws ColonnePleineException, ColonneNotExisteException
	{
		int i = 0;
		if ((numColone < 0 ) || ( numColone > 6))
				throw new ColonneNotExisteException();

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
	}

	// FIXME (FIXED) corriger le commentaire : indiquer le contenu de la chaîne retournée
	
	 // redéfinition de la méthode toString pour afficher le contenu de l'objet grille a l'aide d'une chaine

	 
	/**
	 * @see java.lang.Object#toString()
	 * redéfinition de la méthode toString pour afficher le contenu de l'objet grille a 
	 * l'aide d'une chaine sous la forme d'un tableau
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
				if (this.grille[x][y] == 1)
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
	 * @throws CaseNotExisteException crée une exception si la case n'existe pas
	 */
	// FIXME (FIXED) soulever une exception si la case n'existe pas 
	public int getCase(int x, int y) throws CaseNotExisteException
	{
		if ((x < 0) || (x > X_MAX) || (y < 0) || (y > Y_MAX))
			throw new CaseNotExisteException();
		else
			return this.grille[x][y];
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
	 * @throws CaseNotExisteException crée une exception si la case n'existe pas
	 */
	// FIXME (FIXED) ajouter une méthode pour modifier le contenu d'une case de la grille

	public void setCase(int x, int y, int v) throws CaseNotExisteException
	{
		if ((x < 0) || (x > X_MAX) || (y < 0) || (y > Y_MAX))
			throw new CaseNotExisteException();
		else
			this.grille[x][y] = v;
	}

}
