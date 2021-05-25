
public class Staticnest {
	
	public static int ox=10;
	public  int oy;
	
	public Staticnest()
	{
		oy=20;
	}
	public static void display()
	{
		System.out.println(ox);
	}
	public void display2()
	{
		System.out.println(ox+""+oy);
	}
	
	public static class innerstat
	{
		public static int ox=10;
		public  int op;
		
		public innerstat()
		{
			op=20;
		}
		public static void displaying()
		{
			System.out.println(ox);
		}
		public void display2()
		{
			System.out.println(ox+""+op);
		}
	}
	public static void main(String[] args) {
		Staticnest.innerstat.displaying();
	}

}
