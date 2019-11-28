/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
		System.out.println(isPalindromePermutation("atco cta", "taco cat"));


	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	private static boolean isPalindromePermutation(String s1,String s2){
	    //Map<String, > m = new HashMap();
	    //base cases
	    if(s1.length() != s2.length()) return false;
	    s1 = s1.toLowerCase();
	    s2 = s2.toLowerCase();
	    //if(!new StringBuilder(s1).reverse().toString().equals(s1)) return false;
	   
	    int sum1 = 0;
	    int sum2 = 0;
	    for(int i=0; i<s1.length(); i++){
	        sum1 += s1.charAt(i);
	        sum2 += s2.charAt(i);
	    }
	    System.out.println(sum1+ " " + sum2);
	    
	    return sum1 == sum2;
	}
	

}
