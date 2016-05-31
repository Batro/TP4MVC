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
public class DeplacementSpiral implements Deplacement {
    
    private int n;
    private int k;
    private int a;

    public DeplacementSpiral(int n, int k, int a) {
        this.n = n;
        this.k = k;
        this.a = a;
    }
    @Override
    public void deplacement(Tortue t) {
        for (int i = 0; i < k; i++) {
                t.avancer(n);
                t.droite(360/a);
                n = n+1;
        }
    }
    
}
