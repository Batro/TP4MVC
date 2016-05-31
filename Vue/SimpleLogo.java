package Vue;

import Controleur.Controleur;
import Modele.Tortue;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/


 **************************************************************************/


public class SimpleLogo extends JFrame implements Observer, ActionListener, KeyListener {
    public static final Dimension VGAP = new Dimension(1,5);
    public static final Dimension HGAP = new Dimension(5,1);

    private FeuilleDessin feuille;
    private VueTortue courante;
    private JTextField inputValue;
    
    private Controleur controleur;


    private void quitter() {
        System.exit(0);
    }

    public SimpleLogo(Controleur c) {
        
        super("un logo tout simple");
        this.controleur = c;
        c.addObserver(this);
        logoInit();
        addKeyListener(this);
        requestFocus();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10,10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel,"North");

        addButton(toolBar,"Effacer","Nouveau dessin","/icons/index.png");

        toolBar.add(Box.createRigidArea(HGAP));
        inputValue=new JTextField("45",5);
        toolBar.add(inputValue);
        addButton(toolBar, "Avancer", "Avancer 50", null);
        addButton(toolBar, "Droite", "Droite 45", null);
        addButton(toolBar, "Gauche", "Gauche 45", null);

        String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
                "vert", "gris clair", "magenta", "orange",
                "gris", "rose", "jaune"};

        // Create the combo box
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        JComboBox colorList = new JComboBox(colorStrings);
        toolBar.add(colorList);

        colorList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int n = cb.getSelectedIndex();
                courante.setColor(decodeColor(n));
            }
        });




        // Menus
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);	// on installe le menu bar
        JMenu menuFile=new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);

        addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
        addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

        JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);

        JMenu menuHelp=new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // les boutons du bas
        JPanel p2 = new JPanel(new GridLayout());
        JButton b20 = new JButton("Proc1");
        p2.add(b20);
        b20.addActionListener(this);
        JButton b21 = new JButton("Proc2");
        p2.add(b21);
        b21.addActionListener(this);
        JButton b22 = new JButton("Proc3");
        p2.add(b22);
        b22.addActionListener(this);

        getContentPane().add(p2,"South");

        feuille = new FeuilleDessin(); //500, 400);
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600,400));
        feuille.setPreferredSize(new Dimension(600,400));

        getContentPane().add(feuille,"Center");

        // Creation de la tortue
        VueTortue tortue = new TortueTriangle(controleur.creerTortue(),Color.BLUE);

        // Deplacement de la tortue au centre de la feuille
        controleur.setPosition(tortue.getId(), 500/2, 400/2);

        courante = tortue;
        feuille.addTortue(tortue);

        pack();
        setVisible(true);
    }

    public String getInputValue(){
        String s = inputValue.getText();
        return(s);
    }

    public void avancer() {
        System.out.println("avancer");
        try {
            int v = Integer.parseInt(inputValue.getText());
            controleur.avancer(courante.getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + inputValue.getText());
        }
    }

    public void droite() {
        try {
            int v = Integer.parseInt(inputValue.getText());
            controleur.droite(courante.getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + inputValue.getText());
        }
    }

    public void gauche() {
        try {
            int v = Integer.parseInt(inputValue.getText());
            controleur.gauche(courante.getId(),v);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + inputValue.getText());
        }
    }
    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
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
            quitter();

        feuille.repaint();
    }

    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {
        controleur.deplacementCarre(courante.getId());
    }

    public void proc2() {
        controleur.deplacementPoly(courante.getId());
    }

    public void proc3() {
        controleur.deplacementSpiral(courante.getId());
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset(controleur);
        feuille.repaint();

        // Replace la tortue au centre
        Dimension size = feuille.getSize();
        controleur.setPosition(courante.getId(),size.width/2, size.height/2);
    }

    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton)p.add(new JButton(name));
        }
        else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon (u);
                b = (JButton) p.add(new JButton(im));
            }
            else
                b = (JButton) p.add(new JButton(name));
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0,0,0,0));
        b.addActionListener(this);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(this);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE)
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            else
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
        }
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
                quitter();
                break;

        }

        feuille.repaint();
    }
    
        	protected Color decodeColor(int c) {
		switch(c) {
			case 0: return(Color.black);
			case 1: return(Color.blue);
			case 2: return(Color.cyan);
			case 3: return(Color.darkGray);
			case 4: return(Color.red);
			case 5: return(Color.green);
			case 6: return(Color.lightGray);
			case 7: return(Color.magenta);
			case 8: return(Color.orange);
			case 9: return(Color.gray);
			case 10: return(Color.pink);
			case 11: return(Color.yellow);
			default : return(Color.black);
		}
	}

    @Override
    public void update(Observable o, Object arg) {
        feuille.repaint();
    }
}
