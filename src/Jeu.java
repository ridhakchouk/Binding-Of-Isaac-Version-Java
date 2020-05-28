//package WindowBuilder.src;

import java.util.Scanner;

public class Jeu {

	private Individu[] tabIndividu;
	private Objet[] tabObjet;
	Joueur monJoueur;

	public Jeu(Individu[] ti, Objet[] to, Joueur mj) {
		tabIndividu = ti;
		tabObjet = to;
		monJoueur = mj;
	}

	public void affiche() {
		monJoueur.affiche();
		Piece p = monJoueur.getPosition();
		int nbi = 0, nbo = 0;
		System.out.println("Individu(s) dans la pièce");
		for (int i = 0; i < tabIndividu.length; i++) {
			// affichage des individus dans la même pièce que le joueur
			if (tabIndividu[i].getPosition() == p) {
				tabIndividu[i].affiche();
				nbi++;
			}
		}
		if (nbi == 0)
			System.out.println("\tPas d'individu dans la pièce");

		System.out.println("Objet(s) dans la pièce");
		for (int i = 0; i < tabObjet.length; i++) {
			// affichage des objets dans la même pièce que le joueur
			if (tabObjet[i].getPosition() == p) {
				System.out.print("objet " + i + " : ");
				tabObjet[i].affiche();
				nbo++;
			}
		}
		if (nbo == 0)
			System.out.println("\tPas d'objet dans la pièce");
	}

	public Objet getObjet(int i) {
		return tabObjet[i];
	}

	public Individu getIndividu(int i) {
		return tabIndividu[i];
	}

	public int nbObjet() {
		return tabObjet.length;
	}

	public int nbIndividu() {
		return tabIndividu.length;
	}

	public void rencontrerIndividu() {
		Piece positionJoueur = monJoueur.getPosition();
		// pour tout les individu
		for (int i = 0; i < tabIndividu.length; i++)
			// si même pièce
			if (tabIndividu[i].getPosition() == positionJoueur) {
				// si monstre
				if (tabIndividu[i].getClass().getName().equals("Monstre")) {
					Monstre m = (Monstre) tabIndividu[i];
					monJoueur.combat(m);
				}
				// si medecin
				if (tabIndividu[i].getClass().getName().equals("Medecin"))
					monJoueur.guerir();
				// si cuisinier
				if (tabIndividu[i].getClass().getName().equals("Cuisinier"))
					monJoueur.nourrir();
			}
	}

	/*
	 * renvoie vrai si le joueur et le trésor sont dans la même pièce
	 */
	public boolean gagne() {
		boolean test = false;
		Piece positionJoueur = monJoueur.getPosition();
		for (int i = 0; i < tabObjet.length; i++)
			if (tabObjet[i].getPosition() == positionJoueur) {
				Objet o = tabObjet[i];
				if (o.getClass().getName().equals("Tresor"))
					test = true;
			}
		return test;
	}

	/*
	 * Perdu si point de vie ou de force Nul
	 */
	public boolean perdu() {
		boolean test = false;
		if (monJoueur.getVie() == 0)
			test = true;
		if (monJoueur.getForce() == 0)
			test = true;
		return test;
	}

	/*
	 * Menu du jeu
	 */
	public void menu() {
		System.out.println("Tapez une lettre");
		System.out.println("\tse Déplacer : D");
		System.out.println("\tOuvrir porte : O");
		System.out.println("\tPrendre objet : P");
		System.out.println("\tposer objet : Q");
		System.out.println("\tManger : M");
		System.out.println("\tse Soigner : S");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char r = s.charAt(0);

		switch (r) {
		case 'D':
			monJoueur.deplacer();
			rencontrerIndividu();
			break;
		case 'P':
			monJoueur.prendreObjet(this);
			break;
		case 'M':
			monJoueur.manger();
			break;
		case 'O':
			// monJoueur.ouvrirPorte();
			break;
		case 'Q':
			monJoueur.poserObjet();
			break;
		case 'S':
			monJoueur.soigner();
			break;
		}
		sc.close();
	}

	/*
	 * public static void main(String[] args) { // les pièces Piece p1 = new
	 * Piece(); Piece p2 = new Piece(); Piece p3 = new Piece(); Piece p4 = new
	 * Piece(); Piece p5 = new Piece(); Piece p6 = new Piece(); Piece p7 = new
	 * Piece(); PiecePassageSecret p8 = new PiecePassageSecret(); // les portes
	 * Porte po1 = new Porte(); Porte po2 = new Porte(3); Porte po3 = new
	 * Porte(); Porte po4 = new Porte(2); Porte po5 = new Porte(); Porte po6 =
	 * new Porte(); Porte po7 = new Porte(2); Porte po8 = new Porte(3); // ajout
	 * de portes aux pièces p1.ajoutPorte(po1, p2, "Est"); p1.ajoutPorte(po2,
	 * p5, "Nord"); p2.ajoutPorte(po3, p3, "Est"); p3.ajoutPorte(po4, p4,
	 * "Est"); p5.ajoutPorte(po5, p6, "Est"); p6.ajoutPorte(po6, p7, "Est");
	 * p6.ajoutPorte(po7, p8, "Nord"); p7.ajoutPorte(po8, p3, "Sud");
	 * p8.ajoutPassageSecret(p3); // individus Joueur j = new Joueur(p8);
	 * Monstre m1 = new Monstre(p7); Monstre m2 = new Monstre(p8); Cuisinier c1
	 * = new Cuisinier(p2); Medecin m = new Medecin(p4); Individu tabI[] =
	 * {m1,m2,c1,m};
	 * 
	 * // objets Cle cl1 = new Cle(p6,1); Cle cl2 = new Cle(p7,3); Cle cl3 = new
	 * Cle(p6,2); Nourriture n1 = new Nourriture(p6); Medicament me1 = new
	 * Medicament(p6); Tresor t = new Tresor(p7); Objet tabO[] =
	 * {cl1,cl2,cl3,n1,me1,t};
	 * 
	 * Jeu monJeu = new Jeu(tabI,tabO,j);
	 * 
	 * while (!monJeu.gagne() && !monJeu.perdu()) { monJeu.affiche();
	 * monJeu.menu(); } if(monJeu.gagne())
	 * System.out.println("Bravo vous avez Gagné"); else
	 * System.out.println("vous avez perdu"); }
	 */

}
