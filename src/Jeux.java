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
		int choix = 0, choix2;
		int resultat;
		String nom;
		
		Scanner sc = new Scanner(System.in);
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		
		while (choix != 4)
		{
			choix = 0;
			System.out.println("-------------MENU--------------");
			System.out.println("1   Nouvelle Partie ");
			System.out.println("2   Afficher les scores");
			System.out.println("3   Changer de nom");
			System.out.println("4   Quitter ");
			
			while ((choix <1) || (choix >4))
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
			{	
				j1.score(j1, j2);
			}
			case 3:
			{
				choix2 = 0;
				while(choix2 != 3)
				{
					choix2 = 0;
					System.out.println("1   Edit du nom du joueur 1");
					System.out.println("2   Edit du nom du joueur 2");
					System.out.println("3   Quitter");
					
					while ((choix2 <1) || (choix2 >3))
						{choix2 = sc.nextInt();
						}
					switch (choix2)
					{
					case 1: 
					{
						System.out.println("Entrer le nouveau nom du joueur 1:");
						nom = sc.next();
						j1.setName(nom);
					}
					case 2: 
					{
						System.out.println("Entrer le nouveau nom du joueur 2:");
						nom = sc.next();
						j2.setName(nom);
					}
					case 3:
					{
						System.out.println(j1.getName() +"   "+ j2.getName());
						break;
					}
					}
				}
			}
			case 4:
				break;
			}
		}
		
	}

}
