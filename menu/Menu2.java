package menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FenMenu extends JFrame implements ActionListener, ItemListener
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

        /* Création menu couleur et son groupe de 2 boutons radio : rouge et vert */

        couleur = new JMenu("Couleur");
        barreMenus.add(couleur);

        rouge = new JRadioButtonMenuItem("Rouge");
        couleur.add(rouge);
        rouge.addActionListener(this);
        rouge.addItemListener(this);

        couleur.addSeparator();

        vert = new JRadioButtonMenuItem("Vert");
        couleur.add(vert);
        vert.addActionListener(this);
        vert.addItemListener(this);

        ButtonGroup groupe = new ButtonGroup();
        groupe.add(rouge);
        groupe.add(vert);

        /* Création menu dimensions et ses cases à cocher rectangle et ovale */

        formes = new JMenu("Formes");
        barreMenus.add(formes);

        rectangle = new JCheckBoxMenuItem("Rectangle");
        formes.add(rectangle);
        rectangle.addActionListener(this);
        rectangle.addItemListener(this);

        formes.addSeparator();

        ovale = new JCheckBoxMenuItem("Ovale");
        formes.add(ovale);
        ovale.addActionListener(this);
        ovale.addItemListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        Object source = e.getSource();
        if (source == rouge) System.out.println (" ** Action option rouge **");
        if (source == vert) System.out.println (" ** Action option vert **");
        if (source == rectangle) System.out.println (" ** Action option rectangle **");
        if (source == ovale) System.out.println (" ** Action option ovale **");
    }

    public void itemStateChanged (ItemEvent e)
    {
        Object source = e.getSource();
        if (source == rouge) System.out.println (" ** Action option rouge **");
        if (source == vert) System.out.println (" ** Action option vert **");
        if (source == rectangle) System.out.println (" ** Action option rectangle **");
        if (source == ovale) System.out.println (" ** Action option ovale **");
        System.out.print("Options selectionnees :");
        if (rouge.isSelected()) System.out.println (" rouge");
        if (vert.isSelected()) System.out.println (" vert");
        if (rectangle.isSelected()) System.out.println (" rectangle");
        if (ovale.isSelected()) System.out.println (" ovale");
        System.out.println();
    }

    private JMenuBar barreMenus;
    private JMenu couleur, formes;
    private JRadioButtonMenuItem rouge, vert;
    private JCheckBoxMenuItem rectangle, ovale;
}

public class Menu2 {
    public static void main (String [] args)
    {
        FenMenu fen = new FenMenu();
        fen.setVisible(true);
    }
}
