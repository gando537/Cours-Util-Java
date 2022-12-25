package ellipse;

public class Ellipse
{
    public static void main (String [] args)
    {
        System.out.println(somme(2, 8, 9));
        System.out.println(somme());
        System.out.println(somme(3));
    }

    static int somme (int ... value)
    {
        int res = 0;
        for (int v : value)
            res += v ;
        return res ;
    }
}