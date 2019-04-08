package vue;

import modele.Modele;

import javax.swing.*;
import java.awt.*;

public class GameVue extends JPanel implements VueDessinable {
    Modele modele;
    VueGrille1 vueGrille1;
    VueGrille2 vueGrille2;
    GUI gui;

    public GameVue(Modele modele, GUI gui){
        this.gui=gui;
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

    @Override
    public void dessine() {
        this.repaint();
        this.revalidate();
    }
}
