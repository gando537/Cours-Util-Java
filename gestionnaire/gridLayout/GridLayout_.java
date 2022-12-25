package gestionnaire.gridLayout;

import javax.swing.*;
import java.awt.*;

/*
 * Le gestionnaire GridLayout dispose les composants suivant une grille
 * régulière, chaque composant occupant une cellule
 */

class MaFenetre extends JFrame
{
    public static int NBOUTONS = 10;

    public MaFenetre ()
    {
        setTitle("Exemple GridLayout");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();
        contenu.setLayout(new GridLayout(4, 3, 6, 4));

        boutons = new JButton[NBOUTONS];
        for (int i = 0 ; i < NBOUTONS ; i++) {
            boutons[i] = new JButton("Bouton " + i);
            contenu.add(boutons[i]);
        }

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JButton boutons[];
}

public class GridLayout_ {
    public static void main (String [] args) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible (true);
    }
}
