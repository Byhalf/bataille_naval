package ControleurJoueur;

import modele.Mer;
import modele.Modele;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;
import vue.GameVue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class JoueurSwing extends Controleur implements MouseListener {
    private GameVue gameVue;
    private Modele modele;
    int TAILLE_GRILLE = 10;
    int TAILLE_CASE;
    private Random randomGenerator = new Random();
    private Coordonnees mousePos = new Coordonnees(-1, -1);

    public JoueurSwing(Joueur joueurControle, GameVue gameVue, Modele modele) {
        super(joueurControle);
        this.gameVue = gameVue;
        this.modele = modele;
        TAILLE_CASE = gameVue.getVueGrille2().getTailleCase();
    }

    public void attend() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Coordonnees mousePosConvertisseur(int x, int y) {
        int resX = 0, resY = 0;
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            if (x > i * TAILLE_CASE && x < TAILLE_CASE * (i + 1))
                resX = i;
            if (y > i * TAILLE_CASE && y < TAILLE_CASE * (i + 1))
                resY = i;
        }
        return new Coordonnees(resX, resY);
    }

    @Override
    public Coordonnees choixTir() {
        //on ajoute l'écouteur à la grille concerné
        gameVue.getVueGrille2().addMouseListener(this);
        Coordonnees oldCoord = mousePos;
        while (oldCoord.compare(mousePos)) {
            oldCoord = new Coordonnees(mousePos.getX(), mousePos.getY());
            attend();
        }
        return mousePos;
    }

    @Override
    public Bateau choixPlacement(int taille, Mer mer) {
        ArrayList<Bateau> possibleRes = new ArrayList<>();
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                Bateau bateau = new Bateau(new Coordonnees(i, j), taille, Direction.HORIZONTALE);
                if (mer.estPlacable(getJoueurControle(), bateau))
                    possibleRes.add(bateau);
                bateau = new Bateau(new Coordonnees(i, j), taille, Direction.VERTICALE);
                if (mer.estPlacable(getJoueurControle(), bateau))
                    possibleRes.add(bateau);
            }
        }
        return possibleRes.get(randomGenerator.nextInt(possibleRes.size()));
    }

    //modifie mousePos
    @Override
    public void mouseClicked(MouseEvent e) {
        mousePos = mousePosConvertisseur(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
