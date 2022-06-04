package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_HyperLinks {


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		//getTitle
		String title=driver.getTitle();
		System.out.println("Title: "+title);
		//getCurrentUrl
		System.out.println("Current URL: "+driver.getCurrentUrl());
		driver.navigate().back();
		//navigate to buttons page
		driver.findElement(By.xpath("//a[contains(text(),'without clicking')]")).click();
		System.out.println("Buttons Page:"+driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		//click button
		driver.findElement(By.id("home")).click();
		System.out.println(driver.getPageSource());
		driver.navigate().back();
		//get position of button
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Position of Button:"+location);
		//get color
		String bgColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Button Color:"+bgColor);
		//height and width
		WebElement ele = driver.findElement(By.id("size"));
		System.out.println("Height and Width: "+ele.getSize());
		driver.navigate().back();
		//verify broken link
		driver.findElement(By.linkText("Verify am I broken?")).click();
		System.out.println("Error: "+driver.getCurrentUrl()); 
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Error msg displayed as: "+text);
		driver.navigate().back();
		//go to home page
		driver.findElement(By.xpath("//label[contains(text(),'(Interact')]/preceding-sibling::a[contains(text(),'Home Page')]")).click();
		System.out.println("Current URL"+driver.getCurrentUrl());
		driver.navigate().back();
		driver.close();
	}
}
