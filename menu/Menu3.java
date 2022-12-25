package menu;

import java.awt.*;
import javax.swing.*;

class FenMenu extends JFrame
{
    public FenMenu ()
    {
        setTitle("Exemple de Menu");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        /* Création de la barre des menus */

        barreMenus = new JMenuBar();
        setJMenuBar(barreMenus);

        formes = new JMenu("Formes");
        barreMenus.add(formes);

        arrondi = new JMenu("Arrondi");
        formes.add(arrondi);

        cercle = new JMenuItem("Cercle");
        arrondi.add(cercle);

        ovale = new JMenuItem("Ovale");
        arrondi.add(ovale);

        rectangle = new JMenuItem("Rectangle");
        formes.add(rectangle);

        formes.addSeparator();

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JMenuBar barreMenus;
    private JMenu formes, arrondi;
    private JMenuItem cercle, ovale, rectangle;
}

public class Menu3 {
    public static void main (String [] args)
    {
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}
