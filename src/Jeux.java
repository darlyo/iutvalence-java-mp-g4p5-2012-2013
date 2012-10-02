import java.util.Scanner;

/**
 * 
 * @author mainguek
 *
 */
public class Jeux
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Déclaration de  variable
		int choix = 0;
		int resultat;
		Scanner sc = new Scanner(System.in);
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		
		while (choix != 3)
		{
			choix = 0;
			System.out.println("-------------MENU--------------");
			System.out.println("1   Nouvelle Partie ");
			System.out.println("2   Afficher les scores");
			System.out.println("3   Quitter ");
			
			while ((choix <1) || (choix >3))
				choix = sc.nextInt();
			
			switch (choix)
			{
			case 1:
			{
				Partie partie = new Partie(j1, j2);
				resultat = partie.lancer();
				if (resultat == 1)
				{
					System.out.println("Le joueur 1 a gagné");
					j1.gagne();
				}
				else if (resultat == 2)
				{
					System.out.println("Le joueur 2 a gagné");
					j2.gagne();
				}
				else
					System.out.println("Match nul");
			}	
			case 2:
				j1.score(j1, j2);
				
			case 3:
				break;
			}
		}
		
	}

}
