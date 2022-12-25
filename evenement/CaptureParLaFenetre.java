package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Permet de modifier la couleur d'un paneau en utilisant l'une des combinaisons de touches
 * Ctrl-Alt-r (pour rouge) , Ctrl-Alt-b (pour bleu) ou Ctrl-Alt-y (pour jaune)
 */

class Mafenetre extends JFrame 
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

        Container contenu = getContentPane();

        pan = new JPanel();
        contenu.add(pan);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if ((e.isControlDown() && e.isAltDown())) {
                    int touche = e.getKeyCode();
                    switch(touche) {
                        case KeyEvent.VK_R :
                            pan.setBackground(Color.red);
                            break;
                        case KeyEvent.VK_B :
                            pan.setBackground(Color.blue);
                            break;
                        case KeyEvent.VK_J :
                            pan.setBackground(Color.yellow);
                            break;
                    }
                }
            }
        });
        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPanel pan;

}


public class CaptureParLaFenetre {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
