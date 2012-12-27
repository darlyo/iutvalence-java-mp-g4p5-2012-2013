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
	/**
	 * determine la profondeur de la recherche de l'IA
	 */
	private static final int DIFFICULTE = 9;

	public int saisie(int borne, Grille grille, int joueur)
	{
		int nbCoup = DIFFICULTE;
		float listeCoup[] = new float[borne];
		float max;
		int col;
		int ligne;
		int colonne;
		
		//evaluation des coups
		System.out.println("coup possible:");
		for (col=0; col<borne ; col++)
		{
			try
			{
				if (!( grille.colPleine(col)))
				{
					ligne = grille.joue(joueur, col);
					listeCoup[col] = evaluation(nbCoup-1, grille, joueur*-1 );
					System.out.println((col+1) + ":" + listeCoup[col]);
					grille.setCase(col, ligne, Grille.VIDE);	//on enleve le coup jouer apres son evaluation
				}
				else
					System.out.println((col+1) + ": colonne pleine");
			}
			catch (Exception e)
			{
				//pas d'exception erreur
				System.out.println("erreur 1");
				continue;
			}
		}
		max = -2;
		colonne = 0;
		for (col =0; col<borne; col++)	//recherche du meilleur coup.
		{
			try
			{
				if((max < listeCoup[col]) && (!grille.colPleine(col)) ) //le coup et meuilleur et que la colonne n'est pas pleine
				{
					max = listeCoup[col];
					colonne = col;
				}
				else if ((max == listeCoup[col]) && (!grille.colPleine(col)))	//choix aléatoire si la note est équivalente
				{
					if (Math.random() < .5)
						colonne = col;
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
	 * @param grille grille a evaluer
	 * @param joueur la valeur du joueur a jouer
	 * @return la note du coup 
	 */
	public float evaluation(int nbCoup, Grille grille, int joueur ) 
	{
		if (nbCoup == 0)
			return 0;
		//Variable
		float notePartie;
		float newNote;
		int col;
		int ligne;
		int xMaxP = Grille.X_MAX;
		
		//teste de la grille
		notePartie = (float) (Math.abs(grille.checkVictoire(Partie.NBPIONS))) *(joueur*-1);
		// si il y a une victoire l'on a 1 ou -1 en fonction du joueur precedent (joueur*-1)
		if (notePartie == 0) //pas de victoire actuellement
		{
			for (col=0; col<Grille.X_MAX; col++) //on parcourt les differantes colonne
			{
				try
				{
					if(grille.colPleine(col))	
						//si la colonne est pleine on diminue le nombre de colonne jouable
						xMaxP = xMaxP -1;
					else
					{
						ligne = grille.joue(joueur, col); //on fait jouer le joueur
						newNote = evaluation(nbCoup-1, grille, joueur*-1  ); 	//on evalue la valeur du coup
						//if (((DIFFICULTE-nbCoup)%2 == 1)&&(newNote == joueur))
						//{
						//	grille.setCase(col, ligne, Grille.VIDE);	// on annule le coup precedent
						//	return newNote*-1;
						//}
						notePartie = notePartie + newNote;
						
						grille.setCase(col, ligne, Grille.VIDE);	// on annule le coup precedent
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
				notePartie = (float) 0; //on met a zero comme la division par 0 est imposible
			else 
				notePartie = notePartie / ((float) xMaxP); //on divise par le nombre de colonne jouable
		}
		
		return notePartie;
	}
	
}
