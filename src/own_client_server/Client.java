package own_client_server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws IOException{
		
		if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
		
		String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
		
		
		
		try {
			String fromUser;
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("What do you want ? 1.notion 2.graph  3.pdf");
			
			fromUser = stdIn.readLine();
			
			if (fromUser.equals("notion")){
				Socket socket=null;  
		        try {   
		            socket = new Socket(hostName,portNumber);   
		          } catch (UnknownHostException e1) {   
		            e1.printStackTrace();   
		          } catch (IOException e1) {   
		            e1.printStackTrace();   
		          }  
		        
				System.out.println("Client: notion");
				System.out.println("enter the name of the notion");
				
				String notion;
				notion = stdIn.readLine();
				//here we need a function to send notion to the server
				SendToServer.sendToServer(notion, socket);
				//a function to receive file
				ReceiveFile.receiveFile("/Users/zhangshangyuan/Documents/书籍资料/", socket);
				
				socket.close();
			}
			
			if (fromUser.equals("graphe")){
				Socket socket=null;  
		        try {   
		            socket = new Socket(hostName,portNumber);   
		          } catch (UnknownHostException e1) {   
		            e1.printStackTrace();   
		          } catch (IOException e1) {   
		            e1.printStackTrace();   
		          }  
		        
				System.out.println("Client: graphe");
				System.out.println("enter the name of the graphe");
				
				String notion;
				notion = stdIn.readLine();
				//here we need a function to send notion to the server
				SendToServer.sendToServer(notion, socket);
				//a function to receive file
				ReceiveFile.receiveFile("/Users/zhangshangyuan/Documents/书籍资料/", socket);
				
				socket.close();
			}
			
			if (fromUser.equals("pdf")){
				Socket socket=null;  
		        try {   
		            socket = new Socket(hostName,portNumber);   
		          } catch (UnknownHostException e1) {   
		            e1.printStackTrace();   
		          } catch (IOException e1) {   
		            e1.printStackTrace();   
		          }  
		        
				System.out.println("Client: pdf");
				System.out.println("enter the name of the pdf");
				
				String notion;
				notion = stdIn.readLine();
				//here we need a function to send notion to the server
				SendToServer.sendToServer(notion, socket);
				//a function to receive file
				ReceiveFile.receiveFile("/Users/zhangshangyuan/Documents/书籍资料/", socket);
				
				socket.close();
			}
		
		} catch (UnknownHostException e){
			System.err.println("Don't know about the host" + hostName);
			System.exit(1);   
		} catch (IOException e){
			System.err.println("Couldn't get I/O for the connection" + hostName);
			System.exit(1);
		}
		
	}
}
		
		


