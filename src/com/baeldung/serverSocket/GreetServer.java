package com.baeldung.serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public void start(int port) throws IOException {  /// 
		
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true); /// getOutputStream()
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  //// getInputStream()
		
		String greeting = in.readLine();
		if("hello server".equals(greeting)) {
			out.println("hello client");
			
		}
		else {
			out.println("unrecognised greeting");  
		}
	}
	
	public void stop() throws IOException {
		
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	public static void main(String[] args) {
		
		GreetServer server = new GreetServer();
		try {
			server.start(6666);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("test ========== ");
	}
	
	
	// ServerSocket serverSocket = new ServerSocket(1234); // doing new server socket and then we pass a port number 
	// and basically is saying our server will be listening for client that are making a connection to this port number 
	//so when a client is going to basically have a socket and they're going to send out saying to the server: hey I want to talk on port 1234

	
	// Client Handler class
	//public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	// the main purpose of this array is to keep TRACK of all our clients
	// so that whenever a client sends a message, we can loop through our array list of clients and send the message to each client
	// so this arrayList is basically responsible for us allowing communicate or send messages or broadcast a message to multiple clients 
	// instead of just one or just the server
	
	// this is STATIC because we want it to belong to the class not each object of the class
	
	// In java there are TWO type of streams : there's a byte stream and a character stream 
	// we want a character stream because we are sending messages 
	// and in java character streams end with word writer while byte stream end with word stream  ( min 13:54)
	// and this is why we're wrapping our byte stream in a character stream because we want to send over characters 
	// and then finally we're going to use a buffer which will the communication more efficient 
	
	// getinputStream() : use this stream to send things 
	// getOutputStream() : use this to read things 
	
	
	
}
