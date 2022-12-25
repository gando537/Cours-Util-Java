package gestionnaire.flowLayout;

import javax.swing.*;
import java.awt.*;

/*
 * Il dispose les composants les uns à la suite des autres , sur une même ligne
 */

class MaFenetre extends JFrame
{
    public static int NBOUTONS = 8;

    public MaFenetre ()
    {
        setTitle("Exemple FlowLayout");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();
        contenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        boutons = new JButton[NBOUTONS];
        int n = 1;
        for (int i = 0 ; i < NBOUTONS ; i++)
        {
            boutons[i] = new JButton("Bouton " + n);
            n *= 10;
            contenu.add(boutons[i]);
        }

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JButton boutons[];
}

public class FlowLayout_ {
    public static void main (String [] args) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible (true);
    }
}
