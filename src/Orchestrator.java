import modele.Modele;
import modele.joueurs.Joueur;
import modele.utilities.EcouteurModele;
import vue.ConsoleVue;

public class Orchestrator implements EcouteurModele {
    Modele modele;
    ConsoleVue vue;
    public Orchestrator(){
        modele = new Modele();
        vue = new ConsoleVue(modele);
        vue.dessine();
        modele.getMer().ajoutEcouteur(this);
        Joueur gagnant = modele.joueUnePartie();
        vue.annonceGagnant(gagnant);

    }
    @Override
    public void modeleMisAJour(Object o){
        vue.dessine();
    }
}
