package own_client_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendToServer {
	
	public static void sendToServer(String notion, Socket socket ) throws IOException{
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		out.println(notion);
		
	}

}
