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

        menu = new JMenuBar();
        setJMenuBar(menu);

        menuCouleur = new JMenu("COULEUR");
        actionRouge = new MonAction("EN ROUGE", Color.red);
        actionJaune = new MonAction("EN JAUNE", Color.yellow);
        menuCouleur.add(actionRouge);
        menuCouleur.add(actionJaune);
        menu.add(menuCouleur);

        boutonRouge = new JButton((String)actionRouge.getValue(Action.NAME));
        getContentPane().add(boutonRouge, "South");
        boutonRouge.addActionListener(actionRouge);

        menuSurg = new JPopupMenu();
        menuSurg.add(actionRouge);
        menuSurg.add(actionJaune);
        addMouseListener(new MouseAdapter() {
            public void mouseReleased (MouseEvent e){
                if (e.isPopupTrigger())
                    menuSurg.show (e.getComponent(), e.getX(), e.getY());
            }
        });

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPopupMenu menuSurg;
    private MonAction actionRouge, actionJaune;
    private JMenuBar menu;
    private JMenu menuCouleur;
    private JButton boutonRouge;
}

class MonAction extends AbstractAction
{
    public MonAction (String nom, Color couleur)
    {
        super(nom);
        this.couleur = couleur ;
    }
    public void actionPerformed(ActionEvent e)
    {
        if (couleur == Color.red)
            System.out.println("action rouge, chaine de commande : " + e.getActionCommand());
        if (couleur == Color.yellow)
            System.out.println("action jaune, chaine de commande : " + e.getActionCommand());
    }
    private Color couleur;
}

public class Menu5 {
    public static void main (String [] args)
    {
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}
