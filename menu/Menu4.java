package menu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* Menu surgissant */

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

        formes = new JPopupMenu();

        arrondi = new JMenu("Arrondi");
        formes.add(arrondi);

        cercle = new JMenuItem("Cercle");
        arrondi.add(cercle);

        ovale = new JMenuItem("Ovale");
        arrondi.add(ovale);

        rectangle = new JMenuItem("Rectangle");
        formes.add(rectangle);

        addMouseListener(new MouseAdapter() {
            public void mouseReleased (MouseEvent e){
                if (e.isPopupTrigger())
                    formes.show (e.getComponent(), e.getX(), e.getY());
            }
        });

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPopupMenu formes;
    private JMenu arrondi;
    private JMenuItem cercle, ovale, rectangle;
}

public class Menu4 {
    public static void main (String [] args)
    {
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}
