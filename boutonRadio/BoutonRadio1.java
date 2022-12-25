package boutonRadio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCoches extends JFrame implements ActionListener
{
    public FenCoches ()
    {
        setTitle("Exemple de boutons radios");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());
        ButtonGroup groupe = new ButtonGroup();

        radio1 = new JRadioButton ("radio 1");
        groupe.add(radio1);
        contenu.add(radio1);
        radio1.addActionListener (this) ;

        radio2 = new JRadioButton("radio 2");
        groupe.add(radio2);
        contenu.add(radio2);
        radio2.addActionListener (this) ;

        radio3 = new JRadioButton("radio 3");
        groupe.add(radio3);
        contenu.add(radio3);
        radio3.addActionListener (this) ;

        Etat = new JButton("Etat");
        contenu.add(Etat);
        Etat.addActionListener (this) ;
    }

    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource();
        if (source == radio1)
            System.out.println("action radio 1");
        if (source == radio2)
            System.out.println("action radio 2");
        if (source == radio3)
            System.out.println("action radio 3");
        if (source == Etat)
            System.out.println("Etat Cases : " + radio1.isSelected() + " "
                                                + radio2.isSelected() + " "
                                                + radio3.isSelected());
    }

    private JRadioButton radio1, radio2, radio3 ;
    private JButton Etat ;
}

public class BoutonRadio1 {
    public static void main (String [] args)
    {
        FenCoches fen = new FenCoches() ;
        fen.setVisible(true);
    }
}
