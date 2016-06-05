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
public class TortueTriangle extends VueTortue {
    
    private static final int rp = 15;
    private static final int rb = 10;
    
    

    public TortueTriangle(Tortue t, Color c) {
        super(t, c);
        
    }

    @Override
    Shape getForme() {
        Point p = new Point(t.getX(),t.getY());
		Polygon arrow = new Polygon();

		//Calcule des deux bases
		//Angle de la droite
		double theta=t.getRatioDegRad()*(-t.getDir());
		//Demi angle au sommet du triangle
		double alpha=Math.atan( (float)rb / (float)rp);
		//Rayon de la fleche
		double r=Math.sqrt( rp*rp + rb*rb );
		//Sens de la fleche

		//Pointe
		Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
						 (int) Math.round(p.y-r*Math.sin(theta)));
                this.setPointe(p2);
		arrow.addPoint(p2.x,p2.y);
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

		//Base2
		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
		  (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

		arrow.addPoint(p2.x,p2.y);
                
                return arrow;
    
    }
    
}
