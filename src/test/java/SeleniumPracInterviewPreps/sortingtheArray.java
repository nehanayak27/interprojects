package SeleniumPracInterviewPreps;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortingtheArray {
	
	public void examples()
	{
		LinkedList<String> al=new LinkedList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  
		  al.add("Ajay"); 
		  al.add("savi");  
		  al.add("mijay");  
		  al.add("tavi");  
		  al.add("xjay"); 
		  System.out.println("before removing"+al);
 al.remove("tavi");
 System.out.println("after removing"+al);
 
 //convert from array to list
 String[] array={"Java","Python","PHP","C++"};  
	System.out.println("display the array"+Arrays.toString(array));
	
	java.util.List<String> bb=new ArrayList<String>();  
	
	for(String c:array)
	{
		bb.add(c);
		System.out.println(c);
	}
	bb.add("neha");
	bb.add("nayak");
	System.out.println("added"+bb.toString());
	
	//sorting the array 
	java.util.List<String> list=new ArrayList<String>();  
	 //Adding elements in the List  
	 list.add("Mango");  
	 list.add("Apple");  
	 list.add("Banana");  
	 list.add("Grapes");  
	 System.out.println(list.get(2));
	 list.set(3, "neha");
	 System.out.println(list);
	 
	 Collections.sort(list);
	 for(String ff:list)
	 {
		 System.out.println(ff);
	 }
	 
	

 //list iterator 
	 java.util.List<String> al1=new ArrayList<String>();    
     al1.add("Amit");    
     al1.add("Vijay");    
     al1.add("Kumar");    
     al1.add(1,"Sachin");    
     al1.add(2,"neha");
     al1.add(4,"nayak");
     
     ListIterator<String> litr=al1.listIterator();
    
    while( litr.hasNext())
    {
 	   System.out.println("index:"+litr.nextIndex()+" value:"+litr.next());   
 	   
    }
    
    //hashmap
    
    Map map=new HashMap();  
    //Adding elements to map  
    map.put(1,"Amit");  
    map.put(5,"Rahul");  
    map.put(2,"Jai");  
    map.put(6,"Amit");  
    
    Set  cc=map.entrySet();
    java.util.Iterator it=cc.iterator();
    while(it.hasNext())
    {
 	   Map.Entry entry=(Map.Entry) it.next();
 	  System.out.println (entry.getKey()+""+entry.getValue());
    }
 //new style hashmap 
    Map<Integer,String> map1=new HashMap<Integer,String>();  
	  map1.put(100,"Amit");  
	  map1.put(101,"Vijay");  
	  map1.put(102,"Rahul");  
	  
	  for(Map.Entry m:map1.entrySet())
	  {
		  System.out.println(m.getKey()+""+m.getValue());
	  }
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter how many values to be in the list");
		int size=sc.nextInt();
		ArrayList<String> a=new ArrayList<String>();
		for(int i=0;i<size;i++)
		{
			a.add(sc.nextLine());
		}
		
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<a.size();i++)
		{
			String ai=a.get(i);
			if(hm.containsKey(ai))
			{
				hm.put(1, 10);
			}
			for(Map.Entry e:hm.entrySet())
			{
				System.out.println(e.getKey()+""+e.getValue());
			}
			
		}
		
		
       
  


	}

}
