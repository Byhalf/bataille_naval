package games;

import java.util.Scanner;

public class Humain extends Joueur{
	
	public String name;

	public Humain(String name){
		this.name = name;
	}
	
	public int[] Mouvement(){
		int res[] = new int[2];
		int x, y;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Coordonees x ?");
		x = scanner.nextInt();
		res[0]=x;
		System.out.println("Coordonees y ?");
		y = scanner.nextInt();
		res[1]=y;
		return(res);
	}

	public String getName() {
		return this.name;
	}
}
		