package modele;

import modele.bateau.Bateau;
import modele.joueurs.Joueur;
import modele.utilities.AbstractModeleEcouteur;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

public class Mer extends AbstractModeleEcouteur {
    public final static int TAILLE_GRILLE = 10;
    private Joueur joueur1;
    private Joueur joueur2;

    public boolean[][] getCaseTireJ1() {
        return caseTireJ1;
    }

    public boolean[][] getCaseTireJ2() {
        return caseTireJ2;
    }

    //pour ne pas tirer 2 fois la meme case (meme si il n'y a pas de bateau
    private boolean caseTireJ1[][] = new boolean[TAILLE_GRILLE][TAILLE_GRILLE];
    private boolean caseTireJ2[][] = new boolean[TAILLE_GRILLE][TAILLE_GRILLE];


    public Mer(Joueur joueur1, Joueur joueur2 ){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                caseTireJ1[i][j] = false;
                caseTireJ2[i][j] = false;
            }
        }

    }
    public boolean tirez(Coordonnees caseSelectionne, Joueur joueur_qui_tire){
        //return true si tir possible false sinon
        boolean[][] caseTire;
        Boolean dejaChoisi;
        if(joueur_qui_tire == joueur1 ){
            dejaChoisi = caseTireJ1[caseSelectionne.getX()][caseSelectionne.getY()];
            caseTire = caseTireJ1;
            if (dejaChoisi)
                return false;
        }else{
            dejaChoisi = caseTireJ2[caseSelectionne.getX()][caseSelectionne.getY()];
            caseTire = caseTireJ2;
            if (dejaChoisi)
                return false;
        }
        caseTire[caseSelectionne.getX()][caseSelectionne.getY()] = true;
        Joueur joueur_vise = get_other_player(joueur_qui_tire);
        for(Bateau bateau: joueur_vise.getFlottes()){
            if(bateau.estTouche(caseSelectionne)){
                bateau.applicationDegat(caseSelectionne);
                fireChangement();
                return true;
            }
        }fireChangement();
        return true;
    }
    public void placerFlotte(Joueur joueur, ArrayList<Integer> taillesBateaux){
        for(Integer taille:taillesBateaux){
            Bateau choix = joueur.choixPlacement(taille, this);
            fireChangement();
            while(!joueur.placerBateau(choix)){
                choix = joueur.choixPlacement(taille, this);
                fireChangement();
            }
        }

    }

    public Joueur get_other_player(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }

    public Boolean estFini(){
        for(Bateau bateau:joueur1.getFlottes()){
            if(!bateau.estCoule())
                return false;
        }for(Bateau bateau:joueur2.getFlottes()){
            if(!bateau.estCoule())
                return false;
        }fireChangement();
        return true;
    }

    public Boolean estPlacable(Joueur joueur, Bateau bateau) {
        Bateau[][] grille = joueur.getGrille();
        for (Coordonnees emplacement : bateau.getEmplacements()) {
            if (emplacement.getX() >= TAILLE_GRILLE || emplacement.getY() >= TAILLE_GRILLE)
                return false;
            if (grille[emplacement.getX()][emplacement.getY()] != null)
                return false;
        }
        return true;
    }


}
