package fluxFichiers;
import java.io.*;

public class CreationFichiertext
{
	public static void main (String [] args) throws IOException
	{
		String nomfic;
		int n;

		System.out.print ("Donnez le nom du fichier à créer : ");
		nomfic = Clavier.lireString();
		PrintWriter sortie = new PrintWriter (new FileWriter (nomfic));
		do {
			System.out.print ("donnez un entier : ");
			n = Clavier.lireInt();
			if (n != 0)
				sortie.println (n + " a pour carré " + n * n);
		}while (n != 0);
		sortie.close();
		System.out.println ("*** fin création de fichier ***");
	}
}
