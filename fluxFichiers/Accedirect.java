package fluxFichiers;
import java.io.*;

public class Accedirect
{
	public static void main (String [] args) throws IOException
	{
		String nomfic;
		int n, num;
		RandomAccessFile entree;

		System.out.print ("donnez le nom du fichier à consulter : ");
		nomfic = Clavier.lireString();
		entree = new RandomAccessFile(nomfic, "r");
		long taille = entree.length();
		do {
			System.out.print ("Numéro de l'entier recherché : ");
			num = Clavier.lireInt();
			if (num == 0)
				break;
			int rang = 4 * (num - 1);
			if ((rang >= 0) && (rang < taille)){
				entree.seek(4 * (num - 1));
				n = entree.readInt ();
				System.out.println ("	Valeur = " + n);
			}
			else{
				System.out.println ("Entier inexistant");
				continue;
			}
		}while (num != 0);
		entree.close ();
		System.out.println ("*** fin consultation fichier ***");
	}
}
