package tab2D;

class Util
{
    static void raz (int t [][])
    {
        int i, j ;
        for (i = 0; i < t.length ; i++)
            for (j = 0; j < t[i].length ; j++)
                t[i][j] = 0 ;
    }

    static void affiche (int t [][])
    {
        int i = 1;
        for (int [] line : t)
        {
            System.out.print ("ligne de rang : " + i + " = ");
            for (int col : line)
                System.out.print (col + " ") ;
            System.out.println () ;
            i++;
        }
    }
}

public class Tab2D
{
    public static void main (String [] args)
    {
        int t[][] = {{1, 2, 3}, {11, 12}, {21, 22, 23, 24}};
        System.out.println("t avant raz : ") ;
        Util.affiche(t) ;
        Util.raz (t) ;
        System.out.println("t apres raz : ");
        Util.affiche(t);
    }
}