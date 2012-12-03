package fr.iutvalence.java.projets.puissance4.nonmvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonneInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonnePleineException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * lance une partie et la gère
 * 
 * @author mainguene kevin marie joris
 */
public class Partie
{
	// ************** VARIABLES ******************
	
	/**
	 * T_MAX est le nombre maximal de tours qu'une partie peut durer
	 */
	private final static int T_MAX = 42;

	/**
	 * Informe qu'il n'y a pas encore de gagnant, permet de continuer la partie.
	 */
	public static final int CONTINU = 0;
	
	
	/**
	 *  NBPIONS le nombre de pions a alligner pour gagner
	 */
	public final static int NBPIONS = 4;

	/**
	 * nombre de tours joués
	 */
	private int nbTours;

	/**
	 * grille de jeu
	 */
	private Grille grille;

	/**
	 * valeur du pion identifiant le Joueur 1 d'une partie
	 */
	private int j1;

	/**
	 * valeur du pion identifiant le Joueur 2 d'une partie
	 */
	private int j2;

	/**
	 * Nom du joueur 1
	 */
	private String player1;

	/**
	 * Nom du joueur 2
	 */
	private String player2;

	
	/*
	  String[] noms
	  int joueurCourant = 0;
	 */
	

	// ************* CONSTRUCTEUR ****************

	/**
	 * Créer une partie vierge entre 2 joueurs
	 * 
	 * @param player1
	 *            : nom du joueur 1
	 * @param player2
	 *            : nom du joueur 2
	 */
	public Partie(String player1, String player2)
	{  
		// FIXME ne pas utiliser == ou != pour comparer les chaînes de caractères, ça ne marche pas !
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
		this.nbTours = 0;
		this.grille = new Grille();
	}

	// ****************** METHODE ************************

	

	/**
	 * lance une partie avec au maximun 21 tour le joueur 1 commence il pose son jeton, on affiche la grille et on
	 * regarde si il a gagner apres de al meme maniere le joueur 2 joue.
	 * 
	 * @return le vainqueur
	 */
	public int lancer()
	{
		int resultat;
		int numColone;
		System.out.println(this.grille);
		while ((this.nbTours != T_MAX) && (this.checkVictoire(NBPIONS) == CONTINU))
		{

			//numColone = new Saisie(this.player1).getC();
			numColone = (int)(Math.round(Math.random()*6));
			try
			{
				if (this.nbTours % 2 == 0) //tour pair le joueur 1 joue
				{
					this.grille.joue(this.j1, (int) (numColone));
				}
				else	// tour impaire le joueur 2 joue
				{
					this.grille.joue(this.j2, (int) (numColone));
				}
			}
			catch (ColonnePleineException e)
			{
				System.out.println("La colonne est pleine, choisissez une autre colonne.");
				continue;
			}
			catch (ColonneInexistanteException e)
			{
				// le test a été effectué avant
				continue;					
			}
		
			System.out.println(this.grille);
			this.nbTours++; // tour suivant
		}
		
		resultat = this.checkVictoire(NBPIONS);
		if ( resultat == 1)
		{
			System.out.println("Le joueur 1 a gagné");
		}
		else if (resultat == 2)
		{
			System.out.println("Le joueur 2 a gagné");
		}
		else
			System.out.println("Match nul");
		return resultat;
	}


