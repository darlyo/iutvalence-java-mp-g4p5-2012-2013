package fr.iutvalence.java.projets.puissance4;

import java.util.Scanner;

// FIXME corriger le commentaire : ouvrir un bescherelle ou trouver dans le dictionnaire le verbe "géstionner" (bon courage !) ;-)
/**
 * lance une partie et la géstionnera 
 * @author mainguene kevin 		marie joris 
 */
public class Partie
{
	//************** VARIABLES ******************
	
	/**
	 * T_MAX est le nombre maximal de tours qu'une partie peut durer
	 */
	private final static int T_MAX = 21; 
	
	/**
	 * Informe qu'il n'y a pas encore de gagnant, permet de continuer la partie.
	 */
	public static final int CONTINU = 0;
	
	/**
	 * nombre de tours joués
	 */
	
	// FIXME (FIXED) renommer l'attribut (il peut y avoir plusieurs tours ;-) )
	private int nbTour;
	
	/**
	 * grille de jeu
	 */
	private Grille grille;
	
	
	/**
	 * valeur du pion identifiant le Joueur 1 d'une partie
	 */
	private int j1 ;
	
	/**
	 * valeur du pion identifiant le Joueur 2 d'une partie
	 */
	private int j2 ;
	
	/**
	 * Nom du joueur 1
	 */
	private String player1;
	
	/**
	 * Nom du joueur 2
	 */
	private String player2;
	
	//************* CONSTRUCTEUR ****************
	
	/**
	 * Créer une partie vierge entre 2 joueurs 
	 * @param player1 : nom du joueur 1
	 * @param player2 : nom du joueur 2
	 */
	public Partie(String player1, String player2)
	{
		if (player1 != "")		
			this.player1 = player1;
		else 
			this.player1 = "Joueur 1";
		if (player2 != "")
			this.player2 = player2;
		else 
			this.player2 = "Joueur 2";
		this.j1 = 1;
		this.j2 = 2;
		this.nbTour = 0;
		this.grille = new Grille();
	}
	
	//****************** METHODE ************************
	
	// FIXME se rendre indépendant de l'interaction avec les joueurs
	// FIXME se rendre indépendant de l'affichage console
	/**
	 * lance une partie avec au maximun 21 tour
	 * le joueur 1 commence il pose son jeton, on affiche la grille et on regarde si il a gagner 
	 * apres de al meme maniere le joueur 2 joue. 
	 * @return le vainqueur
	 */
	public int lancer()
	{
		int numColone;
		int numLigne;
		Scanner sc = new Scanner(System.in);
		
		this.grille.toString();
		while ((this.nbTour != T_MAX) && (this.checkVictoire()== CONTINU))
		{
			do
			{
				System.out.println("Tour de "+ this.player1+" , quel colone ?");
				do
				{
					numColone = sc.nextInt()-1;
				}while ((numColone <0) || (numColone >6));
				numLigne = this.grille.Joue(this.j1, numColone);
			}while(numLigne == Grille.PLEIN);
			
			this.grille.toString();
			
			if (this.checkVictoire() == 0)
			{
				do
				{
					System.out.println("Tour de "+this.player2+" , quel colone ?");
					do
					{
						numColone = sc.nextInt()-1;
					}while ((numColone <0) || (numColone >6));
				}while((this.grille.Joue(this.j2, numColone)) == Grille.PLEIN);
				this.grille.toString();
			}
			
			this.nbTour++; // tour suivant
		}
		
		return this.checkVictoire();
	}
	
	/**
	 * vérification de la grille pour voir si le dernier joueur a gagner ou non
	 * @return le vainqueur ou 0 pour continuer la partie 
	 */
	public int checkVictoire()
	{
		int x, y;	//variable pour se déplacer dans le tableau ordonne et abscisse
		int i;			
		int couleur;	//variable de vérification et résultat (joueur gagnant)
		
		for (x=0;x <7;x++)		//check des colonnes de gauche a droite
		{
			if ((this.grille.grille[x][2] != 0) && (this.grille.grille[x][2] == this.grille.grille[x][3]))
				{
					couleur = this.grille.grille[x][2];
					if (couleur == this.grille.grille[x][4])
					{
						if ((couleur == this.grille.grille[x][5]) || (couleur == this.grille.grille[x][1]))
							return couleur;
					}
					else 
						if ((couleur == this.grille.grille[x][1])&&(couleur == this.grille.grille[x][0]))
							return couleur;
				}	
		}
		
		for (y=0; y<6; y++) 	//check des lignes de bas en haut
		{
			if (this.grille.grille[3][y] != 0)
			{
				couleur = this.grille.grille[3][y];
				if ((couleur == this.grille.grille[2][y])&&(couleur == this.grille.grille[1][y])&&(couleur == this.grille.grille[0][y]))
					return couleur;
				if ((couleur == this.grille.grille[2][y])&&(couleur == this.grille.grille[1][y])&&(couleur == this.grille.grille[4][y]))
					return couleur;
				if ((couleur == this.grille.grille[2][y])&&(couleur == this.grille.grille[4][y])&&(couleur == this.grille.grille[5][y]))
					return couleur;
				if ((couleur == this.grille.grille[4][y])&&(couleur == this.grille.grille[5][y])&&(couleur == this.grille.grille[6][y]))
					return couleur;
			}
		}
		
		for(x=0; x<4;x++)	// check diagonale de gauche a droite
		{
			for(i=0; i<3;i++)
			{
				couleur = this.grille.grille[x][0];
				if((couleur == this.grille.grille[x][i]) && (couleur == this.grille.grille[x+1][1+i]) && (couleur == this.grille.grille[x+2][2+i]) && (couleur == this.grille.grille[x+3][3+i]))
					return couleur;
			}
		}
		
		for(x=6; x>3;x++)	// check diagonale de droite a gauche
		{
			for(i=0; i<3;i++)
			{
				couleur = this.grille.grille[x][0];
				if((couleur == this.grille.grille[x][i]) && (couleur == this.grille.grille[x-1][1+i]) && (couleur == this.grille.grille[x-2][2+i]) && (couleur == this.grille.grille[x-3][3+i]))
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
	
}
