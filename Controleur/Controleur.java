/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.DeplacementAleatoire;
import Modele.DeplacementCarre;
import Modele.DeplacementPoly;
import Modele.DeplacementSpiral;
import Modele.Tortue;
import java.util.HashMap;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chloé
 */
public class Controleur extends Observable implements Runnable {
    
    HashMap<Integer,Tortue> tortues;
    Boolean stop = false;

    public Controleur() {
        tortues = new HashMap();
        new Thread(this).start();
    }
    
    public Tortue creerTortue() {
        Tortue t = new Tortue();
        tortues.put(t.getId(),t);
        return t;
    }
    
    public void quitter() {
        System.exit(0);
    }
    
    public void avancer(int id, int v) {
        Tortue t = tortues.get(id);
        t.avancer(v);
        setChanged();
        notifyObservers();
    }
    
    public void droite (int id, int v) {
        tortues.get(id).droite(v);
        setChanged();
        notifyObservers();
    }
    
    public void gauche(int id, int v) {
        tortues.get(id).gauche(v);
        setChanged();
        notifyObservers();
    }
    
    public void setPosition(int id, int x, int y) {
        tortues.get(id).setPosition(x, y);
        setChanged();
        notifyObservers();
    }
    
    public void deplacementCarre(int id) {
        DeplacementCarre dc = new DeplacementCarre();
        dc.deplacement(tortues.get(id));
        setChanged();
        notifyObservers();
    }
    
    public void deplacementPoly(int id) {
        DeplacementPoly dc = new DeplacementPoly(60,8);
        dc.deplacement(tortues.get(id));
        setChanged();
        notifyObservers();
    }

    public void deplacementSpiral(int id) {
        DeplacementSpiral dc = new DeplacementSpiral(50,40,6);
        dc.deplacement(tortues.get(id));
        setChanged();
        notifyObservers();
    }
    
    public void resetTortue(int id) {
        tortues.get(id).reset();
    }
    
    public void deplacementTortueAleatoire(int id){
        tortues.get(id).setDeplacement(new DeplacementAleatoire());
    }
    


    @Override
    public void run() {

        while(!stop) {
            for(Tortue t : tortues.values()) {
                t.seDeplacer();
                if(t.getX() < 0)
                    t.setPosition(600+t.getX(), t.getY());
                if(t.getX() > 599)
                    t.setPosition(t.getX()-600, t.getY());
                if(t.getY() < 0)
                    t.setPosition(t.getX(),400+t.getY());
                if(t.getY() > 399)
                    t.setPosition(t.getX(), t.getY()-400);
            }
            try {

                setChanged();
                notifyObservers();
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    
    

}