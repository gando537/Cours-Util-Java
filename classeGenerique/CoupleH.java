package classeGenerique;

public class CoupleH
{
	public static void main (String [] args)
	{
		Integer oi1 = 3;	// equivalent à : Integer oi1 = new Integer (3)
		Integer oi2 = 5;    // equivalent à : Integer oi2 = new Integer (5)
		Couple <Integer> ci = new Couple <Integer> (oi1, oi2);
		ci.affiche ();
		Couple <Double> cd = new Couple <Double> (2.0, 12.0);
			/* On peut fournir des arguments de type double qui seront
			   converti automatiquement en Double */
		cd.affiche ();
		Double p = cd.getPremier () ;
		System.out.println ("Premier élément du couple cd = " + p);
	}
}

class Couple <T>
{
	private T x, y;		/* les deux éléments du couple*/
	public Couple (T premier, T second)
	{
		x = premier;
		y = second;
	}

	public void affiche ()
	{
		System.out.println("Première valeur = " + x + " - Deuxième valeur = " + y);
	}

	public T getPremier() { return x; }
	public T getSecond() { return y; }
}
