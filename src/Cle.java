//package WindowBuilder.src;

/**
 * classe Cle gère les objets de type clé
 * une clé numéo i permet d'ouvrir une porte numéro i
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
		System.out.println("cle numéroté : "+numero);
	}

	public int getNumero()
	{
		return numero;
	}
}
