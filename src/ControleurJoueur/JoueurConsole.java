package ControleurJoueur;

import modele.Mer;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;

import java.util.Scanner;

public class JoueurConsole extends Controleur {

    public JoueurConsole(Joueur joueur) {
        super(joueur);
    }

    @Override
    public Coordonnees choixTir() {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coordonees x ?");
        x = scanner.nextInt();
        System.out.println("Coordonees y ?");
        y = scanner.nextInt();
        return (new Coordonnees(x, y));
    }

    @Override
    public Bateau choixPlacement(int taille, Mer mer) {
        int x, y, z;
        Direction d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coordonees x ?");
        x = scanner.nextInt();
        System.out.println("Coordonees y ?");
        y = scanner.nextInt();
        System.out.println("direction?0=droite,1=bas");
        z = scanner.nextInt();
        if (z == 0)
            d = Direction.HORIZONTALE;
        else
            d = Direction.VERTICALE;
        Coordonnees coord = new Coordonnees(x, y);
        return new Bateau(coord, taille, d);
    }

}
