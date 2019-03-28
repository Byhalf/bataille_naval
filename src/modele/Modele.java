package modele;

import modele.joueurs.*;
import modele.joueurs.Aleatoire;
import modele.joueurs.Humain;
import java.util.ArrayList;
import modele.Mer;
import modele.utilities.Coordonnees;
import modele.utilities.EcouteurModele;
import modele.utilities.ModeleEcouteur;

public class Modele {
    public Mer getMer() {
        return mer;
    }

    private Mer mer;

    public Humain getJoueur1() {
        return joueur1;
    }

    public Aleatoire getJoueur2() {
        return joueur2;
    }

    private Humain joueur1;
    private Aleatoire joueur2;

    public Modele(){
        joueur1 = new Humain("humain");
        joueur2 = new Aleatoire("robot");

        //5 bateaux 1-2 2-3 1-4 1-5
        ArrayList<Integer> typeFlotte = new ArrayList<Integer>();
        typeFlotte.add(new Integer(2));
        typeFlotte.add(new Integer(3));
        typeFlotte.add(new Integer(3));
        typeFlotte.add(new Integer(4));
        typeFlotte.add(new Integer(5));

        mer = new Mer(joueur1, joueur2);
        mer.placerFlotte(joueur1,typeFlotte);
        mer.placerFlotte(joueur2,typeFlotte);
    }

    public void joueurTour(Joueur joueur){
        Coordonnees choix = joueur.choixTir();
        mer.tirez(choix, joueur);
    }


    public Joueur getAutreJoueur(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }

/*
    public void joueUnePartie(){
        Joueur joueurCourant = joueur1;
        while(!mer.estFini()){
            Coordonnees choix = joueurCourant.choixTir();
            mer.tirez(choix,joueurCourant);
            joueurCourant = getAutreJoueur(joueurCourant);
        }
    }
    */
}
