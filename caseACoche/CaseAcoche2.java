package caseACoche;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCoches extends JFrame implements ActionListener, ItemListener
{
    public FenCoches ()
    {
        setTitle("Exemple de case à cocher");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane() ;
        contenu.setLayout(new FlowLayout());

        case1 = new JCheckBox("Case 1");
        contenu.add(case1);
        case1.addItemListener (this) ;

        case2 = new JCheckBox("Case 2");
        contenu.add(case2);
        case2.addItemListener (this) ;

        Etat = new JButton("Etat");
        contenu.add(Etat);
        Etat.addActionListener (this) ;
    }

    public void itemStateChanged (ItemEvent ev)  //écouter événémenent Item
    {
        Object source = ev.getSource();
        if (source == case1)
            System.out.println("action case 1");
        if (source == case2)
            System.out.println("action case 2");
    }

    public void actionPerformed (ActionEvent ev)
    {
        System.out.println("Etat Cases : " + case1.isSelected() + " " + case2.isSelected());
    }

    private JCheckBox case1, case2 ;
    private JButton Etat ;
}

public class CaseAcoche2 {
    public static void main (String [] args)
    {
        FenCoches fen = new FenCoches() ;
        fen.setVisible(true);
    }
}
