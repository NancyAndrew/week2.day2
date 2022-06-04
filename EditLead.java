package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		 * 1	Launch the browser
		 * 2	Enter the username
		 * 3	Enter the password
		 * 4	Click Login
		 * 5	Click crm/sfa link
		 * 6	Click Leads link
		 * 7	Click Find leads
		 * 8	Enter first name
		 * 9	Click Find leads button
		 * 10 Click on first resulting lead
		 * 11 Verify title of the page
		 * 12 Click Edit
		 * 13 Change the company name
		 * 14 Click Update
		 * 15 Confirm the changed name appears
		 * 16 Close the browser (Do not log out)
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
		driver.findElement(By.xpath("//div[contains(@class,'x-panel-body-noheader')]//input[ @name='firstName' and contains(@class,'x-form-text')]")).sendKeys("Nancy");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000); 
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'col-firstName')]/a"));
		element.click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Flormitha");
		driver.findElement(By.className("smallSubmit")).click();
		WebElement companyName = driver.findElement(By.id("viewLead_companyName_sp"));
		String text=companyName.getText();
		if(text.contains("Flormitha")) 
		{
			System.out.println("Company Name Updated as: "+text);
		}
		else
		{
			System.out.println("Failed");
		}
		driver.close();
	}
	}
