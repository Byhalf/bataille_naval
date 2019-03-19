package games;

import java.util.Scanner;
import java.lang.Boolean;
public class Naval{

	public static void main (String [] args){

		int grille1[][] = new int[10][10];
		int grille2[][] = new int[10][10];
		int player =1;
			
		boolean jeux_finie=false;
		
		while(jeux_finie =! false){
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un nombre :");
			int n1 = sc.nextInt();
			System.out.println("Veuillez saisir un nombre :");
			int n2 = sc.nextInt();
			
			if(player==1){
				System.out.println("Tour du joueur 1 :");
				if(grille1[n1][n2]==0){
					grille1[n1][n2] = 1;
					afficherGrille(grille1);
				}

				else{
					System.out.println("ERREUR");
				}
			}
			
			else{
				System.out.println("Tour du joueur 2 :");
				if(grille1[n1][n2]==0){
					grille2[n1][n2] = 2;
					afficherGrille(grille2);
				}

				else{
					System.out.println("ERREUR");
				}
			}
			
			if(player==1){
				player=2;
			}
			else{
				player=1;
			}
		}

	}	
		
	public static void afficherGrille(int grille[][]){

		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				System.out.print(grille[i][j]);
			}
			System.out.println();
		}
	}

}