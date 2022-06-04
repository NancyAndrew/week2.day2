package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	
	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main	 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)	
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("florin_pops@yahoo.co.in");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'col-firstName')]/a[@class='linktext']"));
		String text=ele.getText();
		System.out.println("First Resulting Name is: "+text);
		ele.click();
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[1]")).click();
		String title = driver.getTitle();
		if (title.contains("Duplicate Lead")) {
			System.out.println("Title is Duplicate Lead");
		}
		else {
			System.out.println("Title is Not Matching");
		}
		driver.findElement(By.linkText("Create Lead")).click(); 
		driver.close();
	}

}

