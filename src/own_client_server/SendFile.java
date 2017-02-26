package own_client_server;

import java.io.*;
import java.net.*;


public class SendFile{
    // send a file by a filePath and a port
	public static void sendFile(String filePath,int port, Socket socket){  
	    DataOutputStream dos=null;  
	    DataInputStream dis=null;  
	    
	    try {  
	        File file=new File(filePath);  
	         
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
               
            }
	    
	}
	
}