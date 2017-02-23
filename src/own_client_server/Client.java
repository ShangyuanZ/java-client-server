package own_client_server;

import java.io.*;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws IOException{
		
		
		
		String hostName = "localhost"; // temporary
		int portNumber = 8821 ;// temporary   Integer.parseInt(args[1]);
		
		try {
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String fromUser;
			
			System.out.println("What do you want ?  1.notion  2.graph  3.pdf");
			
			fromUser = stdIn.readLine();
			
			
			if (fromUser.equals("pdf")){
				System.out.println("Client: pdf");
				new FileIncepter().receiveFile("/Users/zhangshangyuan/Documents/书籍资料/", "localhost", portNumber);
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
