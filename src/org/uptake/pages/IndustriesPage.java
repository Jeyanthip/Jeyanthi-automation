package org.uptake.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class IndustriesPage {
	WebDriver driver;
	 
	 public IndustriesPage(WebDriver driver)
	 {
		this.driver= driver;
	 }
	 
	 
	public int getIndustriesListCount()
	  {
			
		List<WebElement> Clist = driver.findElements(By.xpath("//div/div[@class='industries-list']/a"));
		return Clist.size();
	  }
	 	 
	}


