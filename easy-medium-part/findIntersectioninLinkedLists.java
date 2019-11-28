/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	   /* MyLinkedList<String> n = new MyLinkedList<>();
	    n.add("David");
	    n.add("as");
	    n.add("Fraga");
	    n.add("Laureano");
	    n.add("as");
	    System.out.println(n.get(2));
	    System.out.println(n.get(4));
	    System.out.println(n.contains("David"));
	    System.out.println(n.contains("as"));
	    System.out.println(n.contains("Laureano"));
	    System.out.println(n.remove("Laureano"));
	    System.out.println(n.contains("Laureano"));
	    System.out.println(n.remove("as"));
	    n.fromNtoLastElement(3);
	    n.removeNode(n.getNodeAt(3));
	    n.fromNtoLastElement(1);*/
	    
	    
	    
	    // Sum linked lists in an inverted way and return the value
	    Node n = new Node(7);  // --> 7,[1],6
	    n.appendToEnd(1);
	    n.appendToEnd(6);
	    
	    Node m = new Node(2);
	    m.appendToEnd(0);
	    m.appendToEnd(5);
	    m.appendNodeToEnd(n.next);   // ---> m = 2, 0, [1], 6  here we append an existing node coming from n to m, to join both list at (1)
	    //m.appendToEnd(8);
	    
	    Node intersection  = MyLinkedList.getIntersection(m,n); // get the intersection if there's one.
	    if(intersection != null)
	        System.out.println(intersection.data);  // null if theres no intersection, Node if an intersection was found
	    else    
	        System.out.println("There's no intersecion between these lists.");
        
        // Print both linked list 
	    MyLinkedList.print(n);
	    System.out.println("\n");
	    MyLinkedList.print(m);
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
	    
	    public static Node getIntersection(Node l1, Node l2){
	        Node a = traverseList(l1);
	        Node intersection = traverseList(l2); 
	        
	        if(intersection != null)
	            return intersection;
	        else
	            return null;
	    }
	    
	    // Mark nodes as visited in one of the list
	    private static Node traverseList(Node n){
	        if(n == null)
	            return null;
	        if(n.visited)
	            return n;
	            
	        n.visited = true;
	        return traverseList(n.next);
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
