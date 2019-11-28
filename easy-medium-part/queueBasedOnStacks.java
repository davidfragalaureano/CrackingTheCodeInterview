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
		
		queue.add("putos");
	    System.out.println(queue.peek());
	    System.out.println(queue.remove());
		System.out.println(queue.peek());
		//queue.add("todos");
	    //System.out.println(queue.peek());

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
	   MyStack<T> q1;
	   MyStack<T> q2;
	   Node<T> top;
	   
	   int size;
	   public MyQueue(){
	       this.q1 = new MyStack();
	       this.q2 = new MyStack();
	       this.top = null;

	       size = 0;
	   }
	   
	   public void add(T t){
	      size++;
	      q1.push(t);
	   }
	   
	   // use for getting the oldest element (how the queue works)
	   private void suffleStacks(){
	       if(q2.isEmpty()){
	           while(!q1.isEmpty()){
	                q2.push(q1.pop());
	           }
	       }
	   }
	   
	   public T remove(){
	       suffleStacks();
	       size--;
	       return q2.pop();
	   }  
	       
	   public T peek(){
	       suffleStacks();
	       return q2.peek();
	   }
	   
	   public boolean isEmpty(){
	       return size == 0;
	   }
	   
	   
	}
	
	
	
	public static class MyStack<T>{
	   Node<T> top;
	   int size;
	   public MyStack(){
	       this.top = null;
	       size = 0;
	   }
	   
	   public void push(T t){
	       Node<T> n = new Node(t);
	       n.next = this.top;
	       this.top = n;
	       size++;
	   }
	   
	   
	   public T pop(){
	       if(this.top == null) 
	            return null;
	       else{
	           T item = this.top.data;
	           this.top = this.top.next;
	           size--;
	           return item;
	       }
	   }  
	       
	   public T peek(){
	       if(this.top == null) 
	            return null;
	       else
	            return this.top.data;
	   }
	   
	   public boolean isEmpty(){
	       return this.top == null;
	   }
	   
	   
	}

}
