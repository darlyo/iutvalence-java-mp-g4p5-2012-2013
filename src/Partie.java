import java.util.Scanner;

/**
 * 
 * @author mainguene kevin 		marie joris
 *	lancement d'une partie 
 */
public class Partie
{
	/**
	 * T_MAX est le nombre maximal de tour qu'un partie peut duréé
	 */
	private final static int T_MAX = 21; 
	
	/**
	 * nombre de tour jouer
	 */
	private int tour;
	
	/**
	 * grille de jeux
	 */
	private Grille grille;
	
	/**
	 * Joueur 1 d'une partie
	 */
	private int j1;
	
	/**
	 * Joueur 2 d'une partie
	 */
	private int j2;
	
	/**
	 * Crée un partie
	 * @param j1 : Joueur 1
	 * @param j2 : Joueur 2
	 */
	public Partie(Joueur j1, Joueur j2)
	{
		this.j1 = j1.getValeur();
		this.j2 = j2.getValeur();
		this.tour = 0;
		this.grille = new Grille();
	}
	
	/**
	 * lance une partie
	 * @return le vainqueur
	 */
	public int lancer()
	{
		int numColone;
		int numLigne;
		Scanner sc = new Scanner(System.in);
		
		this.grille.affiche();
		while ((this.tour != T_MAX) && (this.grille.Check()== Grille.CONTINU))
		{
			do
			{
				System.out.println("Tour du Joueur 1, quel colone ?");
				do
					{
						numColone = sc.nextInt()-1;
					}while ((numColone <0) || (numColone >6));
				numLigne = this.grille.Joue(this.j1, numColone);
			}while(numLigne == Grille.PLEIN);
			
			this.grille.affiche();
			
			if (this.grille.Check() == 0)
			{
				do
				{
					System.out.println("Tour du Joueur 2, quel colone ?");
					do
					{
						numColone = sc.nextInt()-1;
					}while ((numColone <0) || (numColone >6));
				}while((this.grille.Joue(this.j2, numColone)) == Grille.PLEIN);
				this.grille.affiche();
			}
			
			this.tour++; // tour suivant
		}
		
		return this.grille.Check();
	}
}
