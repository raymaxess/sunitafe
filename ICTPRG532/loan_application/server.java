package test3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import test3.MyGui.Input;

public class server {
	static String line=null;
    static DataInputStream is;
    static PrintStream os;
    static ServerSocket jServer; 
    static Socket clientSocket = null;
    String msgtoclient;
    static int port = 9999;


	public static void main(String[] args) throws IOException {
		Address address = new Address();
		
        try {
            jServer = new ServerSocket(port);
            if(jServer != null){System.out.println("The Server Socket is runing at port:" + port);}
         }
         catch (IOException e) {
            System.out.println("Failed to set up the server!"+ "\n"+e);
            e.printStackTrace();
         }   
  
         try {
            clientSocket = jServer.accept();
            if(clientSocket != null){
               System.out.println("Client/Server binding done! Socket: " + clientSocket.toString());}
                           
 			BufferedReader sbr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 			//BufferedWriter sbw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
 		    
 			//Try PrintStream, it supports println() method.             
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
              line = sbr.readLine();
              
              if(line!=null)
             	 {
            	  	System.out.println("Client message --> " + line);
            	  	System.out.println(address.findAddress(line));
//            	  	System.out.println("A message is received from the client: "+ line +"\n" + "Start processing request...");
             	 	pw.println(line); 
             	 }
              else 
        	  	System.out.println("Message has not been received from the client!");
                                     
            }
         }   
     catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
            clientSocket.close();
            jServer.close();
         }

	}
}

class Address {
	@SuppressWarnings("unlikely-arg-type")
	Boolean findAddress(String address) {
		LinkedList<String> streets = new LinkedList<String>(); 
		
		streets.add(0,"1 First St");
		streets.add(1,"2 First St");
		streets.add(2,"3 First St");
		streets.add(3,"4 First St");
		streets.add(4,"5 First St");
		
		// Obtaining Iterator
	    java.util.Iterator<String> it = streets.iterator();
		
	    while(it.hasNext()){
	    	
	    	String a=address;
	    	String b=it.next();
	    	
	    	if(a.equals(b)) return true;
	    }

	    return false;
	}
}
