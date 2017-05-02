package org.uptake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage  {
WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
	this.driver=driver;
    }
    
	
	public void jumptoApproach()
	{
		driver.findElement(By.linkText("APPROACH")).click();
	}
	public void jumptoProduct()
	{
		driver.findElement(By.linkText("PRODUCT")).click();
	}
	public void jumptoindustries()
	{
		driver.findElement(By.linkText("INDUSTRIES")).click();
		
	}	
	public void jumptoNewsroom()
	{
		driver.findElement(By.linkText("NEWSROOM")).click();
		
	}	
	public void jumptoBeyonduptake()
	{
		driver.findElement(By.linkText("BEYOND.UPTAKE")).click();
		
	}	
	public void jumptoBlog()
	{
		driver.findElement(By.linkText("BLOG")).click();
	}
}


