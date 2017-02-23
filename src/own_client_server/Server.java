package own_client_server;


import org.python.util.PythonInterpreter;

import java.io.BufferedInputStream;  
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Server {  
    private ServerSocket ss=null;  
    public Server(){  
          
    }  
    public void sendFile(String filePath,int port){  
        DataOutputStream dos=null;  
        DataInputStream dis=null;  
          
        Socket socket=null;  
        try {  
            File file=new File(filePath);  
            ss=new ServerSocket(port);  
            socket=ss.accept();  
            dos=new DataOutputStream(socket.getOutputStream());  
            dis=new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));  
              
            int buffferSize=1024;  
            byte[]bufArray=new byte[buffferSize];  
            dos.writeUTF(file.getName());   
            dos.flush();   
            dos.writeLong((long) file.length());   
            dos.flush();   
            while (true) {   
                int read = 0;   
                if (dis!= null) {   
                  read = dis.read(bufArray);   
                }   
  
                if (read == -1) {   
                  break;   
                }   
                dos.write(bufArray, 0, read);   
              }   
              dos.flush();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } finally {   
              // close all the connection   
              try {   
                if (dos != null)   
                  dos.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (dis != null)   
                  dis.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (socket != null)   
                  socket.close();   
              } catch (IOException e) {   
              }   
              try {   
                if (ss != null)   
                  ss.close();   
              } catch (IOException e) {   
              }   
            }   
  
  
    }  
    public static void main(String []args) throws IOException{  
    	
    	PythonInterpreter interpreter = new PythonInterpreter();
    	
    	InputStream filePy = new FileInputStream("/Users/zhangshangyuan/Documents/Client.py");
    	
    	
    	interpreter.execfile(filePy);
    	
    	filePy.close();
    	
    	interpreter.close();
    	
        new Server().sendFile("/Users/zhangshangyuan/Downloads/_e3f520a46a4184060b2b6db96d9a8fb0_Semaine-1-Vocabulaire-des-voyages.pdf", 8821);  
    }  
} 