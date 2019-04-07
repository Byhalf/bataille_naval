package modele.utilities;

import java.util.ArrayList;

public abstract class AbstractModeleEcouteur implements ModeleEcouteur {
    ArrayList<EcouteurModele> ecouteurModeles = new ArrayList<>();
    @Override
    public void ajoutEcouteur(EcouteurModele e) {
        ecouteurModeles.add(e);
    }

    protected void fireChangement() {
        for (EcouteurModele e :
                ecouteurModeles) {
            e.modeleMisAJour(this);
        }
    }
}
