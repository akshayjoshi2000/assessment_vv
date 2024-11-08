package PageObjects;

import org.magnifi.App;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends App {

//-------------------------------------------------------------------------------------
	@FindBy(xpath = "(//div[@class='style_container__YahQJ']//div[1])[1]")
	WebElement DashboardButton;
	@FindBy(xpath = "//div[@class='style_container__YahQJ']//div[2]")
	WebElement VideoButton;


//--------------------------------------------------------------------------------------
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------
	
	
	
	public void ClickOnVideo() {
		VideoButton.click();
		threadTest();
		VerifyVideoPage();
	}

	public void GoToDashboard(){
		DashboardButton.click();
	}


	
	public static void VerifyVideoPage() {
		System.out.println("This is the title "+ driver.getTitle());
		assert driver.getTitle().equals("Videos"): "Title does not match!";
	}


	//-------------------------------------------------------------------------------------
	public static void threadTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
