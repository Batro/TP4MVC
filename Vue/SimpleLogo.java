package Vue;

import Controleur.Controleur;
import Controleur.ControleurInterface;
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


public class SimpleLogo extends JFrame implements Observer {
    public static final Dimension VGAP = new Dimension(1,5);
    public static final Dimension HGAP = new Dimension(5,1);

    private FeuilleDessin feuille;
    private VueTortue courante;
    private JTextField inputValue;
    
    private Controleur controleur;
    private ControleurInterface controleurInterface;



    public SimpleLogo(Controleur c) {
        
        super("un logo tout simple");
        controleurInterface = new ControleurInterface(c,this);
        feuille = new FeuilleDessin(false); //500, 400);
        this.controleur = c;
        c.addObserver(this);
        logoInit();
        addKeyListener(controleurInterface);
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

        toolBar.add(Box.createRigidArea(HGAP));

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
        b20.addActionListener(controleurInterface);
        JButton b21 = new JButton("Proc2");
        p2.add(b21);
        b21.addActionListener(controleurInterface);
        JButton b22 = new JButton("Proc3");
        p2.add(b22);
        b22.addActionListener(controleurInterface);

        getContentPane().add(p2,"South");
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600,400));
        feuille.setPreferredSize(new Dimension(600,400));

        getContentPane().add(feuille,"Center");

        // Creation de la tortue
        VueTortue tortue = new TortueCarre(controleur.creerTortue(),Color.BLUE);

        // Deplacement de la tortue au centre de la feuille
        controleur.setPosition(tortue.getId(), 500/2, 400/2);
        courante = tortue;
        feuille.addTortue(tortue);

        pack();
        setVisible(true);
    }

    public JTextField getInputValue() {
        return inputValue;
    }

    public VueTortue getCourante() {
        return courante;
    }

    public FeuilleDessin getFeuille() {
        return feuille;
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
        b.addActionListener(controleurInterface);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(controleurInterface);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE)
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            else
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
        }
    }

  

    @Override
    public void update(Observable o, Object arg) {
        feuille.repaint();
    }
}