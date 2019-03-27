package modele.utilities;

public class Coordonnees{
	private int x,y;

	public Coordonnees(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public boolean compare(Coordonnees coordAComparer){
		if(getX()==coordAComparer.getX() && getY()==coordAComparer.getY())
			return true;
		return false;
	}
}
