import ControleurJoueur.Aleatoire;
import ControleurJoueur.Controleur;
import modele.Modele;
import modele.bateau.Bateau;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;
import modele.utilities.EcouteurModele;
import vue.ConsoleVue;

import java.util.ArrayList;
public class Orchestrator implements EcouteurModele {
    Modele modele;
    ConsoleVue vue;
    Controleur controleur1;
    Controleur controleur2;

    public Orchestrator(){
        modele = new Modele();
        controleur2 = new Aleatoire(modele, modele.getJoueur2());
        //controleur1 = new JoueurConsole(modele.getJoueur1());
        controleur1 = new Aleatoire(modele, modele.getJoueur1());
        //controleur2 = new JoueurConsole(modele.getJoueur2());


        vue = new ConsoleVue(modele);
        vue.dessine();
        modele.ajoutEcouteur(this);
        //Joueur gagnant = modele.joueUnePartie();
        //vue.annonceGagnant(gagnant);
        //5 bateaux 1-2 2-3 1-4 1-5
        ArrayList<Integer> typeFlotte = new ArrayList<Integer>();
        //typeFlotte.add(new Integer(2));
        //typeFlotte.add(new Integer(3));
        //typeFlotte.add(new Integer(3));
        //typeFlotte.add(new Integer(4));
        typeFlotte.add(new Integer(5));
        placerFlotte(controleur1, typeFlotte);
        placerFlotte(controleur2, typeFlotte);
        joueUnePartie();

    }

    public void placerFlotte(Controleur controleur, ArrayList<Integer> taillesBateaux) {
        for (Integer taille : taillesBateaux) {
            Bateau choix = controleur.choixPlacement(taille, modele.getMer());
            while (!modele.placerBateau(controleur.getJoueurControle(), choix)) {
                choix = controleur.choixPlacement(taille, modele.getMer());
            }
        }
    }

    public Joueur joueUnePartie() {
        Controleur controleurCourant = controleur1;
        while (!modele.getMer().estFini()) {
            boolean bonTir = false;
            while (!bonTir) {
                Coordonnees choix = controleurCourant.choixTir();
                bonTir = modele.tirer(controleurCourant.getJoueurControle(), choix);
            }
            controleurCourant = autreControleur(controleurCourant);
        }//le gagnant est celui qui n'a pas joué
        return autreControleur(controleur1).getJoueurControle();
    }

    @Override
    public void modeleMisAJour(Object o){
        vue.dessine();
    }

    //Il y a pas un raccourci pour ?
    public Controleur autreControleur(Controleur controleur) {
        if (controleur == controleur1)
            return controleur2;
        return controleur1;
    }
}
