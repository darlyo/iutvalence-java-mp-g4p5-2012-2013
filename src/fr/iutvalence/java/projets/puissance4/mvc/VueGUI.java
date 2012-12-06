package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;

/**
 * gestiond e l'affiche graphique pour un joueur
 * 
 * @author mainguene kevin marie joris
 */
public class VueGUI implements InterfaceVue, InterfaceControl, ActionListener
{
	/**
	 * 
	 */
	private Panneau pan;
	
	/**
	 * Fenetre associe au joueur
	 */
	private JFrame fenetre;

	/**
	 * 
	 */
	private JLabel[][] tabl;
	
	@Override
	public void affichegrille(Grille grille)
	{
		int ligne;
		int col;
		Icon blanc = new ImageIcon("./Image/vide.png");
		Icon fleche = new ImageIcon("./Image/fleche.png");
		this.tabl = new JLabel[7][6];
		
        this.fenetre = new JFrame();
		
		this.fenetre.setTitle("Puissance 4");
		this.fenetre.setSize(600, 600);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setResizable(false);
		
		this.pan = new Panneau();
		this.pan.paintInit();
		this.pan.setBackground(Color.blue);
		this.pan.setLayout(new GridLayout(7, 7));
		
		
		//ajout des boutons
		for(col = 0; col<7; col++)
		{
			this.pan.add( new JButton(fleche));
		}
		
		//crteation du tableau de jlabel
		for(ligne = 0; ligne <6 ; ligne++)
		{
			//initilalise les cases a vide
			for(col = 0; col<7; col++)
			{
				this.tabl[col][ligne] = new JLabel(blanc);
				this.pan.add( this.tabl[col][ligne]);
			}	
		}
		
		this.fenetre.add(this.pan);
		this.fenetre.repaint();
		this.fenetre.setVisible(true);
	}

	@Override
	public void ajoutePion(int ligne, int colone, int valeur, Grille grille) throws CaseInexistanteException
	{	
		Icon icon;
		if (valeur == 1)
			icon = new ImageIcon("./Image/croix.png");
		else 
			icon = new ImageIcon("./Image/rond.png");
		this.pan.paintPion(ligne, colone, valeur);
		this.tabl[colone][5-ligne].setIcon(icon);
		this.pan.repaint();
	}

	@Override
	public void message(String msg)
	{
		this.pan.setMsg(msg);
		this.pan.repaint();
	}

	@Override
	public int saisie(int borne, Grille grille)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int col = ((MyJButton) e.getSource()).getCol();
		
		
	}
	

}
