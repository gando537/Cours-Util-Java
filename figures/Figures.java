package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame implements ActionListener, ItemListener, FocusListener
{
    static public final String [] nomCouleurs = {"rouge", "vert", "jaune", "bleu"} ;
    static public final Color [] couleurs = {Color.red, Color.green, Color.yellow, Color.blue} ;

    public MaFenetre ()
    {
        setTitle("FIGURES");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;

        /** paneau pour les dessins */

        panDes = new PaneauDessin () ;
        contenu.add(panDes) ;
        panDes.setBackground(Color.cyan) ; // Paneau initialement bleu

        /** paneau pour les commandes */

        panCom = new JPanel() ;
        contenu.add(panCom, "South") ;

        /* Choix couleur */

        comboCoulFond = new JComboBox<>(nomCouleurs) ;
        panCom.add(comboCoulFond);
        comboCoulFond.addItemListener(this);

        /* Choix dimensions */

        JLabel dim = new JLabel("DIMENSIONS") ; panCom.add(dim) ;
        txtLargeur = new JTextField("50", 5);
        txtLargeur.addActionListener(this);
        txtLargeur.addFocusListener(this);
        panCom.add(txtLargeur) ;
        txtHauteur = new JTextField("20", 5);
        txtHauteur.addActionListener(this);
        txtHauteur.addFocusListener(this);
        panCom.add(txtHauteur) ;

        /* Choix formes */

        cOvale = new JCheckBox("Ovale");
        panCom.add(cOvale);
        cOvale.addActionListener(this);
        cRectangle = new JCheckBox("Rectangle");
        panCom.add(cRectangle);
        cRectangle.addActionListener(this);

        /* bouton pour fermer le programme */

        panBut = new JPanel() ;
        contenu.add(panBut, "North") ;

        jbutton = new JButton("Fermer");
        jbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                MaFenetre.this.dispose();
            }
        });

        panBut.add(jbutton);

        /* ferméture avec le croix rouge */

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent ev)
    {
        if (ev.getSource() == txtLargeur)
            setLargeur() ;
        if (ev.getSource() == txtHauteur)
            setHauteur() ;
        if (ev.getSource() == cOvale)
            panDes.setOvale(cOvale.isSelected()) ;
        if (ev.getSource() == cRectangle)
            panDes.setRectangle(cRectangle.isSelected()) ;

        panDes.repaint ();
    }

    public void focusLost (FocusEvent e)
    {
        if (e.getSource() == txtLargeur)
        {
            setLargeur() ;
            System.out.println ("perte focus largeur");
        }
        if (e.getSource() == txtHauteur)
        {
            setHauteur() ;
            panDes.repaint ();
        }
    }

    public void focusGained (FocusEvent e)
    {}

    public void setLargeur ()
    {
        String ch = txtLargeur.getText ();
        System.out.println ("Largeur : " + ch);
        panDes.setLargeur (Integer.parseInt(ch));
    }

    public void setHauteur ()
    {
        String ch = txtHauteur.getText ();
        System.out.println ("Hauteur : " + ch);
        panDes.setHauteur (Integer.parseInt(ch));
    }

    public void itemStateChanged (ItemEvent e)
    {
        String couleur = (String) comboCoulFond.getSelectedItem();
        panDes.setCouleur(couleur);
    }

    private PaneauDessin panDes ;
    private JPanel panCom, panBut ;
    private JComboBox comboCoulFond;
    private JTextField txtLargeur, txtHauteur ;
    private JCheckBox cOvale, cRectangle;
    private JButton jbutton;
}

class PaneauDessin extends JPanel
{
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        if (ovale)
            g.drawOval(10, 10, 10 + largeur, 10 + hauteur);
        if (rectangle)
            g.drawRect(10, 10, 10 + largeur, 10 + hauteur);
    }
    public void setRectangle(boolean b) { rectangle = b ;}
    public void setOvale(boolean b) { ovale = b ;}
    public void setLargeur (int l) { largeur = l ;}
    public void setHauteur (int h) { hauteur = h ;}
    public void setCouleur (String c)
    {
        for (int i = 0 ; i < MaFenetre.nomCouleurs.length ; i++)
            if (c == MaFenetre.nomCouleurs[i])
                setBackground(MaFenetre.couleurs[i]);
    }

    private boolean rectangle = false, ovale = false;
    private int largeur = 50, hauteur = 50 ;
}

public class Figures {
    public static void main (String args [])
    {
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
    }
}
