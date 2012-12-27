package fr.iutvalence.java.projets.puissance4;

import java.util.Arrays;


/**
 * creation d'un menu
 * 
 * @author mainguene kevin Marie joris
 */
public class Menu
{
	/**
	 * taille du menu
	 */
	private int taille;
	
	/**
	 * titre du menu
	 */
	private String titre;
	
	/**
	 * tabeau contenant les differant choix du menu
	 */
	private String[] choix;
	
	/**
	 * nombre de choix remplie
	 */
	private int etat;
	
	/**
	 * @param taille taille du menu
	 * @param titre titre du menu
	 */
	public Menu (int taille, String titre)
	{
		this.taille = taille-1;
		this.titre = titre;
		this.choix = new String[this.taille];
		this.etat = 0;
	}
	
	/**
	 * @param taille taille du menu
	 * @param titre titre du menu
	 * @param choix le differant choix
	 * @throws MenuPleinException le tableau de choix est plus grand que la taille du menu
	 */
	public Menu (int taille, String titre, String[] choix) throws MenuPleinException
	{
		if (choix.length > taille)
			throw new MenuPleinException();
		this.taille = taille-1;
		this.titre = titre;
		this.choix = choix;
		this.etat = choix.length;
	}
	
	/**
	 * @param choix une possibiliter du menu
	 * @throws MenuPleinException le menu est deja plein
	 */
	public void addChoix (String choix) throws MenuPleinException
	{
		if (this.etat >= this.taille)
			throw new MenuPleinException();
		this.etat = this.etat +1;
		this.choix[this.etat] = choix;
	}

	/**
	 * @param choix les choix d'un menu
	 * @throws MenuPleinException le tableau de choix est plus grand que la taille du menu
	 */
	public void setChoix(String[] choix) throws MenuPleinException
	{
		if (choix.length > this.taille)
			throw new MenuPleinException();
		this.choix = choix;
	}

	@Override
	public String toString()
	{
		String menu;
		menu = this.titre + "\n";
		for (int i = 0; i <= this.taille; i++)
		{
			menu = menu + (i+1)+")  " + this.choix[i] +"\n";
		}
		
		return menu;
	}
	
	/**
	 * @param numero le numero du choix a afficher
	 * @return le choix correspondant
	 * @throws ChoixInexistantException le numero ne correspond a aucun choix
	 */
	public String getChoix (int numero)throws ChoixInexistantException
	{
		if (numero > this.taille)
			throw new ChoixInexistantException();
		return this.choix[numero];
	}

	/**
	 * @return le titre du menu
	 */
	public String getTitre()
	{
		return this.titre;
	}
	
	
}
