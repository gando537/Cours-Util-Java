 class Fact
{
    public static long fac (int n)
    {
        return (n > 1) ? fac (n - 1) * n : 1 ;
    }
}

public class Factorielle
{
    public static void main (String [] args)
    {
        int n ;

        System.out.print ("donnez un nombre > ") ;
        n = Clavier.lireInt() ;
        System.out.println("Voici la factorielle de " + n + " = " + Fact.fac(n)) ;
    }
}
