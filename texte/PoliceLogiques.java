package texte;

import java.awt.*;
import javax.swing.*;

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
        String fontes [] = {"SansSerif", "Serif", "Monospaced", "Dialog", "DialoInput"};
        int styles [] = {Font.PLAIN, Font.BOLD, Font.ITALIC, Font.PLAIN, Font.BOLD+Font.ITALIC};
        int tailles [] = {12, 10, 18, 32, 24};
        int x = 10, y = 10;
        for (int i = 0; i < fontes.length; i++) {
            g.setFont(new Font (fontes[i], styles[i], tailles[i]));
            FontMetrics fm = g.getFontMetrics();
            String ch = fontes[i] + " " + tailles[i] + " abcdefghijklmnopqrstuvwxyz0123456789";
            y += fm.getAscent();
            g.drawString(ch, x, y);
            y += fm.getDescent() + fm.getLeading();
        }
    }
}

public class PoliceLogiques {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre ();
        fen.setVisible(true);
    }
}
