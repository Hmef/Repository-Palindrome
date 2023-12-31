package com.baeldung.serverSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GreetClient {
	
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public void startConnection(String ip, int port) throws UnknownHostException, IOException {
		
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	
	public String sendMessage(String msg) throws IOException {
		
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}
	
	public void stopConnection() throws IOException {
		
		in.close();
		out.close();
		clientSocket.close();
	}

}
