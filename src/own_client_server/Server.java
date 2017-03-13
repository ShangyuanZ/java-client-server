package own_client_server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;




  
public class Server{  
    public static void main(String []args) throws IOException{  
    	
    	/*PythonInterpreter interpreter = new PythonInterpreter();
    	
    	InputStream filePy = new FileInputStream("/Users/zhangshangyuan/Documents/Client.py");
    	
    	
    	interpreter.execfile(filePy);
    	
    	filePy.close();
    	
    	interpreter.close();*/  
    	
    	if (args.length != 1) {
            System.err.println("Usage: java KnockKnockServer <port number>");
            System.exit(1);
        }
    	
    	int portNumber = Integer.parseInt(args[0]);
    	 
        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        	
         
            String inputLine;
             
            inputLine = in.readLine();
            
            if (inputLine.equals("notion")){
            	String notion;
            	notion = in.readLine();
            	
            	//run a python program
            	
            	
            	// send the file to client
            	SendFile.sendFile("/Users/zhangshangyuan/Downloads/test5 (1).json", portNumber, clientSocket);
            	
            }
            
            if (inputLine.equals("graphe")){
            	String graphe;
            	graphe = in.readLine();
            	
            	
            	
            	
            	SendFile.sendFile("/Users/zhangshangyuan/Downloads/test5 (1).json", portNumber, clientSocket);
            	
            }
            
            if (inputLine.equals("pdf")){
            	String pdf;
            	pdf = in.readLine();
            	
            	
            	
            	SendFile.sendFile("/Users/zhangshangyuan/Downloads/voyages.pdf", portNumber, clientSocket);
            }
            
            serverSocket.close();
            clientSocket.close();
            
        } catch (IOException e) {
        	
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    	 
    }  
}