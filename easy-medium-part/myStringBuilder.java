/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		
		MyStringBuilder sb = new MyStringBuilder();
		sb.append("hellow world");
		
		System.out.println(sb.size());
		System.out.println(sb.tostring());
		
		sb.append(" xdxdXDxd");
		
		System.out.println(sb.size());
		System.out.println(sb.tostring());

	}
	
	// O(1) space complex
	// O(n*n) time complex
	
	
	public static class MyStringBuilder{
	    
	    private final int bufferIncrease = 2;
	    private final int defaultSize = 10;
	    private int size;
	    private int charCount;
	    private char[] CHARS;
	    
	    public MyStringBuilder(String s){
	        this.size = s.length();
	        this.charCount = this.size;
	        this.CHARS = new char[s.length()];
	    }
	    public MyStringBuilder(){
	        this.size = defaultSize;
	        this.charCount = 0;
	        this.CHARS = new char[this.defaultSize];
	    }
	    
	    private boolean isDoubleSizeRequired(String newStr){
	        return this.charCount + newStr.length() > this.size;
	    }
	    
	    private void resizeBuffer(String newStr){
	        int oldSize = this.size;
	        this.size *= this.bufferIncrease;
	        
	        char[] newChars = new char[this.size];
	        System.arraycopy(this.CHARS, 0, newChars, 0, oldSize);
	        
	        this.CHARS = newChars;
	    }
	    
	    public void append(String s){
	        while(isDoubleSizeRequired(s)){
	            resizeBuffer(s);
	        }
	       
	       System.arraycopy(s.toCharArray(), 0, this.CHARS, this.charCount, s.length());
	       
	       this.charCount+=s.length();
	    }
	    
	    public int size(){
	        return this.charCount;
	    }
	    
	    public String tostring(){
	        return new String(this.CHARS);
	    }
	}
	

}
