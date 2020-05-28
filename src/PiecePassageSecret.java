//package WindowBuilder.src;

import java.util.Scanner;

public class PiecePassageSecret extends Piece{
	
	private Piece passageSecret;
	private Scanner sc;
	
	public void affiche()
	{
		super.affiche();
		System.out.println("Passage secret");
	}
	
	public void ajoutPassageSecret(Piece p)
	{
		passageSecret = p;
	}
	
	public Piece pieceVoisine()
	{
		sc = new Scanner(System.in);
		System.out.println("Tapez une lettre (N (Nord), E (Est), S (Sud), O (Ouest), s (secret)");
		String s = sc.next();
		char r = s.charAt(0);
		// renvoie pièce 
		return pieceVoisine(r);
	}
	
	public Piece pieceVoisine(char r)
	{
		if (r=='s')
			return passageSecret;
		else
			return super.pieceVoisine(r); // pièce voisine de la classe Piece
	}
	
}
