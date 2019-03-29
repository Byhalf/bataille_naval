package modele.joueurs;
import modele.bateau.*;
import modele.utilities.Coordonnees;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Joueur{
    public String getName() {
        return name;
    }

    public String name;
    public Joueur(String name){
        this.name= name;
    }
    Bateau grille[][] = new Bateau[10][10];

    public ArrayList<Bateau> getFlottes() {
        return flottes;
    }

    private ArrayList<Bateau> flottes;

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

    public abstract Bateau choixPlacement(int taille);
    public abstract Coordonnees choixTir();


}