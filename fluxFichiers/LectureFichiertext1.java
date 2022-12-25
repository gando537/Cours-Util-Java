package fluxFichiers;
import java.io.*;
import java.util.*; //Pour StringTokenizer

public class LectureFichiertext1
{
	public static void main (String [] args) throws IOException
	{
		String nomfic;
		String ligne;
		double x, sum = 0;

		System.out.print ("Donnez le nom du fichier à lire : ");
		nomfic = Clavier.lireString ();

		BufferedReader entree = new BufferedReader (new FileReader (nomfic));
		do {
			ligne = entree.readLine ();
			if (ligne == null)
				break;
			StringTokenizer tok = new StringTokenizer (ligne, " ");
			int nv = tok.countTokens (); 			// pour compter le nombre de tokens dans la ligne lue
			for (int i = 0 ; i < nv ; i++)
			{
				x = Double.parseDouble (tok.nextToken()); // Pour le token suivant
				sum += x;
				System.out.println(x + " ");
			}
		}while (ligne != null);
		entree.close ();
		System.out.println("somme des nombres = " + sum);
		System.out.println ("*** fin liste fichier ***");
	}
}
