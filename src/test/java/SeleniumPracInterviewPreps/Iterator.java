package SeleniumPracInterviewPreps;

import java.util.ArrayList;
import java.util.ListIterator;

public class Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		ArrayList<String> list = new ArrayList<String>();
		list.add("addition");
		list.add("substraction");
		list.add("multiplication");
		list.add("division");
		list.add("jonny");
		list.add("jonny yes");
		list.add("pappa");
		
		ListIterator iterator = list.listIterator();
		//traversing list  in frwd direction
		System.out.println("Displaying list elements in forward direction : ");
		
		while ( iterator.hasNext())
		{
			System.out.print(iterator.next() + " ");
			
		}
		System.out.println();
		
		System.out.println("_______________________________");
		
		
		//traversing from bacwrd direction.
		
		System.out.println("Displaying list elements in backward direction : ");
		while ( iterator.hasPrevious())
		{
			System.out.print(iterator.previous() + " ");
			
		}
		System.out.println();
		
		//remove an value from the arraylist using remove method. 
		ListIterator iteratowr = list.listIterator();
		      String str = "";
		      while (iteratowr.hasNext()) {
		         str = (String) iteratowr.next();
		         if (str.equals("jonny")) {
		        	 iteratowr.remove();
		            System.out.println("\nThe element jonny is removed");
		            break;
		         }
		      }
		      
		      System.out.println("\nThe ArrayList elements are: ");
		      for (String s: list) {
		         System.out.println(s);
		      }
		
		      
	}

}
