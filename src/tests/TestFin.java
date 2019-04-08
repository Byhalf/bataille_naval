package tests;

import modele.Mer;
import modele.joueurs.Joueur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFin {
    Mer mer;
    Joueur joueur1, joueur2;
    Boolean fin;

    public TestFin() throws Exception {
    }


    @Test
    public void testFin(){
        joueur1 = new Joueur("premier");
        joueur2 = new Joueur("deuxième");
        mer = new Mer(joueur1, joueur2);
        mer.aPerdu(joueur1);
        fin=mer.estFini();

        Assertions.assertTrue(fin==true);
    }
}
