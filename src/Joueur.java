import java.util.Scanner;

public class Joueur{
	
	Bateau bateau[][] = new Bateau[10][10];

	public boolean placerBateau(int x, int y, Direction d, Bateau bat){
		int coordBateau[][] = bat.getCoord(d);
		if(estPlacable(x,y,d, bat)){
			for(int[] coord:coordBateau){
				bateau[coord[0]][coord[1]] = bat;
			}return true;
		}return false;
	}
		
		

}