	/**
	 * vérification de la grille pour voir si le dernier joueur a gagner ou non
	 * @param nbPions le nombre de pions necessaire pour gagner
	 * @return le vainqueur ou 0 pour continuer la partie
	 */
	public int checkVictoire(int nbPions)
	{
		int x, y;	// variable pour se déplacer dans le tableau ordonne et abscisse
		int i;
		int couleur;	// variable de vérification et résultat (joueur gagnant)

		try
		{
			for (x = 0; x < Grille.X_MAX ; x++)		// check des colonnes de gauche a droite
			{
				for(y = 0; y < (Grille.Y_MAX - nbPions +1) ; y++)
				{
					if (this.grille.getCase(x, y)!= Grille.VIDE)
					{
						i = 0;
						couleur = this.grille.getCase(x, y);
						while((i < nbPions-1) && (this.grille.getCase(x, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.grille.getCase(x, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}

			for (y = 0; y < Grille.Y_MAX ; y++) 	// check des lignes de bas en haut
			{
				for(x = 0; x < (Grille.X_MAX - nbPions +1) ; x++)
				{
					if (this.grille.getCase(x, y)!= Grille.VIDE)
					{
						i = 0;
						couleur = this.grille.getCase(x, y);
						while((i < nbPions-1) && (this.grille.getCase(x+i, y)== couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.grille.getCase(x+i, y) == couleur))
						{
							return couleur;
						}
					}
				}
			}

			for (y = 0; y < (Grille.Y_MAX - nbPions +1) ; y++) 	// check diagonale de gauche a droite
			{
				for(x = 0; x < (Grille.X_MAX - nbPions +1) ; x++)
				{
					if (this.grille.getCase(x, y) != Grille.VIDE)
					{
						i = 0;
						couleur = this.grille.getCase(x, y);
						while((i < nbPions-1) && (this.grille.getCase(x+i, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.grille.getCase(x+i, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}
			
			for (y = 0; y < (Grille.Y_MAX - nbPions +1) ; y++) 	// check diagonale de droite a gauche
			{
				for(x = Grille.X_MAX-1 ; x > (nbPions -1) ; x--)
				{
					if (this.grille.getCase(x, y) != Grille.VIDE)
					{
						i = 0;
						couleur = this.grille.getCase(x, y);
						while((i < nbPions-1) && (this.grille.getCase(x-i, y) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (this.grille.getCase(x-i, y+i) == couleur))
						{
							return couleur;
						}
					}
				}
			}
		}
		catch (CaseInexistanteException e)
		{
			// case correcte car controlé avant
			//on ignore donc l'erreur
		}		

		return CONTINU;
	}
	/**
	 * @param x l'abscisse du pions a checker
	 * @param y l'ordonnée du pion a checker
	 * @param nbPions le nombre de pions a aligner pour gagner
	 * @return le gagnant ou 0  pour continuer ou -1 si le case n'existe pas ( plus ou moins impossible )
	 */
	public int checkvictoryV2(int x, int y, int nbPions) 
	{   
		int couleur;
		
		try
		{
			couleur = this.grille.getCase(x,y); 

			if ((x+3 < Grille.X_MAX) & (this.grille.getCase(x+1,y) == couleur) & (this.grille.getCase(x+2,y) == couleur) & (this.grille.getCase(x+3,y) == couleur))
				return couleur;
			if ((x-1 >-1) & (x+2 < Grille.X_MAX) &(this.grille.getCase(x-1,y) == couleur) & (this.grille.getCase(x+1,y) == couleur) & (this.grille.getCase(x+2,y) == couleur))
				return couleur;
			if ((x-2 >-1) & (x+1 < Grille.X_MAX) &(this.grille.getCase(x-2,y) == couleur) & (this.grille.getCase(x-1,y) == couleur) & (this.grille.getCase(x+1,y) == couleur))
				return couleur;
			if ((x-3 >-1) &(this.grille.getCase(x-3,y) == couleur) & (this.grille.getCase(x-2,y) == couleur) & (this.grille.getCase(x-1,y) == couleur))
				return couleur; //ligne horizontale check
			
			if ((y < Grille.Y_MAX) & (this.grille.getCase(x,y+1) == couleur) & (this.grille.getCase(x,y+2) == couleur) & (this.grille.getCase(x,y+3) == couleur))
				return couleur;
			if ((y-1 >-1) & (y+2 < Grille.Y_MAX) &(this.grille.getCase(x,y-1) == couleur) &  (this.grille.getCase(x,y+1) == couleur) & (this.grille.getCase(x,y+2) == couleur))
				return couleur;
			if ((y-1 >-2) & (y+1 < Grille.Y_MAX) &(this.grille.getCase(x,y-2) == couleur) &  (this.grille.getCase(x,y-1) == couleur) & (this.grille.getCase(x,y+1) == couleur))
				return couleur;
			if ((y-1 >-3) &(this.grille.getCase(x,y-3) == couleur) &  (this.grille.getCase(x,y-2) == couleur) & (this.grille.getCase(x,y-1) == couleur))
				return couleur; //ligne verticale check
			
			if ((x+3 < Grille.X_MAX) & (y+3 < Grille.Y_MAX) & (this.grille.getCase(x+1,y+1) == couleur) & (this.grille.getCase(x+2,y+2) == couleur) & (this.grille.getCase(x+3,y+3) == couleur))
				return couleur;
			if ((x+2 < Grille.X_MAX) & (y+2 < Grille.Y_MAX) & (x-1 > -1) & (y-1 >-1) & (this.grille.getCase(x-1,y-1)== couleur) & (this.grille.getCase(x+1,y+1)== couleur) & (this.grille.getCase(x+2,y+2)== couleur))
				return couleur;
			if ((x+1 < Grille.X_MAX) & (y+1 < Grille.Y_MAX) & (x-2 > -1) & (y-2 >-1) & (this.grille.getCase(x-2,y-2)== couleur) & (this.grille.getCase(x-1,y-1)== couleur) & (this.grille.getCase(x+1,y+1)== couleur))
				return couleur;
			if ((x-3 > -1) & (y-3 >-1) & (this.grille.getCase(x-3,y-3)== couleur) & (this.grille.getCase(x-2,y-2)== couleur) & (this.grille.getCase(x-1,y-1)== couleur))
				return couleur; // Diagonnale gauche droite check
			
			if ((x-3 > -1) & (y+3 <Grille.Y_MAX) & (this.grille.getCase(x-3,y+3) == couleur) & (this.grille.getCase(x-2,y+2) == couleur) & (this.grille.getCase(x-1,y+1) == couleur))
				return couleur;
			if ((x-2 > -1) & (y-1 >-1) & (y+2 <Grille.Y_MAX) & (x+1 < Grille.X_MAX) & (this.grille.getCase(x-2,y+2) == couleur) & (this.grille.getCase(x-1,y+1) == couleur) & (this.grille.getCase(x+1,y-1) == couleur))
				return couleur;
			if ((x-1 > -1) & (y-2 >-1) & (y+1 <Grille.Y_MAX) & (x+2 < Grille.X_MAX) & (this.grille.getCase(x-1,y+1) == couleur) & (this.grille.getCase(x+1,y-1) == couleur) & (this.grille.getCase(x+2,y-2) == couleur))
				return couleur;
			if ( (y-2 >-1) & (x+2 < Grille.X_MAX) & (this.grille.getCase(x+1,y-1)== couleur) & (this.grille.getCase(x+2,y-2) == couleur) & (this.grille.getCase(x+3,y-3) == couleur))
				return couleur; // diagonale droite gauche check
		}
		catch (CaseInexistanteException e)
		{
			// case correcte car controlé avant
			//on ignore donc l'erreur
		}
		
		
		return 0;
		
	}
}


