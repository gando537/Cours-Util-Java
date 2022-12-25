package traceClic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame
{
    MaFenetre ()
    {
        setTitle("Trace de Clic");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        pan = new EcouteClic() ;
        Container contenu = getContentPane() ;
        contenu.add(pan) ;
    }
    private JPanel pan ;
}

class EcouteClic extends JPanel
{
    final int MAX = 5 ;

    public EcouteClic ()
    {
        abs = new int [MAX] ; ord = new int [MAX] ;
        nbClics = 0 ;
        addMouseListener (new MouseAdapter()
            {
                public void mouseClicked (MouseEvent e)
                {
                    if (nbClics < MAX)
                    {
                        abs[nbClics] = e.getX () ;
                        ord[nbClics] = e.getY () ;
                        nbClics++ ;
                        repaint ();
                    }
                }
            }
        );
    }

    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0 ; i < nbClics ; i++)
            g.drawRect(abs[i], ord[i], 5, 5);
    }
    private int nbClics ;
    private int abs [] , ord [] ;
}

public class TraceClic2 {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
