package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Affiche des caractères dans un paneau à un emplacement choisi à l'aide de la souris.
 * Chaque clic affiche le dernier caractère saisi au clavier.
 *
 * chaque paneau mémorise un caractère courant, correspondant au dernier caractère frappé alors que le paneau
 * avait le focus. Chaque clic dans un paneau provoque l'affichaage du caractère courant du paneau à l'emplacement
 * du clic.
 *
 * Nous avons dû créer une classe Paneau , dérivée de JPanel , en redéfinissant la méthode isFocusTraversable.
 * De plus , nous avons prévu qu'un clic dans le paneau lui donne le focus.
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
        contenu.setLayout(new FlowLayout());

        pan1 = new Paneau(Color.yellow);
        contenu.add(pan1);

        pan2 = new Paneau(Color.CYAN);
        contenu.add(pan2);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Paneau pan1;
    private Paneau pan2;

}

class Paneau extends JPanel
{
    public Paneau(Color c)
    {
        setPreferredSize(new Dimension (160, 100));
        setBackground(c);
        addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {
                    Graphics g = getGraphics();
                    String ch = "" + caractereCourant ;
                    g.drawString (ch, e.getX(), e.getY());
                    g.dispose();
                    requestFocus();
                }
            });

        addKeyListener(new KeyAdapter() {
            public void keyTyped (KeyEvent e) {
                caractereCourant = e.getKeyChar();
            }
        });
    }

    // public boolean isFocusTraversable () { return true ; }

    private char caractereCourant = '*';
}

public class CombinaisonClavierSouri2 {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
