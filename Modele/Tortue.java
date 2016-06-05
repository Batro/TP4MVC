package Modele;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import Modele.Segment;
import java.awt.geom.Arc2D;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

	Source originale : J. Ferber - 1999-2001

			   Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/2001

**************************************************************************/


public class Tortue
{

	protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)
	
	protected int x, y;	
	protected int dir;	
        
        private static int idInit = 0;
        private Deplacement deplacement;
        private int vitesse = 45;
        private int angle = 45;
        private int distance = 80;
        private HashMap<Integer,Tortue> tortuesVisibles;
        
        int id;

    public Deplacement getDeplacement() {
        return deplacement;
    }

    public HashMap<Integer, Tortue> getTortuesVisibles() {
        return tortuesVisibles;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    
        
    public boolean champDeVision(HashMap<Integer,Tortue> tortues) {
        tortuesVisibles = new HashMap();
        Arc2D arc = new Arc2D.Double(x - distance, y-distance, 2*distance, 2*distance,(-dir-(angle/2))%360, angle, Arc2D.PIE);
        for(Tortue t : tortues.values()) {
            if(arc.contains(t.getX(), t.getY()) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            } else if(arc.contains(t.getX(), t.getY()- 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            }else if(arc.contains(t.getX(), t.getY()+ 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            }else if(arc.contains(t.getX()+599, t.getY()+ 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            }else if(arc.contains(t.getX()-599, t.getY()+ 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            }else if(arc.contains(t.getX()-599, t.getY()- 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            } else if(arc.contains(t.getX()+599, t.getY()- 399) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            } else if(arc.contains(t.getX()-599, t.getY()) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            } else if(arc.contains(t.getX()+599, t.getY()) && t.getId() != this.id) {
                tortuesVisibles.put(t.getId(), t);
            }
        }
        if(tortuesVisibles.isEmpty())
            return false;
        return true;
    }
    
    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }
	

	public Tortue() { 
		this.id = idInit++;
		reset();
	}

    public int getAngle() {
        return angle;
    }

    public int getDistance() {
        return distance;
    }
    
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getVitesse() {
        return vitesse;
    }
        
        

	public void reset() {
		x = 0;
		y = 0;
		dir = -90;
  	}

    public int getId() {
        return id;
    }
        
        

	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
  
        
        public int getX() {
            return x;
        }
        
        public double getRatioDegRad() {
            return ratioDegRad;
        } 
        
        public int getY() {
            return y;
        }
        
        public int getDir() {
            return dir;
        }



	public void avancer(int dist) {
		int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
		int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));
		x = newX;
		y = newY;
	}

	public void droite(int ang) {
		dir = (dir + ang) % 360;
	}

	public void gauche(int ang) {
		dir = (dir - ang) % 360;
	}
        
        public void seDeplacer() {
            if(deplacement!=null) {
                deplacement.deplacement(this);
            }
        }


}
