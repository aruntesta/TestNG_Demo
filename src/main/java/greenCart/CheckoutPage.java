package greenCart;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutPage extends BaseClass {
	
	
	@Test(dataProvider = "appData", priority = 2)
	public void promoCode(String promoCode) {
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promoCode);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebElement applied = driver.findElement(By.cssSelector("span.promoInfo"));
		Assert.assertTrue(applied.isDisplayed());
	}
		
	@Test (priority = 3)
	public void checkoutAction() {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		System.out.println("Checkout Page title is ==> "+driver.getTitle());
	}
}
