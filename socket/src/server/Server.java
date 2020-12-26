package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	

	
	public static void main(String[] args) throws IOException {
		//Criando socket de conexao 
		ServerSocket serverSocket = new ServerSocket(1616);
		
		//criando socket de comunicacao
		Socket socket = serverSocket.accept();
		
		//Criando entrada e saida de dados streams
		ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
		
		
		
		
		
	}

}
