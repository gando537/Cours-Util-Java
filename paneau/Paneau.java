package paneau;
import javax.swing.*;
import java.awt.*;

class MaFenetre extends JFrame
{
    public MaFenetre ()
    {
        setTitle("Fenetre = panneau jaune");
        setSize(300, 150);
        paneau = new Dessin () ;
        paneau.setBackground (Color.yellow) ;
        getContentPane().add(paneau) ;
    }
    private JPanel paneau ;
}

class Dessin extends JPanel
{
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawLine(15, 10, 500, 400);
    }
}

public class Paneau {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
