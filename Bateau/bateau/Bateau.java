package bateau;

import Array<>;

public class Bateau{
	private int x, y, x1, y1, taille;
	private String direction;
	private Array<int> tab=new Array();

	public Bateau(int x, int y, int x1, int y1, int taille, String direction, Array<int> tab){
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
		this.taille=taille;
		this.direction=direction;
		this.tab=tab;
	}

	public void estTouche(x,y,x1,y1){
		tab=[]
		if (this.x==this.x1 && this.y==this.y1){
			System.out.println("Bateau touché");
			tab.add(1);
		}
		else{
			System.out.println("Raté");
		}
	}

	public void estCoule(tab, taille){
		if (this.tab.length==this.taille){
			System.out.println("Bateau coulé");
		}
	}
}
