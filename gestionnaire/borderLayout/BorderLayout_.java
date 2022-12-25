package gestionnaire.borderLayout;

import javax.swing.*;
import java.awt.*;

/*
 * Le gestionnaire BorderLayout dispose les composants suivant l'un des quatre bords du conteneur
 */

class MaFenetre extends JFrame
{
    public static int NBOUTONS = 5;

    public MaFenetre ()
    {
        setTitle("Exemple BorderLayout");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();

        boutons = new JButton[NBOUTONS];
        for (int i = 0 ; i < NBOUTONS ; i++)
            boutons[i] = new JButton("Bouton " + i);
        contenu.add(boutons[0]);
        contenu.add(boutons[1], BorderLayout.NORTH);
        contenu.add(boutons[2], BorderLayout.SOUTH);
        contenu.add(boutons[3], BorderLayout.WEST);
        contenu.add(boutons[4], BorderLayout.EAST);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JButton boutons[];
}

public class BorderLayout_ {
    public static void main (String [] args) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible (true);
    }
}
