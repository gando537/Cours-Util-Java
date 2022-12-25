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
        pan = new JPanel() ;
        Container contenu = getContentPane() ;
        contenu.add(pan) ;
        pan.addMouseListener(new EcouteClic(pan));
    }
    private JPanel pan ;
}

class EcouteClic extends MouseAdapter
{
    public EcouteClic (JPanel pan)
    {
        this.pan = pan ;
    }

    public void mouseClicked (MouseEvent e)
    {
        int x = e.getX () , y = e.getY () ;
        Graphics g = pan.getGraphics () ;
        g.drawRect (x, y, 5, 5);
        g.dispose();
    }
    private JPanel pan ;
}

public class TraceClic1 {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
