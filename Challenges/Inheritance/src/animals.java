
public class animals {
	String type; 
	int number; //number of animals of that type 
	public void type(String type){
		this.type = type; 
	}
	public String whatType(){ //if the person wants to find out what type of animal they have 
		return type; 
	}
	public void setAmount(int count){
		number = count; 
	}
	public int getCount(){
		return number; 
	}
	public void printZoo(){
		System.out.println("This animal belongs to the San Diego Zoo");
	}
	public void printSound(){
		//print the sound that each animal will make, this will be declared within each 
	}
}
