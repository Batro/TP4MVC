/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Controleur;
import Controleur.ControleurInterface;
import Controleur.ControleurInterfaceRandom;
import Modele.Tortue;
import static Vue.SimpleLogo.HGAP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Chloé
 */
public class RandomFlockingLogo extends javax.swing.JFrame implements Observer {

    
    HashMap<Integer, VueTortue> tortues;
    Controleur c;
    ControleurInterfaceRandom controleurInterface;
    FeuilleDessin feuille;
    
    public RandomFlockingLogo() {
        feuille = new FeuilleDessin(true);
        c = new Controleur();
        controleurInterface = new ControleurInterfaceRandom(c,this);
        c.addObserver(this);
        tortues = new HashMap();
        initComponents();
        for(int i = 0; i<10;i++) {
            VueTortue t = new TortueTriangle(c.creerTortue(),Color.RED);
            tortues.put(t.getId(), t);
            c.setPosition(t.getId(), 300, 200);
            feuille.addTortue(t);
            c.deplacementTortueAleatoire(t.getId());
        }
        logoInit();
        
        
    }

    public HashMap<Integer, VueTortue> getTortues() {
        return tortues;
    }
    
    
    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    
       
        
        JPanel p2 = new JPanel(new GridLayout());
        JButton b20 = new JButton("Ajouter une tortue");
        p2.add(b20);
        b20.addActionListener(controleurInterface);
        JButton b21 = new JButton("Retirer une tortue");
        p2.add(b21);
        b21.addActionListener(controleurInterface);


        getContentPane().add(p2,"South");
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600,400));
        feuille.setPreferredSize(new Dimension(600,400));
        getContentPane().add(feuille,"Center");
        pack();
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void update(Observable o, Object arg) {
        if(arg!= null && arg instanceof Tortue) {
            VueTortue t = new TortueTriangle((Tortue)arg,Color.RED);
            tortues.put(t.getId(), t);
            c.setPosition(t.getId(), 300, 200);
            feuille.addTortue(t);
            c.deplacementTortueAleatoire(t.getId());
        } else if (arg!= null && arg instanceof Integer) {
            feuille.removeTortue(tortues.get((Integer)arg));
            tortues.remove((Integer)arg);
            System.out.println(tortues.size());
        }
        feuille.repaint();
    }
}