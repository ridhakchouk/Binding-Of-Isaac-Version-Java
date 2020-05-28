//package WindowBuilder.src;


public abstract class Individu {
	private Piece position;
	
	public Individu(Piece p)
	{
		position = p;
	}
	
	public void affiche()
	{
		position.affiche();
	}
	
	public void deplacer()
	{
		position = position.pieceVoisine();
	}

	public Piece getPosition()
	{
		return position;
	}

	public void setPosition(Piece position) {
		this.position = position;
	}
	
	
	
	
}
