public class Mer {
    //Il faut une classe bateau avec methode est_touche() qui renvoie un bool, Joueur avec get_bateau() qui renvoie les bateaux du joeurs,
    public final static int TAILLE_GRILLE = 10;
    private Joueur joueur1;
    private Joueur joueur2;
    public Mer(Bateau[][] bateaux1, Bateau[][] bateaux2, Joueur joueur1, Joueur joueur2 ){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    public boolean tirez(int x, int y, Joueur joueur_qui_tire){
        Joueur joueur_vise = get_other_player(joueur_qui_tire);
        Bateau[][] bateaux= joueur_vise.get_bateaux();
        for(Bateau bateau: bateaux){
            if(bateau.est_touche(x,y))
                return true;
            return false;
        }
    }
    public boolean placer_bateau(int x, int y, Direction d, Bateau bateau,Joueur joueur){
        int[][] coord_bateau= bateau.get_coordone();
        Bateau[][] liste_bateaux = joueur.get_bateaux();
        if(est_placable(x,y,d,bateau,joueur)){
            for(int[] coord:coord_bateau){
                liste_bateaux[coord[0]][coord[1]] = bateau;
            }
        }
    }
    public boolean est_placable(int x, int y, Direction d, Bateau bateau,Joueur joueur){
        int[][] coord_bateau= bateau.get_coordone();
        Bateau[][] liste_bateaux = joueur.get_bateaux();

        for(int[] coord:coord_bateau){
            if(coord[0]>=TAILLE_GRILLE || coord[0]<0)
                return false;
            if(coord[1]>=TAILLE_GRILLE || coord[1]<0)
                return false;
            for(Bateau autre_bateau:liste_bateaux){
                if(autre_bateau.est_touche()){
                    return false;
                }

            }
        }return true;
    }
    public Joueur get_other_player(Joueur joueur){
        if(joueur == joueur1)
            return joueur2;
        return joueur1;
    }

}
