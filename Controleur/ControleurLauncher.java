/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.Launcher;
import Vue.RandomLogo;
import Vue.SimpleLogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Chloé
 */
public class ControleurLauncher implements ActionListener {
    
    Launcher vue;
    
    public ControleurLauncher(Launcher vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String c = e.getActionCommand();    
        if(c.equals("Mode manuel")) {
            SimpleLogo fenetre = new SimpleLogo(new Controleur());
            fenetre.setVisible(true); 
        } else if(c.equals("Mode aléatoire")) {
            RandomLogo fenetre = new RandomLogo();
            fenetre.setVisible(true);
        }
        vue.setVisible(false);
    }
    
}
