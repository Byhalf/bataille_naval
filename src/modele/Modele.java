package modele;

import modele.joueurs.Aleatoire;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

/**
 * Classe du Modele
 */
public class Modele  {
    /**
     * Retourne une instance de mer
     * @return Instance de mer
     */
    public Mer getMer() {
        return mer;
    }

    private Mer mer;
//rechanger déclaration Joeur en humain ou aléatoire une fois les tests fini, plus propre.

    /**
     * Retourne le joueur 1
     * @return Joueur 1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * Retourne le joueur 2
     * @return Joueur 2
     */
    public Joueur getJoueur2() {
        return joueur2;
    }

    private Joueur joueur1;
    private Joueur joueur2;

    /**
     * Constructeur du modele
     */
    public Modele(){
        joueur1 = new Aleatoire("alea");
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

    /**
     * Effectue le changement de joueur
     * @param joueur Joueur actuel
     * @return Joueur suivant
     */
    public Joueur getAutreJoueur(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }

    /**
     * Permet de jouer une partie
     * @return Gagnant de la partie
     */
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
