package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * 
 * @author mainguene kevin marie joris
 */

public class MyJButton extends JButton
{
	/**
	 * Colonne du bouton
	 */
	private int col;

	/**
	 * @param icon icone
	 * @param col colonne
	 * @param listener click
	 */
	public MyJButton(Icon icon, int col, ActionListener listener)
	{	
		super(icon);
		this.col = col;
		this.addActionListener(listener);
	}
	
	/**
	 * 
	 * @return colone du bouton
	 */
	public int getCol()
	{
		return this.col;
	}
}

