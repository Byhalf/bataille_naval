package modele;

import modele.joueurs.Aleatoire;
import modele.joueurs.Humain;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

public class Modele  {
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
        joueur1 = new Humain("humain");
        joueur2 = new Aleatoire("robot");

        //5 bateaux 1-2 2-3 1-4 1-5
        ArrayList<Integer> typeFlotte = new ArrayList<Integer>();
        //typeFlotte.add(new Integer(2));
        //typeFlotte.add(new Integer(3));
        //typeFlotte.add(new Integer(3));
        //typeFlotte.add(new Integer(4));
        typeFlotte.add(new Integer(5));

        mer = new Mer(joueur1, joueur2);
        mer.placerFlotte(joueur1,typeFlotte);
        mer.placerFlotte(joueur2,typeFlotte);
    }


    public Joueur getAutreJoueur(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }


    public Joueur joueUnePartie(){
        Joueur joueurCourant = joueur1;
        while(!mer.estFini()){
            boolean bonTir = false;
            while(!bonTir){
                Coordonnees choix = joueurCourant.choixTir();
                bonTir = mer.tirez(choix, joueurCourant);
            }
            joueurCourant = getAutreJoueur(joueurCourant);
        }//le gagnant est celui qui n'a pas joué
        return getAutreJoueur(joueurCourant);
    }

}
