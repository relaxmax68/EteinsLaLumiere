import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JToggleButton;
/**
 * classe qui modélise le comportement des Lampes
 */
public class Lampe extends JToggleButton{
	private static ActionListener listener;
	/**
	 * paramètre le nombre de cases sélectionnées au départ en mode de jeu avec génération aléatoire
	 */
	private final int NBCASESAUDEPART=6;
/**
 * attribut qui qualifie l'état de la lampe
 * false : éteint / true : allumé
 */
	private boolean etat;
/**
 * constructeur
 * @param e : booléen état de la lampe au départ	
 */
	public Lampe(boolean e){
		this.etat=e;
		this.setBackground(Color.green);
	}
	/**
	 * permet de modifier les états des boutons à chaque coup
	 *@param l : int ligne du tableau
	 *@param c : int colonne du tableau
	 */
	public void action(int l,int c){
		
	}
	/**
	 * crée un jeu de départ aléatoire
	 */
	public void aleatoire(){
		for(int i=0;i<NBCASESAUDEPART;i++){
			int l=Math.random(TAILLEGRILLE);
			int c=Math.random(TAILLEGRILLE);
		}
	}
	@Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (getModel().isPressed()) {
            g.setColor(Color.green);//(g.getColor());
            g2.fillRect(3, 3, getWidth() - 6, getHeight() - 6);
        }
        super.paintComponent(g);
        g2.setColor(new Color(128, 0, 128));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1.2f));
        g2.draw(new RoundRectangle2D.Double(1, 1, (getWidth() - 3),(getHeight() - 3), 12, 8));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(4, getHeight() - 3, getWidth() - 4, getHeight() - 3);
        g2.dispose();
    }
}