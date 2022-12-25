package caseACoche;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenCoches extends JFrame implements ActionListener
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
        case1.addActionListener (this) ;

        case2 = new JCheckBox("Case 2");
        contenu.add(case2);
        case2.addActionListener (this) ;

        Etat = new JButton("Etat");
        contenu.add(Etat);
        Etat.addActionListener (this) ;
    }

    public void actionPerformed (ActionEvent ev)
    {
        Object source = ev.getSource();
        if (source == case1)
            System.out.println("action case 1");
        if (source == case2)
            System.out.println("action case 2");
        if (source == Etat)
            System.out.println("Etat Cases : " + case1.isSelected() + " " + case2.isSelected());
    }

    private JCheckBox case1, case2 ;
    private JButton Etat ;
}

public class CaseAcoche1 {
    public static void main (String [] args)
    {
        FenCoches fen = new FenCoches() ;
        fen.setVisible(true);
    }
}
