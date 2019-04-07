package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.utilities.EcouteurModele;

import javax.swing.*;
import java.awt.*;

public class VueBataille extends JPanel implements EcouteurModele {
    public static final int TAILLE_CASE = 50;
    public static final int TAILLE_GRILLE = 10;
    private int dimX, dimY;
    private Modele modele;

    public VueBataille(Modele modele) {
        //modele.ajoutEcouteur(this);
        this.modele = modele;
        dimX = 500;
        dimY = 500;
        setPreferredSize(new Dimension(dimX, dimY));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        paintLevel(g);
    }

    private void paintLevel(Graphics g){

        Bateau[][] grille1 = modele.getJoueur1().getGrille();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE ; j++) {
                g.drawOval(i*TAILLE_CASE,j*TAILLE_CASE,TAILLE_CASE,TAILLE_CASE);
            }
        }
    }

    @Override
    public void modeleMisAJour(Object source) {
        this.repaint();
        this.revalidate();
    }
}
