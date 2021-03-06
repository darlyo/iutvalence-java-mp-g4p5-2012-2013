package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonneInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonnePleineException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * lance une partie et la g�re
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
	 *  NBPIONS le nombre de pions a alligner pour gagner
	 */
	public final static int NBPIONS = 4;

	/**
	 * nombre de tours jou�s
	 */
	private int nbTours;

	/**
	 * grille de jeu
	 */
	public Grille grille;

	/**
	 * valeur du pion identifiant le Joueur 1 d'une partie
	 */
	private int j1;

	/**
	 * valeur du pion identifiant le Joueur 2 d'une partie
	 */
	private int j2;

	/**
	 * Le joueur 1
	 */
	private Joueur player1;
	
	/**
	 * le joueur 2
	 */
	private Joueur player2;

	/*
	  String[] noms
	  int joueurCourant = 0;
	 */
	

	// ************* CONSTRUCTEUR ****************

	/**
	 * Cr�er une partie vierge entre 2 joueurs
	 * @param player1 : nom du joueur 1
	 * @param player2 : nom du joueur 2
	 */
	public Partie(Joueur player1, Joueur player2)
	{
		this.j1 = 1;
		this.j2 = -1;
		this.player1 = player1;
		this.player2 = player2;
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
		int ligne;
		int tour;
		this.player1.getVue().affichegrille(this.grille);
		this.player2.getVue().affichegrille(this.grille);
		InterfaceVue vue1, vue2;
		vue1 = this.player1.getVue();
		vue2 = this.player2.getVue();
		while ((this.nbTours != T_MAX) && (this.grille.checkVictoire(NBPIONS) == Grille.CONTINU))
		{
			tour = this.nbTours % 2;
			try
			{
				if (tour == 0) //tour pair le joueur 1 joue
				{
					this.player1.getVue().message("Tour de "+ this.player1.getName());
		
					numColone = this.player1.getCtrl().saisie(Grille.X_MAX, this.grille, this.j1);
					System.out.println("LLLLLLLLLLLLLL");
					ligne = this.grille.joue(this.j1, (int) (numColone));
				}
				else	// tour impaire le joueur 2 joue
				{
					this.player2.getVue().message("Tour de "+ this.player2.getName());
					numColone = this.player2.getCtrl().saisie(Grille.X_MAX, this.grille, this.j2);
					System.out.println("LLLLLLLLLLLLLL");
					ligne = this.grille.joue(this.j2, (int) (numColone));
				}
			}
			catch (ColonnePleineException e)
			{
				if (tour == 0) //tour pair le joueur 1 joue
				{
					this.player1.getVue().message("Colonne pleine");
				}
				else	// tour impaire le joueur 2 joue
				{
					this.player2.getVue().message("Colonne pleine");
				}
				continue;
			}
			catch (ColonneInexistanteException e)
			{
				// le test a �t� effectu� avant
				continue;					
			}
		    
			try
			{
				if (vue1 == vue2)
					this.player1.getVue().ajoutePion(ligne, numColone, (tour+1), this.grille);
				else	
				{		
					this.player1.getVue().ajoutePion(ligne, numColone, (tour+1), this.grille);
					this.player2.getVue().ajoutePion(ligne, numColone, (tour+1), this.grille);
				}
			}
			catch (CaseInexistanteException e)
			{
				// le test a �t� effectu� avant
				continue;
			}
			this.nbTours++; // tour suivant
		}
		
		resultat = this.grille.checkVictoire(NBPIONS);
	
	
			if ( resultat == 1)
			{
				this.player1.getVue().message("Victoire de "+this.player1.getName());
				this.player2.getVue().message("Victoire de "+ this.player1.getName());
			}
			else if (resultat == -1)
			{
				this.player1.getVue().message("Victoire de " + this.player2.getName());
				this.player2.getVue().message("Victoire de " + this.player2.getName());
			}
			else
				if (vue1 == vue2)
					this.player1.getVue().message("Match nul");
				else 
				{
					this.player1.getVue().message("Match nul");
					this.player2.getVue().message("Match nul");
				}
		return resultat;
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
			couleur = this.grille.getCase(x,y);   
			if ((x+3 < Grille.X_MAX) && (this.grille.getCase(x+1,y) == couleur) && (this.grille.getCase(x+2,y) == couleur) && (this.grille.getCase(x+3,y) == couleur))
				return couleur;
			if ((x-1 >-1) && (x+2 < Grille.X_MAX) && (this.grille.getCase(x-1,y) == couleur) && (this.grille.getCase(x+1,y) == couleur) && (this.grille.getCase(x+2,y) == couleur))
				return couleur;
			if ((x-2 >-1) && (x+1 < Grille.X_MAX) && (this.grille.getCase(x-2,y) == couleur) && (this.grille.getCase(x-1,y) == couleur) && (this.grille.getCase(x+1,y) == couleur))
				return couleur;
			if ((x-3 >-1) &&(this.grille.getCase(x-3,y) == couleur) && (this.grille.getCase(x-2,y) == couleur) && (this.grille.getCase(x-1,y) == couleur))
				return couleur; //ligne horizontale check
			
			if ((y < Grille.Y_MAX) && (this.grille.getCase(x,y+1) == couleur) && (this.grille.getCase(x,y+2) == couleur) && (this.grille.getCase(x,y+3) == couleur))
				return couleur;
			if ((y-1 >-1) && (y+2 < Grille.Y_MAX) &&(this.grille.getCase(x,y-1) == couleur) &&  (this.grille.getCase(x,y+1) == couleur) && (this.grille.getCase(x,y+2) == couleur))
				return couleur;
			if ((y-1 >-2) && (y+1 < Grille.Y_MAX) &&(this.grille.getCase(x,y-2) == couleur) &&  (this.grille.getCase(x,y-1) == couleur) && (this.grille.getCase(x,y+1) == couleur))
				return couleur;
			if ((y-1 >-3) &&(this.grille.getCase(x,y-3) == couleur) &&  (this.grille.getCase(x,y-2) == couleur) && (this.grille.getCase(x,y-1) == couleur))
				return couleur; //ligne verticale check
			
			if ((x+3 < Grille.X_MAX) && (y+3 < Grille.Y_MAX) && (this.grille.getCase(x+1,y+1) == couleur) && (this.grille.getCase(x+2,y+2) == couleur) && (this.grille.getCase(x+3,y+3) == couleur))
				return couleur;
			if ((x+2 < Grille.X_MAX) && (y+2 < Grille.Y_MAX) && (x-1 > -1) && (y-1 >-1) && (this.grille.getCase(x-1,y-1)== couleur) && (this.grille.getCase(x+1,y+1)== couleur) && (this.grille.getCase(x+2,y+2)== couleur))
				return couleur;
			if ((x+1 < Grille.X_MAX) && (y+1 < Grille.Y_MAX) && (x-2 > -1) && (y-2 >-1) && (this.grille.getCase(x-2,y-2)== couleur) && (this.grille.getCase(x-1,y-1)== couleur) && (this.grille.getCase(x+1,y+1)== couleur))
				return couleur;
			if ((x-3 > -1) && (y-3 >-1) && (this.grille.getCase(x-3,y-3)== couleur) && (this.grille.getCase(x-2,y-2)== couleur) && (this.grille.getCase(x-1,y-1)== couleur))
				return couleur; // Diagonnale gauche droite check
			
			if ((x-3 > -1) && (y+3 <Grille.Y_MAX) && (this.grille.getCase(x-3,y+3) == couleur) && (this.grille.getCase(x-2,y+2) == couleur) && (this.grille.getCase(x-1,y+1) == couleur))
				return couleur;
			if ((x-2 > -1) && (y-1 >-1) && (y+2 <Grille.Y_MAX) && (x+1 < Grille.X_MAX) && (this.grille.getCase(x-2,y+2) == couleur) && (this.grille.getCase(x-1,y+1) == couleur) && (this.grille.getCase(x+1,y-1) == couleur))
				return couleur;
			if ((x-1 > -1) && (y-2 >-1) && (y+1 <Grille.Y_MAX) && (x+2 < Grille.X_MAX) && (this.grille.getCase(x-1,y+1) == couleur) && (this.grille.getCase(x+1,y-1) == couleur) && (this.grille.getCase(x+2,y-2) == couleur))
				return couleur;
			if ( (y-2 >-1) && (x+2 < Grille.X_MAX) && (this.grille.getCase(x+1,y-1)== couleur) && (this.grille.getCase(x+2,y-2) == couleur) && (this.grille.getCase(x+3,y-3) == couleur))
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


