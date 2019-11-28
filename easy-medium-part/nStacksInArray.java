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
	    
	    StacksInOneArray<String> stacks = new StacksInOneArray();
	    stacks.push(1, "1");
	    stacks.push(1, "2");
	    stacks.push(1, "3");
	    stacks.push(1, "4");
	    stacks.push(2, "a");
	    stacks.push(2, "b");
	    stacks.push(2, "c");
	    stacks.push(3, "100");
	    stacks.push(3, "110");
	    stacks.pop(1);
	    stacks.pop(2);
	    stacks.pop(3);

	    System.out.println("top element in stack 1: " + stacks.peek(1));
	    System.out.println("Whole Size: " + stacks.size());
	    stacks.printStacks();
	}
	
	public static class Node<T>{
	    T data;
	    Node<T> next;
	    
	    public Node(T t){
	        this.next = null;
	        this.data = t;
	    }
	}
	
	/* Wrapper class to keep data about each stack such as:
	*  stackNumber
	*  topIndex
	*  endChunkIndex
	*/ 
	private static class StackMetadata{
	    // incremental index for each Stack
	    final int stackNumber;
	    // index of the last data inserted  on the stack (peek() will return this value)
	    int topIndex;
	    // index of the start of this stack
	    int endChunkIndex;
	    
	    public StackMetadata(int stackNumber, int topIndex, int endChunkIndex){
	        this.stackNumber = stackNumber;
	        this.topIndex = topIndex;
	        this.endChunkIndex = endChunkIndex;
	    }
	}
	
	public static class StacksInOneArray<T>{
	   private final int DEFAULT_SIZE = 10;
	   private final int stacks = 3;
	   private Object[] arr;
	   private int size;
	   private int currentChunkSize;
	   private Map<Integer, StackMetadata> stackIndexes= new HashMap();
	   
	   public StacksInOneArray(){
	       this.arr = new Object[DEFAULT_SIZE];
	       this.initializeStackMetadata();
	       this.calculateStackIndexes();
	       this.currentChunkSize = this.calculateChunkSize();
	       this.size = 0;
	   }
	   
	   private void initializeStackMetadata(){
	       for(int i = 0; i < stacks; i++)
	            stackIndexes.put(i,new StackMetadata(i,0,0));
	   }
	   
	   private StackMetadata getStackInfo(int stackNumber){
	       return this.stackIndexes.get(stackNumber);
	   }
	   
	   // calculates chunk size depeding on the array length and the number of stacks on that array
	   private int calculateChunkSize(){
	        return (int) this.arr.length / stacks;
	   }
	   
	   public int size(){
	       return this.size;
	   }
	   
	   
	   private Map<Integer, StackMetadata> calculateStackIndexes(){
	       Map<Integer, StackMetadata> newStackIndexes =  new HashMap();
	       this.currentChunkSize = this.calculateChunkSize();
	       //if(this.arr.length % stacks == 0){
	       int indexCount = 0;
	       for(int i = 0; i < this.arr.length; i++){
	           // check if i is a multiple of the chunk, so we refer to the i stack
	           if((i+1) % this.currentChunkSize == 0){

	               StackMetadata sm = this.getStackInfo(indexCount);// get the current metadata for the stack i
	               sm.endChunkIndex = i;                            // update the endChunkIndex in StackMetadata
	               newStackIndexes.put(indexCount, sm);             // Add the new StackMetadata to the map
	               
	               indexCount++;
	           }
	               
	       }
	       
	       return newStackIndexes;
	   }
	   
	   private void doubleSizeArray(){
	       // incrase the size array 3 times
	       Object[] newArr = new Object[this.arr.length*2];
	       //copy values from the main array into the new array;
	       System.arraycopy(this.arr, 0, newArr, 0, this.arr.length-1);
	       // pass newArr to main array
	       this.arr = newArr;
	   }
	   
	   
	   // this function reacommodates the array according to the  
	   // start index of each stack in the new array length
	   private void reacommodateArrayValues(){
	       
	       // save old size before double sizing array
	       int oldChunkSize = this.currentChunkSize;
	       // actually, doubleSizeArray
	       this.doubleSizeArray();
	       // we get the new stack stackIndexes 
	       Map<Integer, StackMetadata>  newStackIndexes = this.calculateStackIndexes();
	       // iterate over the array from end to start and place
	       // each stack in its new index
	       
	       // get last item of the stackIndexes 
	       int startIndexChunk =  this.stackIndexes.get(this.stackIndexes.size()-1).endChunkIndex;
	       for(int i = this.stackIndexes.size()-1; i>0; i--){
	           //if(stackIndexes.get(i).equals())
	           //System.out.println("start chunk: " + (startIndexChunk) + ", end chunk: " + newStackIndexes.get(i).endChunkIndex + ", elements to copy: " + oldChunkSize);
	           // copy the portion of the stack to the new index
	           if(this.arr[newStackIndexes.get(i).endChunkIndex] != null)
	               System.arraycopy(this.arr, startIndexChunk, this.arr, newStackIndexes.get(i).endChunkIndex, oldChunkSize);
	           // calculate the next start index chunk
	           startIndexChunk = newStackIndexes.get(i-1).endChunkIndex + 1;
	       }
	       
	       this.stackIndexes = newStackIndexes;
	   }
	   
	   private boolean isAnyStackFull(){
	       // iterate over actual List stack indexes  to find if some of
	       // those index have any value, if so, it means that we reach the
	       // capacity of one of the stacks in the array, so we need to 
	       // double size the length of the array and calculate the new stack indexes
	       for(Map.Entry<Integer, StackMetadata> entry : this.stackIndexes.entrySet()){
			   // check if any of the stack indexes have a value
			   StackMetadata stack = entry.getValue();
			    int lastIndexInStack = 0;
			   //check it is the last stack
			   if(entry.getKey() == this.stacks - 1)
			       lastIndexInStack = this.arr.length - 1;
			   else  // this is not the last stack
			       lastIndexInStack = stack.endChunkIndex;
			   
			   //System.out.println(lastIndexInStack);
			   // given the index, we check for that position in the array    
	           if(this.arr[lastIndexInStack] != null)
	               return true;
	       }
	       
	       return false;
	   }

	   
	   // Inner methods for Stack Operations
	   public void push(int stackNumber, T t){
	       
	       // Throw exception if the stackNumber is not valid
	       if(stackNumber > this.stacks || stackNumber <= 0){
	           System.out.println("Invalid stack number.");
	           return;
	       }
	           
	       if(this.isAnyStackFull())
	           this.reacommodateArrayValues();
	       
	       // Get the stack info to be updated
	       StackMetadata sm = getStackInfo(stackNumber-1);
	       if(sm == null){
	           	System.out.println("Stack not found.");
	           	return;
	       }
	       else{
	           // add the element to the corresponding stack index by adding endChunkIndex + topIndex
	           int indexStack = (this.currentChunkSize*(stackNumber-1)) + sm.topIndex; // get the index position of the stack i and adding the top index (last index elem inserted)
	           this.arr[indexStack] = t;
	            // increase the counter of that Stack
	           sm.topIndex = sm.topIndex + 1;
	           // increase total size counter of the array
	           this.size++;
	           this.stackIndexes.put(stackNumber-1,sm);
	       }
	       
	           
	   }
	   
	   
	   public T pop(int stackNumber){
	      if(stackNumber > this.stacks || stackNumber <= 0){
	           System.out.println("Invalid stack number.");
	           return null;
	      }
	          
	       
	      StackMetadata sm = this.getStackInfo(stackNumber-1);
	      if(sm.topIndex == 0){
	          System.out.println("Empty stack.");
	          return null;
	      }
	           
	      // store the data of the item to delete
	      T data = (T) this.arr[sm.topIndex-1];
	      int indexStack = (this.currentChunkSize*(stackNumber-1) - 1) + sm.topIndex; // get the index position of the stack i and adding the top index (last index elem inserted)
          
          System.out.println(indexStack);

	      //convert to null the item 
	      this.arr[indexStack] = null;
	      // decrease the topIndex
	      sm.topIndex = sm.topIndex - 1;
	      // decrease size of array
	      size--;
	      return data;
	   }  
	       
	   public T peek(int stackNumber){
	      if(stackNumber > this.stacks || stackNumber <= 0){
	           System.out.println("Invalid stack number.");
	           return null;
	      }
            
            //System.out.println("top element index:" + (this.stackIndexes.get(stackNumber-1).topIndex-1));    
	       return (T) this.arr[this.stackIndexes.get(stackNumber-1).topIndex-1];
	   }
	   
	   public boolean isEmpty(int stackNumber){
	        if(stackNumber > this.stacks || stackNumber <= 0){
	           System.out.println("Invalid stack number.");
	           return false;
	        }
	           
	       return this.getStackInfo(stackNumber-1).topIndex == 0;
	   }
	   
	   
	   public void printStacks(){
	       for(Object t: this.arr){
	           System.out.print((T) t + ", ");
	       }
	   }
	   
	}

}
