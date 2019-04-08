package vue;

import modele.Modele;

import javax.swing.*;

public class Fenetre extends JFrame implements VueDessinable {
    private GameVue gameVue;

    public Fenetre(Modele modele) {
        super("Bataille Navale");
        gameVue = new GameVue(modele);

        add(gameVue);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void dessine() {
        this.repaint();
        this.revalidate();
        gameVue.dessine();
    }
}
