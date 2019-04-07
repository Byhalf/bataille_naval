package ControleurJoueur;

import modele.Mer;
import modele.bateau.Bateau;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;

public abstract class Controleur {

    private Joueur joueurControle;

    public Joueur getJoueurControle() {
        return joueurControle;
    }


    public Controleur(Joueur joueurControle) {
        this.joueurControle = joueurControle;
    }

    public abstract Bateau choixPlacement(int taille, Mer mer);

    public abstract Coordonnees choixTir();
}
