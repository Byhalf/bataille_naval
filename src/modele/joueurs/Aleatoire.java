package modele.joueurs;


import java.util.Random;

public class Aleatoire extends Joueur {

	Random randomGenerator;

	public Aleatoire(String name) {
		super(name);
		this.randomGenerator = new Random();
	}

	public int[] Mouvement() {
		int res[] = new int[2];
		int rndX = randomGenerator.nextInt(11);
		res[0] = rndX;
		int rndy = randomGenerator.nextInt(11);
		res[1] = rndy;
		return(res);
	}

}