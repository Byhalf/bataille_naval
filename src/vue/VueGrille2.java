package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.utilities.Coordonnees;

import javax.swing.*;
import java.awt.*;

public class VueGrille2 extends JPanel implements VueDessinable {
    public static final int TAILLE_CASE = 50;
    public static final int TAILLE_GRILLE = 10;
    private int dimX, dimY;
    private Modele modele;

    public VueGrille2(Modele modele) {
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

        Bateau[][] grille2 = modele.getJoueur2().getGrille();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                if (grille2[j][i] != null) {
                    if (grille2[j][i].estEndomage(new Coordonnees(j, i))) {
                        g.setColor(Color.orange);
                        g.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);

                        if (grille2[j][i].estCoule()) {
                            g.setColor(Color.red);
                            g.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                        }
                    }
                } else {
                    if (modele.getMer().getCaseTireJ2()[j][i]) {
                        g.setColor(Color.green);
                        g.fillOval(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
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