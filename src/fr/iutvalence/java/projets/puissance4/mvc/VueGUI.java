package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	/**
	 * 
	 */
	private MyJButton[] button;

	private boolean click;

	private int colonne;
	
	@Override
	public void affichegrille(Grille grille)
	{
		this.click = false;
		
		int ligne;
		int col;
		Icon blanc = new ImageIcon("./Image/vide.png");
		Icon fleche = new ImageIcon("./Image/fleche.png");
		this.tabl = new JLabel[7][6];
		this.button = new MyJButton[7];
		
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
			this.button[col] = new MyJButton(fleche, col, new VueGUI());
			this.pan.add( this.button[col]);
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
		System.out.println("saisie");
		/*int i;
		for (i = 0; i<7; i++)
		{
			this.button[i].setEnabled(true);
		}*/
		while(this.click);
		this.click = false;
		System.out.println(this.colonne);

		
		/*for (i = 0; i<7; i++)
		{
			this.button[i].setEnabled(false);
		}*/
		System.out.println("fin saisie");

		return this.colonne;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.colonne = ((MyJButton) e.getSource()).getCol();
		this.click = true;
		System.out.println(this.colonne);

	}
	

}
