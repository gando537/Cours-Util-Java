package collection;

import java.util.*;

public class OperationEnsembliste2
{
	public static void main (String [] args)
	{
		String phrase = "je me figure ce zouave qui joue";
		String voy = "aeiouy";

		HashSet <String> lettres = new HashSet <String> ();

		for (int i = 0; i < phrase.length(); i++)
			lettres.add(phrase.substring(i, i + 1));
		System.out.println ("Lettres présentes : " + lettres);

		HashSet <String> voyelles = new HashSet <String> ();

		for (int i = 0; i < voy.length() ; i++)
			voyelles.add(voy.substring(i, i + 1));
		lettres.removeAll(voyelles);

		System.out.println ("Lettres sans les voyelles : " + lettres);
	}
}
