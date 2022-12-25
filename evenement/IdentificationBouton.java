package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mafenetre extends JFrame implements MouseListener, MouseMotionListener
{
    public Mafenetre ()
    {
        setTitle("Trace souris");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        addMouseListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /* Méthode chargée d'afficher les différentes informations pour un événement donné(fourni en argument) */

    public static void details (String txt, MouseEvent e)
    {
        System.out.print (txt + e.getX() + " " + e.getY());
        System.out.print ("     Ctr = " + e.getClickCount());
        System.out.print ("     Boutons : ");

        if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != 0)
            System.out.print ("gauche ");
        if ((e.getModifiersEx() & InputEvent.BUTTON2_DOWN_MASK) != 0)
            System.out.print ("milieu ");
        if ((e.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0)
            System.out.print ("droite ");
        if (e.isPopupTrigger())
            System.out.print (" Popup ");
        System.out.println ();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        details("mouseClicked ", e) ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        details("mousePresssed ", e) ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        details("mouseReleased ", e) ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        details("mouseMoved ", e) ;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}


public class IdentificationBouton {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
