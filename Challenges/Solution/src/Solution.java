import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	 static String compress(String str) {
	        int count = 1; //to count the amount of times a string appears 
	        char temp; //initialize the string & will hold the new string
	        String word = ""; 
	        for(int i = 0; i < str.length()-1; i++){
	            temp = str.charAt(i); 
	            while(str.charAt(i) == str.charAt(i+1)){
	                count++; 
	                i++;
	            }
	            if(count > 1){
	                word = word + temp;
	                word += count; //concatenating the word 
	            } else {
	                word = word + temp; //not adding a value 
	            }
	            count = 1; //reinitialize count 
	        }
	        if(word.charAt(word.length()-1) != str.charAt(str.length()-1)){
	                word += str.charAt(str.length()-1);//get the last character
	            }
	        return word; 
	    }

	    public static void main(String[] args) throws IOException{
//	        Scanner in = new Scanner(System.in);
//	        final String fileName = System.getenv("OUTPUT_PATH");
//	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//	        String res;
//	        String _str;
//	        try {
//	            _str = in.nextLine();
//	        } catch (Exception e) {
//	            _str = null;
//	        }
//	        
//	        res = compress(_str);
//	        bw.write(res);
//	        bw.newLine();
//	        
//	        bw.close();
	    	System.out.println(compress("aaaaabbbbbbbbbccccpqrstuv"));
	    	return; 
	    }
	}