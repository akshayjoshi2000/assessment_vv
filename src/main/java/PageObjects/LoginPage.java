package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.magnifi.App;

public class LoginPage extends App {
	
//-------------------------------------------------------------------------------------	
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement EmailTextField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PasswordTextField;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginButton;

	
	
//--------------------------------------------------------------------------------------
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------
	
	
	
	public void Login() {
		EmailTextField.sendKeys(prop.getProperty("username"));
		PasswordTextField.sendKeys(prop.getProperty("password"));
		LoginButton.click();
		threadTest();
		VerifyDashboardPage();
	}


	
	public static void VerifyDashboardPage() {
		System.out.println("This is the title "+ driver.getTitle());

		assert driver.getTitle().equals("Dashboard"): "Title does not match!";
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
