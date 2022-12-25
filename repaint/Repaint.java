package repaint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MaFenetre extends JFrame implements ActionListener
{
    MaFenetre ()
    {
        setTitle("Exemple appel repaint");
        setSize(300, 200);
        Container contenu = getContentPane() ;

        pan = new Paneau () ;
        pan.setBackground (Color.cyan) ;
        contenu.add(pan) ;

        rectangle = new JButton("Rectangle") ;
        contenu.add(rectangle, "North");
        rectangle.addActionListener(this) ;

        ovale = new JButton("Ovale") ;
        contenu.add(ovale, "South");
        ovale.addActionListener(this) ;
    }

    public void actionPerformed (ActionEvent ev)
    {
        if (ev.getSource() == rectangle)
            pan.setRectangle ();
        if (ev.getSource() == ovale)
            pan.setOvale () ;
        pan.repaint () ;                    // Pour forcer la peinture du paneau dès maintenant
    }

    private Paneau pan ;
    private JButton rectangle, ovale ;
}

class Paneau extends JPanel
{
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);

        // connaitre les dimensions d'un composant
        Dimension dim = getSize() ;
        int larg = dim.width ;
        int haut = dim.height ;

        if (ovale)
            g.drawOval(10, 10, larg - 20, haut - 20);
        if (rectangle)
            g.drawRect(10, 10, larg - 20, haut - 20);
    }

    public void setRectangle () { rectangle = true ; ovale = false ; }
    public void setOvale () { rectangle = false ; ovale = true ; }
    private boolean rectangle = false, ovale = false ;
}

public class Repaint {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre() ;
        fen.setVisible(true);
    }
}
