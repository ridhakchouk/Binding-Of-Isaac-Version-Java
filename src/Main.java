

public class Main { 

	
	//private Individu[] tabIndividu;
	Objet[] tabObjet;

	
	//private Joueur monJoueur;
	
	public static void main(String[] args) 
	{

			// les pièces
			Piece P1 = new Piece();
			Piece P2 = new Piece();
			Piece P3 = new Piece();
			Piece P4 = new Piece();
			Piece P5 = new Piece();
			Piece P6 = new Piece();
			Piece P7 = new Piece();
			Piece P8 = new Piece();
			Piece P9 = new Piece();
			Piece P10 = new Piece();
			Piece P11 = new Piece();
			Piece P12 = new Piece();
			Piece P13 = new Piece();
			Piece P14 = new Piece();
			Piece P15 = new Piece();
			Piece P16 = new Piece();
			Piece P17 = new Piece();
			PiecePassageSecret PPS1 = new PiecePassageSecret();
			PiecePassageSecret PPS2 = new PiecePassageSecret();
			// les portes
			Porte Po1 = new Porte();
			Porte Po2 = new Porte();
			Porte Po3 = new Porte(); // false
			Porte Po4 = new Porte();
			Porte Po5 = new Porte(1);
			Porte Po6 = new Porte();
			Porte Po7 = new Porte();
			Porte Po8 = new Porte();
			Porte Po9 = new Porte();
			Porte Po10 = new Porte(2);
			Porte Po11 = new Porte();
			Porte Po12 = new Porte();
			Porte Po13 = new Porte();
			Porte Po14 = new Porte();
			Porte Po15 = new Porte();
			Porte Po16 = new Porte();
			Porte Po17 = new Porte(3);
			Porte Po18 = new Porte();

			// relier les porte au piece
			// Passage secret
			// PPS1
			PPS1.ajoutPassageSecret(P2);
			// PPS2
			PPS2.ajoutPassageSecret(PPS1);
			// P1
			P1.ajoutPorte(Po1, P2, "Nord");
			// P2
			P2.ajoutPorte(Po2, P3, "Ouest");
			P2.ajoutPorte(Po5, P5, "Est");
			P2.ajoutPorte(Po10, P10, "Nord");
			// P3
			P3.ajoutPorte(Po3, P4, "Ouest");
			// P4
			P4.ajoutPorte(Po4, PPS1, "Nord");
			// P5
			P5.ajoutPorte(Po6, P6, "Est");
			P5.ajoutPorte(Po7, P7, "Nord");
			// P7
			P7.ajoutPorte(Po8, P8, "Nord");
			// P8
			P8.ajoutPorte(Po9, P9, "Est");
			// P10
			P10.ajoutPorte(Po11, P11, "Nord");
			// P11
			P11.ajoutPorte(Po12, P12, "Nord");
			// P12
			P12.ajoutPorte(Po13, P13, "Est");
			P12.ajoutPorte(Po16, PPS2, "Nord");
			P12.ajoutPorte(Po17, P16, "Ouest");
			// P13
			P13.ajoutPorte(Po14, P14, "Est");
			// P14-
			P14.ajoutPorte(Po15, P15, "Nord");
			// P16
			P16.ajoutPorte(Po18, P17, "Ouest");

			// individus
			Joueur j = new Joueur(P1);
			Monstre m1 = new Monstre(P3);
			Monstre m2 = new Monstre(P16);
			Monstre m3 = new Monstre(P13);
			Monstre m4 = new Monstre(P7);
			Cuisinier c1 = new Cuisinier(P6);
			Cuisinier c2 = new Cuisinier(P15);
			Medecin m = new Medecin(P6);
			// Individu tabI[] = {m1,m2,c1,m};

			// objets
			Cle cl1 = new Cle(PPS1, 1);
			Cle cl2 = new Cle(P9, 2);
			Cle cl3 = new Cle(P15, 3);
			Nourriture n1 = new Nourriture(P4);
			Nourriture n2 = new Nourriture(P11);
			
			Medicament me1 = new Medicament(P12);
			Tresor t = new Tresor(P17);
			// Objet tabO[] = {cl1,cl2,cl3,n1,me1,t};

			// test
			Objet tabO[] = { cl1, cl2, cl3, t, n1, me1,n1,n2 };
			Individu tabI[] = { c1,c2, m, m1,m2,m3,m4};

			Jeu jeu = new Jeu(tabI, tabO, j);

			// System.out.println(jeu.getObjet(0).getPosition());
			Window fenetre = new Window(jeu);

			fenetre.maj_map();
			fenetre.maj_inv();
			fenetre.refresh_vie();
			fenetre.refresh_force();
			fenetre.falseDropAndUse();
			fenetre.setVisible(true);

			/*
			 * while (!jeu.gagne() && !jeu.perdu()) { jeu.affiche(); jeu.menu(); }
			 */
			if (jeu.gagne())
				System.out.println("Bravo vous avez Gagné");

			if (jeu.perdu() == true) {
				System.out.println("vous avez perdu");
				System.exit(0);
			}
			
	}
		
	
	
		
}
