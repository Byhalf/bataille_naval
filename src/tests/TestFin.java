package tests;

import modele.Mer;
import modele.joueurs.Joueur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Classe de test de la fin
 */
public class TestFin {
    Mer mer;
    Joueur joueur1, joueur2;
    Boolean fin;

    public TestFin() throws Exception {
    }

    /**
     * Test si la partie est finie
     */
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
