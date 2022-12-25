package gestionnaire.cardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Il dispose les composants suivant une pile, de telle façon que seul le composant supérieur
 * soit visibleà un moment donné.
 *
 * Ce programme crée une pile de 8 boutons dans un premier paneau.
 * Un second paneau contient des boutons permettant de parcourir la pile à l'aide
 * des fonctins next, previous, first et last
 */

class MaFenetre extends JFrame implements ActionListener
{
    public static int NBOUTONS = 8;

    public MaFenetre ()
    {
        setTitle("Exemple CardLayout");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        Container contenu = getContentPane();

        panCard = new JPanel();   //Paneau pour la pile
        contenu.add(panCard);

        panCom = new JPanel();   //Paneau pour les boutons de parcours de la pile
        contenu.add(panCom, "South");

        /* Création de la pile de boutons */

        pile = new CardLayout(30, 10);
        panCard.setLayout(pile);

        boutons = new JButton[NBOUTONS];
        for (int i = 0 ; i < NBOUTONS ; i++)
        {
            boutons[i] = new JButton("Bouton " + i);
            panCard.add(boutons[i], "Bouton"); // identification obligatoire ici
        }

        /* Création des boutons de parcours de la pile */

        prec = new JButton("precedent");   panCom.add(prec);
        prec.addActionListener(this);
        suiv = new JButton("suivant");   panCom.add(suiv);
        suiv.addActionListener(this);
        prem = new JButton("premier");   panCom.add(prem);
        prem.addActionListener(this);
        der = new JButton("dernier");   panCom.add(der);
        der.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        JButton source = (JButton)e.getSource();

        if (source == prec) pile.previous(panCard);
        if (source == suiv) pile.next(panCard);
        if (source == prem) pile.first(panCard);
        if (source == der) pile.last(panCard);
    }

    private CardLayout pile;
    private JButton boutons[];
    private JPanel panCard, panCom;
    private JButton prec, suiv, prem, der;
}

public class CardLayout_ {
    public static void main (String [] args) {
        MaFenetre fen = new MaFenetre();
        fen.setVisible (true);
    }
}
