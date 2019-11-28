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
	    
	    List l = new ArrayList();
		System.out.println(printValue(l));
		
		int[] array = new int[]{17,65,4,9,12,4,21,89,100,76};
		System.out.println(binarySearch(array, 21, 0, array.length - 1));
	}
	
	
	public static int binarySearch(int[] array, int key, int izq, int der) {
	    
	    if(izq > der) return  -1;
	    
	    int centro = (int) (izq + der)/2;
	    
	    if(array[centro] == key)
	        return centro;
	    else if(key > array[centro])
	        izq = centro + 1;
	    else if(key < array[centro])
	        der = centro - 1;
	    
	    return binarySearch(array, key, izq, der);
	}
	
	public static <T extends List> int printValue(T t){
	    return t.size();
	}
}
