package boiteDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenDialog extends JFrame implements ActionListener
{
    static public final String [] nomCouleurs = {"rouge", "vert", "jaune", "bleu"} ;
    static public final Color [] couleurs = {Color.red, Color.green, Color.yellow, Color.blue} ;
    FenDialog ()
    {
        setTitle("FIGURES AVEC BOITES DE DIALOGUE");

        // Pour connaitre la taille de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);
        Container contenu = getContentPane();

        /** paneau pour les dessins */

        pan = new PaneauDessin () ;
        contenu.add(pan) ;
        pan.setBackground(Color.cyan) ; // Paneau initialement bleu

        /* bouton pour lancer la boite de dialogue */

        lanceDial = new JButton("MODIFICATIONS");
        contenu.add(lanceDial, "South") ;
        lanceDial.addActionListener(this);

        /* ferméture avec le croix rouge */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (dialogue == null)
        {
            dialogue = new Dialogue (this);
            infos = new Infos();
        }

        /* récupération informations courantes dans l'objet infos */

        infos.largeur = pan.getLargeur();
        infos.hauteur = pan.getHauteur();
        infos.rectangle = pan.getRectangle();
        infos.ovale = pan.getOvale();
        infos.nomCouleurs = pan.getnomCouleurs();

        /* Lancement dialogue */

        dialogue.lanceDial(infos);

        /* Prise en compte de nouvelles informations */

        pan.setLargeur (infos.largeur);
        pan.setHauteur (infos.hauteur);
        pan.setRectangle (infos.rectangle);
        pan.setOvale (infos.ovale);
        pan.setCouleur (infos.nomCouleurs);
        pan.repaint ();
    }

    private JButton lanceDial;
    private Dialogue dialogue;
    private PaneauDessin pan ;
    private Infos infos ;
}

class Dialogue extends JDialog implements ActionListener
{
    public Dialogue (JFrame proprio)
    {
        super (proprio, "COULEURS, FORMES, TAILLES", true);

        Toolkit tk = Toolkit.getDefaultToolkit () ;
        Dimension dimEcran = tk.getScreenSize() ;
        int large = dimEcran.width ;
        int haut = dimEcran.height ;

        setSize(large / 2, haut / 2);

        okBouton = new JButton("OK");
        cancelBouton = new JButton("CANCEL");
        okBouton.addActionListener(this);
        cancelBouton.addActionListener(this);
        Container contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        contenu.add(okBouton);
        contenu.add(cancelBouton);

        /* choix couleur */

        comboCoulFond = new JComboBox<>(FenDialog.nomCouleurs);
        contenu.add(comboCoulFond);

        /*choix dimensions */

        JLabel dim = new JLabel("DIMENSIONS") ;
        contenu.add(dim);
        txtLargeur = new JTextField(5);
        txtHauteur = new JTextField(5);
        contenu.add(txtLargeur);
        contenu.add(txtHauteur);

        /* Choix formes */

        cOvale = new JCheckBox("Ovale");
        contenu.add(cOvale);
        cRectangle = new JCheckBox("Rectangle");
        contenu.add(cRectangle);
    }

    public void lanceDial (Infos infos)
    {
        /*Placer infos dans controles */

        txtLargeur.setText(""+infos.largeur);
        txtHauteur.setText(""+infos.hauteur);
        cOvale.setSelected(infos.ovale);
        cRectangle.setSelected(infos.rectangle);
        comboCoulFond.setSelectedItem(infos.nomCouleurs);

        /* Lancer le dialogue */

        ok = false;
        setVisible(true);

        /*si ok on récupère les infos du dialogue */
        if (ok)
        {
            infos.largeur = Integer.parseInt(txtLargeur.getText());
            infos.hauteur = Integer.parseInt(txtHauteur.getText());
            infos.rectangle = cRectangle.isSelected();
            infos.ovale = cOvale.isSelected();
            infos.nomCouleurs = (String)comboCoulFond.getSelectedItem();
        }
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource()== okBouton)
        {
            ok = true;
            setVisible(false);
        }
        if (e.getSource() == cancelBouton)
            setVisible(false);
    }

    private boolean ok = false;
    private JComboBox comboCoulFond;
    private JButton okBouton, cancelBouton;
    private JCheckBox cOvale, cRectangle;
    private JTextField txtLargeur, txtHauteur;
}

class Infos
{
    public boolean ovale, rectangle;
    public int largeur, hauteur;
    public String nomCouleurs;
}

class PaneauDessin extends JPanel
{
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        if (ovale)
            g.drawOval(10, 10, 10 + largeur, 10 + hauteur);
        if (rectangle)
            g.drawRect(10, 10, 10 + largeur, 10 + hauteur);
    }
    public void setRectangle(boolean b) { rectangle = b ;}
    public void setOvale(boolean b) { ovale = b ;}
    public void setLargeur (int l) { largeur = l ;}
    public void setHauteur (int h) { hauteur = h ;}
    public void setCouleur (String c)
    {
        for (int i = 0 ; i < FenDialog.nomCouleurs.length ; i++) {
            if (c == FenDialog.nomCouleurs[i])
                setBackground(FenDialog.couleurs[i]);
        }
        nomCouleurs = c;
    }

    public boolean getRectangle() { return rectangle ;}
    public boolean getOvale() { return ovale;}
    public int getLargeur () { return largeur;}
    public int getHauteur () { return hauteur;}
    public String getnomCouleurs () { return nomCouleurs;}

    private boolean rectangle = false, ovale = false;
    private int largeur = 50, hauteur = 50 ;
    private String nomCouleurs = FenDialog.nomCouleurs[0];
}

public class FigBoiteDial {
    public static void main (String args [])
    {
        FenDialog fen = new FenDialog();
        fen.setVisible(true);
    }
}
