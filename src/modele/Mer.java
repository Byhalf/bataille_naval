package modele;
import modele.utilities.Coordonnees;
import modele.joueurs.*;
import modele.bateau.Bateau;
import modele.bateau.Direction;

import java.util.ArrayList;

public class Mer {
    //Il faut une classe modele.bateau avec methode est_touche() qui renvoie un bool, modele.joueurs.Joueur avec get_bateau() qui renvoie les bateaux du joeurs,
    public final static int TAILLE_GRILLE = 10;
    private Joueur joueur1;
    private Joueur joueur2;

    public boolean[][] getCaseTireJ1() {
        return caseTireJ1;
    }

    public boolean[][] getCaseTireJ2() {
        return caseTireJ2;
    }

    private boolean caseTireJ1[][] = new boolean[10][10];
    private boolean caseTireJ2[][] = new boolean[10][10];


    public Mer(Joueur joueur1, Joueur joueur2 ){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    public boolean tirez(Coordonnees caseSelectionne, Joueur joueur_qui_tire){
        if(joueur_qui_tire == joueur1)
            caseTireJ1[caseSelectionne.getX()][caseSelectionne.getY()] = true;
        else
            caseTireJ2[caseSelectionne.getX()][caseSelectionne.getY()] = true;
        Joueur joueur_vise = get_other_player(joueur_qui_tire);
        for(Bateau bateau: joueur_vise.getFlottes()){
            if(bateau.estTouche(caseSelectionne))
                return true;
        }return false;
    }
    public void placerFlotte(Joueur joueur, ArrayList<Integer> taillesBateaux){
        for(Integer taille:taillesBateaux){
            Bateau choix = joueur.choixPlacement(taille);
            while(!joueur.placerBateau(choix)){
                choix = joueur.choixPlacement(taille);
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
        }return true;

    }

    public Boolean aGagner(Joueur joueur){
        if(!estFini())
            return false;
        for(Bateau bateau:joueur.getFlottes()) {
            if (!bateau.estCoule())
                return true;
        }return false;
    }

}
