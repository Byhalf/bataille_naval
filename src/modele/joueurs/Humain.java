package modele.joueurs;

import modele.Mer;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.utilities.Coordonnees;

import java.util.Scanner;

public class Humain extends Joueur {
	

	public Humain(String name){
		super(name);
	}

	@Override
	public Coordonnees choixTir(){
		int res[] = new int[2];
		int x, y;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Coordonees x ?");
		x = scanner.nextInt();
		System.out.println("Coordonees y ?");
		y = scanner.nextInt();
		return(new Coordonnees(x,y));
	}

	//Choix placement prendra 2 coordonné donné par le controleur.
	@Override
	public Bateau choixPlacement(int taille, Mer mer) {
		int x, y, z;
		Direction d;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Coordonees x ?");
		x = scanner.nextInt();
		System.out.println("Coordonees y ?");
		y = scanner.nextInt();
		System.out.println("direction?0=droite,1=bas");
		z = scanner.nextInt();
		if(z==0)
			d = Direction.HORIZONTALE;
		else
			d = Direction.VERTICALE;
		Coordonnees coord = new Coordonnees(x,y);
		return new Bateau(coord,taille,d);
	}

	public String getName() {
		return this.name;
	}
}
		