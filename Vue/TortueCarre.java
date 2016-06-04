/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Tortue;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

/**
 *
 * @author Chloé
 */
public class TortueCarre extends VueTortue {
    
    private static final int rp = 10;

    public TortueCarre(Tortue t, Color c) {
        super(t, c);
    }

    @Override
    Shape getForme() {
        Point p = new Point(t.getX(),t.getY());
		Polygon arrow = new Polygon();
		arrow.addPoint(p.x,p.y);
		arrow.addPoint(p.x +rp, p.y);
                arrow.addPoint(p.x +rp, p.y+rp);
                arrow.addPoint(p.x, p.y+rp);
                return arrow;
    
    }
    
}
