package server;

import java.io.IOException; 

import java.net.ServerSocket;
import java.net.Socket;

import Thread.SocketThread;


public class Server {
	

	
	public static void main(String[] args) {
	
		
		try {
			
			//Criando socket de conexao 
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(1616);
			System.out.println("Iniciando Socket de Transferencia (SERVER)");
			
			//criando socket de comunicacao
			
			
			while(true) {
				
				Socket socket = serverSocket.accept();
				System.out.println("Criando conexao com socket de transporte ");
				
				SocketThread socketThread = new SocketThread(socket);
				socketThread.start();
			
			}
		
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
			
			
		}
		
		
		
	}

}
