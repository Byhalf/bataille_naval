package ControleurJoueur;

import modele.Mer;
import modele.Modele;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;
import vue.GameVue;

import java.util.ArrayList;
import java.util.Random;

public class JoueurSwing extends Controleur {
    private GameVue gameVue;
    private Modele modele;
    int TAILLE_GRILLE = 10;
    private Random randomGenerator = new Random();

    public JoueurSwing(Joueur joueurControle, GameVue gameVue, Modele modele) {
        super(joueurControle);
        this.gameVue = gameVue;
        this.modele = modele;
    }

    @Override
    public Coordonnees choixTir() {
        return new Coordonnees(0, 0);
    }

    @Override
    public Bateau choixPlacement(int taille, Mer mer) {
        ArrayList<Bateau> possibleRes = new ArrayList<>();
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                Bateau bateau = new Bateau(new Coordonnees(i, j), taille, Direction.HORIZONTALE);
                if (mer.estPlacable(getJoueurControle(), bateau))
                    possibleRes.add(bateau);
                bateau = new Bateau(new Coordonnees(i, j), taille, Direction.VERTICALE);
                if (mer.estPlacable(getJoueurControle(), bateau))
                    possibleRes.add(bateau);
            }
        }
        return possibleRes.get(randomGenerator.nextInt(possibleRes.size()));
    }


}
