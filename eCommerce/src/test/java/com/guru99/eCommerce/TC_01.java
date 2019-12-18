package com.guru99.eCommerce;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 {
	 static WebDriver driver;
	  static String baseURL;
	    @BeforeMethod
	    public void tearup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        baseURL = eCommerceUtil.url;
	        driver.get(baseURL + "/V4/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(eCommerceUtil.waittime, TimeUnit.SECONDS);
	    }
	
	  @Test
	  public void Mobile () {
			String actualBoxtitle = driver.getTitle();
			assertEquals(actualBoxtitle,eCommerceUtil.etitle);
			driver.findElement(By.xpath("//*[@class='level0 nav-1 first']/a")).click();
			String actualMobtitle = driver.getTitle();
			assertEquals(actualMobtitle,eCommerceUtil.Mobetitle);
			
			Select sort = new Select(driver.findElement(By.xpath("//*[@class='category-products']/div[@class='toolbar']//select[@title='Sort By']")));
			sort.selectByVisibleText("Name");

	  }
	    
	    
}
