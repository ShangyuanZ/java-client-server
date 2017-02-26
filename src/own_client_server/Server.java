package own_client_server;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;





  
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
            	PythonInterpreter interpreter = new PythonInterpreter();
            	InputStream filePy = new FileInputStream("/Users/zhangshangyuan/Documents/test.py");
            	interpreter.execfile(filePy);
            	
            	PyObject someFunc = interpreter.get("test");
            	someFunc.__call__(new PyString(notion));
            	
            	filePy.close();
            	interpreter.close();
            	
            	if (notion.equals("voyages"))
            	
            	// send the file to client
            	SendFile.sendFile("/Users/zhangshangyuan/Downloads/voyages.pdf", portNumber, clientSocket);
            	
            }
            
            if (inputLine.equals("graphe")){
            	String graphe;
            	graphe = in.readLine();
            	
            	//python program
            	PythonInterpreter interpreter = new PythonInterpreter();
            	InputStream filePy = new FileInputStream("/Users/zhangshangyuan/Documents/test.py");
            	interpreter.execfile(filePy);
            	
            	PyObject someFunc = interpreter.get("test");
            	someFunc.__call__(new PyString(graphe));
            	
            	filePy.close();
            	interpreter.close();
            	
            	
            	
            	SendFile.sendFile("/Users/zhangshangyuan/Downloads/voyages.pdf", portNumber, clientSocket);
            	
            }
            
            if (inputLine.equals("pdf")){
            	String pdf;
            	pdf = in.readLine();
            	
            	//python program
            	PythonInterpreter interpreter = new PythonInterpreter();
            	InputStream filePy = new FileInputStream("/Users/zhangshangyuan/Documents/test.py");
            	interpreter.execfile(filePy);
            	
            	PyObject someFunc = interpreter.get("test");
            	someFunc.__call__(new PyString(pdf));
            	
            	filePy.close();
            	interpreter.close();
            	
            	
            	
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