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
	    
	  MyQueue q = new MyQueue();
	  Animal d1 = new Dog();
	  Animal d2 = new Dog();
      Animal c3 = new Cat();
      Animal c4 = new Cat();
      
      q.enqueue(d1);
      q.enqueue(d2);
      q.enqueue(c3);
      q.enqueue(c4);
        
      System.out.println(q.dequeueDog());
      System.out.println(q.getSize());
      System.out.println("\n");
      
      System.out.println(q.dequeueAny());
      System.out.println(q.getSize());
      
      System.out.println("\n");
      System.out.println(q.dequeueAny());
      System.out.println(q.getSize());
      
      System.out.println("\n");
      System.out.println(q.dequeueCat());
      System.out.println(q.getSize());
      
      System.out.println(q.dequeueAny());


	}
	
	public static interface Animal{
	    public void setPriority(int arrivalTime);
	    public int getPriority();
	}
	
	public static class Dog implements Animal{
	    int arrivalTime;
        public Dog(){}

        @Override
        public void setPriority(int arrivalTime){
            this.arrivalTime = arrivalTime;
        }
        
        @Override
        public int getPriority(){
            return this.arrivalTime;
        }
	}
	
	public static class Cat implements Animal{
        int arrivalTime;
        public Cat(){}
        
        @Override
        public void setPriority(int arrivalTime){
            this.arrivalTime = arrivalTime;
        }
        
        @Override
        public int getPriority(){
            return this.arrivalTime;
        }
	}

	public static class MyQueue{
	   LinkedList<Cat> cats;
	   LinkedList<Dog> dogs;
	   int priority;
	   
	   public MyQueue(){
	       dogs = new LinkedList();
	       cats = new LinkedList();
	       int priority = 0;
	   } 
	   
	   public void enqueue(Animal animal){
	       if(animal instanceof Dog){
	            Dog dog = (Dog) animal;
	            dog.setPriority(priority++);
	            dogs.add(dog);
	       }else{
	            Cat cat = (Cat) animal;
	            cat.setPriority(priority++);
	            cats.add(cat);
	       } 
	          
	   }
	   
	   public int dequeueDog(){
	      System.out.println("Dequeuing Dog...");
	      
	      if(dogs.isEmpty())
	         return -1;
	         
	      int p = dogs.getFirst().getPriority();
	      dogs.removeFirst();
	      return p;
	   }
	   
	   public int dequeueCat(){
	      System.out.println("Dequeuing Cat...");
	      
	      if(cats.isEmpty())
	         return -1;
	         
	      int p = cats.getFirst().getPriority();
	      cats.removeFirst();
	      return p;
	   }
	   
	   public int dequeueAny(){
	      int p;
	      if(cats.isEmpty())
	           return dequeueDog();
	      if(dogs.isEmpty())
	          return dequeueCat();
	      
	      if(dogs.getFirst().getPriority() < cats.getFirst().getPriority()){
	          return dequeueDog();
	      }else{
	          return dequeueCat();
	      }
	     
	   }
	   
	   public int getSize(){
	       return cats.size() + dogs.size();
	   }
	   
	}
	

}
