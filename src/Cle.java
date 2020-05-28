//package WindowBuilder.src;

/**
 * classe Cle g�re les objets de type cl�
 * une cl� num�o i permet d'ouvrir une porte num�ro i
 * @author : thomas devogele 
 * @see : Porte
 */

public class Cle extends Objet{
	
	private int numero;
	
	public Cle (Piece p, int n)
	{
		super(p);
		numero = n;
	}
	
	public void affiche()
	{
		System.out.println("cle num�rot� : "+numero);
	}

	public int getNumero()
	{
		return numero;
	}
}
