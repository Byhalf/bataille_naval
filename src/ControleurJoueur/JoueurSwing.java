package ControleurJoueur;

import modele.Mer;
import modele.Modele;
import modele.bateau.Bateau;
import modele.bateau.Direction;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;
import vue.GameVue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class JoueurSwing extends Controleur implements MouseListener, KeyListener {
    private GameVue gameVue;
    private Modele modele;
    int TAILLE_GRILLE = 10;
    int TAILLE_CASE;
    private Random randomGenerator = new Random();
    private Coordonnees mouseClickPos = new Coordonnees(-1, -1);
    private Coordonnees mousePos = new Coordonnees(-1, -1);
    private Direction direction = Direction.HORIZONTALE;
    private Boolean clicked = false;

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
            if (x >= i * TAILLE_CASE && x < TAILLE_CASE * (i + 1))
                resX = i;
            if (y >= i * TAILLE_CASE && y < TAILLE_CASE * (i + 1))
                resY = i;
        }
        return new Coordonnees(resX, resY);
    }
    @Override
    public Coordonnees choixTir() {
        //on ajoute l'écouteur à la grille concerné
        gameVue.getVueGrille2().addMouseListener(this);
        Coordonnees oldCoord = mouseClickPos;
        while (oldCoord.compare(mouseClickPos)) {

            oldCoord = new Coordonnees(mouseClickPos.getX(), mouseClickPos.getY());

            attend();
        }
        clicked = false;
        return mouseClickPos;
    }
    /*
    @Override
    public Bateau choixPlacement(int taille, Mer mer) {
        Bateau bateauTemp = new Bateau(mousePos,taille,direction);
        while (!clicked){
            Bateau[][] copieGrilleBateau = Arrays.copyOf(getJoueurControle().getGrille(),
                    getJoueurControle().getGrille().length);
            gameVue.remove(gameVue.getVueGrille1());
            Modele tempModele =  new Modele();
            tempModele.setJoueur1(new Joueur("copie",copieGrilleBateau));
            VueGrille1 temp = new VueGrille1(tempModele);
            gameVue.add(temp, BorderLayout.WEST);
            temp.addMouseListener(this);
            temp.addKeyListener(this);
            Bateau vieuxBateau = new Bateau(mousePos,taille,direction);
            bateauTemp = new Bateau(mousePos,taille,direction);
            while (bateauTemp.compare(vieuxBateau)){
                attend();
                bateauTemp = new Bateau(mousePos,taille,direction);
            }tempModele.placerBateau(getJoueurControle(),bateauTemp);
            attend();
            gameVue.remove(temp);
        } gameVue.add(gameVue.getVueGrille1(), BorderLayout.WEST);


        return bateauTemp;
        }
*/

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

    //modifie mouseClickPos
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClickPos = mousePosConvertisseur(e.getX(), e.getY());
        clicked = true;

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        mousePos = mousePosConvertisseur(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT || keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            direction = Direction.HORIZONTALE;
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN || keyEvent.getKeyCode() == KeyEvent.VK_UP)
            direction = Direction.VERTICALE;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
