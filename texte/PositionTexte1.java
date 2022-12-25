package texte;

import java.awt.*;
import javax.swing.*;

/* Affichage d'un texte sur deux lignes */

class MaFenetre extends JFrame
{
    public MaFenetre ()
    {
        setTitle("Essai Texte");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        pan = new Paneau();
        getContentPane().add(pan);
        pan.setBackground(Color.black);
        pan.setForeground(Color.green); // La couleur de la police

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private Paneau pan;
}

class Paneau extends JPanel
{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 20, y = 30;
        String ch1 = "Bonjour";
        String ch2 = "Monsieur";
        g.drawString(ch1, x, y);
        FontMetrics fm = g.getFontMetrics();
        y += fm.getHeight();
        g.drawString(ch2, x, y);
    }
}

public class PositionTexte1 {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre ();
        fen.setVisible(true);
    }
}
