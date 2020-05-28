//package WindowBuilder.src;


public class Porte {
	private int numero;
	private Piece devant;
	private Piece derriere;
	private boolean fermer;
	
	Porte(){
		fermer=false;
	}
	
	Porte(int num){
		numero=num;
		fermer= true;
	}
	
	public void affiche(){
		if(fermer){
			System.out.println("la porte est fermer avec la cle n°: "+numero);
		}
		else{
			System.out.println("la porte est ouverte");
		}
	}
	
	public void ajoutPiece(Piece p1,Piece p2){
		devant= p1;
		derriere=p2;
	}
	
	public Piece autrePiece(Piece p){
		if (devant==p){
			return derriere;
		}
		else{
			return devant;
		}
	}
	
	public void ouvrir(){
		fermer=false;
	}

	public boolean getFermer(){
		return fermer;
	}

	public int getNumero() {
		return numero;
	}
	
	
	
}
