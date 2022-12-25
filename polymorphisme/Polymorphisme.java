package polymorphisme;

class Point
{
    public Point (int x, int y)
    { this.x = x ; this.y = y ;}

    public void affiche ()
    {
        identifie ();
        System.out.println ("   Mes coordonnées sont : " + x + " " + y);
    }

    public void identifie ()
    {
        System.out.println ("Je suis un point ");
    }

    private int x , y ;
}

class Pointcol extends Point
{
    public Pointcol (int x, int y, byte col)
    {
        super(x, y);
        this.col = col ;
    }
    public void identifie ()
    {
        System.out.println ("Je suis un pointcol de couleur : " + this.col);
    }
    byte col ;
}

public class Polymorphisme
{
    public static void main (String [] args)
    {
        Point [] tabPts = new Point [4] ;

        tabPts[0] = new Point (0, 2);
        tabPts[1] = new Pointcol (1, 5, (byte)3);
        tabPts[2] = new Pointcol (2, 8, (byte)9);
        tabPts[3] = new Point (1, 2);

        for (Point p: tabPts)
            p.affiche();
    }
}