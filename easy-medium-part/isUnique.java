/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		
		System.out.println(areAllCharsUnique1("abcde"));

	}
	
	// O(1) space complex
	// O(n*n) time complex
	public static boolean areAllCharsUnique(String s){
	    
	    for(int i = 0; i < s.length()-2; i++){
	        for(int j = i + 1; j < s.length()-1; j++){
	           if(s.charAt(i) == s.charAt(j))
	                return false;
	        }
	    }
	    
	    return true;
	}
	
	// O(n) space solution
	// O(n) time complex
	public static boolean areAllCharsUnique1(String s){
	    Map<Character, Integer> m = new HashMap();
	    for(int i = 0; i < s.length(); i++){
	        Integer occ = m.get(s.charAt(i)) != null ?  m.get(s.charAt(i)) : 0;
	        m.put(s.charAt(i), ++occ);
	    }
	    
	    return m.size() == s.length();
	}
    
}
