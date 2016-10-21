import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args){
		System.out.print("Enter the file that you would like to search though: ");
		Scanner scan = new Scanner(System.in); 
		String fileName = scan.nextLine(); 
		System.out.print("Enter the word you want to search for: "); 
		String toSearch = scan.nextLine();  
		int count = countStringInFile(toSearch, fileName); 
	}
	
	public static int countStringInFile(String stringToLookFor, String fileName){
		System.out.println("filename: " + fileName + " " + stringToLookFor);
		  int count = 0;
		  try{
		    //FileInputStream fstream = new FileInputStream(fileName);
		    BufferedReader br = new BufferedReader(new FileReader(fileName)); //new BufferedReader(new InputStreamReader(fstream));
		    String strLine;
		    while ((strLine = br.readLine()) != null)   {
		      int startIndex = strLine.indexOf(stringToLookFor);
		      while (startIndex != -1) {
		        count++;
		        String base = null;
				startIndex = base.indexOf(stringToLookFor, 
		                                  startIndex +stringToLookFor.length());
		      }
		    }
		   // in.close();
		  }catch (Exception e){//Catch exception if any
		    System.err.println("Error: " + e.getMessage());
		  }
		  return count;
		}
}
//read in the information from file.txt and count the amount of times that a certain string shows up 