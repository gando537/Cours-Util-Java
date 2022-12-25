package fenetre3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame
{
    public MaFenetre()
    {
        setTitle("Bouton dynamique");
        setBounds(50, 100, 650, 400);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        crBouton = new JButton("Création Bouton") ;
        contenu.add(crBouton);
        EcouteCr ecouteCr = new EcouteCr(contenu) ;
        crBouton.addActionListener(ecouteCr);
    }
    private JButton crBouton ;
}

class EcouteCr implements ActionListener
{
    public EcouteCr (Container contenu)
    {
        this.contenu = contenu ;
    }
    public void actionPerformed (ActionEvent ev)
    {
        JButton nouvBouton = new JButton("BOUTON");
        contenu.add(nouvBouton);
        contenu.validate(); // pour recalculer
    }
    private Container contenu ;
}

public class Premierfen {
    public static void main (String [] args)
    {
        JFrame fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
