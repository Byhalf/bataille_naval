package modele.joueurs;


import modele.Mer;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.utilities.Coordonnees;

import java.util.ArrayList;
import java.util.Random;

public class Aleatoire extends Joueur {

    private Random randomGenerator;
    private ArrayList<Coordonnees> caseATirer = new ArrayList<>();


	public Aleatoire(String name) {
		super(name);
		this.randomGenerator = new Random();
        initCaseATirer();
    }


    private void initCaseATirer() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                caseATirer.add(new Coordonnees(i, j));
            }
        }
    }

	//pour que ça compile quand je teste c'est les méthodes à changer
	@Override
	public Coordonnees choixTir(){
        int random = randomGenerator.nextInt(caseATirer.size());
        Coordonnees res = caseATirer.get(random);
        caseATirer.remove(res);
        return (res);
	}

	@Override
    public Bateau choixPlacement(int taille, Mer mer) {
        ArrayList<Bateau> possibleRes = new ArrayList<>();
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                Bateau bateau = new Bateau(new Coordonnees(i, j), taille, Direction.HORIZONTALE);
                if (mer.estPlacable(this, bateau))
                    possibleRes.add(bateau);
                bateau = new Bateau(new Coordonnees(i, j), taille, Direction.VERTICALE);
                if (mer.estPlacable(this, bateau))
                    possibleRes.add(bateau);
            }
        }
        return possibleRes.get(randomGenerator.nextInt(possibleRes.size()));
	}


}