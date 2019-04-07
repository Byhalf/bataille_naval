package modele;

import modele.bateau.Bateau;
import modele.joueurs.Joueur;
import modele.utilities.AbstractModeleEcouteur;
import modele.utilities.Coordonnees;

public class Modele extends AbstractModeleEcouteur {
    public Mer getMer() {
        return mer;
    }

    private Mer mer;
//rechanger déclaration Joeur en humain ou aléatoire une fois les tests fini, plus propre.
    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    private Joueur joueur1;
    private Joueur joueur2;

    public Modele(){
        joueur1 = new Joueur("alea");
        joueur2 = new Joueur("robot");



        mer = new Mer(joueur1, joueur2);

    }


    public void placerBateau(Joueur joueur, Bateau choix) {
        if (joueur.placerBateau(choix))
            fireChangement();
    }

    public void tirer(Joueur joueur, Coordonnees choix) {
        if (mer.tirez(choix, joueur))
            fireChangement();
    }


    public Joueur getAutreJoueur(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }


}
