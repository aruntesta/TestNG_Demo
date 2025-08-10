package greenCart;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Super;

public class GreenCart_Header extends BaseClass {

	@Test()
	public void logo() {
		String logoName = driver.findElement(By.xpath("//header/div/div[@class='brand greenLogo']")).getText();
		System.out.println(logoName);

	}

	@Test()
	public void cart() {
	//	driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	}

	@Test(priority = 2)
	public void headerLink_TopDeals() {
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		GreenCart_Header gh = new GreenCart_Header();
		String prtID = gh.windowsID().get(0);
		String chdID = gh.windowsID().get(1);
		driver.switchTo().window(chdID);
		System.out.println("TopDeals Page Title is ==> " + driver.getTitle());
		driver.switchTo().window(prtID);
	}

	@Test(priority = 2)
	public void headerLink_FlightBooking() {
		driver.findElement(By.xpath("//a[text()='Flight Booking']")).click();
		GreenCart_Header gh = new GreenCart_Header();
		String prtID = gh.windowsID().get(0);
		String chdID = gh.windowsID().get(1);
		driver.switchTo().window(chdID);
		System.out.println("FlightBooking Page Title is ==> " + driver.getTitle());
		driver.switchTo().window(prtID);
	}

	@Test(priority = 2)
	public void headerLink_Flashlink() {
		driver.findElement(By.xpath("//a[contains(@class,'blinkingText')]")).click();
		GreenCart_Header gh = new GreenCart_Header();
		String prtID = gh.windowsID().get(0);
		String chdID = gh.windowsID().get(1);
		driver.switchTo().window(chdID);
		System.out.println("Flashlink Page Title  is ==> " + driver.getTitle());
		driver.switchTo().window(prtID);
	}

	@Test
	public void search() {
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
		searchBox.sendKeys("c");
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addToCart = driver.findElement(By.xpath("//div/div/h4[text()='Carrot - 1 Kg']/following-sibling::div/button[text()='ADD TO CART']"));
		wt.until(ExpectedConditions.visibilityOf(addToCart)).click();
		WebElement added = driver.findElement(By.xpath("//button[@class='added']"));
		assertTrue(added.isDisplayed());

	}

}
