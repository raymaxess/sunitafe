package test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;



public class Client implements Comparator<Client>, Comparable<Client> {
   private String clientName;
   private int clientID;
   
   Client(String name, int id){
	   this.clientName =name; 
	   this.clientID = id;
	   
   }
   Client(){}
      	   
   public String getClientName() {
	      return clientName;
	   }
	   public int getClientID() {
	      return clientID;
	   }

	@Override
	public int compareTo(Client c) {
		// TODO Auto-generated method stub
		return (this.clientName).compareTo(c.clientName);
	}

	@Override
	public int compare(Client c1, Client c2) {
		return c1.clientID - c2.clientID; 
	}

	public static void main(String args[]) {
	  List<Client> list = new LinkedList<Client>();
	  list.add(new Client("Jones", 3));
	  list.add(new Client("David", 2));
	  list.add(new Client("George", 10));
	  list.add(new Client("Raymund", 4));
	  list.add(new Client("Ben", 1));
	  
	  System.out.print("Original list:" + "\n");
	  for(Client o: list)   
		  System.out.print(o.getClientID() +" => "+ o.getClientName() + "\n");
	   
	  System.out.print("\n");
//	  	Sort Names by ID
	  Collections.sort(list, new Client());
	      
	  System.out.print("Sorted list by ID:" + "\n");
//	  Display sorted data
	  for(Client o: list)   
		  System.out.print(o.getClientID() +" => "+ o.getClientName() + "\n");
	}
}
