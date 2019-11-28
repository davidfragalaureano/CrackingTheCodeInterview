/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    Node m = new Node(2);
	    m.appendToEnd(5); // regarding its the same value as below, we validate by reference, whether the node is a node added before to the list (loop)
	    m.appendToEnd(5); // this is actually where the loop starts
 	    m.appendToEnd(9);
	    m.appendToEnd(7);
	    m.appendToEnd(1); 
	    
	    // Getting a Node already inserted in the list to make a loop
	    Node sameNodeAsBefore = m.next.next; // This could be any node already inserted on the list 
	    
	    // Append that same node again 
	    m.appendNodeToEnd(m.next.next);   // ---> m = 2 -> 0  -> (5) ->  9 -> 7 -> 1 -> (5)   Make a loop on the same list (5)
	    
	    // Second approach with the hashmap
	    Node nodeLooped =  MyLinkedList.findLoop(m, new HashMap<Object, Node>());
        
        
        // The output will be  5 -> 9 -> 7  since we have a loop in 5 
        // NOTE : If the list has not a loop nodeLooped will be "null" and this line will throw a NPE
    	System.out.println(nodeLooped.data + " " + nodeLooped.next.data + " " + nodeLooped.next.next.data);
	 
	 
	    // ---- first approach with the visited property ---
	    //Node nodeLooped =  MyLinkedList.findLoop(m);
	    
	        
	    /*MyLinkedList.print(n);
	    System.out.println("\n");
	    MyLinkedList.print(m);*/
	}
	
	private static class Node<T>{
	    Object data;
	    Node next = null;
	    boolean visited = false;
	    
	    
	    public Node(T data){
	       this.data = data;
	    }
	    
	    // append value into a new node created by this class
	    public void appendToEnd(T data){
	        Node end = new Node(data);
	        Node current = this;
	        
	        while(current.next != null){
	            current = current.next;
	        }
	        
	        current.next = end;
	        //System.out.println(current.next.data);
	    }
	    
	    // append node to list
	    public void appendNodeToEnd(Node n){
	        Node end = n;
	        Node current = this;
	        
	        while(current.next != null){
	            current = current.next;
	        }
	        
	        current.next = end;
	        //System.out.println(current.next.data);
	    }
	    
	}
	
	public static class MyLinkedList<T>{
	    Node head;
	    
	    public MyLinkedList(){
	        this.head = null;
	    }
	    
	    public void add(T t){
	        if(this.head == null)
	            this.head = new Node(t);
	        else
	            head.appendToEnd(t);
	    }
	    
	    public T get(int index){
	        
	        if(this.head != null){
	            if(index == 1) {
    	           return (T) this.head.data;
    	        }
    	        
    	        Node n = this.head;
    	        int i  = 1;
    	        while(n.next != null){
    	            if(i == index){
    	                return (T) n.data;
    	            }
    	            n=n.next;
    	            i++;
    	        }
    	        
    	        if(index > i) 
    	            return null; 
    	            
    	        return (T) n.data;
	        }else{
	            return null;
	        }
	        
	    }
	    
	    private Node getNodeAt(int index){
	        
	        if(this.head != null){
	            
	            if(index == 1)
	                return this.head;
	            else{
	                Node n = this.head;
	               
	                for(int i = 1; n.next != null; i++){
	                    if(i == index){
	                        return n;
	                    }
	                    n = n.next;
	                }
	                return null;
	            }
	            
	        }else{
	            return null;
	        }
	    }
	    
	    /*public static Node getIntersection(Node l1, Node l2){
	        Node a = traverseList(l1);
	        Node intersection = traverseList(l2); 
	        
	        if(intersection != null)
	            return intersection;
	        else
	            return null;
	    }*/
	    
	    // Finds if the list has a loop using visited approach --> (This requires to modify the Node structure to add a property of visited which)
	    // which is going to be updated to 'true' once the node is visited, a node who has this prop as false, indicates that we havent added it Before
	    private static Node findLoop(Node n){
	        if(n == null)
	            return null;
	        if(n.visited)
	            return n;
	            
	        n.visited = true;
	        return findLoop(n.next);
	    }
	    
	    // Approach to store nodes in HashMap and check for their existence in that HashMap 
	    private static Node findLoop(Node n, Map map){
	        
	        // this tells that the list is not in a loop, looped list does not have an end node
	        if(n.next == null)
	           return null;
	        if(map.get(n.data) != null && map.get(n.data) == n) // use == instead of equals since we need to know if that object is the same of one of nodes of the list
	            return n;
	       
	        // is the list has no end (next node as null) 
	        // or all nodes added at this point are different in the HashMap,
	        // we insert it as a new item in the HashMap
	        map.put(n.data, n);
	        
	        // Continue the recursion
	        return findLoop(n.next, map);
	    }
	 
	    public static void print(Node n, int indexHead, int i){
	        
	        if(n == null) return;
	        if(indexHead >= i) System.out.print(n.data + ", ");
	        if(n.next == null) return;
	        
	        print(n.next, ++indexHead, i);
	    }
	    
	    public static void print(Node n){
	        
	        if(n == null) return;
	        System.out.print(n.data + ", ");
	        print(n.next);
	    }
	    
	
	}

}
