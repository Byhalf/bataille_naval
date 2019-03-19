package modele.bateau;

import modele.*;

public class Bateau{
	private int x, y, x1, y1, taille;
	private Direction dir;
	private int[][] caseTouchee={{}};

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

	public setCaseTouchee(int[][] caseTouchee){
		this.caseTouchee=caseTouchee;
	}

	public getCaseTouchee(){
		return this.caseTouchee;
	}

	public getCoord(dir){
		int[][] tab={{}};
		for (int i=0; i<getTaille(); i++){
			if (dir.values==HORIZONTALE){
				tab[i]={this.getX()+1*i,this.getY()};
			}
			else{
				tab[i]={this.getX(),this.getY()+1*i};
			}
		}
		return tab;
	}

	public boolean estTouche(x1,y1){
		for (int j=0; j<this.caseTouchee.length; j++){
			if (getCaseTouchee()[j]=={x1,y1}){
				break;// Ajouter une exception (try catch)
			}
		coord=this.getCoord(dir);
		for (int i=0; i<coord; i++){
			if ({x1,y1}==coord[i]){
				this.setCaseTouchee({x1,y1});
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
