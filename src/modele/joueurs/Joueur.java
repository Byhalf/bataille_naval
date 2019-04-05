package modele.joueurs;

import modele.Mer;
import modele.bateau.Bateau;
import modele.utilities.Coordonnees;

import java.util.ArrayList;

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

    public abstract Bateau choixPlacement(int taille, Mer mer);
    public abstract Coordonnees choixTir();


}