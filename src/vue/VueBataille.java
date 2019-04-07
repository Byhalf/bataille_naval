package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.utilities.EcouteurModele;

import javax.swing.*;
import java.awt.*;

public class VueBataille extends JPanel implements EcouteurModele {
    public static final int TAILLE_CASE = 10;
    private int dimX, dimY;
    private Modele modele;

    public VueBataille(Modele modele) {
        //modele.ajoutEcouteur(this);
        this.modele = modele;
        dimX = 300;
        dimY = 300;
        setPreferredSize(new Dimension(dimX, dimY));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        paintLevel(g);
    }

    private void paintLevel(Graphics g){

        Bateau[][] grille1 = modele.getJoueur1().getGrille();

        for (int j = 0;j<dimX;j++){
            for (int i = 0; i < dimY; i++) {
                if (grille1[i][j] == null) {
                    if (modele.getMer().getCaseTireJ1()[i][j]) {
                        g.drawRect(i*TAILLE_CASE,j*TAILLE_CASE,10,10);
                    } else {
                        g.fillRect(i*TAILLE_CASE,j*TAILLE_CASE,10,10);
                    }
                }
            }
        }
    }

    @Override
    public void modeleMisAJour(Object source) {
        this.repaint();
        this.revalidate();
    }
}
