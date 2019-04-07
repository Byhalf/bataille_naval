package modele.bateau;

import modele.utilities.Coordonnees;

import java.util.ArrayList;

public class Bateau{
    private int x, y, taille;


    private ArrayList<Coordonnees> emplacements;
    private ArrayList<Coordonnees> coordToucher = new ArrayList<Coordonnees>();

    public Bateau(Coordonnees placement,int taille, Direction dir){
        this(placement.getX(),placement.getY(),taille,dir);
    }
    public Bateau(int x, int y, int taille, Direction dir){
        this.x=x;
        this.y=y;
        this.taille=taille;
        this.emplacements =getCoord(dir);
    }

    public ArrayList<Coordonnees> getEmplacements() {
        return emplacements;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getTaille(){
        return this.taille;
    }

    public ArrayList<Coordonnees> getCoord(Direction dir){
        ArrayList<Coordonnees> emplacements = new ArrayList<Coordonnees>();
        for (int i=0; i<getTaille(); i++){
            if (dir==Direction.HORIZONTALE){
                emplacements.add(new Coordonnees(this.getX()+i, this.getY()));
            }
            else{
                emplacements.add(new Coordonnees(this.getX(), this.getY()+i));
            }
        }
        return emplacements;
    }

    public void applicationDegat(Coordonnees degat) {
        coordToucher.add(degat);
    }

    public boolean estEndomage(Coordonnees caseVise) {
        for (Coordonnees caseEndomager : coordToucher) {
            if (caseEndomager.compare(caseVise))
                return true;
        }
        return false;
    }

    //J'ai eu un bug avec estTouche, car je l'utilisait pour vérifié qu'une case avait
    //été déja touché cependant une fois qu'elle est touché ça renvoie false bref
    public boolean estTouche(Coordonnees caseTouche){
        for(Coordonnees dejaTouche:coordToucher){
            if(dejaTouche.compare(caseTouche))
                return false;
        }for(Coordonnees emplacement: emplacements){
            if(emplacement.compare(caseTouche)){
                return true;
            }
        }return false;
    }

    public boolean estCoule(){
        return coordToucher.size() == getTaille();
    }
}
