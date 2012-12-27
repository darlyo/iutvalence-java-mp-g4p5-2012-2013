package fr.iutvalence.java.projets.puissance4.mvc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iutvalence.java.projets.puissance4.CaseInexistanteException;
import fr.iutvalence.java.projets.puissance4.Grille;
import fr.iutvalence.java.projets.puissance4.Menu;

/**
 * gestiond e l'affiche graphique pour un joueur
 * 
 * @author mainguene kevin marie joris
 */
public class VueGUI implements InterfaceVue, InterfaceControl, ActionListener
{
	/**
	 * Le panneau principal, où est disposé la grille
	 */
	private JPanel pan;
	
	private JPanel panAcueil;
	/**
	 * La fenêtre principale
	 */
	private JFrame fenetre;

	/**
	 * Représentation graphique des cases de la grille.
	 * (le repère est identique à celui défini dans Grille)
	 * 
	 */
	private JLabel[][] cases;
	
	/**
	 * Les boutons permettant de poser un jeton
	 */
	private MyJButton[] boutons;

	/**
	 * Etat du jeton (posé ou non-
	 */
	// L'attribut doit être déclaré "volatile" pour éviter les optimisations de boucle d'attente dans la méthode saisie
	// voir http://www.javamex.com/tutorials/synchronization_volatile_typical_use.shtml
	private volatile boolean jetonPose;

	/**
	 * Colonne dans laquelle le jeton a été posé
	 */
	private int colonneJetonPose;
	
	/**
	 * creation de la fenetre du joueur
	 */
	public VueGUI()
	{
		this.fenetre = new JFrame();
		
		this.fenetre.setTitle("Puissance 4");
		this.fenetre.setSize(600, 600);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fenetre.setResizable(false);
	}
	
	@Override
	public void affichegrille(Grille grille)
	{
		this.jetonPose = false;
		
		int ligne;
		int col;
		Icon blanc = new ImageIcon("./Image/vide.png");
		Icon fleche = new ImageIcon("./Image/fleche.png");
		this.cases = new JLabel[7][6];
		this.boutons = new MyJButton[7];
		
		this.pan = new JPanel();
		//this.pan.paintInit();
		this.pan.setBackground(Color.blue);
		this.pan.setLayout(new GridLayout(7, 7));
		
		
		//ajout des boutons
		for(col = 0; col<7; col++)
		{
			this.boutons[col] = new MyJButton(fleche, col, this);
			this.pan.add( this.boutons[col]);
		}
		
		//creation du tableau de jlabel
		for(ligne = 0; ligne <6 ; ligne++)
		{
			//initilalise les cases a vide
			for(col = 0; col<7; col++)
			{
				this.cases[col][ligne] = new JLabel(blanc);
				this.pan.add( this.cases[col][ligne]);
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
		this.cases[colone][5-ligne].setIcon(icon);
		this.pan.repaint();
	}

	@Override
	public void message(String msg)
	{
		//this.pan.setMsg(msg);
		this.pan.repaint();
	}

	@Override
	public int saisie(int borne, Grille grille, int joueur)
	{   
		System.out.println("saisie"); // JAMAIS PRINT
		
		// On réactive les boutons afin que pouvoir capturer les évènements
		for (MyJButton bouton: boutons)
			bouton.setEnabled(true);
		
		// On déclare le jeton non posé 
		this.jetonPose = false;
				
		// On attend que le joueur pose son jeton
		while(!this.jetonPose);
		
		
		System.out.println(this.colonneJetonPose);

		
		System.out.println("fin saisie");

		return this.colonneJetonPose;
	}

	/**
	 * Traitement du click sur les boutons permettant de poser les jetons
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Obtention de la colonne associée au bouton sur lequel l'évènement s'est produit
		this.colonneJetonPose = ((MyJButton) e.getSource()).getCol();
		
		// On déclare le jeton posé
		this.jetonPose = true;
		
		// On désactive les boutons pour éviter les évènements en dehors du tour de jeu du joueur
		for (MyJButton bouton: boutons)
			bouton.setEnabled(false);
		
		System.out.println(this.colonneJetonPose); // PASSE ICI 

	}

	@Override
	public void afficheMenu(Menu menu)
	{
		this.panAcueil = new JPanel();
		this.panAcueil.setBackground(Color.blue);
		this.panAcueil.setLayout(new GridLayout(1,3));
	}
	
}
