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
	    stack.push(2);
	    stack.push(1);
	    stack.push(5);
	    stack.push(4);
	    stack.push(0);
	    stack.push(3);
	    stack.push(10);
		System.out.println(stack.peek());
		System.out.println("\n");
		stack.print(stack.top);

		//System.out.println(stack.pop());
		//System.out.println(stack.peek());
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
	       
	       Node<T> n = new Node<T>(t);
	       
	       if(this.top != null){
	           Node<T> curr = this.top;
	           Node<T> prev = this.top;;
	           while(curr.next != null){
	               // check if the next data is higher that the actual
	               if((Integer) n.data > (Integer) curr.next.data){
	                   // is so, we move onto the next node
	                   prev = curr;
	                   System.out.println("n > next.data: true");
	               }else{
	                   // means it's lower or equal to the next node, so we add the new node to this position
	                   // we point the prev node to this new, and we replace the next node of the new node to the prev.next  prev -> new -> prev.next
	                   System.out.println("n > next.data: false");
	                   n.next = curr.next;
	                   if(prev != curr){
	                       curr.next = n;
	                   }else{
	                       n.next = this.top;
	                       this.top = n;
	                   }
	                       
	                   return;
	               }
	               curr = curr.next;

	           }
	           
	           // if no element was put in, this is the greatest element in the stack, so we move it at the end of the stack
	       
               if((Integer) n.data > (Integer) curr.data){
                  System.out.println("greatest element: true");
                  curr.next = n;
               }else{
                    System.out.println("smallest element: true");
                    n.next = this.top;
                    this.top = n;
               }
     
	       }else{
	           this.top = n;
	       }
	       
	       size++;
	       
	   }
	   
	  /* private void compareData(Node<Integer> prev, Node<Integer> curr, Node<Integer> n){
           if((Integer) n.data > (Integer) curr.next.data){
               // is so, we move onto the next node
               prev = curr;
               curr = curr.next;
               System.out.println("n > next.data: true");
           }else{
               // means it's lower or equal to the next node, so we add the new node to this position
               // we point the prev node to this new, and we replace the next node of the new node to the prev.next  prev -> new -> prev.next
               System.out.println("n > next.data: false");
               n.next = curr.next;
               if(prev != this.top){
                   prev.next = n;
               }else{
                   this.top = n;
               }
                   
               return;
           }
	   }*/
	 
	   
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
	   
	   public void print(Node n){
	        
	        if(n == null) return;
	        System.out.print(n.data + ", ");
	        if(n.next == null) return;
	        print(n.next);
	    }
	}

}
