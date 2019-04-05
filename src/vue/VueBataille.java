package vue;

import modele.Modele;
import modele.utilities.EcouteurModele;

import javax.swing.*;

public class VueBataille extends JPanel implements EcouteurModele {
    Modele modele;

    public VueBataille(Modele modele) {
        this.modele = modele;
    }

    @Override
    public void modeleMisAJour(Object source) {
        ;
    }
}
