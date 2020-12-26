package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import util.Message;

public class Server {
	

	
	public static void main(String[] args) {
	
		
		try {
			
			//Criando socket de conexao 
			ServerSocket serverSocket = new ServerSocket(1616);
			
			//criando socket de comunicacao
			Socket socket = serverSocket.accept();
			
			//Criando entrada e saida de dados streams
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			
			Message msgResult = (Message) entrada.readObject();

			System.out.println("NOME: "+msgResult.getName());
			System.out.println("SOBRENOME: "+msgResult.getSurname());
			System.out.println("IDADE: "+msgResult.getAge());
			System.out.println("MENSAGEM: "+msgResult.getMessage());
			
			
			Message msgResponse = new Message();
			msgResponse.setMessage("Ola "+ msgResult.getName()+"recebemos sua mensagem e ela será arquivada no servidor.");
			
			saida.writeObject(msgResponse);
			saida.flush();
			
			
			entrada.close();
			saida.close();
			socket.close();
			serverSocket.close();
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
			
		}
		
		
		
	}

}
