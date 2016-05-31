/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Tortue;
import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author Chloé
 */
public abstract class VueTortue {
    
    Tortue t;
    private int id;
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }
    
    
    
    public VueTortue(Tortue t, Color c) {
        id = t.getId();
        this.t = t;
        this.color = c;
    }
    
        abstract Shape getForme();
    

}
