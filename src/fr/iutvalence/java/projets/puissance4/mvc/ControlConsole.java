package fr.iutvalence.java.projets.puissance4.mvc;

import java.util.Scanner;

/**
 * @author mainguek
 *
 */
public class ControlConsole implements InterfaceControl
{

	public int saisie(int borne )
	{
		int resultat;
		
		Scanner sc = new Scanner(System.in);
		do
		{
			resultat = sc.nextInt();
		}
		while ((resultat > 0) || (resultat <= borne));
		
		return resultat-1;
	}
}
