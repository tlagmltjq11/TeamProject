package Thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CanVasColorSendThread extends Thread {

   private Socket s;   
   private String ID,color;
   private DataOutputStream outputstream;
   
   public CanVasColorSendThread(Socket s, String color){
      this.s = s;
      this.color=color;   
      System.out.println(this.color);
      
      try {
         outputstream=new DataOutputStream((s.getOutputStream()));
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   

   public void run() {
      try {
         
         outputstream.writeUTF(color);
         
               
      }
      catch(Exception e){
         e.printStackTrace();
      }
      finally {
         outputstream = null;
      }
   }
}