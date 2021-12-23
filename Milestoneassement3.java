package com.mindtree.demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Milestoneassement3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\Documents\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/");
		//1st hovers
		String hov = driver.findElement(By.partialLinkText("Hovers")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(hov);
		Set<String> id = driver.getWindowHandles();
		Iterator<String> s = id.iterator();
		String parent = s.next();
		String child = s.next();
		driver.switchTo().window(child);
		
		WebElement hAndL = driver.findElement(By.xpath("//div[@id='content']/div/div[1]"));
		
		Actions a = new Actions(driver);
		a.moveToElement(hAndL).build().perform();
		
		String name=driver.findElement(By.xpath("//div[@id='content']/div/div[1]/div/h5")).getText();
		System.out.println(name);
		driver.switchTo().window(parent);
		
		//2nd checkboxes
		String box = driver.findElement(By.partialLinkText("Checkboxes")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(box);
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i=0;i<checkbox.size();i++) {
			if(checkbox.get(i).isSelected()) {
				checkbox.get(i).click();
				
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		for (int i=0;i<checkbox.size();i++) {
			checkbox.get(i).click();
		}
		driver.switchTo().window(parent);
		
		//3 input
		String inputx = driver.findElement(By.partialLinkText("Inputs")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(inputx);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(4444));
		driver.switchTo().window(parent);
		
		//4th dropdown
		String dropdowns = driver.findElement(By.partialLinkText("Dropdown")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(dropdowns);
		
		driver.findElement(By.id("dropdown")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.switchTo().window(parent);
		
		//5th fileupload
		String fileup = driver.findElement(By.partialLinkText("File Upload")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(fileup);
	
		WebElement uploadElement = driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys("C:\\Users\\shiva\\Desktop\\milestone.txt");
        driver.findElement(By.id("file-submit")).click();
        driver.switchTo().window(parent);

		//6th sortable data tables
		String table = driver.findElement(By.partialLinkText("Sortable Data Tables")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(table);
		List<WebElement> table1row=driver.findElements(By.xpath("//table[@id='table1'] /tbody /tr"));
		String FirstName="Tim";		
		for(int i=0;i<table1row.size();i++) {
			List<WebElement> tabledata=table1row.get(i).findElements(By.tagName("td"));
			for(int j=0;j<tabledata.size();j++) {
				if(tabledata.get(j).getText().contentEquals(FirstName) ) {
					System.out.println("Email:   "+tabledata.get(2).getText());
					System.out.println("Website:   "+tabledata.get(4).getText());
					break;
				}
			}
			
		}
		driver.switchTo().window(parent);
		
		//7th KeyPress
		String key = driver.findElement(By.partialLinkText("Key Presses")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(key);
		driver.findElement(By.id("target")).sendKeys(Keys.ESCAPE);
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.switchTo().window(parent);
		
		//8th mutliple windows
		String windows = driver.findElement(By.partialLinkText("Multiple Windows")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(windows);
		driver.findElement(By.partialLinkText("Click Here")).click();
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parent);
		
		//9th Context Menu
		String menu = driver.findElement(By.partialLinkText("Context Menu")).getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().maximize();
		driver.get(menu);
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("hot-spot"));
		actions.contextClick(elementLocator).perform();
		driver.switchTo().alert().accept();
		driver.switchTo().window(parent);
		
		
		

	}

}
