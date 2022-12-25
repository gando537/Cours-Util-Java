package anonyme;

class A
{
    public void affiche () { System.out.println ("Je suis un A") ; }
}

public class Anonyme
{
    public static void main (String [] args)
    {
        A a ;
        A a1 ;
        a = new A() {
            public void affiche ()
            {
                System.out.println ("Je suis un anonyme de derive de A") ;
            }
        } ;

        a.affiche();

        a1 = new A() {} ;
        a1.affiche();
    }
}
