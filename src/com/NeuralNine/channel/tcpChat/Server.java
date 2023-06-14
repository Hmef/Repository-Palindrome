package com.NeuralNine.channel.tcpChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

	private ArrayList<ConnectionHandler> connections;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket server = new ServerSocket(9999);
			
			Socket client = server.accept();
			
			ConnectionHandler handler = new ConnectionHandler(client);
			connections.add(handler);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void broadcast(String message) {
		
		for(ConnectionHandler ch : connections) {
			if(ch != null) {
				ch.sendMessage(message);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	public void start() {
		
	}

}
