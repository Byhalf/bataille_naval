package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.utilities.Coordonnees;

import javax.swing.*;
import java.awt.*;

public class VueGrille1 extends JPanel implements VueDessinable {
    public static int getTailleCase() {
        return TAILLE_CASE;
    }

    public static final int TAILLE_CASE = 50;
    public static final int TAILLE_GRILLE = 10;
    private int dimX, dimY;
    private Modele modele;


    public VueGrille1(Modele modele) {
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

    private void paintLevel(Graphics g) {

        Bateau[][] grille1 = modele.getJoueur1().getGrille();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (grille1[j][i] != null) {
                    if (grille1[j][i].estEndomage(new Coordonnees(j, i))) {
                        g.setColor(Color.orange);
                        g.fillOval(j * TAILLE_CASE, i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);

                        if (grille1[j][i].estCoule()) {
                            g.setColor(Color.red);
                            g.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                        }
                    } else {
                        g.setColor(Color.gray);
                        g.drawOval(j * TAILLE_CASE, i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                    }
                } else {
                    if (modele.getMer().getCaseTireJ2()[j][i]) {
                        g.setColor(Color.green);
                        g.fillOval(j * TAILLE_CASE, i * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                    }
                }
            }
        }
    }

    @Override
    public void dessine() {
        this.repaint();
        this.revalidate();
    }

}