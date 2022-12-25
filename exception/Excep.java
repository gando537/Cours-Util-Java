package exception;

class Point
{
    public Point (int x, int y) throws ErrConst
    {
        if ( (x < 0) || (y < 0) )
            throw new ErrConst (x, y) ;
        this.x = x ;
        this.y = y ;
    }
    public void deplace (int dx, int dy) throws ErrDepl
    {
        if ( (x + dx) < 0 || (y + dy) < 0)
            throw new ErrDepl ("    Erreur de déplacement avec : " + dx + " " + dy) ;
        this.x += dx ;
        this.y += dy ;
    }
    public void affiche ()
    {
        System.out.println ("   Mes coordonnées sont : " + x + " " + y);
    }
    private int x, y ;
}

class ErrConst extends Exception
{
    ErrConst (int abs, int ord)
    {
        this.abs = abs;
        this.ord = ord;
    }
    public int abs, ord;
}

class ErrDepl extends Exception
{
    ErrDepl (String mes)
    { super(mes);}
}

public class Excep {
    public static void main (String [] args)
    {
        try {
            Point a = new Point(1, 4);
            a.affiche();
            a.deplace(-3, 4);
            a.affiche();
            a = new Point(-3, 5);
            a.affiche();
        } catch (ErrConst e) {
            System.out.println ("   Erreur construction");
            System.out.println ("   Coordonnées souhaitées : " + e.abs + " " + e.ord);
            System.exit(-1);
        }
        catch (ErrDepl e) {
            System.out.println (e.getMessage());
            System.exit(-1);
        }
    }
}
