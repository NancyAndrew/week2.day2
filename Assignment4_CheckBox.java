package week2.day2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_CheckBox {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// Select the languages that you know?
		WebElement languages = driver.findElement(By.xpath("//label[contains(text(),'Select the languages that you know?')]/following-sibling::input[1]"));
		languages.click();
		Thread.sleep(3000);
		System.out.println("Is Language slected as Java: "+languages.isSelected());
		// Confirm Selenium is checked
		WebElement selenium = driver.findElement(By.xpath("//label[contains(text(),'Selenium is checked')]/following-sibling::input[@type='checkbox']"));
		System.out.println("Is Selenium is checked by default: "+selenium.isSelected());
		// DeSelect only checked
		WebElement deSelect = driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[@checked]"));
		deSelect.click();
		Thread.sleep(3000);
		boolean unchecked=driver.findElement(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input[2]")).isSelected();
		if(unchecked==false)
		{
			System.out.println("Checkbox deselected");
		}
		else 
		{
			System.out.println("Checkbox selected");	
		}	
		// Select all below checkboxes
		List<WebElement> all = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following-sibling::input"));
		for(WebElement checkall:all) {
			checkall.click();
		}
		Thread.sleep(3000);
		System.out.println("All below options got selected");
		driver.close();
	}


}
