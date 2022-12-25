package boiteDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenInput extends JFrame implements ActionListener
{
    private String [] couleurs = {"rouge", "bleu", "gris", "vert", "jaune", "noir"} ;
    FenInput ()
    {
        setTitle("Essai Boite de liste");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        JButton saisie = new JButton("CHOIX");
        getContentPane().add(saisie, "South") ;
        saisie.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        System.out.println("** Affichage boite d'options **");
        String txt = (String)JOptionPane.showInputDialog(this,
                        "choisissez une couleur",
                        "BOITE D'OPTIONS",
                        JOptionPane.QUESTION_MESSAGE, null,
                        couleurs, couleurs[1]);

        if (txt == null)
            System.out.println("Pas de choix effectuer");
        else
            System.out.println("Option choisie : " + txt);
    }
}

public class BoiteDialog4 {
    public static void main (String args [])
    {
        FenInput fen = new FenInput();
        fen.setVisible(true);
    }
}
