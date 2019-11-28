/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
		System.out.println(compress("aaa"));


	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	private static String compress(String s){
	    
	    StringBuilder sb = new StringBuilder();
	    char curr;
	    int count = 1;
	    for(int i=0 ; i < s.length(); i++){
	       curr = s.charAt(i);
	       if(i != s.length() -1 &&  curr == s.charAt(i+1)){
	           count++;
	       }else{
	           sb.append(curr);
	           sb.append(count);
	           count = 1;
	       }
	    }
	    
	    return sb.length() >= s.length() ? s : sb.toString();
	}
	

}
