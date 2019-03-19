package bateau;

import java.util.*;

public class Bateau{
	private int x, y, x1, y1, taille;
	private Direction dir;
	public int[][] caseTouchee={{}};

	public Bateau(int x, int y, int x1, int y1, int taille, Direction dir, int[][] caseTouchee){
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
		this.taille=taille;
		this.dir=dir;
		this.caseTouchee=caseTouchee;
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

	public void setCaseTouchee(int[][] caseTouchee){
		this.caseTouchee=caseTouchee;
	}

	public int[][] getCaseTouchee(){
		return this.caseTouchee;
	}

	public int[][] getCoord(Direction dir){
		int[][] tab = new int[10][];
		for (int i=0; i<getTaille(); i++){
			if (dir==Direction.HORIZONTALE){
				tab[i]=new int[]{this.getX()+1*i,this.getY()};
			}
			else{
				tab[i]=new int[]{this.getX(),this.getY()+1*i};
			}
		}
		return tab;
	}

	public boolean estTouche(int x1, int y1){
		for (int j=0; j<this.caseTouchee.length; j++){
			if (getCaseTouchee()[j]==new int []{x1,y1}){
				break;// Ajouter une exception (try catch)
			}
		}
		coord=this.getCoord(dir);
		for (int i=0; i<coord; i++){
			if (new int []{x1,y1}==coord[i]){
				this.setCaseTouchee(new int []{x1,y1});
				return true;
			}
		}
		return false;
	}

	public boolean estCoule(){
		if (this.getCaseTouchee.length==this.getTaille()){
			return true;
		}
		return false;
	}
}
