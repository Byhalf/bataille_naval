package modele.joueurs;
import modele.bateau.*;
import modele.utilities.Coordonnees;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Joueur{
	// Il faut une arrayList des bateaux
	Bateau grille[][] = new Bateau[10][10];
	private ArrayList<Bateau> flottes;

	public Bateau[][] getGrille(){
		return grille;
	}


	public boolean placerBateau(Coordonnees placement, Direction d, int taille){
		//Catch exeption si ça dépasse de la grille

		Bateau bateauAPlacer = new Bateau(placement,taille,d);
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

	public abstract Coordonnees choixPlacement(int taille);
	public abstract Coordonnees choixTir();
		

}