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
	    
	    MyStack<String> stack = new MyStack();
	    stack.push("putos");
	    stack.push("todos");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
	
	public static class Node<T>{
	    T data;
	    Node<T> next;
	    
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
