/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
		System.out.println(oneWay("cat", "sat"));


	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	private static boolean oneWay(String s1,String s2){
	    
	    if(s1.length() - s2.length() > 0 || s1.length() - s2.length() < 0) return true;
	    int replaceCount = 0;
	    for(int i=0 ; i < s1.length(); i++){
	        if(s1.charAt(i) != s2.charAt(i))
	            replaceCount++;
	        if(replaceCount > 1) return false;
	    }
	    return true;
	}
	

}
