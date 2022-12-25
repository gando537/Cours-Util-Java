package boiteDeListe;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class FenList extends JFrame implements ListSelectionListener
{
    public FenList ()
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

        liste = new JList(couleurs);
        contenu.add(liste);
        liste.addListSelectionListener(this);
    }

    public void valueChanged (ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            System.out.println ("**Action Liste - valeurs selectionnees :");
            List valeurs = liste.getSelectedValuesList();
            for (int i = 0; i < valeurs.size() ; i++)
                System.out.println (valeurs.get(i)) ;
        }
    }

    private String [] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir"} ;
    private JList liste ;
}

public class BoiteDeListe {
    public static void main (String args[])
    {
        FenList fen = new FenList () ;
        fen.setVisible (true) ;
    }
}
