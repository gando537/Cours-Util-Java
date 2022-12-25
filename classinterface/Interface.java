package classinterface;

interface Affichable
{
    abstract public void affiche () ;
}

class Entier implements Affichable
{
    public Entier (int n)
    {
        value = n ;
    }
    public void affiche ()
    {
        System.out.println("Je suis un entier de valeur : " + value) ;
    }
    private int value ;
}

class Floattant implements Affichable
{
    public Floattant (float n)
    {
        value = n ;
    }
    public void affiche ()
    {
        System.out.println("Je suis un flottant de valeur : " + value) ;
    }
    private float value ;
}

public class Interface
{
    public static void main (String [] args)
    {
        Affichable [] tab ;

        tab = new Affichable [3] ;
        tab[0] = new Entier(25) ;
        tab[1] = new Floattant(1.25f) ;
        tab[2] = new Entier(42) ;
        for(Affichable t : tab)
            t.affiche();
    }
}

