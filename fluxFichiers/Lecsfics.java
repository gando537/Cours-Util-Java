package fluxFichiers;
import java.io.*;

public class Lecsfics
{
	public static void main (String [] args) throws IOException
	{
		String nomfic;
		int n = 0;

		System.out.print ("donnez le nom du fichier à lister : ");
		nomfic = Clavier.lireString();
		DataInputStream entree = new DataInputStream (new FileInputStream(nomfic));
		System.out.println ("Valeurs lues dans le fichier " + nomfic + " :");
		boolean eof = false;		// sera mis à true par exception

		while (!eof) {
			try {
				n = entree.readInt();
			}catch (EOFException e) {
				eof = true ;
			}
			if (!eof)
				System.out.println(n);
		}
		entree.close ();
		System.out.println ("*** fin liste fichier ***");
	}
}
