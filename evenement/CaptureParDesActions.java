package evenement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Permet de modifier la couleur d'un paneau en utilisant l'une des combinaisons de touches
 * Ctrl-Alt-r (pour rouge) , Ctrl-Alt-b (pour bleu) ou Ctrl-Alt-y (pour jaune)
 *
 * La capture se fait ici par des actions
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

        pan = new Paneau();
        contenu.add(pan);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Paneau pan;

}

class Paneau extends JPanel
{
    public Paneau()
    {
        actionRouge = new ActionCouleur("rouge", Color.red, this);
        actionBleu = new ActionCouleur("bleu", Color.blue, this);
        actionJaune = new ActionCouleur("jaune", Color.yellow, this);

        registerKeyboardAction(actionRouge,
                                KeyStroke.getKeyStroke(KeyEvent.VK_R,
                                                        InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK),
                                JComponent.WHEN_IN_FOCUSED_WINDOW);

        registerKeyboardAction(actionBleu,
                                KeyStroke.getKeyStroke(KeyEvent.VK_B,
                                                        InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK),
                                JComponent.WHEN_IN_FOCUSED_WINDOW);

        registerKeyboardAction(actionJaune,
                                KeyStroke.getKeyStroke(KeyEvent.VK_J,
                                                        InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK),
                                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private ActionCouleur actionRouge, actionBleu, actionJaune;
}

class ActionCouleur extends AbstractAction
{
    public ActionCouleur (String nomCouleur, Color couleur, Paneau pan)
    {
        super(nomCouleur);
        this.nomCouleur = nomCouleur;
        this.couleur = couleur;
        this.pan = pan;
    }

    public void actionPerformed (ActionEvent e)
    {
        pan.setBackground(couleur);
    }

    private String nomCouleur;
    private Color couleur;
    private Paneau pan;
}

public class CaptureParDesActions {
    public static void main (String [] args)
    {
        Mafenetre fen = new Mafenetre();
        fen.setVisible(true);
    }
}
