package greenCart;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Footer extends BaseClass {
String ftrTxt;

	@Test
	public void footerText() {
		ftrTxt = driver.findElement(By.xpath("//footer/p")).getText();
		System.out.println(ftrTxt);
	}
	
	@Test (invocationCount = 4)
	public void footerText_Comparasion(){
		assertEquals(ftrTxt, "© 2019 GreenKart - buy veg and fruits online");
	}

}
