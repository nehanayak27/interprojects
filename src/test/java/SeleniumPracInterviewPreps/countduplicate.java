package SeleniumPracInterviewPreps;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class countduplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="my n n e e h ha 333a ame bme"; 
		Pattern p2=Pattern.compile("[0-9]+");
		Matcher m2=p2.matcher(text);
		int consonents=0;
		while(m2.find())
		{
			consonents=consonents+1;
		}
		System.out.println("Count  is "+consonents);
		
		

	}

}
