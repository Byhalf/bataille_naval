package modele.joueurs;


import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.utilities.Coordonnees;

import java.util.Random;

public class Aleatoire extends Joueur {

	Random randomGenerator;

	public Aleatoire(String name) {
		super(name);
		this.randomGenerator = new Random();
	}

	public int[] Mouvement() {
		int res[] = new int[2];
        int rndX = randomGenerator.nextInt(TAILLE_GRILLE + 1);
		res[0] = rndX;
        int rndy = randomGenerator.nextInt(TAILLE_GRILLE + 1);
		res[1] = rndy;
		return(res);
	}

	//pour que ça compile quand je teste c'est les méthodes à changer
	@Override
	public Coordonnees choixTir(){

		return(new Coordonnees(0,0));
	}

	@Override
	public Bateau choixPlacement(int taille) {

		return new Bateau(0,0,taille,Direction.HORIZONTALE);
	}


}