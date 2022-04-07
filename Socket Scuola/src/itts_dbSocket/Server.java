package itts_dbSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server {
	ServerSocket serverSocket; 
	Socket socket; 
	
public void connessione() {
	try {
		serverSocket = new ServerSocket(2000);
		System.out.println("Comunicazioe avviata con successo");
		socket=serverSocket.accept();
		System.out.println("richiesta client con successo");
		
	} catch (IOException e) {
		System.out.println("Comunicazione non avviata");
	}
}

public void chiusura() {
	
	try {
		serverSocket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public void chat() {
try {
	Scanner sc;  
	Scanner in=new Scanner(System.in); 
	
	System.out.println("inserisci il messaggio da mandare al client");
	String messaggio=in.nextLine(); 
	messaggio += "\n";
	DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
	dos.writeBytes(messaggio);
	
	sc=new Scanner(socket.getInputStream()); 
	String risposta=sc.nextLine(); 
	risposta +="\n"; 
	System.out.println("Client: " + risposta); 
	
	
	
	
}  catch (IOException e) {
	e.printStackTrace();
}
} 



	
public static void main(String[] args) {
	
	Server se = new Server(); 
	
	se.connessione();
	se.chat();
	se.chiusura();
	
	}

}

