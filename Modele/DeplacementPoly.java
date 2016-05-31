/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Chloé
 */
public class DeplacementPoly implements Deplacement {
    
    private int a;
    private int n;

    public DeplacementPoly(int a, int n) {
        this.a = a;
        this.n = n;
    }
    
    

    @Override
    public void deplacement(Tortue t) {
        for (int j=0;j<a;j++) {
                t.avancer(n);
                t.droite(360/a);
        }
    }
    
}
