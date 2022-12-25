package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mafenetre extends JFrame
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

        paneau = new Paneau();
        getContentPane().add(paneau);
        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Paneau paneau;

}

class Paneau extends JPanel implements MouseMotionListener
{
    Paneau ()
    {
        addMouseMotionListener(this);
        addMouseListener(new MouseAdapter()
            {
                public void mouseReleased(MouseEvent e)
                {
                    enCours = false;
                    System.out.println ("Released " + e.getX() + " " + e.getY());
                }
            });
        repaint();
    }

    public void mouseDragged (MouseEvent e)
    {
        System.out.println ("Drag " + e.getX() + " " + e.getY());
        if (!enCours ) {
            xDeb = e.getX();
            yDeb = e.getY();
            enCours = true;
        }
        else {
            xFin = e.getX();
            yFin = e.getY();
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        int xd, yd, xf, yf;

        xd = Math.min(xDeb, xFin);
        xf = Math.max(xDeb, xFin);
        yd = Math.min(yDeb, yFin);
        yf = Math.max(yDeb, yFin);

        g.drawRect(xd, yd, xf-xd, yf-yd);
    }
    private boolean enCours = false;
    private int xDeb, yDeb, xFin, yFin;
}


public class ZoneDeSelection {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
