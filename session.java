package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class session extends Thread{
 Socket clientSocket;
	public session(Socket clientSocket)
	{
		
		this.clientSocket=clientSocket;
		
		
	}
	
	@Override
		public void run() {
		//takes input from the client socket
		DataInputStream input;
		try {
			input = new DataInputStream(clientSocket.getInputStream());
	
		//print output to the client socket 
		DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());
	
		 //take input from console
			Scanner scanner=new Scanner(System.in);
			
			output.writeUTF("Connected");
			
			while(true)
			{ //send a message to the client asking it to send its own request o close the connection
				output.writeUTF("please enter 'arrange' the list of numbers to arrange or 'close'to close the connection/n");
				//read the request from the client and output it to server's console
				String request=input.readUTF();
				System.out.println("Client:"+request);
		//check if the request is 'close',the server closes the connection with the client
				if(request.equalsIgnoreCase("close"))
				{
					clientSocket.close();
					System.out.println("Connection with this client is closed");
					break;}
				else if(request.equalsIgnoreCase("arrange"))
				{ output.writeUTF("if you want to ascend press '1' or deascend press'2'");
				String request2=input.readUTF();
				System.out.println("Client:"+request2);
				if(request2.equalsIgnoreCase("1"))
						
				{output.writeUTF("enter your list of numbers");
			
				 int arrFromClient[]=new int[10];
				   int arrFromServer[]=new int[10];
					
				//   String request2=input.readUTF();
				//	System.out.println("Server:"+request2);

					  DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
					    DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
					    for(int i=0;i<10;i++) {
					        arrFromClient[i] = inFromClient.readInt();
					    }
					    Arrays.sort(arrFromClient);
					    for (int i = 0; i < arrFromClient.length; i++) {
					        outToClient.writeInt(arrFromClient[i]);
					    }}
				else if(request2.equalsIgnoreCase("2"))
				{output.writeUTF("enter your list of numbers");
				
				 int arrFromClient[]=new int[10];
				   int arrFromServer[]=new int[10];
					
				//   String request2=input.readUTF();
				//	System.out.println("Server:"+request2);

					  DataInputStream inFromClient = new DataInputStream(clientSocket.getInputStream());
					    DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
					    for(int i=0;i<10;i++) {
					        arrFromClient[i] = inFromClient.readInt();
					    }
					   // Arrays.sort(arrFromClient);
					    
					    
					    
					    int[] arrDesc = Arrays.stream(arrFromClient).boxed()
					    	    .sorted(Collections.reverseOrder())
					    	    .mapToInt(Integer::intValue)
					    	    .toArray();
					    
					   // arrFromClient=Collections.reverseOrder();
					   
					    for (int i = 0; i < arrDesc.length; i++) {
					        outToClient.writeInt(arrDesc[i]);
					    }}
					//write the reply of the server and send it to the client
					
				//String reply=scanner.nextLine();
				//	output.writeUTF(reply);
			
					
					
				}
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
}
