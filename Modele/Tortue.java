package Modele;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import Modele.Segment;


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
        
        int id;

    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }
	

	public Tortue() { 
		this.id = idInit++;
		reset();
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
