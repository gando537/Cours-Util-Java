package fluxFichiers.sockets;

import java.io.*;
import java.net.*;

public class Serveur
{
	public static void main (String [] args) throws IOException
	{
		int port = 1000;
		ServerSocket sersoc = new ServerSocket (port);
		System.out.println ("Serveur active sur port : " + port);
		Socket soc = sersoc.accept();
		InputStream flux = soc.getInputStream ();
		BufferedReader entree = new BufferedReader (new InputStreamReader (flux));

		while (true) {
			String message = entree.readLine ();
			System.out.println ("message reçu sur le serveur = " + message);
		}
	}
}
