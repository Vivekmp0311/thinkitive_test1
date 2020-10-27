package TestCases.ThinkitiveTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Assignment2 {
	
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	Actions act;
	
	@Test(priority=1)
	public void init() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		prop=new Properties();
		fis=new FileInputStream("C:\\Users\\Vivek\\eclipse-workspace\\ThinkitiveTest\\src\\test\\java\\TestCases\\ThinkitiveTest\\Data.properties");
		prop.load(fis);
		
		act=new Actions(driver);
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority=2)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.id("searchInput")).sendKeys("jeans ");
		Thread.sleep(5000);
		act.sendKeys(Keys.ENTER);
		act.build().perform();
	}
	@AfterTest
	public void getProductDetails() {
		List<WebElement> list=driver.findElements(By.xpath("//body/div[@id='app']/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[2]/div[1]/span[1]"));
		System.out.println(list.size());
		
		Iterator<WebElement> it=list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
