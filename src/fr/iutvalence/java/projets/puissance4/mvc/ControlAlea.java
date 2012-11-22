package fr.iutvalence.java.projets.puissance4.mvc;

/**
 * @author mainguek
 *
 */
public class ControlAlea implements InterfaceControl
{
	
	public int saisie(int borne )
	{
		return (int)(Math.round(Math.random()*(borne-1)));
	}
}