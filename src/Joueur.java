//package WindowBuilder.src;


import java.util.Scanner;


public class Joueur extends Individu  {
	private final int  DEBUT = 10; 
	private int force;
	private int vie;
	private static Objet[] tabObjet;
	static Scanner sc = new Scanner(System.in);
	

	public Joueur(Piece p)
	{
		super(p);
		force = DEBUT;
		vie = DEBUT;
		tabObjet = new Objet[4];
	}
	
	
	
	public Objet[] getTabObjet() {
		return tabObjet;
	}



	public void deplacer()
	{
		super.deplacer();
		force--;
		// action en foction des personnages présent dans la pièce
	}
	
	public void affiche()
	{
	  System.out.println();
	  System.out.println("JOUEUR force : "+force+" et de point de vie : "+vie);	
	  int nbobj = 0;
	  // objet du joueur
	  for( int i=0; i<tabObjet.length; i++)
		  if (tabObjet[i]!=null)
		  {
			System.out.print("Objet en "+i+ " : ");
			tabObjet[i].affiche();
			nbobj++;
		  }
	  if (nbobj==0)
		  System.out.println("pas d'objet sur le joueur");
	  // pièce
	  System.out.println("Dans la pièce du joueur");
	  super.affiche();
	}
	
	// prendre objet et le mettre à l'indice i
	public void prendreObjet(Jeu jeu)
	{
		
		Objet o;
		System.out.println("quel numéro d'objet ? (entre 0 et "+(jeu.nbObjet()-1)+")");
		int no = sc.nextInt();
		while (no<0 || no>=jeu.nbObjet() )
		{
			System.out.println("quel numéro d'objet ? (entre 0 et "+ (jeu.nbObjet()-1)+")");
			no = sc.nextInt();
		}
			
		if (jeu.getObjet(no) != null)
		{
			o = jeu.getObjet(no);
			if (o.getPosition() == getPosition())
			{
				System.out.println("A quelle place voulez vous mettre votre objet ? (0,1,2,3)");
				int i = sc.nextInt();
				// si à cet indice, il y a déjà un objet le poser
				if(tabObjet[i]!=null)
				{
					System.out.println("depose de l'objet en "+i+" dans cette pièce");
					poserObjet(i);
				}
				tabObjet[i]=o;
				o.pris(); // la position de l'objet devient null
			}
			else
			{
				System.out.println("Erreur l'objet et le joueur ne sont pas dans la même pièce");
			}
		}
		else
			System.out.println("pas d'objet en "+no);
	}
	

	
	// poser l'objet à l'indice i
	public void poserObjet(int i)
	{
		if(tabObjet[i]!=null)
		{
			Objet o = tabObjet[i];
			o.setPosition(getPosition()); // donne à l'objet la position du joueur
			System.out.print("depose de ");
			o.affiche();
		}
		else
			System.out.println("pas d'objet en "+i);
	}
	
	// poser l'objet
	public void poserObjet()
	{
		System.out.println("quel est l'indice de l'objet à poser ? (de 0 à 3)");
		int i = sc.nextInt();
		while(i>3 || i<0)
		{
			System.out.println("quel est l'indice de l'objet à poser ? (de 0 à 3)");
			i = sc.nextInt();
		}
		poserObjet(i);
	}
	/*public void ouvrirPorte()
	{
		System.out.println("quel porte désirez vous ouvrir ? (N, E, S, O)");
		String s = sc.next();
		char r = s.charAt(0);
		Porte po = getPosition().getPorte(r);
		if (po == null)
			System.out.println("Pas de porte "+r+".");
		else
		{
			if (po.getFermer()) // porte fermée
			{
				int numPorte = po.getNumero();
				// recherche si le joueur à une clé avec le même numéro dans tabObjet
				boolean memeNum = false;
				for (int i=0; i<4; i++)
				{
					if (tabObjet[i]!=null && tabObjet[i].getClass().getName().equals("Cle") )
					{
						Cle c = (Cle) tabObjet[i];
						if (c.getNumero() == numPorte)
							memeNum = true;
					}
				}
				// si le joueur a la clé
				if (memeNum)
				{
					po.ouvrir();
					System.out.println("la porte "+r+" est maintenant ouverte");
				}
				else
					System.out.println("le joueur n'a pas la clé");
			}
			else
				System.out.println("la porte est déjà ouverte");
		}
	}*/
	
	// renvoie l'objet en i
	public Objet objetI() 
	{
		int i;
		do
		{
			System.out.println("quel objet désirez vous ? (numéro de 0 à 3)");
			i = sc.nextInt();
		} while (i<0 || i>3);
		return tabObjet[i];
	}
	
	public void manger()
	{
		System.out.println("Manger");
		Objet o = objetI();
		// Si cet objet est de la nourriture
		if (o!=null && o.getClass().getName().equals("Nourriture"))
		{
			Nourriture n = (Nourriture) o;
			force = Math.min(force+ n.getForce(), DEBUT); // calcule de la force du joueur
			System.out.println("la force est maintenant de "+force);
			o=null; // suppression de la nourriture
		}
		else
			System.out.println("l'objet n'est pas de la nourriture");	
	}
	
	public void soigner()
	{
		System.out.println("Soigner");
		Objet o = objetI();
		// Si cet objet est un médicament
		if (o!=null && o.getClass().getName().equals("Medicament"))
		{
			Medicament m = (Medicament) o;
			vie = Math.min(vie+ m.getVie(), DEBUT); // calcule des points de vie du joueur
			System.out.println("Les points de vie sont maintenant de "+vie);
			o=null; // suppression du médicament
		}
		else
			System.out.println("l'objet n'est pas de la nourriture");			
	}
	
	public void combat(Monstre m)
	{
		if(getPosition() == m.getPosition())
		{
			System.out.println("Combat");
			int sommeForce = force + m.getForce();
			int tirage =(int) (Math.random()*sommeForce );
			System.out.println("tirage : "+tirage);
			if (tirage < force) // si tirage compris entre 0 et force le joueur gagne
			{
				System.out.println("Joueur gagne");
			}
			else // si tirage compris entre force et (force + force du monstre) le monstre gagne
			{
				System.out.println("Monstre gagne");
				vie--;
			}	
		}
	}
	
	public void guerir()
	{
		System.out.println("Guerir");
		vie = DEBUT;
	}
	
	public void nourrir()
	{
		System.out.println("Nourrir");
		force = DEBUT;
	}

	public int getForce() {
		return force;
	}

	public int getVie() {
		return vie;
	}



	public void setForce(int force) {
		this.force = force;
	}



	public void setVie(int vie) {
		this.vie = vie;
	}
	
	
	
	
	
}
