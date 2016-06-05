package Vue;


import Controleur.Controleur;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import Modele.Segment;
import Modele.Tortue;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
	private ArrayList<VueTortue> tortues; // la liste des tortues enregistrees
	private boolean cone;
        
	public FeuilleDessin(boolean cone) {
		tortues = new ArrayList();
                this.cone = cone;
	}

	public void addTortue(VueTortue o) {
		tortues.add(o);
	}

    public ArrayList<VueTortue> getTortues() {
        return tortues;
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	public void showTurtles(Graphics g) {
		for(Iterator it = tortues.iterator();it.hasNext();) {
			VueTortue t = (VueTortue) it.next();
			drawTurtle(g,t);
                        if(cone)
                            drawCone(g,t);
		}
	}
        
        public void drawTurtle (Graphics graph, VueTortue t) {
                Graphics2D graph2D = (Graphics2D)graph;
		if (graph==null)
			return;
		graph.setColor(Color.green);             
		graph2D.fill(t.getForme());
    }
        
        public void drawCone( Graphics graph, VueTortue t) {
            Graphics2D graph2D = (Graphics2D)graph;
		if (graph==null)
			return;
		graph.setColor(new Color(1,0,0,0.25f));             
		graph2D.fill(t.getCone());
        }
}
