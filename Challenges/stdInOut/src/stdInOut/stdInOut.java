package stdInOut;

import java.util.Scanner;

public class stdInOut {
	public static void main(String[] args){
		System.out.print("Enter a string: "); 
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.next();
		System.out.print("Enter an integer: ");
		int myInt = scanner.nextInt();
		scanner.close(); //don't forget to close the scanner 

		System.out.println("myString is: " + myString);
		System.out.println("myInt is: " + myInt);
	}
}
