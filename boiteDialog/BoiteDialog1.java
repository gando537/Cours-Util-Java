package boiteDialog;

import javax.swing.*;
import java.awt.*;

class MaFenetre extends JFrame
{
    MaFenetre ()
    {
        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

public class BoiteDialog1 {
    public static void main (String args [])
    {
        MaFenetre fen = new MaFenetre();
        fen.setVisible(true);
        JOptionPane.showMessageDialog(fen, "Mauvais choix",
                                "Message d'avertissement",
                                JOptionPane.ERROR_MESSAGE);
    }
}
