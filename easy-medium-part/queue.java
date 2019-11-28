/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    
	    MyQueue<String> queue = new MyQueue();
	    queue.add("putos");
	    queue.add("todos");
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		queue.add("todos");
	    System.out.println(queue.peek());

	}
	
	public static class Node<T>{
	    T data;
	    Node<T> next;
	    
	    public Node(T t){
	        this.next = null;
	        this.data = t;
	    }
	}
	
	public static class MyQueue<T>{
	   Node<T> first;
	   Node<T> last;
	   
	   int size;
	   public MyQueue(){
	       this.first = null;
	       this.last = null;
	       size = 0;
	   }
	   
	   public void add(T t){
	      Node<T> n = new Node(t);
	      
	      if(this.last != null)
	          this.last.next = n;
	         
	      this.last = n;
	
	      if(this.first == null)
	        this.first = last;
	   }
	   
	   
	   public T remove(){
	      if(this.first == null)
	            return null;
	       else{
	           T data = this.first.data;
	            this.first = this.first.next;
	            if(this.first == null) this.last = null;
	            return data;
	       }
	           
	            
	   }  
	       
	   public T peek(){
	       if(this.first == null) 
	            return null;
	       else
	            return this.first.data;
	   }
	   
	   public boolean isEmpty(){
	       return this.first == null;
	   }
	   
	   
	}

}
