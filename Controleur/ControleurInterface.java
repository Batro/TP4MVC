/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.SimpleLogo;
import Vue.VueTortue;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JTextField;

/**
 *
 * @author Chloé
 */
public class ControleurInterface implements ActionListener, KeyListener{
    
    private Controleur controleur;
    private SimpleLogo vue;

    public ControleurInterface(Controleur controleur, SimpleLogo vue) {
        this.controleur = controleur;
        this.vue = vue;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        // actions des boutons du haut
        if (c.equals("Avancer")) {
            avancer();
        }
        else if (c.equals("Droite")) {
            droite();
        }
        else if (c.equals("Gauche")) {
            gauche();
        }
        else if (c.equals("Proc1"))
            proc1();
        else if (c.equals("Proc2"))
            proc2();
        else if (c.equals("Proc3"))
            proc3();
        else if (c.equals("Effacer"))
            effacer();
        else if (c.equals("Quitter"))
            controleur.quitter();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        return;
    }

 @Override
    public void keyReleased(KeyEvent e) {

        int c = e.getKeyCode();

        switch(c) {
            case KeyEvent.VK_ENTER:
                avancer();
                break;
            case KeyEvent.VK_LEFT:
                gauche();
                break;
            case KeyEvent.VK_RIGHT:
                droite();
                break;
            case KeyEvent.VK_1:
                proc1();
                break;
            case KeyEvent.VK_2:
                proc2();
                break;
            case KeyEvent.VK_3:
                proc3();
                break;
            case KeyEvent.VK_DELETE:
                effacer();
                break;
            case KeyEvent.VK_ESCAPE:
                controleur.quitter();
                break;

        }
    }

    public void avancer() {
        System.out.println("avancer");
        try {
            int v = Integer.parseInt(vue.getInputValue().getText());
            controleur.avancer(vue.getCourante().getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
    }

    public void droite() {
        try {
            int v = Integer.parseInt(vue.getInputValue().getText());
            controleur.droite(vue.getCourante().getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
    }

    public void gauche() {
        try {
            int v = Integer.parseInt(vue.getInputValue().getText());
            controleur.gauche(vue.getCourante().getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
        
    }
        public void proc1() {
            controleur.deplacementCarre(vue.getCourante().getId());
        }

        public void proc2() {
            controleur.deplacementPoly(vue.getCourante().getId());
        }

        public void proc3() {
            controleur.deplacementSpiral(vue.getCourante().getId());
        }
        
        public void effacer() {
            for (Iterator it = vue.getFeuille().getTortues().iterator();
            it.hasNext();) {
            VueTortue t = (VueTortue) it.next();                    
		controleur.resetTortue(t.getId());
            }	
            Dimension size = vue.getFeuille().getSize();           
            controleur.setPosition(vue.getCourante().getId(),size.width/2, size.height/2);
        }

    
}
