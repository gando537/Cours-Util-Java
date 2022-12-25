package fenetre;
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
        EcouteBouton1 ecoute1 = new EcouteBouton1 ();
        EcouteBouton2 ecoute2 = new EcouteBouton2 ();
        monBouton1.addActionListener(ecoute1);
        monBouton2.addActionListener(ecoute2);
    }
    private JButton monBouton1, monBouton2 ;
}

class EcouteBouton1 implements ActionListener
{
    public void actionPerformed (ActionEvent ev)
    {
        System.out.println ("Action sur Bouton A");
    }
}

class EcouteBouton2 implements ActionListener
{
    public void actionPerformed (ActionEvent ev)
    {
        System.out.println ("Action sur Bouton B");
    }
}

public class Premierfen {
    public static void main (String [] args)
    {
        JFrame fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
