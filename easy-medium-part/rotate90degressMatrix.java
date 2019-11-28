/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    int [][] a = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
	    rotateMatrix(a);
        //System.out.println(rotateMatrix(a));

	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	private static void rotateMatrix(int[][] m){
	    
	    int[][] rotated = new int[m.length][m.length];
	    for(int i=0 ; i < m.length; i++){
	        placeNewArray(m[i],rotated,i);
	    }
	    
	    print(rotated);
	}
	
	private static void placeNewArray(int[]source, int[][] dest, int index){
	    for(int i=source.length-1 ; i >= 0; i--){
	       if(index + i + 1 == source.length){
    	       for(int j=0; j < source.length; j++){
    	           //System.out.println(j + ", " + i + " = " + source[j]);
    	           dest[j][i] = source[j];
    	       }
	       }
	   }
	   
	}
	
	private static void print(int [][] a){
	    for(int i=0; i < a.length; i++){
	       for(int j=0; j < a.length; j++){
	          System.out.print(a[i][j] + ", ");
	       }
	       System.out.println("\n");
	   }
	}
	

}
