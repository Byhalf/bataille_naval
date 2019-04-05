package vue;

import modele.Modele;
import modele.bateau.Bateau;
import modele.joueurs.Joueur;
import modele.utilities.Coordonnees;

public class ConsoleVue  {
    private Modele modele;
    public ConsoleVue(Modele modele){
        this.modele = modele;

    }
    public void annonceGagnant(Joueur gagnant){
        System.out.println(gagnant.getName());
    }
    public void dessine(){
        Bateau[][] grille1 = modele.getJoueur1().getGrille();
        Bateau[][] grille2 = modele.getJoueur2().getGrille();
        //constante à définit (10)
        //j'ai inversé i j
        //grille j2
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(grille2[j][i]!=null && grille2[j][i].estTouche(new Coordonnees(j,i)))
                    System.out.print("O");
                else{
                    if(modele.getMer().getCaseTireJ1()[j][i])
                        System.out.print("X");
                    else
                        System.out.print("*");
                }
            }System.out.print("\n");
        }
        System.out.println("\n ############ \n");
        //grille j1
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(grille1[j][i]!=null)
                    System.out.print("O");
                else{
                    if(modele.getMer().getCaseTireJ2()[j][i])
                        System.out.print("X");
                    else
                        System.out.print("*");
                }
            }System.out.print("\n");
        }
        System.out.println("\n");
    }
}
