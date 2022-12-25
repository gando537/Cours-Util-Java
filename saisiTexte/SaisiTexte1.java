package saisiTexte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenTexte extends JFrame implements ActionListener, FocusListener
{
    public FenTexte ()
    {
        setTitle("Saisi de texte");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());

        saisi = new JTextField(20);
        saisi.addActionListener(this);
        saisi.addFocusListener(this);
        contenu.add(saisi);

        bouton = new JButton("COPIER");
        contenu.add(bouton);
        bouton.addActionListener(this);

        copie = new JTextField(20);
        copie.setEditable(false);
        contenu.add(copie);
    }

    public void focusLost (FocusEvent e)
    {
        System.out.println ("Perte focus saisie");
        String texte = saisi.getText();
        copie.setText(texte);
    }

    public void focusGained (FocusEvent e)
    {
        System.out.println ("Focus sur saisie");
    }

    public void actionPerformed (ActionEvent ev)
    {
        if (ev.getSource() == bouton)
        {
            System.out.println ("Validation saisie");
            String texte = saisi.getText();
            copie.setText(texte);
        }
    }

    private JTextField saisi, copie ;
    private JButton bouton ;
}

public class SaisiTexte1 {
    public static void main (String [] args)
    {
        FenTexte fen = new FenTexte() ;
        fen.setVisible(true);
    }
}

