package fr.iutvalence.java.projets.puissance4;

// FIXME (NOT FIXED !)(FIXED) corriger le commentaire (juste indiquer à quoi sert la classe, éventuellement comment est placé le repère (numéros de lignes et colonnes)
/**
 * definition d'une grille de jeu avec le point d'origine en bas a gauche
 * 
 * @author mainguene kevin marie joris
 */
public class Grille
{
	// FIXME (NOT FIXED!)(FIXED) corriger le commentaire : ne pas indiquer par quelle méthode la constante est utilisée
	// mais juste quel sens elle véhicule
	/**
	 * constante envoyé indicant que la colone joué est pleine
	 */
	public static final int PLEIN = -1;

	/**
	 * Constante représentant un contenu "vide" pour une case de la grille
	 */
	public static final int VIDE = 0;

	// FIXME (FIXED) regrouper les définitions des constantes avant celles des attributs
	/**
	 * largeur de la grille
	 */
	// FIXME (FIXED) renommer la constante
	public static final int X_MAX = 7;

	// FIXME (FIXED) préciser
	/**
	 * hauteur de la grille
	 */
	// FIXME (FIXED) renommer la constante
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
		System.out.println("1");
	}

	// FIXME (FIXED) gérer les cas d'erreur avec des exceptions
	/**
	 * Ajoute un jeton dans la colone donner en parametre par le joueur et renvoie PLEIN si on peut pas jouer
	 * 
	 * @param joueur
	 *            : 1 ou 2 en fonvtion du joueur qui joue
	 * @param numColone
	 *            : numero de la colonne ou on ajoute un jeton
	 * @return numero de la case libre ou PLEIN si la colone est pleine.
	 * @throws ColonnePleineEx
	 *             traite le cas ou la colonne est pleine
	 */
	public int Joue(int joueur, int numColone) throws ColonnePleineEx
	{
		int i;

		for (i = 0; i < Y_MAX; i++)
		{
			if (this.grille[numColone][i] == VIDE)
			{
				this.grille[numColone][i] = joueur;
				break;
			}
		}
		if (i == Y_MAX)
			throw new ColonnePleineEx();
		return i;
	}

	// FIXME (NOT FIXED) corriger le commentaire : indiquer le contenu de la chaîne retournée
	/**
	 * redéfinition de la méthode toString pour afficher le contenu de l'objet grille a l'aide d'une chaine
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
	 * donne le valeur d'une case
	 * 
	 * @param x
	 *            abscisse de la case
	 * @param y
	 *            ordonnée de la case
	 * @return valeur de la case
	 */
	// FIXME (FIXED) ajouter une méthode pour obtenir le contenu d'une case de la grille
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
	 *            ordonnée de la case
	 * @param v
	 *            valeur de la case
	 */
	// FIXME (FIXED) ajouter une méthode pour modifier le contenu d'une case de la grille

	public void setCase(int x, int y, int v)
	{
		this.grille[x][y] = v;
	}

}
