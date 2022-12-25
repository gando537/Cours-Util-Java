package fluxFichiers;
import java.io.*;

public class LectureFichiertext
{
	public static void main (String [] args) throws IOException
	{
		String nomfic;
		String ligne;

		System.out.print ("Donnez le nom du fichier à lire : ");
		nomfic = Clavier.lireString ();

		BufferedReader entree = new BufferedReader (new FileReader (nomfic));
		do {
			ligne = entree.readLine ();
			if (ligne != null)
				System.out.println(ligne);
		}while (ligne != null);
		entree.close ();
		System.out.println ("*** fin liste fichier ***");
	}
}
