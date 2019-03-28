package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.utilities.Coordonnees;
import modele.utilities.EcouteurModele;

public class ConsoleVue implements EcouteurModele {
    private Modele modele;
    public ConsoleVue(Modele modele){
        this.modele = modele;

    }
    public void dessine(){
        Bateau grille1[][] = modele.getJoueur1().getGrille();
        Bateau grille2[][] = modele.getJoueur2().getGrille();

        //constante à définit (10)

        //grille j2
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(grille2[i][j]!=null && grille2[i][j].estTouche(new Coordonnees(i,j)))
                    System.out.print("O");
                else{
                    if(modele.getMer().getCaseTireJ1()[i][j])
                        System.out.print("X");
                    else
                        System.out.print(" ");
                }
            }System.out.print("\n");
        }

        //grille j1
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){

                if(grille1[i][j]!=null)
                    System.out.print("O");
                else{
                    if(modele.getMer().getCaseTireJ2()[i][j])
                        System.out.print("X");
                    else
                        System.out.print(" ");
                }
            }System.out.print("\n");
        }

    }
    @Override
    public void modeleMisAJour(Object o){
        dessine();
    }
}
