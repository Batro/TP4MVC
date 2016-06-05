/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.RandomFlockingLogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Chloé
 */
public class ControleurInterfaceRandom implements ActionListener {

    private Controleur controleur;
    private RandomFlockingLogo vue;

    public ControleurInterfaceRandom(Controleur controleur, RandomFlockingLogo vue) {
        this.controleur = controleur;
        this.vue = vue;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Ajouter une tortue")) {
            controleur.ajouterTortue();
        } else if(e.getActionCommand().equals("Retirer une tortue")) {
            controleur.retirerTortue();
        }
        
    }
    
}
