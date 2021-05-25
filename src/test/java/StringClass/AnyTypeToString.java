package StringClass;

public class AnyTypeToString {
	public void test(int s)
	{
		//Way 1
				int x=100;
				String y1=String.valueOf(x);
				
				//Way 2
				String y2="";
				y2=y2+x;
				
				//Way 3
				Integer i=new Integer(x);
				String y3=i.toString();
				
				//Above 3 ways are common for all other data types in Java including char[]
		
	}

		
			
}
