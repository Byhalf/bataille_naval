package modele.joueurs;

import modele.bateau.Bateau;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

/**
 * Une instance de Joueur peut jouer à la bataille naval
 */
public class Joueur {

    public final static int TAILLE_GRILLE = 10;
    public String name;
    Bateau grille[][];

    public Joueur(String name){
        grille = new Bateau[TAILLE_GRILLE][TAILLE_GRILLE];
        this.name= name;
    }

    public ArrayList<Bateau> getFlottes() {
        return flottes;
    }

    public String getName() {
        return name;
    }

    private ArrayList<Bateau> flottes = new ArrayList<>();

    public Bateau[][] getGrille(){
        return grille;
    }

    /**
     * place l'instance de Bateau passer en paramêtre sur la grille des bateaux du joueur
     *
     * @param bateauAPlacer
     * @return un boolean, true si le bateau à bien été placé.
     */
    public boolean placerBateau(Bateau bateauAPlacer){
        //Catch exeption si ça dépasse de la grille

        try{
            for(Coordonnees emplacement:bateauAPlacer.getEmplacements()){
                if(grille[emplacement.getX()][emplacement.getY()] != null)
                    return false;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        for(Coordonnees emplacement:bateauAPlacer.getEmplacements()){
            grille[emplacement.getX()][emplacement.getY()] = bateauAPlacer;
        }flottes.add(bateauAPlacer);
        return true;
    }


}