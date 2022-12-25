package classeGenerique;

public class CoupleM
{
	public static void main (String [] args)
	{
		Integer oi1 = 3;	// equivalent à : Integer oi1 = new Integer (3)
		Double od1 = 2.5;    // equivalent à : Integer oi2 = new Integer (5)
		Couple <Integer, Double> ch1 = new Couple <Integer, Double> (oi1, od1);
		ch1.affiche ();

		Integer oi2 = 4;
		Couple <Integer, Integer> ch2 = new Couple <Integer, Integer> (oi1, oi2);
		ch2.affiche ();
		Integer n = ch1.getPremier () ;
		System.out.println ("Premier élément du couple ch1 = " + n);
	}
}

class Couple <T, U>
{
	private T x;		/* le premier élément du couple*/
	private U y;		/* le deuxième élément du couple*/
	public Couple (T premier, U second)
	{
		x = premier;
		y = second;
	}

	public void affiche ()
	{
		System.out.println("Première valeur = " + x + " - Deuxième valeur = " + y);
	}

	public T getPremier() { return x; }
	public U getSecond() { return y; }
}
