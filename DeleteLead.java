package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
 
		/*
		 * http://leaftaps.com/opentaps/control/main
		 *  Delete Lead:
			1	Launch the browser
			2	Enter the username
			3	Enter the password
			4	Click Login
			5	Click crm/sfa link
			6	Click Leads link
			7	Click Find leads
			8	Click on Phone
			9	Enter phone number
			10	Click find leads button
			11	Capture lead ID of First Resulting lead
			12	Click First Resulting lead
			13	Click Delete
			14	Click Find leads
			15	Enter captured lead ID
			16	Click find leads button
			17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
			18	Close the browser (Do not log out)
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
	driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber')]")).sendKeys("7401089612");
	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inne x-grid3-col-partyId']/a"));
	System.out.println("Lead ID: "+element.getText());
	String LeadID=element.getText();
	element.click();
	driver.findElement(By.xpath("//a[contains(test(), 'Delete')]")).click();
	driver.findElement(By.xpath("//a[contains(test(), 'Find Lead')]")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
	
	Thread.sleep(3000);
	WebElement text = driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]"));
	String text1=text.getText();
	System.out.println(text1);
	
	if (text1.contains("No records to display")) {
		
		System.out.println("Pass");
	}
	
	else {
		System.out.println("Fail");
	}
	
	Thread.sleep(3000);
	driver.close();
	
	}

}
