package com.youtube.wittcode.javaSocketProgramming;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;

	public Server(ServerSocket serverSocket) {
		
		this.serverSocket = serverSocket;
	}
	
	public void startServer() {
		
		try {
			
			while(!serverSocket.isClosed()) { // Tant que serverSocket is not closed 
				
				Socket socket = serverSocket.accept();
				System.out.println("A new client has connected!");
				//ClientHandler clientHandler = new ClientHandler();
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		
	}
}
