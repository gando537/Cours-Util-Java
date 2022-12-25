package fluxFichiers;
import java.io.*;

public class Crsfic1
{
	public static void main (String [] args) throws IOException
	{
		String nomfich;
		int n;
		System.out.print ("donnez le nom du fichierà créer : ");
		nomfich = Clavier.lireString ();
		DataOutputStream sortie = new DataOutputStream (new FileOutputStream(nomfich));

		do {
			System.out.print ("donnez un entier : ");
			n = Clavier.lireInt();
			if (n != 0)
				sortie.writeInt(n);
		} while(n != 0);
		sortie.close();
		System.out.println ("*** fin création fichier ***");
	}
}

