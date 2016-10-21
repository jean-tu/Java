
public class Inheritance extends animals { //this will be the main class 
	public static void main(String[] args){
		pigeon p = new pigeon(); 
		p.setAmount(34);
		p.printZoo();
		p.printSound();
		p.type("bird");
		int number = p.getCount(); //should print 34
		System.out.println("number of birds you defined: " + number);
		return; 
	}
}
