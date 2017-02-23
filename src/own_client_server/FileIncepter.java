package own_client_server;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
public class FileIncepter {  
    public FileIncepter(){  
          
    }  
    public void receiveFile(String savePath,String hostName,int portNumber){  
        Socket socket=null;  
        try {   
            socket = new Socket(hostName,portNumber);   
          } catch (UnknownHostException e1) {   
            e1.printStackTrace();   
          } catch (IOException e1) {   
            e1.printStackTrace();   
          }   
        DataInputStream dis=null;  
        try {   
            dis = new DataInputStream(new BufferedInputStream(socket   
                .getInputStream()));   
          } catch (IOException e1) {   
            e1.printStackTrace();   
          }   
        int bufferSize = 1024;   
       
        byte[] buf = new byte[bufferSize];   
        int passedlen = 0;   
        long len = 0;   
        // get the file name 
       try{  
        savePath += dis.readUTF();   
        DataOutputStream fileOut = new DataOutputStream(   
            new BufferedOutputStream(new BufferedOutputStream(   
                new FileOutputStream(savePath))));   
        len = dis.readLong();   
        System.out.println("the length of the file:" + len + "    KB");   
        System.out.println("start receiving !");   
        while (true) {   
            int read = 0;   
            if (dis!= null) {   
              read = dis.read(buf);   
            }   
            passedlen += read;   
            if (read == -1) {   
              break;   
            }   
            System.out.println("file received " + (passedlen * 100 / len) + "%");   
            fileOut.write(buf, 0, read);   
          }   
          System.out.println("finished, it has been saved at " + savePath);   
          fileOut.close();   
        } catch (Exception e) {   
          e.printStackTrace();   
          return;   
        }   
    }  
}  