package boiteDeCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCombo extends JFrame implements ActionListener
{
    public FenCombo ()
    {
        setTitle("Essai Boite de liste");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());

        combo = new JComboBox(couleurs);
        combo.setEditable(true);
        combo.setMaximumRowCount(6);
        contenu.add(combo);
        combo.addActionListener(this);
    }

    public void actionPerformed (ActionEvent e)
    {
        System.out.println ("**Action Combo :");
        Object valeur = combo.getSelectedItem();
        int rang = combo.getSelectedIndex() ;
        if (rang == -1)
        {
            System.out.println ("Saisie nouvelle valeur : " + valeur);
            combo.addItem(valeur) ;
        }
        else
            System.out.println ("selection de valeur existante : " + valeur + " de rang : " + rang);
    }

    private String [] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir"} ;
    private JComboBox combo ;
}

public class BoiteDeCombo1 {
    public static void main (String args[])
    {
        FenCombo fen = new FenCombo () ;
        fen.setVisible (true) ;
    }
}

