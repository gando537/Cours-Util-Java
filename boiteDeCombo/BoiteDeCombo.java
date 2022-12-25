package boiteDeCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCombo extends JFrame implements ActionListener, ItemListener
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
        contenu.add(combo);
        combo.addActionListener(this);
        combo.addItemListener(this);
    }

    public void actionPerformed (ActionEvent e)
    {
        System.out.println ("**Action Combo :");
        Object valeur = combo.getSelectedItem();
        System.out.println ((String) valeur);
    }

    public void itemStateChanged (ItemEvent e)
    {
        System.out.println ("**Item Combo :");
        Object valeur = combo.getSelectedItem();
        System.out.println ((String) valeur);
    }

    private String [] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir"} ;
    private JComboBox combo ;
}

public class BoiteDeCombo {
    public static void main (String args[])
    {
        FenCombo fen = new FenCombo () ;
        fen.setVisible (true) ;
    }
}
