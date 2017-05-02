package org.testng.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.uptake.pages.HomePage;
import org.uptake.pages.IndustriesPage;

public class uptaketests {
	
	WebDriver driver;
	
	 @Parameters({"browserType","url"})
	 @BeforeClass
	public void InvokeBrowser(String browserType,String url)
	{
		if(browserType.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		else if (browserType.equals("IE"))
		{
			System.setProperty("WebDriver.ie.driver","IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserType.equals("Chrome"))
		{
			System.setProperty("WebDriver.chrome.driver", "ChromeDriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	 @AfterClass
	 public void logout()
	 {
		 driver.quit();
	 }
		
	// Testcase 1 : Verify Title of UPTAKE webpage	
	 @Test(priority=1,description="Verify Title")
			public void VerifyTitle() throws InterruptedException
		{
			String expected ="Analytics for the industrial internet";
			String actual = driver.getTitle();
			Thread.sleep(3000);
			Assert.assertEquals(actual, expected);
		}
	
	 //TestCase 2 :  verify sectioname links are working in Uptake Homepage
		@Parameters({"sectionName"})
		@Test(priority=2,description="Verify Jump to Section")
		public void verifyjumptosection(String sectionName) throws InterruptedException
		{
			// Create an Object on HomePage Class
			HomePage hp =new HomePage(driver);
			
			if (sectionName.equals("INDUSTRIES"))
			{
				//Invoke the method using the object in HomePage
				hp.jumptoindustries();
				String expected1 = "https://uptake.com/industries";
				String actual1 = driver.getCurrentUrl();
				Thread.sleep(2000);
				Assert.assertEquals(actual1,expected1);
			}				
			else if (sectionName.equals("BLOG"))
			{
				hp.jumptoBlog();
			}
			else if (sectionName.equals("PRODUCTS"))
			{
				hp.jumptoProduct();
			}
			else if(sectionName.equals("NEWSROOM"))
			{
				hp.jumptoNewsroom();
			}
			else if (sectionName.equals("APPROACH"))
			{
				hp.jumptoApproach();
			}
			else
			{
				hp.jumptoBeyonduptake();
			}
			
		}
		
		//Test case 3 : Verify footer Element are present
		@Test(priority=3,description="VerifyElementPresent",timeOut=2000)
		public void isElementpresentHomePage() 
		    {
	        
			Assert.assertTrue(driver.findElement(By.xpath("(//footer[@id='footer']/div//img)[1]")).isDisplayed());         
	        Assert.assertTrue(driver.findElement(By.xpath("(//footer[@id='footer']/div//img)[2]")).isDisplayed());
	        Assert.assertTrue(driver.findElement(By.xpath("(//footer[@id='footer']/div//img)[3]")).isDisplayed());
	     		
			}
		
		
		//Test case 4 : Verify the number of indestrieslist present in INDUSTRIES page
		@Parameters({"industriesListnumber"})		
		@Test(priority=4,description="VerifyIndustriesListCount")
		public void industrieslist(String industriesListnumber )
		{
			
			//Creat an object of Industriespage
			IndustriesPage indpage = new IndustriesPage(driver);
			int Actual = indpage.getIndustriesListCount();
			int Expected = Integer.parseInt(industriesListnumber);
			//Compare actual against expected
			Assert.assertEquals(Actual,Expected);
								
		}
		
}



