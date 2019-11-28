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
	    MyLinkedList<Integer> n = new MyLinkedList<>();
	    n.add(7);
	    n.add(1);
	    n.add(6);
	    
	    MyLinkedList<Integer> m = new MyLinkedList<>();
	    m.add(1);
	    m.add(0);
	    m.add(1);
	    
	    /*MyLinkedList.print(n.getNodeAt(1), 1, 1);
	    MyLinkedList.print(m.getNodeAt(1), 1, 1);
	    
	    Node sum = MyLinkedList.sumList(n.getNodeAt(1), m.getNodeAt(1));
	    
	    MyLinkedList.print(sum, 1, 1);
	   
	    // test reverse list using recursion
	    StringBuilder sb = new StringBuilder();
	    System.out.println(MyLinkedList.reverseList(n.getNodeAt(1), sb).toString());
	    System.out.println(sb.toString());*/
	    
	    System.out.println(MyLinkedList.isPalindrome(m.getNodeAt(1)));
	    
	}
	
	private static class Node<T>{
	    Object data;
	    Node next = null;
	    
	    
	    public Node(T data){
	       this.data = data;
	    }
	    
	    public void appendToEnd(T data){
	        Node end = new Node(data);
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
	    
	    
	    
	    // Prints from the kth  to the last element in the linked list 
	    public void fromNtoLastElement(int i){
	        fromNtoLastElement(this.head, 1,i);
	    }
	    
	    // Print from kth elements to the last
	    private void fromNtoLastElement(Node n, int indexHead, int i){
	        
	        if(n == null) return;
	        if(indexHead >= i) System.out.println(n.data + ", ");
	        if(n.next == null) return;
	        
	        fromNtoLastElement(n.next, ++indexHead, i);
	    }
	    
	    
	    public boolean contains(T t){
	        
	        if(this.head != null){
	            if(this.head.data.equals((Object) t)) 
    	            return true;
    	        
    	        Node n = this.head;
    	        while(n.next != null){
    	            if(n.data.equals((Object) t)){
    	                return true;
    	            }
    	            n=n.next;
    	        }
    	        
    	        return n.data.equals((Object) t);
	        }else{
	            return false;
	        }
    	        
	    }
	    
	    
	    // removes the given node from the linked list, except if it is the head or the last one
	    public void removeNode(Node deleteNode){
	        if(deleteNode == null || deleteNode.next == null)
	            return;
	            
	        deleteNode.data = deleteNode.next.data;
	        deleteNode.next = deleteNode.next.next;
	    }
	    
	    
	    // removes t object from the linked list
	    public T remove(T t){
	        
	        if(this.head != null){
                if(this.head.data.equals((Object) t)){
                     Object oldData =  this.head.data;
                     this.head = this.head.next;
                     return  (T) oldData;
                }else{
                    Node n = this.head;
                    while (n.next != null){
                        if(n.next.data.equals((Object) t)){
                            Object oldData = n.next.data;
                            n.next = n.next.next;
                            return (T) oldData;
                        }
                        n = n.next;
                    }
                }
	        }
	        
	        return null;
                
	    }
	    
	    
	    public int removeAll(T t){
	        
	        if(this.head != null){
	            int deleted = 0;
    	        if(this.head.data.equals( (Object) t)){
    	             this.head = this.head.next;
    	             deleted++;
    	        }
    	        
                Node n = this.head;
                while (n.next != null){
                    if(n.next.data.equals((Object) t)){
                        // remove the value by overriding that node with the next one
                        System.out.println("curr: " + n.data + " next: " + n.next);
                        
                        // check if the next of the next is not null
                        if(n.next.next != null){
                             n.next = n.next.next;
                        }else{
                            n.next = null;    
                        }
                        deleted++;
                    }else{
                        n = n.next;
                    }
                }
                
    	        return deleted;
	        }
	            
	       return 0;
	    }
	    
	    // LinkedList Utils 
	    public static Node sumList(Node l1, Node l2){
	        Integer d1 = new Integer(getReverseList(l1, new StringBuilder()).toString());
	        Integer d2 = new Integer(getReverseList(l2, new StringBuilder()).toString());
            
            Integer sum = d1 + d2;
            return convertIntToList(sum);
	    }
	    
	    private static StringBuilder getReverseList(Node n, StringBuilder sb){
	        
	        if(n.next == null) return sb.append(n.data).reverse(); 
	        else return getReverseList(n.next, sb.append(n.data));
	        
	    }
	    
	     // reverse list  as String with recursion using StringBuilder
	     private static StringBuilder reverseList(Node n, StringBuilder sb){
	        
	        if(n == null)return sb;
	        return reverseList(n.next, sb).append(n.data);
	    }
	    
	    public static boolean isPalindrome(Node n){
	        Stack<Node> stack = new Stack();
	        Node original = n;
	        
	        while(n != null){
	            stack.push(n);
	            n = n.next;
	        }
	        
	        while(!stack.empty()){
	            if(!original.data.equals(stack.pop().data))
	                return false;
	            original = original.next;
	        }
	        
	        return true;
	    }
	    
	    
	    private static Node convertIntToList(Integer num){
	        StringBuilder sb = new StringBuilder(String.valueOf(num)).reverse();
	        Node head = null;
	        
	        for(int i=0; i < sb.length(); i++){
	            if(head == null){
	                head = new Node(sb.charAt(i));
	            }else{
	                head.appendToEnd(sb.charAt(i));
	            }
	        }
	        
	        return head;
	    }
	    
	    public static void print(Node n, int indexHead, int i){
	        
	        if(n == null) return;
	        if(indexHead >= i) System.out.print(n.data + ", ");
	        if(n.next == null) return;
	        
	        print(n.next, ++indexHead, i);
	    }
	    
	
	}

}
