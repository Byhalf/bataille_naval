package modele.joueurs;

import modele.Mer;
import modele.bateau.Bateau;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

/**
 * Une instance de Joueur peut jouer à la bataille naval
 */
public abstract class Joueur{

    public final static int TAILLE_GRILLE = 10;
    public String name;
    Bateau grille[][] = new Bateau[TAILLE_GRILLE][TAILLE_GRILLE];

    public Joueur(String name){
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

    /**
     * Choisi où placer un bateau
     * Génére une liste
     * @param taille la taille du bateau à placer
     * @param mer permet de vérifié grace à la méthode estPlaçable si le bateau est plaçable
     * @return un bateau, car un bateau contient toutes les information nécessaire à sont placement.
     */
    public abstract Bateau choixPlacement(int taille, Mer mer);

    /**
     * @return une coordonnée ou le joueur tir.
     */
    public abstract Coordonnees choixTir();


}