package fluxFichiers;
import java.io.*;

public class Clavier
{
    public static String lireString ()
    {
        String ligne_lue = null ;
        try
        {
            InputStreamReader lecteur = new InputStreamReader(System.in) ;
            BufferedReader entree = new BufferedReader(lecteur) ;
            ligne_lue = entree.readLine() ;
        }
        catch (IOException err)
        {
            System.exit(0) ;
        }
        return ligne_lue ;
    }

    public static float lireFloat ()
    {
        float x = 0 ;
        try
        {
            String ligne_lue = lireString() ;
            x = Float.parseFloat(ligne_lue) ;
        }
        catch (NumberFormatException err)
        {
            System.out.println("*** Erreur de donnee ***") ;
            System.exit(0) ;
        }
        return x ;
    }

    public static double lireDouble ()
    {
        double x = 0 ;
        try
        {
            String ligne_lue = lireString() ;
            x = Double.parseDouble(ligne_lue) ;
        }
        catch (NumberFormatException err)
        {
            System.out.println("*** Erreur de donnee ***") ;
            System.exit(0) ;
        }
        return x ;
    }

    public static int lireInt ()
    {
        int x = 0 ;
        try
        {
            String ligne_lue = lireString() ;
            x = Integer.parseInt(ligne_lue) ;
        }
        catch (NumberFormatException err)
        {
            System.out.println("*** Erreur de donnee ***") ;
            System.exit(0) ;
        }
        return x ;
    }

    public static void main (String [] args)
    {
        System.out.print ("donnez un flottant > ");
        float x ;
        x = Clavier.lireFloat () ;
        System.out.println ("merci pour " + x) ;
        System.out.print ("donnez un entier > ");
        int n ;
        n = Clavier.lireInt () ;
        System.out.println ("merci pour " + n) ;
    }
}

