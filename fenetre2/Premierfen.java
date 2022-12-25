package fenetre2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame
{
    public MaFenetre()
    {
        setTitle("Ma première fenêtre");
        setBounds(50, 100, 650, 400);
        monBouton1 = new JButton("Bouton A") ;
        monBouton2 = new JButton("Bouton B") ;
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        contenu.add(monBouton1);
        contenu.add(monBouton2) ;
        EcouteBouton ecoute1 = new EcouteBouton (10);
        EcouteBouton ecoute2 = new EcouteBouton (20);
        monBouton1.addActionListener(ecoute1);
        monBouton2.addActionListener(ecoute2);
    }
    private JButton monBouton1, monBouton2 ;
}

class EcouteBouton implements ActionListener
{
    public EcouteBouton (int n)
    {
        this.n = n ;
    }
    public void actionPerformed (ActionEvent ev)
    {
        System.out.println ("Action sur Bouton " + n);
    }
    private int n ;
}


public class Premierfen {
    public static void main (String [] args)
    {
        JFrame fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
