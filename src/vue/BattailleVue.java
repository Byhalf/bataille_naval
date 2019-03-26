package vue;

import javax.swing.*;

public class BattailleVue extends JPanel{
    public BattailleVue(){

    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    private void paintGrille(Graphics g){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                g.setColor(Color.BLACK);
            }
        }
    }

    private void paintTouche(Graphics g){

    }
}