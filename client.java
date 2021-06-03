package Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class client {
public static void main(String[] args)
{
try {
	
	//Get ip address of local host and send it the socket with the server
	//port number
	InetAddress ip=InetAddress.getByName("localhost");
	Socket clientSocket=new Socket(ip,4000);
	
	System.out.println("Connecting to the server...");
	//Take input from the server by using the client socket
	DataInputStream input=new DataInputStream(clientSocket.getInputStream());
	//print output to the server by using client sockett
	DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());
	
	//take input from the console
	Scanner scanner=new Scanner(System.in);
	
	//read from the server that the client is now connected and print it
	String connectCofirm=input.readUTF();
	System.out.println("Server: "+connectCofirm);
	
	//Start connection with server
	
	while(true)
	{
		//read from the server the message that was asking for the request and print it
		String serverAsk=input.readUTF();
		System.out.println("Server:"+serverAsk);
		//write the requested message and send it to the server
		String request=scanner.nextLine();
		output.writeUTF(request);
		//check if the request is 'close' , the client closes the connection with the srvers.
		if (request.equalsIgnoreCase("close"))
		{
			clientSocket.close();
			System.out.println("Connection is closed.");
	        break;	}
		else if (request.equalsIgnoreCase("arrange"))
		{	   String request2=input.readUTF();
		System.out.println("Server:"+request2);
		String request3=scanner.nextLine();
		output.writeUTF(request3);
		if(request3.equalsIgnoreCase("1"))
		{	
			String reply=input.readUTF();
			System.out.println("Server:"+reply);
			int arr[]=new int[10];
		int arrFromServer[]=new int[10];
		Scanner inFromUser= new Scanner(System.in);
			
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		    DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		    for(int i=0;i<10;i++)
		        arr[i]=inFromUser.nextInt();

		    for(int i=0;i<10;i++)
		        outToServer.writeInt(arr[i]);

		    for(int i=0;i<10;i++)
		        arrFromServer[i]=inFromServer.readInt();

		    for (int i = 0; i < arrFromServer.length; i++) {
		        System.out.println("From Server::"+arrFromServer[i]);
		    }}
		else if (request3.equalsIgnoreCase("2"))
		{
			String reply=input.readUTF();
			System.out.println("Server:"+reply);
			int arr[]=new int[10];
		int arrFromServer[]=new int[10];
		Scanner inFromUser= new Scanner(System.in);
			
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		    DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
		    for(int i=0;i<10;i++)
		        arr[i]=inFromUser.nextInt();

		    for(int i=0;i<10;i++)
		        outToServer.writeInt(arr[i]);

		    for(int i=0;i<10;i++)
		        arrFromServer[i]=inFromServer.readInt();

		    for (int i = 0; i < arrFromServer.length; i++) {
		        System.out.println("From Server::"+arrFromServer[i]);
		    }
			
			
		}
			
			
			
			

	       // System.out.println("Sending messages to the ServerSocket");

	        //objectOutputStream.writeObject(messages);
			
			
			
			
			
			//write the reply of the server and send it to the client
		//	int [] reply=new int [] {7,5,2,3,8,10};
			
			//System.out.println("Server: ...");
		// System.out.println("Please input numbers:");
		/*String request2=input.readUTF();
		System.out.println("Server:"+request2);
		 Scanner input2 = new Scanner(System.in);
		    ArrayList<Double> list = new ArrayList<>();
		    while (input2.hasNextDouble()) {
		            list.add(input2.nextDouble());
		        }
			output.write([2,5,1,3]);
			//int reply=scanner.nextInt();
			//output.writeInt(reply);*/
			
		}
		
		
	}
}

catch(UnknownHostException e)
{
e.printStackTrace();	}

catch(IOException e){
	e.printStackTrace(); //catch the error}

}
}}
		

