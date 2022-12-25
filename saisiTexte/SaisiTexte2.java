package saisiTexte;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class FenTexte extends JFrame implements DocumentListener
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
        contenu.add(saisi);
        saisi.getDocument().addDocumentListener(this);

        copie = new JTextField(20);
        copie.setEditable(true);
        copie.setBackground(Color.gray);
        contenu.add(copie);
    }

    public void insertUpdate (DocumentEvent e)
    {
        String texte = saisi.getText();
        copie.setText(texte);
    }

    public void removeUpdate (DocumentEvent e)
    {
        String texte = saisi.getText();
        copie.setText(texte);
    }

    public void changedUpdate (DocumentEvent e)
    {}

    private JTextField saisi, copie ;
}

public class SaisiTexte2 {
    public static void main (String [] args)
    {
        FenTexte fen = new FenTexte() ;
        fen.setVisible(true);
    }
}

