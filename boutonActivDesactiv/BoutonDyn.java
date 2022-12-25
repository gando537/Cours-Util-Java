package boutonActivDesactiv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenBoutonDyn extends JFrame implements ActionListener
{
    final int NBOUTONS = 5;
    public FenBoutonDyn()
    {
        setTitle("Activation / Désactivation");
        setBounds(50, 100, 650, 400);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        tabBouton = new JButton[NBOUTONS];
        for (int i = 0 ; i < NBOUTONS ; i++)
        {
            tabBouton[i] = new JButton("BOUTON " + i);
            contenu.add(tabBouton[i]);
            tabBouton[i].addActionListener(this);
        }
    }

    public void actionPerformed (ActionEvent ev)
    {
        System.out.print ("Etat Boutons = ") ;
        for (int i = 0 ; i < NBOUTONS ; i++)
            System.out.print (tabBouton[i].isEnabled() + " ") ;
        System.out.println ();
        JButton source = (JButton) ev.getSource() ;
        System.out.println ("on désactive le bouton : " + source.getActionCommand());
        source.setEnabled(false);
    }
    private JButton tabBouton [] ;
}

public class BoutonDyn {
    public static void main (String [] args)
    {
        FenBoutonDyn fen = new FenBoutonDyn() ;
        fen.setVisible(true);
    }
}
