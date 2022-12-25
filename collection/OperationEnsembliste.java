package collection;

import java.util.*;

public class OperationEnsembliste
{
	public static void main (String [] args)
	{
		int t1[] = {2, 5, 6, 8, 9};
		int t2[] = {3, 6, 7, 9};

		HashSet <Integer> e1 = new HashSet <Integer> ();
		HashSet <Integer> e2 = new HashSet <Integer> ();

		for (int v : t1)
			e1.add(v);

		for (int v : t2)
			e2.add(v);

		System.out.println ("e1 = " + e1);
		System.out.println ("e2 = " + e2);

		/* Réunion de e1 et e2 dans u1 */
		
		HashSet <Integer> u1 = new HashSet <Integer> ();
		copie(u1, e1);		// copie e1 dans u1
		u1.addAll(e2);
		System.out.println ("u1 = " + u1);

		/* Intersection de e1 et e2 dans i1 */

		HashSet <Integer> i1 = new HashSet <Integer> ();
		copie (i1, e1);
		i1.retainAll(e2);
		System.out.println ("i1 = " + i1);
	}

	public static <E> void copie (HashSet <E> dest, HashSet <E> src)
	{
		Iterator <E> iter = src.iterator ();
		while (iter.hasNext())
			 dest.add(iter.next());
	}
}
