package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_RadioButton {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// Are you enjoying the classes?
		boolean ele1 = driver.findElement(By.id("yes")).isSelected();
		System.out.println("Is Element 1 Selected: "+ele1);
		//Find default selected radio button
		boolean ele2 = driver.findElement(By.xpath("//input[@name='news' and @value='1']")).isSelected();
		System.out.println("Is Element 2 Already Selected: "+ele2);
		// Select your age group (Only if choice wasn't selected)
		WebElement ele3 = driver.findElement(By.xpath("//input[@name='age' and @value='1']"));
		System.out.println("Is Age Selected between 21 - 40: "+ele3.isSelected());
		Thread.sleep(5000);
		driver.close();
	}

}
