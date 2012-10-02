// FIXME déplacer dans un paquetage

import java.util.Scanner;

// FIXME corriger le commentaire
/**
 * 
 * @author mainguene kevin 		marie joris
 *	lancement d'une partie 
 */
public class Partie
{
	/**
	 * T_MAX est le nombre maximal de tours qu'une partie peut durer
	 */
	private final static int T_MAX = 21; 
	
	// FIXME renommer l'attribut
	/**
	 * nombre de tours joués
	 */
	private int tour;
	
	/**
	 * grille de jeu
	 */
	private Grille grille;
	
	
	// FIXME réfléchir au type de l'attribut
	/**
	 * Joueur 1 d'une partie
	 */
	private int j1;
	
	// FIXME réfléchir au type de l'attribut
	/**
	 * Joueur 2 d'une partie
	 */
	private int j2;
	
	
	// FIXME détailler le commentaire
	/**
	 * Créer une partie
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
	
	// FIXME détailler le commentaire
	// FIXME se rendre indépendant de l'intercation avec les joueurs
	// FIXME se rendre indépendant de l'affichage console
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
