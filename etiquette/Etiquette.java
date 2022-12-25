package etiquette;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCoches extends JFrame implements ActionListener
{
    public FenCoches ()
    {
        setTitle("Exemple Etiquettes");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        bouton = new JButton("COMPTEUR");
        bouton.addActionListener(this);
        contenu.add(bouton);
        nbClics = 0;
        compte = new JLabel("" + nbClics);
        titre = new JLabel("Nombre de clics sur COMPTEUR = ");
        contenu.add(titre);
        contenu.add(compte);
    }

    public void actionPerformed (ActionEvent ev)
    {
        nbClics++;
        compte.setText("" + nbClics);
    }

    private JLabel compte ;
    private JLabel titre ;
    private JButton bouton ;
    private int nbClics ;
}

public class Etiquette {
    public static void main (String [] args)
    {
        FenCoches fen = new FenCoches() ;
        fen.setVisible(true);
    }
}
