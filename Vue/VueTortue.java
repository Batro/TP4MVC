/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Tortue;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;

/**
 *
 * @author Chloé
 */
public abstract class VueTortue {
    
    protected Point pointe;
    Tortue t;
    private int id;
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPointe(Point pointe) {
        this.pointe = pointe;
    }

    
    public int getId() {
        return id;
    }
    
    
    
    public VueTortue(Tortue t, Color c) {
        id = t.getId();
        this.t = t;
        pointe = new Point(t.getX(),t.getY());
        this.color = c;
    }
    
        abstract Shape getForme();
        
    
    public Shape getCone() {
        Arc2D arc = new Arc2D.Double(pointe.getX() - t.getDistance(), pointe.getY()-t.getDistance(), 2*t.getDistance(), 2*t.getDistance(), (-t.getDir()-(t.getAngle()/2))%360, t.getAngle(), Arc2D.PIE);
        return arc;
    }   
    

}
