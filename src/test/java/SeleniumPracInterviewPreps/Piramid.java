package SeleniumPracInterviewPreps;

public class Piramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp=9;
		for(int i=1;i<temp;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=temp;i++)
		{
			for(int j=temp;j>=i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	
		

	}

}
