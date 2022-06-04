package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// create Account in Facebook
		
		System.setProperty("webdriber.chrome.driver", "D:\\Chromedriver_win32\\chromedriver.exe")
;
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@class='_42ft_4jy0_6lti_4jy6_4jy2 selected _51sy']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("FristName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LastName");
		driver.findElement(By.xpath("//input[@name='reg_email_']")).sendKeys("7401089612");
		driver.findElement(By.xpath("//input[@name='reg_password_']")).sendKeys("TestLeaf123");
		
		WebElement ele1 = driver.findElement(By.xpath("//select[@id='day']"));
		Select day = new Select (ele1);
		
		day.selectByValue("15");
		
		WebElement ele2 = driver.findElement(By.xpath("//select[@id='month']"));
		Select month = new Select (ele2);
		
		month.selectByIndex(1);
		
		WebElement ele3 = driver.findElement(By.xpath("//select[@id='year']"));
		Select year = new Select (ele3);
		
		year.selectByVisibleText("1988");
		driver.findElement(By.xpath("//input[@value='2']/preceding-sibling::labl[@class='58mt']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

}
