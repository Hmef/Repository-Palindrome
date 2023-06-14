package com.NeuralNine.channel.tcpChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable{

	private Socket client;
	private BufferedReader in; // get the stream from the socket(client) - text send by client - when the client send something we're going to get it from in 
	private PrintWriter out;  // and when we run, I want to write something to the client we're going to use out 
	private String nickname;
	
	// we need to handle multiple client concurrently, because of that we're going to define constructor 
	//and we're going pass the socket which is going to be the client that we're going to deal with 
	
	public ConnectionHandler(Socket client) {
		
		this.client = client;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			out = new PrintWriter(client.getOutputStream());
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			//send to the client a prompt that asks for a nickname 
			out.println("please enter a nickname: ");
			
			// then we're going to wait for a input from the client 
			nickname = in.readLine();
			System.out.println( nickname + " connected!");

			String message;
			while((message = in.readLine()) != null) {
				if(message.startsWith("/nick ")) {
					// TODO: handla nickname =============== min: 13:06
					//String
					
				}else if(message.startsWith("/quit")) {
					// TODO: quit 
				}else {
					sendMessage(message);
				}
			}
			// send something to the client 
			//out.println("Hello client from the server!");
			
			// get the message from the client 
			//in.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	// in the run function, we want open up a try/catch block because we're going to have to catch IO Exception 
	// in the try block, we we're going to deal with the client  

	
	// In order to be able to send somthing to the client via the handler, we need to implement a function here, which is just
	// going to send a message 
	
	public void sendMessage(String message) {
		
		out.println("message");
		
	}
	
	
	
	
}
