import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<T>{
	Iterator<T> it; 
	private T t; 
	
	PeekingIterator(Iterator it){
		this.it = it; //setting it to this instance of iterator 
	}
	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		List<String> L = Arrays.asList("First Item", //defining a List to on  
				"Second Item", 
				"Third Item", 
				"Fourth Item"
				); //new ArrayList<String>();
		List<String> empty = new ArrayList<String>(); 
		
		L.iterator(); //creating an iterator instance for L list 
		empty.iterator(); //creating an iterator for the empty instance 
		
		PeekingIterator(L.iterator()); 
		
	}

	private static void PeekingIterator(Iterator<String> iterator) {
		// TODO Auto-generated method stub
		
	}

}
