package boiteDialog;

import javax.swing.*;

public class BoiteDialog3 {
    public static void main (String args [])
    {
        String txt ;
        while (true)
        {
            txt = JOptionPane.showInputDialog(null, "Voulez-vous continuer");
            if (txt == null)
                System.out.println("aucun saisie");
            else
                System.out.println("saisie : [" + txt + "] de longueur : " + txt.length());
        }
    }
}
