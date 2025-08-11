package greenCart;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrderReview extends BaseClass {

	@Test(priority = 4)
	public void countrySelection() {
		WebElement dropdown = driver.findElement(By.cssSelector("div select"));
		Select sc = new Select(dropdown);
		sc.selectByValue("India");

	}

	@Test(priority = 4)
	public void agreeCheckbox() {
		WebElement chkBx = driver.findElement(By.cssSelector("input.chkAgree"));
		chkBx.click();
		assertTrue(chkBx.isSelected());
	}

	@Test(priority = 4)
	public void proceedToOrder() {
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		System.out.println("Order success Page title is ==> "+driver.getTitle());
	}
	
	@Test(priority = 5)
	public void orderSucessMsg() {
		String successMsg = driver.findElement(By.xpath("//div[@class='wrapperTwo']/span")).getText();
		System.out.println("Order Created Message ==> "+successMsg);
	}

}
