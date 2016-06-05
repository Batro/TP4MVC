/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Chloé
 */
public class DeplacementFloking implements Deplacement {

    
    public DeplacementFloking() {
        
    }
    @Override
    public void deplacement(Tortue t) {
        int vitesseMoyenne=0;
        int directionMoyenne=0;
        for(Tortue tortue : t.getTortuesVisibles().values()) {
            vitesseMoyenne+= t.getVitesse();
            directionMoyenne+= t.getDir();
        }
        vitesseMoyenne /= t.getTortuesVisibles().size();
        directionMoyenne /= t.getTortuesVisibles().size();
        t.setVitesse(vitesseMoyenne);
        t.setDir(directionMoyenne);
        t.avancer(vitesseMoyenne);
               
    }
    
}
