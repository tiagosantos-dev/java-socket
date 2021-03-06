package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import util.Message;

public class Client {
	
	
	public static void main(String[] args) {
		
		
		try {
			Socket socket = new Socket("localhost", 1616);
			
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
			
			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			
			
			
			Message msg = new Message("Ola, quero arquivar essa mensagem", "Tiago", "Santos", 22);
			
			saida.writeObject(msg);
			
			Message msgResponse = (Message) entrada.readObject();
			System.out.println("Mensagem recebida do servidor : "+ msgResponse.getMessage());
			
			
			entrada.close();
			saida.close();
			socket.close();
			
			
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
			
		
	}

}
