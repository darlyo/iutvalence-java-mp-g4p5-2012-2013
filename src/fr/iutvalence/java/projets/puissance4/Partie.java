package fr.iutvalence.java.projets.puissance4;

// FIXME  FIXED !!! corriger le commentaire : ouvrir un bescherelle ou trouver dans le dictionnaire le verbe "géstionner" (bon courage !) ;-)
/**
 * lance une partie et la gère
 * 
 * @author mainguene kevin marie joris
 */
public class Partie
{
	// ************** VARIABLES ******************

	/**
	 * PLEIN boolean qui permet d'indiquer si la colone ou on vient de jouer est pleine
	 */
	private final static boolean PLEIN = false;
	
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

	
	// FIXME se rendre indépendant de l'affichage console
	/**
	 * lance une partie avec au maximun 21 tour le joueur 1 commence il pose son jeton, on affiche la grille et on
	 * regarde si il a gagner apres de al meme maniere le joueur 2 joue.
	 * 
	 * @return le vainqueur
	 */
	public int lancer()
	{
		
		this.grille.toString();
		while ((this.nbTours != T_MAX) && (this.checkVictoire(NBPIONS) == CONTINU))
		{
			
				// FIXME se rendre indépendant de l'interaction avec les joueurs (à discuter !)
				// FIXME  ( FIXED ) commencer par faire une implémentation aléatoire du joueur
				
			while (true)
			{
				//numColone = new Saisie(this.player1).getC();
				int numColone = (int)(Math.round(Math.random()*6));
				try
				{
					if (this.nbTours % 2 == 0)
						this.grille.joue(this.j1, (int) (numColone));
					if (T_MAX % 2 == 1)
						this.grille.joue(this.j2, (int) (numColone));
				}
				catch (ColonnePleineException e)
				{
					System.out.println("La colonne est pleine, choisissez une autre colonne.");
					continue;
				}
				catch (ColonneInexistanteException e)
				{
					// le test a été effectué avant
				}	
			}
			
			System.out.println(this.grille);

			if (this.checkVictoire(NBPIONS) == 0)
			{
				do
				{
					//numColone = new Saisie(this.player2).getC();
					numColone = (int)(Math.round(Math.random()*6));
					try
					{
						this.grille.joue(this.j2, numColone);
					}
					catch (ColonnePleineException e)
					{
						System.out.println("La colonne est pleine choisissez une autre colonne.");
						saisieOk = PLEIN;
					}
					catch (ColonneInexistanteException e)
					{
						System.out.println("La colonne n'existe pas, choisissez une autre colonne.");
						
						saisieOk = ERRORCOLONNE;
					};	
				}
				while (!saisieOk);
				System.out.println(this.grille);
			}

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
		return this.checkVictoire(NBPIONS);
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

		for (x = 0; x < Grille.X_MAX ; x++)		// check des colonnes de gauche a droite
		{
			for(y = 0; y < (Grille.Y_MAX - nbPions +1) ; y++)
			{
				if (this.grille.grille[x][y] != Grille.VIDE)
				{
					i = 0;
					couleur = this.grille.grille[x][y];
					while((i < nbPions-1) && (this.grille.grille[x][y+i] == couleur) )
					{
						i++;
					}
					if ((i == nbPions-1) && (this.grille.grille[x][y+i] == couleur))
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
				if (this.grille.grille[x][y] != Grille.VIDE)
				{
					i = 0;
					couleur = this.grille.grille[x][y];
					while((i < nbPions-1) && (this.grille.grille[x+i][y] == couleur) )
					{
						i++;
					}
					if ((i == nbPions-1) && (this.grille.grille[x+i][y] == couleur))
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
				if (this.grille.grille[x][y] != Grille.VIDE)
				{
					i = 0;
					couleur = this.grille.grille[x][y];
					while((i < nbPions-1) && (this.grille.grille[x+i][y+i] == couleur) )
					{
						i++;
					}
					if ((i == nbPions-1) && (this.grille.grille[x+i][y+i] == couleur))
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
				if (this.grille.grille[x][y] != Grille.VIDE)
				{
					i = 0;
					couleur = this.grille.grille[x][y];
					while((i < nbPions-1) && (this.grille.grille[x-i][y+i] == couleur) )
					{
						i++;
					}
					if ((i == nbPions-1) && (this.grille.grille[x-i][y+i] == couleur))
					{
						return couleur;
					}
				}
			}
		}		

		return CONTINU;
	}
	/**
	 * @param x l'abscisse du pions a checker
	 * @param y l'ordonnée du pion a checker
	 * @param nbPions le nombre de pions a aligner pour gagner
	 * @return le gagnant ou 0  pour continuer ou -1 si le case n'existe pas ( plus ou moins impossible )
	 */
	public int checkvictoryv2(int x, int y, int nbPions) 
	{   
		int couleur;
	
		try{ 
			couleur = Grille.getCase(x,y);  // Voir interaction avec getCase ( static )
		 }
		catch (CaseInexistanteException e)
		{
			return -1; // la case n'existe pas 
		}
		
		if ((x+3 < Grille.X_MAX) & (Grille.getCase(x+1,y) == couleur) & (Grille.getCase(x+2,y) == couleur) & (Grille.getCase(x+3,y) == couleur))
			return couleur;
		if ((x-1 >-1) & (x+2 < Grille.X_MAX) &(Grille.getCase(x-1,y) == couleur) & (Grille.getCase(x+1,y) == couleur) & (Grille.getCase(x+2,y) == couleur))
			return couleur;
		if ((x-2 >-1) & (x+1 < Grille.X_MAX) &(Grille.getCase(x-2,y) == couleur) & (Grille.getCase(x-1,y) == couleur) & (Grille.getCase(x+1,y) == couleur))
			return couleur;
		if ((x-3 >-1) &(Grille.getCase(x-3,y) == couleur) & (Grille.getCase(x-2,y) == couleur) & (Grille.getCase(x-1,y) == couleur))
			return couleur; //ligne horizontale check
		
		if ((y < Grille.Y_MAX) & (Grille.getCase(x,y+1) == couleur) & (Grille.getCase(x,y+2) == couleur) & (Grille.getCase(x,y+3) == couleur))
			return couleur;
		if ((y-1 >-1) & (y+2 < Grille.Y_MAX) &(Grille.getCase(x,y-1) == couleur) &  (Grille.getCase(x,y+1) == couleur) & (Grille.getCase(x,y+2) == couleur))
			return couleur;
		if ((y-1 >-2) & (y+1 < Grille.Y_MAX) &(Grille.getCase(x,y-2) == couleur) &  (Grille.getCase(x,y-1) == couleur) & (Grille.getCase(x,y+1) == couleur))
			return couleur;
		if ((y-1 >-3) &(Grille.getCase(x,y-3) == couleur) &  (Grille.getCase(x,y-2) == couleur) & (Grille.getCase(x,y-1) == couleur))
			return couleur; //ligne verticale check
		
		if ((x+3 < Grille.X_MAX) & (y+3 < Grille.Y_MAX) & (Grille.getCase(x+1,y+1)== couleur) & (Grille.getCase(x+2,y+2)== couleur) & (Grille.getCase(x+3,y+3)== couleur))
			return couleur;
		if ((x+2 < Grille.X_MAX) & (y+2 < Grille.Y_MAX) & (x-1 > -1) & (y-1 >-1) & (Grille.getCase(x-1,y-1)== couleur) & (Grille.getCase(x+1,y+1)== couleur) & (Grille.getCase(x+2,y+2)== couleur))
			return couleur;
		if ((x+1 < Grille.X_MAX) & (y+1 < Grille.Y_MAX) & (x-2 > -1) & (y-2 >-1) & (Grille.getCase(x-2,y-2)== couleur) & (Grille.getCase(x-1,y-1)== couleur) & (Grille.getCase(x+1,y+1)== couleur))
			return couleur;
		if ((x-3 > -1) & (y-3 >-1) & (Grille.getCase(x-3,y-3)== couleur) & (Grille.getCase(x-2,y-2)== couleur) & (Grille.getCase(x-1,y-1)== couleur))
			return couleur; // Diagonnale gauche droite check
		
		if ((x-3 > -1) & (y+3 <Grille.Y_MAX) & (this.grille.grille[x-3][y+3] == couleur) & (this.grille.grille[x-2][y+2] == couleur) & (this.grille.grille[x-1][y+1] == couleur))
			return couleur;
		
		
		
		
		
		
		return 0;
		
	}
}


