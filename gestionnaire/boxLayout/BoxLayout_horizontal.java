package gestionnaire.boxLayout;

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
        setTitle("Exemple BoxLayout_horizontal");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();

        bHor = Box.createHorizontalBox();
        contenu.add(bHor);
        b1 = new JButton("Bouton1");
        bHor.add(b1);
        txt = new JTextField(20);
        bHor.add(txt);
        coche1 = new JCheckBox("case à cocher");
        bHor.add(coche1);
        etiq = new JLabel("Bonjour");
        bHor.add(etiq);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Box bHor;
    private JButton b1;
    private JCheckBox coche1;
    private JTextField txt;
    private JLabel etiq;
}

public class BoxLayout_horizontal {
    public static void main (String [] args) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible (true);
    }
}
