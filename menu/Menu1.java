package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FenMenu extends JFrame implements ActionListener
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

        /* Création menu couleur et ses options rouge et vert */

        couleur = new JMenu("Couleur");
        barreMenus.add(couleur);

        rouge = new JMenuItem("Rouge");
        couleur.add(rouge);

            /*Pour raccourcis clavier : CTRL-R pour sélectionner rouge */
        rouge.setMnemonic('R');
        rouge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));

            /* Une bulles d'aide de texte explicatifi quand la souris est sur l'objet*/
        rouge.setToolTipText("fond rouge");

        rouge.addActionListener(this);

        couleur.addSeparator();

        vert = new JMenuItem("Vert");
        couleur.add(vert);

            /*Pour raccourcis clavier : CTRL-V pour sélectionner vert */
        vert.setMnemonic('V');
        vert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));

            /* Une bulles d'aide de texte explicatifi quand la souris est sur l'objet*/
        vert.setToolTipText("fond vert");

        vert.addActionListener(this);

        /* Création menu dimensions et ses options rouge et vert */

        dimensions = new JMenu("Dimensions");
        barreMenus.add(dimensions);

        largeur = new JMenuItem("Largeur");
        dimensions.add(largeur);
        largeur.addActionListener(this);

        dimensions.addSeparator();

        hauteur = new JMenuItem("Hauteur");
        dimensions.add(hauteur);
        hauteur.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        Object source = e.getSource();
        System.out.println (" ** Action avec chaîne de commande = " + e.getActionCommand());
        if (source == rouge) System.out.println (" ** Action option rouge **");
        if (source == vert) System.out.println (" ** Action option vert **");
        if (source == largeur) System.out.println (" ** Action option largeur **");
        if (source == hauteur) System.out.println (" ** Action option hauteur **");
    }

    private JMenuBar barreMenus;
    private JMenu couleur, dimensions;
    private JMenuItem rouge, vert, largeur, hauteur;
}

public class Menu1 {
    public static void main (String [] args)
    {
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}
