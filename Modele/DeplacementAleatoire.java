/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Random;

/**
 *
 * @author Chloé
 */
public class DeplacementAleatoire implements Deplacement {

    @Override
    public void deplacement(Tortue t) {
        Random r = new Random();
        int type = r.nextInt(2);
        switch(type) {
            case 0:
                int dist = r.nextInt(50);
                t.avancer(dist);
                break;
            case 1:
                int dir = r.nextInt(2);
                int angle = r.nextInt(181);
                switch(dir) {
                    case 0:
                        t.gauche(angle);
                        break;
                    case 1:
                        t.droite(angle);
                        break;
                                           
                }
                break;           
        }
    }
    
}
