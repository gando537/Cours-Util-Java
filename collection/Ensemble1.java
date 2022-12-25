package collection;

import java.util.*;

public class Ensemble1
{
	public static void main (String [] args)
	{
		int t[] = { 2, 5, -6, 2, -8, 9, 5};
		HashSet <Integer> ens = new HashSet <Integer> ();

		/* On ajoute des objets de type Integer */

		for (int v : t)
		{
			boolean ajoute = ens.add(v);
			if (ajoute)
				System.out.println ("	On ajoute " + v);
			else
				System.out.println ("	" + v + " est déjà présent");
		}
		System.out.print ("Ensemble en A : ");
		affiche (ens);

		/* On supprime un éventuel objet de valeur Integer(5) */

		Integer cinq = 5;
		boolean enlev = ens.remove (cinq);
		if (enlev)
			System.out.println ("	On a supprimé " + cinq);
		else
			System.out.println ("	On ne trouve pas " + cinq);

		System.out.print ("Ensemble en B : ");
		affiche(ens);

		/* On teste la présence de 5 */

		boolean existe = ens.contains (cinq);
		if (!existe)
			System.out.println ("	On ne trouve pas " + cinq);
		else
			System.out.println ("	Il existe un " + cinq);
	}
	
	public static <E> void affiche (HashSet <E> ens)
	{
		Iterator <E> iter = ens.iterator ();
		while (iter.hasNext())
			System.out.print (iter.next() + " ");
		System.out.println();
	}
}
