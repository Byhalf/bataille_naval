package vue;

import modele.Modele;

import javax.swing.*;
import java.awt.*;

public class GameVue extends JPanel implements VueDessinable {
    private Modele modele;
    private VueGrille1 vueGrille1;
    private VueGrille2 vueGrille2;

    public GameVue(Modele modele) {
        this.modele=modele;
        setPreferredSize(new Dimension(1090, 500));

        setLayout(new BorderLayout());
        vueGrille1 = new VueGrille1(modele);
        vueGrille2 = new VueGrille2(modele);

        add(vueGrille2, BorderLayout.EAST);
        add(vueGrille1, BorderLayout.WEST);

        setFocusable(true);
        setVisible(true);
    }

    public VueGrille1 getVueGrille1() {
        return vueGrille1;
    }

    public VueGrille2 getVueGrille2() {
        return vueGrille2;
    }

    @Override
    public void dessine() {
        vueGrille1.dessine();
        vueGrille2.dessine();
        this.repaint();
        this.revalidate();
    }


}
