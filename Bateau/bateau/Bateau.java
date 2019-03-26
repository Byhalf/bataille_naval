package bateau;

import java.util.ArrayList;

public class Bateau{
	private int x, y, taille;
	private ArrayList<Coordonnees> coordonnees = new ArrayList<Coordonnees>();

	public Bateau(int x, int y, int taille, Direction dir){
		this.x=x;
		this.y=y;
		this.taille=taille;
		this.coordonnees=getCoord(dir);
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getTaille(){
		return this.taille;
	}

	public ArrayList<Coordonnees> getCoord(Direction dir){
		for (int i=0; i<getTaille(); i++){
			if (dir==Direction.HORIZONTALE){
				coordonnees.add(new Coordonnees(this.getX()+1, this.getY()));
			}
			else{
				coordonnees.add(new Coordonnees(this.getX(), this.getY()+1));
			}
		}
		return coordonnees;
	}

	public boolean estTouche(int x1, int y1){
		for (int i=0; i<coordonnees.size(); i++){
			if (coordonnees.get(i)==(new Coordonnees(x1,y1))){
				break;// Ajouter une exception (try catch)
			}
			if (new Coordonnees(x1,y1)==coordonnees.get(i)){
				coordonnees.set(i, new Coordonnees(x1,y1));
				return true;
			}
		}
		return false;
	}

	public boolean estCoule(){
		if (coordonnees.size()==this.getTaille()){
			return true;
		}
		return false;
	}
}
