package boiteDialog;

import javax.swing.*;

public class BoiteDialog2 {
    public static void main (String args [])
    {
        while (true)
        {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous continuer");
            System.out.println("réponse : " + rep);
        }
    }
}
