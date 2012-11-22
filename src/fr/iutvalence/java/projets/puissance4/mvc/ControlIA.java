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


	public int saisie(int borne, Partie partie)
	{
		int nbCoup = 8;
		float listeCoup[] = new float[borne];
		float min;
		int i;
		int ligne;
		int colonne;
		String position;
		//if (T_MAX - this.nbTours < nbCoup)
		//	nbCoup = T_MAX - this.nbTours;
		
		//evaluation des coups
		System.out.println("coup possible:");
		for (i=0; i<borne ; i++)
		{
			try
			{
				if (!( partie.grille.colPleine(i)))
				{
					ligne = partie.grille.joue(1, i);
					position = ""+i;
					listeCoup[i] = evaluation(nbCoup-1, position, partie );
					System.out.println((i+1) + ":" + listeCoup[i]);
					partie.grille.setCase(i, ligne, Grille.VIDE);
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
				if((min > listeCoup[i]) && (!partie.grille.colPleine(i)) )
				{
					min = listeCoup[i];
					colonne = i;
				}
				else if ((min == listeCoup[i]) && (!partie.grille.colPleine(i)))	//choix aléatoire si la note est équivalente
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
	 * @param partie la partie evaluer
	 * @return la note du coup 
	 */
	public float evaluation(int nbCoup, String position, Partie partie) 
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
		notePartie = (float) (Math.abs(partie.checkVictoire(Partie.NBPIONS))) *joueur;
		//System.out.print("note = " + notePartie + ",  joueur = " + joueur +"\n");
		if (notePartie == 0)
		{
			for (x=0; x<Grille.X_MAX; x++)
			{
				try
				{
					if(partie.grille.getCase(x, Grille.Y_MAX-1) != 0)
						xMaxP = xMaxP -1;
					else
					{
						ligne = partie.grille.joue(joueur, x);
						newPosition = position +",";
						newNote = evaluation(nbCoup-1, newPosition, partie );
						notePartie = notePartie + newNote;
						
						//System.out.println("x =" + x +"  profondeur" + nbCoup);
						partie.grille.setCase(x, ligne, Grille.VIDE);
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
}
