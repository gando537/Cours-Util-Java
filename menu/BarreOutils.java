package menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* Menu surgissant */

class FenOutil extends JFrame implements ActionListener
{
    public FenOutil ()
    {
        setTitle("Exemple de Menu");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();

        /* Création de la barre d'outils couleurs */

        barreOutils = new JToolBar();
        boutonRouge = new JButton("Rouge");
        boutonVert = new JButton("Vert");
        barreOutils.add(boutonRouge);
        barreOutils.add(boutonVert);
        contenu.add(barreOutils, "North");
        boutonRouge.addActionListener(this);
        boutonVert.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == boutonRouge) System.out.println (" ** Action rouge **");
        if (e.getSource() == boutonVert) System.out.println (" ** Action vert **");
    }

    private JToolBar barreOutils;
    private JButton boutonRouge, boutonVert;
}

public class BarreOutils {
    public static void main (String [] args)
    {
        FenOutil fen = new FenOutil();
        fen.setVisible(true);
    }
}
