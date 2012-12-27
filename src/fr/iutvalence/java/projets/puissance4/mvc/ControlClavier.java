package fr.iutvalence.java.projets.puissance4.mvc;

import java.util.Scanner;

import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * interface de controle du clavier
 * 
 * @author mainguene kevin Marie joris
 */
public class ControlClavier implements InterfaceControl
{

	@Override
	public int saisie(int borne, Grille grille, int joueur)
	{
		Scanner sc = new Scanner(System.in);
		int colone = sc.nextInt();
		while ((colone < 0) || (colone >= borne+1))
			colone = sc.nextInt();
		
		return colone-1;
	}

}
