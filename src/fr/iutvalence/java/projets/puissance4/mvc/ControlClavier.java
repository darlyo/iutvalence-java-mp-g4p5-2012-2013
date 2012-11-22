package fr.iutvalence.java.projets.puissance4.mvc;

import java.util.Scanner;

/**
 * interface de controle du clavier
 * 
 * @author mainguene kevin Marie joris
 */
public class ControlClavier implements InterfaceControl
{

	@Override
	public int saisie(int borne, Partie partie)
	{
		Scanner sc = new Scanner(System.in);
		int colone = sc.nextInt();
		while ((colone < 0) || (colone >= borne))
			colone = sc.nextInt();
		
		return colone-1;
	}

}
