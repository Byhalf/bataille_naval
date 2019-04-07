package vue;

import modele.Modele;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameVue extends JPanel implements KeyListener, ActionListener {
    Modele modele;
    VueBataille vueBataille;
    GUI gui;

    public GameVue(Modele modele, GUI gui){
        this.gui=gui;
        this.modele=modele;
        this.addKeyListener(this);

        setLayout(new BorderLayout());
        vueBataille = new VueBataille(modele);

        add(vueBataille, BorderLayout.CENTER);

        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


}
