package boiteDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenDialog extends JFrame implements ActionListener
{
    FenDialog ()
    {
        setTitle("Essai Boite de liste");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        lanceDial = new JButton("CHOIX");
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        contenu.add(lanceDial) ;
        lanceDial.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        MonDialog bd = new MonDialog (this);
        texte = bd.lanceDialogue();
        if (texte == null)
            System.out.println("Dialogue abandonné");
        else
            System.out.println("Valeur lue : " + texte);
    }

    private JButton lanceDial;
    private String texte ;
}

class MonDialog extends JDialog implements ActionListener
{
    public MonDialog (JFrame proprio)
    {
        super (proprio, "Dialogue de saisie", true);

        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        okBouton = new JButton("OK");
        okBouton.addActionListener(this);
        champTexte = new JTextField(20);
        Container contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        contenu.add(okBouton);
        contenu.add(champTexte);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource()== okBouton)
        {
            ok = true;
            setVisible(false);
        }
    }

    public String lanceDialogue ()
    {
        ok = false;
        setVisible(true);
        if (ok)
            return champTexte.getText();
        return null;
    }

    private boolean ok;
    private JButton okBouton;
    private JTextField champTexte;
}

public class BoiteDialog5 {
    public static void main (String args [])
    {
        FenDialog fen = new FenDialog();
        fen.setVisible(true);
    }
}
