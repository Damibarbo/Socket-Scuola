package itts_dbSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
Socket socket;
	
	public void connessione() {
		try {
			socket= new Socket("127.0.0.1", 2000);
			System.out.println("Client avviato con successo"); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void chiusura() {
		try {
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chat() {
		try {
			Scanner sc;  
			Scanner in=new Scanner(System.in); 
			
			sc=new Scanner(socket.getInputStream()); 
			String messaggio=sc.nextLine(); 
			System.out.println("Server: " + messaggio); 
			
			System.out.println("inserisci la risposta da mandare al server");
			String risposta=in.nextLine(); 
			risposta += "\n";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
			dos.writeBytes(risposta);
			
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		
		Client cl = new Client(); 
		cl.connessione();
		cl.chat();
		cl.chiusura();
		
	}


}
