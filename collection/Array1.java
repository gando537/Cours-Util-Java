package collection;

import java.util.*;

public class Array1
{
	public static void main (String [] args)
	{
		ArrayList <Integer> v = new ArrayList <Integer> ();

		System.out.println ("En A : taille de v = " + v.size ());

		/* on ajout 10 objets de types intager */

		for (int i = 0 ; i < 10 ; i++)
			v.add(new Integer (i));

		System.out.println ("En B : taille de v = " + v.size ());

		/* Affichage du contenu de v, par accés direct (get) a chaque élement*/

		System.out.println ("En B : contenu de v = ");
		for (Integer e : v)
			System.out.print (e + " ");
		System.out.println ();

		/* Suppression des éléments à une position donnée */

		v.remove (3);
		v.remove (5);
		v.remove (5);

		System.out.println ("En C : contenu de v = " + v);

		/* ajout d'éléments à une position donnée */

		v.add(2, new Integer (100));
		v.add(2, new Integer (200));
		System.out.println ("En D : contenu de v = " + v);

		/* modification d'élements à une position donnnée */

		v.set(2, new Integer (1000)); // modification de l'élément au rang 2
		v.set(5, new Integer (2000)); // modification de l'élément au rang 5

		System.out.println ("En E : contenu de v = " + v);
	}
}
