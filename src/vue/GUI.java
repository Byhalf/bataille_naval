package vue;

import modele.Modele;

import javax.swing.*;

public class GUI extends JFrame {
    GameVue gameVue;

    public GUI(){
        super("Bataille Navale");
        GUI thisGui = this;
        gameVue = new GameVue(new Modele());

        add(gameVue);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
