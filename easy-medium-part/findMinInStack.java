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
	    
	    MyStack<Integer> stack = new MyStack();
	    stack.push(1);
	    stack.push(2);
	    stack.push(-1);
	    
	    System.out.println(stack.min());
	    System.out.println(stack.pop());
	    System.out.println(stack.min());
		
		/*System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());*/
	}
	
	public static class Node<T>{
	    T data;
	    Node<T> next;
	    T min;
	    
	    public Node(T t){
	        this.next = null;
	        this.data = t;
	    }
	}
	
	public static class MyStack<T>{
	   Node<T> top;

	   int size;
	   public MyStack(){
	       this.top = null;
	       size = 0;
	   }
	   
	   // this map stores the digits from 1

	   public void push(T t){
	       Node<T> n = new Node(t);
	       n.next = this.top;
	       this.top = n;
           
           // compare if the min of the element before the new is greather or less than the new
	       if(this.top.next != null && (Integer) this.top.data > (Integer) this.top.next.min)
	         this.top.min = this.top.next.min;
	       else
	         this.top.min = this.top.data;

	       size++;
	   }
	   
	   public T min(){
	       return this.top.min;
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
