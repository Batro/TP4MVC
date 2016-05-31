package Vue;

import Controleur.Controleur;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {

    /**
     * @param args
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                boolean hasNotStarted = true;
                InputStreamReader isReader = new InputStreamReader(System.in);
                BufferedReader bufReader = new BufferedReader(isReader);
                while (hasNotStarted) {
                    String choix;
                    System.out.println("Veuillez saisir le mode de création de logo désiré : 1 pour manuel, 2 pour aléatoire.");
                    try {
                        choix = bufReader.readLine();
                        if (choix.equals("1")) {
                            SimpleLogo fenetre = new SimpleLogo(new Controleur());
                            fenetre.setVisible(true);
                            hasNotStarted = false;
                        } else if (choix.equals("2")) {
                            RandomLogo fenetre = new RandomLogo();
                            fenetre.setVisible(true);
                            hasNotStarted = false;
                        } else {
                            System.out.println("Erreur");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
