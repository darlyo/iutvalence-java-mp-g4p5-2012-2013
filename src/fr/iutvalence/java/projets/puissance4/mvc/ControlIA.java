package fr.iutvalence.java.projets.puissance4.mvc;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonneInexistanteException;
import fr.iutvalence.java.projets.puissance4.ColonnePleineException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * jeux de l'IA
 * 
 * @author mainguene kevin Marie joris
 */
public class ControlIA implements InterfaceControl
{


	public int saisie(int borne, Grille grille)
	{
		int nbCoup = 8;
		float listeCoup[] = new float[borne];
		float min;
		int i;
		int ligne;
		int colonne;
		String position;
		
		//evaluation des coups
		System.out.println("coup possible:");
		for (i=0; i<borne ; i++)
		{
			try
			{
				if (!( grille.colPleine(i)))
				{
					ligne = grille.joue(1, i);
					position = ""+i;
					listeCoup[i] = evaluation(nbCoup-1, position, grille );
					System.out.println((i+1) + ":" + listeCoup[i]);
					grille.setCase(i, ligne, Grille.VIDE);
				}
				else
					System.out.println((i+1) + ": colonne pleine");
			}
			catch (Exception e)
			{
				//pas d'exception erreur
				System.out.println("erreur 1");
				continue;
			}
		}
		min = 2;
		colonne = 0;
		for (i =0; i<borne; i++)	//recherche du meilleur coup.
		{
			try
			{
				if((min > listeCoup[i]) && (!grille.colPleine(i)) )
				{
					min = listeCoup[i];
					colonne = i;
				}
				else if ((min == listeCoup[i]) && (!grille.colPleine(i)))	//choix aléatoire si la note est équivalente
				{
					if (Math.random() < .5)
						colonne = i;
				}
			}
			catch (ColonneInexistanteException e)
			{
				// la colonne est pleine
			}
		}
		return colonne;
	}
	
	/** 
	 * @param nbCoup : le nombre de coup a prévoir
	 * @param position chaine pour l'affichage
	 * @param grille grille a evaluer
	 * @return la note du coup 
	 */
	public float evaluation(int nbCoup, String position, Grille grille ) 
	{
		if (nbCoup == 0)
			return 0;
		//Variable
		float notePartie;
		float newNote;
		int joueur;
		int x;
		int ligne;
		int xMaxP = Grille.X_MAX;
		String newPosition;
		
		//initialisation de joueur
		if (nbCoup % 2 == 0)
			joueur = 1;
		else 
			joueur = -1;
		
		//teste de la grille
		notePartie = (float) (Math.abs(checkVictoire(Partie.NBPIONS, grille))) *joueur;
		//System.out.print("note = " + notePartie + ",  joueur = " + joueur +"\n");
		if (notePartie == 0)
		{
			for (x=0; x<Grille.X_MAX; x++)
			{
				try
				{
					if(grille.getCase(x, Grille.Y_MAX-1) != 0)
						xMaxP = xMaxP -1;
					else
					{
						ligne = grille.joue(joueur, x);
						newPosition = position +",";
						newNote = evaluation(nbCoup-1, newPosition, grille  );
						notePartie = notePartie + newNote;
						
						//System.out.println("x =" + x +"  profondeur" + nbCoup);
						grille.setCase(x, ligne, Grille.VIDE);
					}
				}
				catch (CaseInexistanteException e)
				{
					//pas d'exception erreur
					System.out.println("erreur 3");
					continue;
				}
				catch (ColonnePleineException e)
				{
					//pas d'exception erreur
					System.out.println("erreur 4");
					continue;
				}
				catch (ColonneInexistanteException e)
				{
					//pas d'exception erreur
					System.out.println("erreur 5");
					continue;
				}
			}
			
			if (xMaxP == 0)		//toute les colonne sont pleine
				notePartie = (float) 0;
			else 
				notePartie = notePartie / ((float) xMaxP);
		}
		
		//System.out.print("[position = " + position+"prof("+nbCoup+")"+" joueur("+joueur+")" );
		//System.out.println("note("+notePartie+")]");
		return notePartie;
	}
	
	/**
	 * vérification de la grille pour voir si le dernier joueur a gagner ou non
	 * @param nbPions le nombre de pions necessaire pour gagner
	 * @param grille la grille a chek
	 * @return le vainqueur ou 0 pour continuer la partie
	 */
	public int checkVictoire(int nbPions, Grille grille)
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
					if (grille.getCase(x, y)!= Grille.VIDE)
					{
						i = 0;
						couleur = grille.getCase(x, y);
						while((i < nbPions-1) && (grille.getCase(x, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (grille.getCase(x, y+i) == couleur))
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
					if (grille.getCase(x, y)!= Grille.VIDE)
					{
						i = 0;
						couleur = grille.getCase(x, y);
						while((i < nbPions-1) && (grille.getCase(x+i, y)== couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (grille.getCase(x+i, y) == couleur))
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
					if (grille.getCase(x, y) != Grille.VIDE)
					{
						i = 0;
						couleur = grille.getCase(x, y);
						while((i < nbPions-1) && (grille.getCase(x+i, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (grille.getCase(x+i, y+i) == couleur))
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
					if (grille.getCase(x, y) != Grille.VIDE)
					{
						i = 0;
						couleur = grille.getCase(x, y);
						while((i < nbPions-1) && (grille.getCase(x-i, y+i) == couleur) )
						{
							i++;
						}
						if ((i == nbPions-1) && (grille.getCase(x-i, y+i) == couleur))
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

		return Partie.CONTINU;
	}
}
