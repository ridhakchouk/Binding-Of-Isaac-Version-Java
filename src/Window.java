//package WindowBuilder.src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Point;
import java.awt.Font;
import java.awt.Label;

public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1345994428545756861L;
	Jeu jeu;
	private JPanel contentPane;
	JButton PoNord = new JButton();
	JButton PoOuest = new JButton();
	JButton PoEst = new JButton();
	JButton PoSud = new JButton();
	Piece precedente = new Piece();
	JPanel panel = new JPanel();
	JButton Cle = new JButton();
	private Objet[] tabObjet = new Objet[4];
	JButton bObjet1 = new JButton();
	JButton bObjet2 = new JButton();
	JButton bObjet3 = new JButton();
	JButton bObjet0 = new JButton();
	JButton use = new JButton("utiliser");
	JButton drop = new JButton("lacher");
	int iObjet = -1;
	JButton[] Inv = new JButton[4];
	JFrame fenetregagner = new JFrame();
	JFrame fenetreperdu = new JFrame();
	JFrame chargement = new JFrame();
	JButton Tresor = new JButton();
	JButton Nourriture = new JButton();
	JButton Medicament = new JButton();
	JButton Medecin = new JButton();
	JButton Cuisinier = new JButton();
	JButton Monster = new JButton();
	Label label = new Label("");
	int test = -1;
	private JLabel point_de_vie;
	private JLabel point_de_force;
	int viej;
	int forcej;
	private final JLabel lblInventaire = new JLabel("Inventaire : ");
	private final JLabel lblTrsor = new JLabel("Tr\u00E9sor");
	JButton btnQuitter = new JButton("Quitter");//perdu
	JButton btnQuitter2 = new JButton("Quitter");//gagne
	JButton rejouer = new JButton("Rejouer");//perdu
	JButton rejouer2 = new JButton("Rejouer");//gagne
	JButton PPS = new JButton();

	//SOUNDBLASTER SYSTEM
	private Sound force_wav = new Sound("/son/force.wav");
	private Sound gameover_wav = new Sound("/son/gameover.wav");
	private Sound soin1_wav = new Sound("/son/soin1.wav");
	private Sound soin2_wav = new Sound("/son/soin2.wav");
	private Sound sonchargement_wav = new Sound("/son/sonchargement.wav");
	private Sound victoire_wav = new Sound("/son/victoire.wav");
	private Sound vieperdu_wav = new Sound("/son/vieperdu.wav");
	private Sound mainsong_wav = new Sound("/son/mainsong.wav");
	private JLabel lblMonstre = new JLabel("Les monstre : ");
	private JLabel monstre_display2 = new JLabel("");
	private JLabel monstre_display = new JLabel("EL DIABLO");
	
	Window(Jeu j) {

		// fenetreperdu

		fenetreperdu.getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 460, 215);
		panel_1.setLayout(null);
		fenetreperdu.getContentPane().add(panel_1);
		btnQuitter.addActionListener(this);
		btnQuitter.setBounds(151, 181, 85, 23);
		panel_1.add(btnQuitter);

		
		rejouer2.setBounds(151, 149, 85, 23);
		panel_1.add(rejouer2);
		
		JLabel lblVousAvezPerdu = new JLabel("Vous êtes mort.");
		lblVousAvezPerdu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVousAvezPerdu.setForeground(Color.RED);
		lblVousAvezPerdu.setBounds(43, 11, 102, 23);
		panel_1.add(lblVousAvezPerdu);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Window.class.getResource("/images/header.jpg")));
		lblNewLabel.setBounds(0, 0, 384, 215);
		panel_1.add(lblNewLabel);
		
		rejouer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] args = {};
				fenetregagner.setVisible(false);
				fenetreperdu.setVisible(false);
				
				force_wav.stop();
				gameover_wav.stop();
				soin1_wav.stop();
				soin2_wav.stop();
				sonchargement_wav.stop();
				victoire_wav.stop();
				vieperdu_wav.stop();
				mainsong_wav.stop();
				
				Main.main(args);
			}
		});
		

		// fenetreGagne

		fenetregagner.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 460, 215);
		panel_2.setLayout(null);
		fenetregagner.getContentPane().add(panel_2);

		btnQuitter2.addActionListener(this);
		btnQuitter2.setBounds(151, 181, 85, 23);
		panel_2.add(btnQuitter2);
		
		rejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] args = {};
				fenetregagner.setVisible(false);
				fenetreperdu.setVisible(false);
				force_wav.stop();
				gameover_wav.stop();
				soin1_wav.stop();
				soin2_wav.stop();
				sonchargement_wav.stop();
				victoire_wav.stop();
				vieperdu_wav.stop();
				mainsong_wav.stop();
				Main.main(args);
			}
		});
		
		rejouer.setBounds(151, 149, 85, 23);
		panel_2.add(rejouer);

		JLabel lblVousAvezGagnez = new JLabel("Vous avez gagnez.");
		lblVousAvezGagnez.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVousAvezGagnez.setForeground(Color.GREEN);
		lblVousAvezGagnez.setBounds(43, 11, 112, 23);
		panel_2.add(lblVousAvezGagnez);

		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon(Window.class.getResource("/images/header.jpg")));
		lblNewLabel2.setBounds(0, 0, 384, 215);
		panel_2.add(lblNewLabel2);

		/* Faire marché le window builder commente les ligne 127à140 */
		
	
		
		panel = new JPanel() {

			private static final long serialVersionUID = 3674839139559716305L;

			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit()
						.getImage(Window.class.getResource("/images/room_2.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}

		};

		this.setContentPane(panel);
		

		jeu = j;
		viej = j.monJoueur.getVie();
		forcej = j.monJoueur.getForce();
		
		WindowB1();
		WindowB2_perdu();
		WindowB3_gagner();
	}

	public void WindowB3_gagner() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fenetregagner.setTitle("Victoire !");
		fenetregagner.setSize(390, 240);
		fenetregagner.setResizable(false);
		fenetregagner.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		fenetregagner.setVisible(false);
		ImageIcon img = new ImageIcon(Window.class.getResource("/images/Window_icon.png"));
		fenetregagner.setIconImage(img.getImage());

	}

	public void WindowB2_perdu() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fenetreperdu.setTitle("Game Over :-(");
		fenetreperdu.setSize(390, 240);
		fenetreperdu.setResizable(false);
		fenetreperdu.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		fenetreperdu.setVisible(false);
		ImageIcon img = new ImageIcon(Window.class.getResource("/images/Window_icon.png"));
		fenetreperdu.setIconImage(img.getImage());
		

	}

	public void WindowB1() {

		setSize(1280, 720);
		this.setLocation(0, 0);
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("The Binding of Elias");
		ImageIcon img = new ImageIcon(Window.class.getResource("/images/Window_icon.png"));
		this.setIconImage(img.getImage());

		// JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 520);
		panel.setLayout(null);
		contentPane.add(panel);

		// taille porte = 2,6458 cm

		PoNord.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_NORD.png")));
		PoNord.setBounds(590, 0, 100, 100);fenetreperdu.setVisible(true);

		PoNord.setOpaque(false);
		PoNord.setContentAreaFilled(false);
		PoNord.setBorderPainted(false);

		// JButton Button2 = new JButton("New button");
		PoOuest.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_OUEST.png")));
		PoOuest.setBounds(40, 210, 100, 100);

		PoOuest.setOpaque(false);
		PoOuest.setContentAreaFilled(false);
		PoOuest.setBorderPainted(false);

		// JButton Button3 = new JButton("");
		PoEst.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_EST.png")));
		PoEst.setBounds(1134, 210, 100, 100);

		PoEst.setOpaque(false);
		PoEst.setContentAreaFilled(false);
		PoEst.setBorderPainted(false);

		// JButton Button4 = new JButton("New button");
		PoSud.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_SUD.png")));
		PoSud.setBounds(590, 420, 100, 100);

		PoSud.setOpaque(false);
		PoSud.setContentAreaFilled(false);
		PoSud.setBorderPainted(false);

		// JButton tresor
		Tresor.setIcon(new ImageIcon(Window.class.getResource("/images/tresor.png")));
		Tresor.setBounds(118, 117, 67, 69);

		Tresor.setOpaque(false);
		Tresor.setContentAreaFilled(false);
		Tresor.setBorderPainted(false);

		// JButton Nourriture
		Nourriture.setIcon(new ImageIcon(Window.class.getResource("/images/nourriture.png")));
		Nourriture.setBounds(195, 117, 67, 69);

		Nourriture.setOpaque(false);
		Nourriture.setContentAreaFilled(false);
		Nourriture.setBorderPainted(false);

		// JButton Medicament
		Medicament.setIcon(new ImageIcon(Window.class.getResource("/images/medicament.png")));
		Medicament.setBounds(272, 117, 67, 69);

		Medicament.setOpaque(false);
		Medicament.setContentAreaFilled(false);
		Medicament.setBorderPainted(false);

		// JButton Medecin
		Medecin.setIcon(new ImageIcon(Window.class.getResource("/images/medecin.png")));
		Medecin.setBounds(349, 117, 67, 69);

		Medecin.setOpaque(false);
		Medecin.setContentAreaFilled(false);
		Medecin.setBorderPainted(false);

		// JButton Cuisinier
		Cuisinier.setIcon(new ImageIcon(Window.class.getResource("/images/cuisinier.png")));
		Cuisinier.setBounds(426, 117, 67, 69);

		Cuisinier.setOpaque(false);
		Cuisinier.setContentAreaFilled(false);
		Cuisinier.setBorderPainted(false);
		//RAND
		int mini = 0 ,max=1;
		int rand=(int)( Math.random()*( max - mini + 1 ) ) + mini;
		if(rand ==0)
			Monster.setIcon(new ImageIcon(Window.class.getResource("/images/Boss_The_Fallen.png")));
		else
			Monster.setIcon(new ImageIcon(Window.class.getResource("/images/App_IamError_large.png")));
		
		

	// JButton PPS
		

		PPS.setBounds(404, 280, 100, 100);

		PPS.setOpaque(false);
		PPS.setContentAreaFilled(false);
		PPS.setBorderPainted(false);
		PPS.setIcon(new ImageIcon(Window.class.getResource("/images/Secret_Trap_Door_large.png")));
		PPS.addActionListener(this);
		
		
		// JButton Monster
		// Monster.setIcon(new ImageIcon(Window.class.getResource()));
		Monster.setBounds(895, 201, 114, 120);

		Monster.setOpaque(false);
		Monster.setContentAreaFilled(false);
		Monster.setBorderPainted(false);

		PoNord.addActionListener(this);
		PoOuest.addActionListener(this);
		PoEst.addActionListener(this);
		PoSud.addActionListener(this);
		Tresor.addActionListener(this);
		Nourriture.addActionListener(this);
		Medicament.addActionListener(this);
		Medecin.addActionListener(this);
		Cuisinier.addActionListener(this);
		Monster.addActionListener(this);

		Cle.setMaximumSize(new Dimension(28, 40));
		Cle.setMinimumSize(new Dimension(28, 40));
		Cle.setLocation(new Point(1, 1));
		Cle.setIcon(new ImageIcon(Window.class.getResource("/images/Cle.png")));
		Cle.addActionListener(this);
		Cle.setOpaque(false);
		Cle.setContentAreaFilled(false);
		Cle.setBorderPainted(false);
		Cle.setBounds(171, 347, 61, 69);

		panel.add(PoNord);
		panel.add(PoOuest);
		panel.add(PoEst);
		panel.add(PoSud);
		panel.add(Cle);
		panel.add(Tresor);
		panel.add(Nourriture);
		panel.add(Medicament);
		panel.add(Medecin);
		panel.add(Cuisinier);
		panel.add(Monster);
		panel.add(PPS);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 520, 1274, 175);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		bObjet0.setBounds(171, 67, 69, 23);
		bObjet1.setBounds(245, 67, 69, 23);
		bObjet2.setBounds(171, 101, 69, 23);
		bObjet3.setBounds(245, 101, 69, 23);
		use.setBounds(324, 67, 94, 23);
		drop.setBounds(324, 101, 94, 23);

		panel_1_1.add(bObjet0);
		panel_1_1.add(bObjet1);
		panel_1_1.add(bObjet2);
		panel_1_1.add(bObjet3);
		panel_1_1.add(use);
		panel_1_1.add(drop);

		Inv[0] = bObjet0;
		Inv[1] = bObjet1;
		Inv[2] = bObjet2;
		Inv[3] = bObjet3;

		bObjet0.addActionListener(this);
		bObjet1.addActionListener(this);
		bObjet2.addActionListener(this);
		bObjet3.addActionListener(this);
		use.addActionListener(this);
		drop.addActionListener(this);

		point_de_vie = new JLabel();
		point_de_vie.setIcon(new ImageIcon(Window.class.getResource("/images/Vie.png")));
		point_de_vie.setText("Point de vie : " + viej);
		point_de_vie.setBounds(10, 20, 150, 34);
		point_de_vie.setForeground(Color.BLACK);
		panel_1_1.add(point_de_vie);

		point_de_force = new JLabel();
		point_de_force.setIcon(new ImageIcon(Window.class.getResource("/images/Military Sword.png")));
		point_de_force.setText("Point de force : " + viej);
		point_de_force.setBounds(10, 73, 150, 30);
		point_de_force.setForeground(Color.BLACK);
		panel_1_1.add(point_de_force);
		lblInventaire.setBounds(169, 0, 145, 56);
		panel_1_1.add(lblInventaire);
		lblInventaire.setIcon(new ImageIcon(Window.class.getResource("/images/coffre.png")));
		lblInventaire.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblIndication = new JLabel("Indication :");
		lblIndication.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndication.setBounds(535, 0, 69, 14);
		panel_1_1.add(lblIndication);

		JLabel lblMdecin = new JLabel("M\u00E9decin");
		lblMdecin.setIcon(new ImageIcon(Window.class.getResource("/images/medecin.png")));
		lblMdecin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdecin.setBounds(428, 20, 135, 48);
		panel_1_1.add(lblMdecin);

		JLabel lblMdicamment = new JLabel(" M\u00E9dicament");
		lblMdicamment.setIcon(new ImageIcon(Window.class.getResource("/images/medicament.png")));
		lblMdicamment.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdicamment.setBounds(561, 27, 135, 34);
		panel_1_1.add(lblMdicamment);
		panel_1_1.setBackground(Color.LIGHT_GRAY);

		JLabel lblCuisinier = new JLabel("Cuisinier");
		lblCuisinier.setBounds(455, 67, 108, 48);
		panel_1_1.add(lblCuisinier);
		lblCuisinier.setIcon(new ImageIcon(Window.class.getResource("/images/cuisinier.png")));

		JLabel lblNourriture = new JLabel("    Nourriture");
		lblNourriture.setBounds(583, 73, 113, 30);
		panel_1_1.add(lblNourriture);
		lblNourriture.setIcon(new ImageIcon(Window.class.getResource("/images/nourriture_icon.png")));

		JLabel lblCl = new JLabel("    Cl\u00E9");
		lblCl.setBounds(465, 119, 98, 35);
		panel_1_1.add(lblCl);
		lblCl.setIcon(new ImageIcon(Window.class.getResource("/images/Cle.png")));
		lblTrsor.setBounds(571, 114, 125, 44);
		panel_1_1.add(lblTrsor);
		lblTrsor.setIcon(new ImageIcon(Window.class.getResource("/images/tresor.png")));
		
		
		label.setAlignment(Label.CENTER);
		//label.setBackground(Color.GREEN);
		label.setBounds(750, 27, 514, 34);
		panel_1_1.add(label);
		lblMonstre.setBounds(691, 113, 87, 14);
		
		panel_1_1.add(lblMonstre);
		monstre_display2.setIcon(new ImageIcon(Window.class.getResource("/images/App_IamError.png")));
		monstre_display2.setBounds(788, 79, 69, 72);
		
		panel_1_1.add(monstre_display2);
		monstre_display.setIcon(new ImageIcon(Window.class.getResource("/images/Boss_The_Fallen_small.png")));
		monstre_display.setBounds(867, 91, 145, 67);
		
		panel_1_1.add(monstre_display);

		// PoNord.setVisible(false);// ? what is this bro ?
		// falseDropAndUse();

		
		charge();
		
		mainsong_wav.play();
		
	}

	public void deplacement(char s) {
		if (jeu.monJoueur.getPosition().getPorte(s).getFermer()) {
			for (int j = 0; j < tabObjet.length; j++) {
				if (tabObjet[j] instanceof Cle) {
					Cle Cletest = (Cle) tabObjet[j];
					if (Cletest != null) {
						if (Cletest.getNumero() == jeu.monJoueur.getPosition().getPorte(s).getNumero()) {
							jeu.monJoueur.getPosition().getPorte(s).ouvrir();
							tabObjet[j] = null;
						}
					}
				}
			}
			if (jeu.monJoueur.getPosition().getPorte(s).getFermer()) {
				// System.out.println("Porte fermée avec la clé numero : "+
				// jeu.monJoueur.getPosition().getPorte(s).getNumero());
				label.setText(
						"Porte fermée avec la clé numero : " + jeu.monJoueur.getPosition().getPorte(s).getNumero());
			}

		}
		if (!jeu.monJoueur.getPosition().getPorte(s).getFermer()) {
			// precedente=jeu.monJoueur.getPosition();
			jeu.monJoueur.setPosition(jeu.monJoueur.getPosition().pieceVoisine(s));
			forcej = jeu.monJoueur.getForce();
			forcej = forcej - 1;
			jeu.monJoueur.setForce(forcej);
			if (jeu.monJoueur.getForce() == 0) {
				this.setVisible(false);
				mainsong_wav.stop();
				fenetreperdu.setVisible(true);
				gameover_wav.play();
			}
			refresh_force();
		}

	}

	
	
	public void maj_map() {
		Piece pi = this.jeu.monJoueur.getPosition();

		PoNord.setVisible(false);
		PoOuest.setVisible(false);
		PoEst.setVisible(false);
		PoSud.setVisible(false);
		PPS.setVisible(false);

		Cle.setVisible(false);
		Tresor.setVisible(false);
		Nourriture.setVisible(false);
		Medicament.setVisible(false);

		Medecin.setVisible(false);
		Cuisinier.setVisible(false);
		Monster.setVisible(false);

		if (pi.getPorte('N') != null && pi.getPorte('N').getFermer() == false) {
			PoNord.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_NORD.png")));
			PoNord.setVisible(true);
		}

		if (pi.getPorte('N') != null && pi.getPorte('N').getFermer() == true) {
			PoNord.setIcon(new ImageIcon(Window.class.getResource("/images/Item_Door_NORD.png")));
			PoNord.setVisible(true);
		}

		if (pi.getPorte('O') != null && pi.getPorte('O').getFermer() == false) {
			PoOuest.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_OUEST.png")));
			PoOuest.setVisible(true);
		}

		if (pi.getPorte('O') != null && pi.getPorte('O').getFermer() == true) {
			PoOuest.setIcon(new ImageIcon(Window.class.getResource("/images/Item_Door_OUEST.png")));
			PoOuest.setVisible(true);
		}

		if (pi.getPorte('S') != null && pi.getPorte('S').getFermer() == false) {
			PoSud.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_SUD.png")));
			PoSud.setVisible(true);
		}

		if (pi.getPorte('S') != null && pi.getPorte('S').getFermer() == true) {
			PoSud.setIcon(new ImageIcon(Window.class.getResource("/images/Item_Door_SUD.png")));
			PoSud.setVisible(true);
		}

		if (pi.getPorte('E') != null && pi.getPorte('E').getFermer() == false) {
			PoEst.setIcon(new ImageIcon(Window.class.getResource("/images/Curse_Door_EST.png")));
			PoEst.setVisible(true);
		}

		if (pi.getPorte('E') != null && pi.getPorte('E').getFermer() == true) {
			PoEst.setIcon(new ImageIcon(Window.class.getResource("/images/Item_Door_EST.png")));
			PoEst.setVisible(true);
		}
		
		if (pi instanceof PiecePassageSecret) {
				PPS.setIcon(new ImageIcon(Window.class.getResource("/images/Secret_Trap_Door_large.png")));
				PPS.setVisible(true);
			}

		for (int i = 0; jeu.nbObjet() > i; i++) {
			if (jeu.getObjet(i).getPosition() == pi && jeu.getObjet(i).getPosition() != null
					&& jeu.getObjet(i) instanceof Cle) {
				Cle.setVisible(true);
			}

			if (jeu.getObjet(i).getPosition() == pi && jeu.getObjet(i).getPosition() != null
					&& jeu.getObjet(i) instanceof Tresor) {
				Tresor.setVisible(true);
			}
			if (jeu.getObjet(i).getPosition() == pi && jeu.getObjet(i).getPosition() != null
					&& jeu.getObjet(i) instanceof Nourriture) {
				Nourriture.setVisible(true);
			}
			if (jeu.getObjet(i).getPosition() == pi && jeu.getObjet(i).getPosition() != null
					&& jeu.getObjet(i) instanceof Medicament) {
				Medicament.setVisible(true);
			}

		}
		for (int i = 0; jeu.nbIndividu() > i; i++) {
			if (jeu.getIndividu(i).getPosition() == pi && jeu.getIndividu(i).getPosition() != null
					&& jeu.getIndividu(i) instanceof Medecin) {
				Medecin.setVisible(true);
			}
			if (jeu.getIndividu(i).getPosition() == pi && jeu.getIndividu(i).getPosition() != null
					&& jeu.getIndividu(i) instanceof Cuisinier) {
				Cuisinier.setVisible(true);
			}
			if (jeu.getIndividu(i).getPosition() == pi && jeu.getIndividu(i).getPosition() != null
					&& jeu.getIndividu(i) instanceof Monstre) {
				Monster.setVisible(true);
			}
		}

	}

	// faut rajouter une image en fonction de si c'est quel objet
	public void maj_inv() {
		bObjet0.setVisible(false);
		bObjet1.setVisible(false);
		bObjet2.setVisible(false);
		bObjet3.setVisible(false);

		// int x =0;
		for (int i = 0; i < tabObjet.length; i++) {
			if (tabObjet[i] instanceof Cle && tabObjet[i] != null) {
				Inv[i].setVisible(true);
				Inv[i].setIcon(new ImageIcon(Window.class.getResource("/images/cle_icon.png")));
			}
			if (tabObjet[i] instanceof Nourriture && tabObjet[i] != null) {
				Inv[i].setVisible(true);
				Inv[i].setIcon(
						new ImageIcon(Window.class.getResource("/images/nourriture_icon.png")));
			}
			if (tabObjet[i] instanceof Medicament && tabObjet[i] != null) {
				Inv[i].setVisible(true);
				Inv[i].setIcon(
						new ImageIcon(Window.class.getResource("/images/medicament_icon.png")));
			}

		}
	}
	

	public void refresh_vie() {
		int viej1 = jeu.monJoueur.getVie();
		point_de_vie.setText("Point de vie : " + viej1);
	}

	public void refresh_force() {
		int forcej1 = jeu.monJoueur.getForce();
		point_de_force.setText("Point de force : " + forcej1);
	}

	public void gagne() {
		this.setVisible(false);
		mainsong_wav.stop();
		victoire_wav.play();
		fenetregagner.setVisible(true);
	}
	
	public void charge(){
		sonchargement_wav.play();
		//sonchargement_wav.stop();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void regenHp() {
		int mini = 0 ,max=1;
		int rand=(int)( Math.random()*( max - mini + 1 ) ) + mini;
		jeu.monJoueur.setVie(10);
		label.setText("Le médecin vous soigne");
		
		if(rand==0){
			soin1_wav.play();
		}
		else
			soin2_wav.play();
		//Sound.force_wav.play();
	}

	public void regenStamina() {
		jeu.monJoueur.setForce(10);
		label.setText("Vous reprenez des forces");
		force_wav.play();

	}

	public void open(char s, int i) {
		if (test == jeu.monJoueur.getPosition().getPorte(s).getNumero()) {
			jeu.monJoueur.getPosition().getPorte(s).ouvrir();
			
			
			maj_map();
			falseDropAndUse();
		}
		test = -1;

	}

	public void use(int i) {

		if (tabObjet[i] instanceof Cle) {
			//System.out.println("Cliquer sur une porte, elle va s'ouvrir si c'est la bonne clé! ");
			Cle tmp = (Cle) tabObjet[i];
			test = tmp.getNumero();
			
			// regarder le num de la clé le garder dans une variable
			// delete(i);
		}
		if (tabObjet[i] instanceof Medicament) {
			regenHp();
			refresh_vie();
			delete(i);
		}
		if (tabObjet[i] instanceof Nourriture) {
			regenStamina();
			refresh_force();
			delete(i);

		}
		rangerInv();

	}

	public void drop(int i) {
		if (tabObjet[i] instanceof Cle) {
			tabObjet[i].setPosition(jeu.monJoueur.getPosition());
		}
		if (tabObjet[i] instanceof Medicament) {
			tabObjet[i].setPosition(jeu.monJoueur.getPosition());
		}
		if (tabObjet[i] instanceof Nourriture) {
			tabObjet[i].setPosition(jeu.monJoueur.getPosition());
		}
		delete(i);
		rangerInv();
		maj_inv();

	}

	public void delete(int i) {
		tabObjet[i] = null;
		maj_map();
	}

	public void trueDropAndUse() {
		use.setVisible(true);
		drop.setVisible(true);
	}

	public void falseDropAndUse() {
		use.setVisible(false);
		drop.setVisible(false);
	}

	public void rangerInv() {
		for (int x = 0; x < 3; x++) {

			boolean t = true;
			for (int i = 0; i < 3; i++) {
				if (tabObjet[i] == null) {
					for (int j = 0; j < 3; j++) {
						if (tabObjet[j] != null && j > i && t) {
							tabObjet[i] = tabObjet[j];
							tabObjet[j] = null;
							t = false;
						}
					}
				}
			}
		}
		maj_inv();

	}

	// bug : prend tout les item dans la salle : resolu !
	// bug 2 : ne pas prendre d'objet si l'inventaire plein : resolu !
	public void prendO(int x) {

		int y = 0;
		if (jeu.getObjet(x) instanceof Cle) {
			Objet o = jeu.getObjet(x);
			y = 0;
			while (tabObjet[y] != null) {
				y++;
			}
			if (y < 4) {
				tabObjet[y] = o;

				maj_inv();
				Cle cn = (Cle) jeu.getObjet(x);
				//System.out.println("Vous avez pris la clé " + cn.getNumero());
				label.setText("Vous avez pris la clé " + cn.getNumero());
				o.pris();
			}

		}
		if (jeu.getObjet(x) instanceof Medicament || jeu.getObjet(x) instanceof Nourriture) {

			Objet o = jeu.getObjet(x);
			y = 0;
			while (tabObjet[y] != null) {
				y++;
			}
			if (y < 4) {
				tabObjet[y] = o;

				maj_inv();
				// Cle cn= (Cle) jeu.getObjet(x);
				// System.out.println("Vous avez pris la clé "+cn.getNumero());
				o.pris();
			}

		}

		maj_map();
	}

	/*
	 * public void prendO(){ for(int i=0;jeu.nbObjet()>i;i++){
	 * 
	 * if(jeu.getObjet(i).getPosition()==jeu.monJoueur.getPosition() &&
	 * jeu.getObjet(i) instanceof Cle){
	 * 
	 * Objet o=jeu.getObjet(i); x=0; while(tabObjet[x]!=null){ x++; } if(x<4){
	 * tabObjet[x]=o;
	 * 
	 * maj_inv(); Cle cn= (Cle) jeu.getObjet(i);
	 * System.out.println("Vous avez pris la clé "+cn.getNumero()); o.pris(); }
	 * 
	 * }
	 */

	public void fight() {

		Joueur player = jeu.monJoueur;
		for (int i = 0; i < jeu.nbIndividu(); i++) {
			if (jeu.getIndividu(i).getPosition() == player.getPosition() && jeu.getIndividu(i) instanceof Monstre) {
				Monstre monstre = (Monstre) jeu.getIndividu(i);
				int sommeForce = jeu.monJoueur.getForce() + monstre.getForce();

				int forceCombat = (int) (Math.random() * sommeForce);
				//System.out.println("p: " + player.getForce() + " m :" + forceCombat);
				if (forceCombat > player.getForce()) {
					player.setVie(player.getVie() - 1);
					refresh_vie();
					label.setText("Le monstre vous inflige des dégâts");
					vieperdu_wav.play();
					if (player.getVie() == 0) {
						this.setVisible(false);
						mainsong_wav.stop();
						fenetreperdu.setVisible(true);
						gameover_wav.play();
						
					}
				} else {
					label.setText("Vous avez vaincu le monstre");
					monstre.setPosition(null);
					//(int)( Math.random()*( max - mini + 1 ) ) + mini;
					//Sound.force_wav.play();
				}

			}
		}
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		boolean dep = true;
		if (e.getSource() == PoNord) {

			if (test != -1) {
				open('N', test);
			} else {
				for (int i = 0; i < jeu.nbIndividu(); i++) {
					if (jeu.getIndividu(i) instanceof Monstre
							&& jeu.getIndividu(i).getPosition() == jeu.monJoueur.getPosition()) {
						dep = false;
					}
				}
				if (dep) {
					deplacement('N');
					maj_map();
					maj_inv();
				}

			}
		}
		if (e.getSource() == PoOuest) {
			if (test != -1) {
				open('O', test);

			} else {
				for (int i = 0; i < jeu.nbIndividu(); i++) {
					if (jeu.getIndividu(i) instanceof Monstre
							&& jeu.getIndividu(i).getPosition() == jeu.monJoueur.getPosition()) {
						dep = false;
					}
				}
				if (dep) {
					deplacement('O');
					maj_map();
					maj_inv();
				}
			}

		}

		if (e.getSource() == PoEst) {
			if (test != -1) {
				open('E', test);

			} else {
				for (int i = 0; i < jeu.nbIndividu(); i++) {
					if (jeu.getIndividu(i) instanceof Monstre
							&& jeu.getIndividu(i).getPosition() == jeu.monJoueur.getPosition()) {
						dep = false;
					}
				}
				if (dep) {
					deplacement('E');
					maj_map();
					maj_inv();
				}
			}
		}

		if (e.getSource() == PoSud) {
			if (test != -1) {
				open('S', test);

			} else {
				for (int i = 0; i < jeu.nbIndividu(); i++) {
					if (jeu.getIndividu(i) instanceof Monstre
							&& jeu.getIndividu(i).getPosition() == jeu.monJoueur.getPosition()) {
						dep = false;
					}
				}
				if (dep) {
					deplacement('S');
					maj_map();
					maj_inv();
				}
			}
		}
		if (e.getSource() == bObjet0) {
			trueDropAndUse();
			iObjet = 0;
		}
		if (e.getSource() == Cle) {
			int x = -1;
			for (int i = 0; jeu.nbObjet() > i; i++)
				if (jeu.getObjet(i).getPosition() == jeu.monJoueur.getPosition() && jeu.getObjet(i) instanceof Cle) {
					x = i;

				}

			prendO(x);

		}
		if (e.getSource() == bObjet1) {
			trueDropAndUse();
			iObjet = 1;
		}
		if (e.getSource() == bObjet2) {
			trueDropAndUse();
			iObjet = 2;
		}
		if (e.getSource() == bObjet3) {
			trueDropAndUse();
			iObjet = 3;
		}

		if (e.getSource() == use) {
			use(iObjet);
			falseDropAndUse();
		}
		if (e.getSource() == drop) {
			drop(iObjet);
			falseDropAndUse();
			maj_map();
		}
		if (e.getSource() == Tresor) {
			gagne();
		}

		if (e.getSource() == Nourriture) {
			int x = -1;
			for (int i = 0; jeu.nbObjet() > i; i++)
				if (jeu.getObjet(i).getPosition() == jeu.monJoueur.getPosition()
						&& jeu.getObjet(i) instanceof Nourriture) {
					x = i;
				}

			prendO(x);
		}
		if (e.getSource() == Medicament) {
			int x = -1;
			for (int i = 0; jeu.nbObjet() > i; i++)
				if (jeu.getObjet(i).getPosition() == jeu.monJoueur.getPosition()
						&& jeu.getObjet(i) instanceof Medicament) {
					x = i;

				}

			prendO(x);

		}
		if (e.getSource() == Medecin) {
			regenHp();
			refresh_vie();
		}
		if (e.getSource() == Cuisinier) {
			regenStamina();
			refresh_force();
		}
		if (e.getSource() == Monster) {
			fight();
			maj_map();
		}
		if (e.getSource() == btnQuitter) {
			fenetreperdu.setDefaultCloseOperation(EXIT_ON_CLOSE);
			System.exit(0);
		}
		if (e.getSource() == btnQuitter2) {
			fenetregagner.setDefaultCloseOperation(EXIT_ON_CLOSE);
			System.exit(0);

		}

		if (e.getSource() == PPS) {

			PiecePassageSecret p = (PiecePassageSecret) jeu.monJoueur.getPosition();
			jeu.monJoueur.setPosition(p.pieceVoisine('s'));
			maj_map();

		}

	}
}