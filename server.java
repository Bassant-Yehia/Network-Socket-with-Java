package Chat;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class server {
	

//create static object from ServerSocket
	static ServerSocket serverSocket;
public static void main(String[] args)
{
	
	try {
		//intialize Server Socket with port number as parameter.
		
		serverSocket=new ServerSocket(4000);
		System.out.println("Server is booted up and is waiting for clients to connect");
		
		while(true)
		{//accept any client wants to connect to the server
			Socket clientSocket=serverSocket.accept();
			
			System.out.println("A new client is connected to the server");
			
  session clientSession=new session (clientSocket);
  clientSession.start();

	
		
		
		
		
		
		}}
	
	catch(IOException e){
		e.printStackTrace(); //catch the error}
	
	
	
}
	

}}
