/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    int [][] a = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,0,12},{13,14,15,16}};
	    zeroMatrix(a);
        //System.out.println(rotateMatrix(a));

	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	private static void zeroMatrix(int[][] m){
	    
	    int[][] b = new int[m.length][m[0].length];
	    copyArray(m,b);
	    
	    for(int i=0 ; i < m.length; i++){
	        for(int j=0 ; j < m[i].length; j++){
	            if(m[i][j] == 0){
	                System.out.println("zero found at: " + i +", "+j);
	                b[i] = new int[m[i].length];
	                b = makeYZeros(b, i, j);
	                break;
	            }
	                
	        }
	    }
	    
	   print(b);
	}
	

	private static int[][] makeYZeros(int [][] a, int index, int index2){
	    for(int i=0; i < a.length; i++){
	        for(int j=0; j < a[i].length; j++){
	             if(index2 == j)
	                 a[i][j] = 0;
	        }
	   }
	   
	   return a;
	}
	
	private static void copyArray(int [][] source,int [][] dest){
	    for(int i=0; i<source.length; i++)
          for(int j=0; j<source[i].length; j++)
            dest[i][j]=source[i][j];
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
