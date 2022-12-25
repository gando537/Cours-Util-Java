package fluxFichiers.sockets;

import java.io.*;
import java.net.*;

public class Client
{
	public static void main (String [] args) throws IOException
	{
		String hote = "127.0.0.1";
		int port = 1000;

		Socket soc = new Socket (hote, port);
		OutputStream flux = soc.getOutputStream ();
		OutputStreamWriter sortie = new OutputStreamWriter(flux);
		while (true) {
			String saisi = Clavier.lireString();
			if (saisi.length() != 0)
			{
				saisi += "\n";
				sortie.write(saisi);
				sortie.flush(); //pour forcer l'envoi de la ligne
			}
		}
	}
}
