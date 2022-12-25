package fluxFichiers;

import java.io.*;

public class ClasseFile
{
	public static void main (String [] args) throws IOException
	{
		File rep1 = new File ("/Users/mdiallo/Desktop/Java/"); //chemin absolu
		File rep2 = new File ("/Users/mdiallo/Desktop/exam/../Java/fenetre/..");
		File rep3 = new File ("./fluxFichiers");

		File fic1 = new File (rep1, "chose.txt");
		System.out.println ("fic1 : " + fic1); //Conversion automatique de fic1 en string

		/* Utilisation de méthodes syntaxiques*/

		File rep2Abs = rep2.getAbsoluteFile ();
		File rep2Canonic = rep2.getCanonicalFile (); //élimination des . et ..
		System.out.println ("rep2 absolu :		" + rep2Abs); // ou rep2Abs.getAbsolutePath()
		System.out.println ("rep2 Canonique :	" + rep2Canonic);

		File parentFic1 = fic1.getParentFile ();
		File parentRep2 = rep2.getParentFile ();
		File parentRep3 = rep3.getParentFile ();
		File parentRep2Canonic = rep2Canonic.getParentFile ();
		System.out.println ("Parent de fic1 = " + parentFic1);
		System.out.println ("Parent de rep2 = " + parentRep2);
		System.out.println ("Parent de rep3 = " + parentRep3);
		System.out.println ("Parent de rep2 canonique = " + parentRep2Canonic);
		System.out.println ("Nom fic1 sans chemine = " + fic1.getName());
		System.out.println ("Dernier niveau rep1 = " + rep1.getName ());

		/* Utilisation des méthodes d'informations */

		System.out.println ("Exsitence rep1 = 		" + rep1.exists());
		System.out.println ("rep1 est un fichier =	" + rep1.isFile());
		System.out.println ("rep1 est un répertoire = " + rep1.isDirectory ());
		System.out.println ("Existence de fic1 = 	" + fic1.exists());
		System.out.println ("taille fic1 =			" + fic1.length());
		System.out.println ("ecriture autorisée =	" + fic1.canWrite());

		/* Il existe d'autres méthodes d'informaation :
				getParentFile() 	==> fourni le répertoire parent d'un fichier
				canRead() 			==> mode lecture
				canExecutable () 	==> fichier exécutable
				isHidden()			==> fichier caché
				lastModified()		==> date de dernière modification
				setLastModifiedTime ==> modifier la date de la dernière modification
				setReadOnly()		==> le mettre en lecture seule
				setReadable()		==> en lecture
				setWritable()		==> en écriture
				setExecutable()		==> en exécution

				createNewFile		==> pour créer un nouveau fichier (il ne doit pas exister)
				delete				==> pour supprimer un fichier ou répertoire
				mkdir ou mkdirs		==> pour créer de nouveaux répertoires
				createTempFile		==> pour créer un fichier temporaire, détruit à la fin de l'exécution

				list() et listFIles()==> permet de connaitre la liste de tous les membres 
										(répertoire et fichiers) d'un répertoire
										ex = String [] liste = repert.list ();
										ou   File [] liste = repert.listFiles();
		*/
	}
}
