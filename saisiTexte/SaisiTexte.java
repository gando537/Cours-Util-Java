package saisiTexte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenTexte extends JFrame implements ActionListener
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
        contenu.add(saisi);

        bouton = new JButton("COPIER");
        contenu.add(bouton);
        bouton.addActionListener(this);

        copie = new JTextField(20);
        copie.setEditable(false);
        contenu.add(copie);
    }

    public void actionPerformed (ActionEvent ev)
    {
        if (ev.getSource() == bouton)
        {
            String texte = saisi.getText();
            copie.setText(texte);
        }
    }

    private JTextField saisi, copie ;
    private JButton bouton ;
}

public class SaisiTexte {
    public static void main (String [] args)
    {
        FenTexte fen = new FenTexte() ;
        fen.setVisible(true);
    }
}
