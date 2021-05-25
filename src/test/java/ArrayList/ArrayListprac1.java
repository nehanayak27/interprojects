package ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListprac1 {
	
	public void min()
	{
		ArrayList<String> arylist=new ArrayList<String>();
		arylist.add("neha nayak");
		arylist.add("neal pie");
		arylist.add("jean mol");
		arylist.add("ruchi liu");
		arylist.add("nikie nue");
		for(int i=0;i<arylist.size();i++)
		{
			System.out.println(arylist.get(i).toUpperCase());
		}
		
		for(String j:arylist)
		{
			System.out.println(arylist);
		}
		
		Set s=new HashSet();
		s.add("manual");
		s.add("automation");
		s.add("memo");
		
		for(int i=0;i<s.size();i++)
		{
			
			System.out.println(s);
		}
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListprac1 cvv=new ArrayListprac1();
		cvv.min();
		
	}

}
