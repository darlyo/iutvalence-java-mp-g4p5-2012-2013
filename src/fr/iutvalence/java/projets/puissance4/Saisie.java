package fr.iutvalence.java.projets.puissance4;

import java.util.Scanner;

/**
 * Création d'une classe saisie pour le choix de la colonne
 * 
 * @author mainguene kevin marie joris
 */

public class Saisie
{

	/**
	 * Numero de la colone selectionner par le joueur
	 */
	private int numColone;

	/**
	 * saisie de la colonne on l'on vas jouer
	 * 
	 * @param player
	 *            nom du joueur
	 */
	public Saisie(String player)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Tour de " + player + " , quel colone ?");
		do
		{
			this.numColone = sc.nextInt() - 1;
		}
		while ((this.numColone < 0) || (this.numColone > 6));
	}

	/**
	 * renvoie le numero de la colonne
	 * 
	 * @return numero de la colonne
	 */
	public int getC()
	{
		return this.numColone;
	}
}
