import Joueurs.*;
import modele.bateau.Bateau;
import modele.joueurs.Aleatoire;
import modele.joueurs.Humain;
import java.util.ArrayList;
public class Orchestrator {
    //Chosir coordonné bateaux, instancié bateaux et utilisé mer.placer bateau pour voir si il peut
    //être placé
    //ensuite jeu normal

    public Orchestrator(){
        Humain humain= new Humain("humain");
        Aleatoire robot = new Aleatoire("robot");

        ArrayList<Bateau> bateau_humain = new ArrayList<Bateau>();
        ArrayList<Bateau> bateau_Robot = new ArrayList<Bateau>();

        //5 bateaux 1-2 2-3 1-4 1-5



    }



}
