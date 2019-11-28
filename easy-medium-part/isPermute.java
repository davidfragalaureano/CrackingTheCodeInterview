/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		
		System.out.println(isPermutation("abgc","bcas"));

	}
	
	// O(n) space complex
	// O(1) time complex
	public static boolean isPermutation(String s1, String s2){
	    
	    if(s1.length() != s2.length())
	        return false;
	    int sum1 = 0;
	    int sum2 = 0;

	    for(int i = 0; i < s1.length(); i++){
	        sum1+= (int) s1.charAt(i);
	        sum2+= (int) s2.charAt(i);
	    }
	    
	    return sum1 == sum2;
	}
	

}
