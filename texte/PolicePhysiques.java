/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   PolicePhysiques.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: mdiallo <mdiallo@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/06/13 18:38:19 by mdiallo           #+#    #+#             */
/*   Updated: 2022/06/13 18:39:22 by mdiallo          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

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

        Dimension d = new Dimension(500, 3000);
        pan.setPreferredSize(d);
        defil = new JScrollPane(pan);

        getContentPane().add(defil);
        pan.setBackground(Color.black);
        pan.setForeground(Color.green); // La couleur de la police

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private Paneau pan;
    private JScrollPane defil;
}

class Paneau extends JPanel
{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Pour obtenir les noms de toutes les fontes disponibles dans un tableau de chaînes nommé fontes []  */
        String fontes [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames() ;
        int x = 10, y = 10;
        for (int i = 0; i < fontes.length; i++) {
            g.setFont(new Font (fontes[i], Font.PLAIN, 12));
            FontMetrics fm = g.getFontMetrics();
            y += fm.getAscent();
            String ch = fontes[i] + " " + " abcdefghijklmnopqrstuvwxyz0123456789";
            g.drawString(ch, x, y);
            y += fm.getDescent() + fm.getLeading();
        }
    }
}

public class PolicePhysiques {
    public static void main (String [] args)
    {
        MaFenetre fen = new MaFenetre ();
        fen.setVisible(true);
    }
}
