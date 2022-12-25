package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mafenetre extends JFrame implements KeyListener
{
    public Mafenetre ()
    {
        setTitle("Exemple lecture clavier");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        addKeyListener(this);
        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        System.out.println ("Caractère frappé : " + c + " de code " + (int)c);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println ("Touche" + code + " pressée : " + KeyEvent.getKeyText(code));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println ("Touche" + code + " relachée : " + KeyEvent.getKeyText(code));
    }

}


public class EvenementClavier {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
