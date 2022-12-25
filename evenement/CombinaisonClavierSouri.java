package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Affiche des caractères dans un paneau à un emplacement choisi à l'aide de la souris.
 * Chaque clic affiche le dernier caractère saisi au clavier
 */

class Mafenetre extends JFrame
{
    public Mafenetre ()
    {
        setTitle("Affichage Caractères");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();

        pan = new Paneau();
        contenu.add(pan);

        addKeyListener(new KeyAdapter() {
            public void keyTyped (KeyEvent e) {
                pan.setCaractereCourant(e.getKeyChar());
            }
        });

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Paneau pan;

}

class Paneau extends JPanel
{
    public Paneau()
    {
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    Graphics g = getGraphics();
                    String ch = "" + caractereCourant ;
                    g.drawString (ch, e.getX(), e.getY());
                    g.dispose();
                }
            });
    }

    public void paintComponent(Graphics g) { super.paintComponent(g);}
    public void setCaractereCourant (char c) {caractereCourant = c ;}

    private char caractereCourant = ' ';
}

public class CombinaisonClavierSouri {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
