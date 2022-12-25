package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame implements ActionListener
{
    static public final String [] nomCouleurs = {"rouge", "vert", "jaune", "bleu"} ;
    static public final Color [] couleurs = {Color.red, Color.green, Color.yellow, Color.blue} ;
    static public final String[] nomIcones = {"rouge.gif", "vert.gif", "jaune.gif", "bleu.gif"};

    public MaFenetre ()
    {
        setTitle("FIGURES AVEC MENUS ET BARRES D'OUTILS");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;

        /** paneau pour les dessins */

        pan = new Paneau () ;
        contenu.add(pan) ;
        pan.setBackground(Color.cyan) ; // Paneau initialement bleu
        int nbCouleurs = nomCouleurs.length;

        /* Création des actions */

        actions = new ActionCouleur [nbCouleurs];
        for (int i = 0; i<nbCouleurs; i++)
        {
            actions[i] = new ActionCouleur(nomCouleurs[i], couleurs[i], nomIcones[i], pan);
        }

        /* Créations barre des menus */

        barreMenus = new JMenuBar();
        setJMenuBar(barreMenus);

        /* Création menu couleur et ses options */

        couleur = new JMenu("Couleur");
        couleur.setMnemonic('C');
        barreMenus.add(couleur);
        for(int i = 0; i < nomCouleurs.length; i++)
            couleur.add(actions[i]);

        /* Création menu surgissant couleur et ses option */

        couleurSurg = new JPopupMenu();
        for(int i = 0; i < nomCouleurs.length; i++)
            couleurSurg.add(actions[i]);

        /* Création menu formes et ses options rectangle et ovale */

        formes = new JMenu("Formes");
        formes.setMnemonic('F');
        barreMenus.add(formes);

        ovale = new JCheckBoxMenuItem("Ovale");
        formes.add(ovale);
        ovale.addActionListener(this);

        rectangle = new JCheckBoxMenuItem("Rectangle");
        formes.add(rectangle);
        rectangle.addActionListener(this);

        /* affichage menu surgisant sur clic dans fenetre */

        addMouseListener(new MouseAdapter() {
            public void mouseReleased (MouseEvent e){
                if (e.isPopupTrigger())
                    couleurSurg.show (e.getComponent(), e.getX(), e.getY());
            }
        });

        /* Création menu dimensions et ses options Hauteur et Largeur */

        dimensions = new JMenu("DIMENSIONS") ;
        dimensions.setMnemonic('D') ;
        barreMenus.add(dimensions);
        largeur = new JMenuItem("Largeur");
        largeur.addActionListener(this);
        hauteur = new JMenuItem("Hauteur");
        hauteur.addActionListener(this);

        /* Création barre d'outils couleurs
         * Avec suppression des textes associés et ajout de bulles d'aide
         */

        barreCouleurs = new JToolBar();
        for (int i = 0; i < nomCouleurs.length; i++)
        {
            JButton boutonCourant = barreCouleurs.add(actions[i]);
            boutonCourant.setText(null);
            boutonCourant.setToolTipText((String)actions[i].getValue(Action.SHORT_DESCRIPTION));
        }
        contenu.add(barreCouleurs, "North");

        /* ferméture avec le croix rouge */

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource();
        if (source == largeur)
        {
            String ch = JOptionPane.showInputDialog(this, "Largeur");
            pan.setLargeur(Integer.parseInt(ch)) ;
        }
        if (source == hauteur)
        {
            String ch = JOptionPane.showInputDialog(this, "Hauteur");
            pan.setHauteur(Integer.parseInt(ch)) ;
        }
        if (source == ovale)
            pan.setOvale(ovale.isSelected()) ;
        if (source == rectangle)
            pan.setRectangle(rectangle.isSelected()) ;

        pan.repaint ();
    }

    private Paneau pan ;
    private JCheckBoxMenuItem ovale, rectangle;
    private JMenuBar barreMenus;
    private JMenu formes, couleur, dimensions;
    private JMenuItem largeur, hauteur;
    private JPopupMenu couleurSurg;
    private ActionCouleur [] actions;
    private JToolBar barreCouleurs;
}

class Paneau extends JPanel
{
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        if (ovale)
            g.drawOval(10, 10, 10 + largeur, 10 + hauteur);
        if (rectangle)
            g.drawRect(10, 10, 10 + largeur, 10 + hauteur);
    }
    public void setRectangle(boolean trace) { rectangle = trace ;}
    public void setOvale(boolean trace) { ovale = trace ;}
    public void setLargeur (int l) { largeur = l ;}
    public void setHauteur (int h) { hauteur = h ;}
    public void setCouleur (Color c) { setBackground(c); }

    private boolean rectangle = false, ovale = false;
    private int largeur = 50, hauteur = 50 ;
}

class ActionCouleur extends AbstractAction
{
    public ActionCouleur(String nom, Color couleur, String nomIcone, Paneau pan)
    {
        putValue(Action.NAME, nom);
        putValue(Action.SMALL_ICON, new ImageIcon(nomIcone));
        putValue(Action.SHORT_DESCRIPTION, "Fond " + nom);
        this.couleur = couleur;
        this.pan = pan;
    }
    public void actionPerformed(ActionEvent e)
    {
        pan.setCouleur(couleur);
        pan.repaint();
        setEnabled(false);
        if (actionInactive != null)
            actionInactive.setEnabled(true);
        actionInactive = this;
    }

    private Color couleur;
    private Paneau pan;
    static ActionCouleur actionInactive;
}

public class Figures {
    public static void main (String args [])
    {
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
    }
}
