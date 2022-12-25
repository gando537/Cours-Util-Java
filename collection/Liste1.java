package collection;

import java.util.*;

public class Liste1
{
	public static void main (String [] args)
	{
		LinkedList <String> l = new LinkedList <String> ();

		System.out.print ("Liste en A : ");
		affiche (l);

		l.add("a") ; l.add("b");		// ajout en fin de liste
		System.out.print ("Liste en B : ");
		affiche (l);

		ListIterator <String> it = l.listIterator ();
		it.next ();						// On se place sur le premier élément
		it.add("c") ; it.add("b"); 		// et on ajout deux éléments
		System.out.print ("Liste en C : ");
		affiche (l);

		it = l.listIterator ();
		it.next ();						// On progresse d'un élément
		it.add("b") ; it.add("d");		// Et on ajoute deux éléments
		System.out.print ("Liste en D : ");
		affiche (l);

		it = l.listIterator (l.size());	// On se place en fin de liste
		while (it.hasPrevious())		// on recherche le dernier b
		{
			String ch = it.previous ();

			if (ch.equals("b"))
			{
				it.remove();			// et on le supprime
				break ;
			}
		}
		System.out.print ("Liste en E : ");
		affiche (l);

		it = l.listIterator () ;
		it.next ();
		it.next ();						// On se place sur le deuxième élément
		it.set ("x");					// On le remplace par x
		System.out.print ("Liste en F : ");
		affiche (l);
	}
	public static void affiche (LinkedList <String> l)
	{
		ListIterator <String> iter = l.listIterator ();
		while (iter.hasNext())
			System.out.print (iter.next () + " ");		// iter.next sert aussi à incrémenté
		System.out.println();
	}
}
