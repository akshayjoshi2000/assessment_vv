package PageObjects;

import org.magnifi.App;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class EditPage extends App {

//-------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@data-testid='EditingSidebarToolBarItem-trim']")
	WebElement RigntSidebarShortcutTrim;
	@FindBy(xpath = "//input[@data-testid=\"EditingSidebarContentTrim-startTime\"]")
	WebElement StartTextBox;
	@FindBy(xpath = "//input[@data-testid=\"EditingSidebarContentTrim-endTime\"]")
	WebElement EndTextBox;
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement ApplyButton;
	@FindBy(xpath = "//button[normalize-space()='Generate']")
	WebElement GenerateButton;
	@FindBy(xpath = "//button[normalize-space()='Save as New']")
	WebElement SaveAsNewButton;
	@FindBy(xpath = "//input[@class='ant-input style_input__PrYq1']")
	WebElement TitleTextBox;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement SaveButton;
	@FindBy(xpath = "//button[normalize-space()='Reject All']")
	WebElement RejectCookiesButton;
	@FindBy(xpath = "//button[normalize-space()='View Clip']")
	WebElement ViewClipButton;


	//---------------------------ViewClip--------------------------------------
	@FindBy(xpath = "//input[@data-testid='ClipTrimModal-startTime']")
	WebElement ViewStreamStartTextField;
	@FindBy(xpath = "//input[@data-testid='ClipTrimModal-endTime']")
	WebElement ViewStreamEndTextField;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement CancelButton;


	//------------------------AutoFlipPage----------------------------------------
	@FindBy(xpath = "(//div[@class='style_aspectRatioTag__mplYS'])[3]")
	WebElement NinebySixteenRatio;
//	@FindBy(xpath = "(//div[@class='style_container__3jdNj']//button)[1]")
//	WebElement AutoFlipButton;
	@FindBy(xpath = "//button[normalize-space()='Auto-flip']")
	WebElement AutoFlipButton;
	@FindBy(xpath = "//button[normalize-space()='Generating...']")
	WebElement GeneratingButton;
	@FindBy(xpath = "/html/body/div[8]/div/div/div/div/div/div[1]")
	WebElement SuccessNotification;
	@FindBy(xpath = "(//div[@class='style_cardOverlay__yVSTZ'])[3]")
	WebElement NineBySixteenFinalOP;
	@FindBy(xpath = "//div[@class='style_downloadContainer__B3Av3']")
	WebElement DownloadButton;
	@FindBy(xpath = "//div[@class='ant-notification-notice style_container__gYzXH ant-notification-notice-success ant-notification-notice-closable']")
	WebElement DownloadNotification;


//--------------------------------------------------------------------------------------
	public EditPage() {
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------
	




	public void TrimVideo() {
		RigntSidebarShortcutTrim.click();
		StartTextBox.sendKeys(Keys.CONTROL + "a");
		StartTextBox.sendKeys(Keys.DELETE);
		StartTextBox.sendKeys("00:01:28:935");
		EndTextBox.sendKeys(Keys.CONTROL + "a");
		EndTextBox.sendKeys(Keys.DELETE);
		EndTextBox.sendKeys("00:01:45:060");
		RejectCookiesButton.click();
		ApplyButton.click();
		GenerateButton.click();
		threadTest();
		SaveAsNewButton.click();
		threadTest();
		TitleTextBox.sendKeys("NewFile_"+HexCode());
		threadTest();
		SaveButton.click();
		assert DownloadNotification.isDisplayed();
		threadTest();
		ViewClipButton.click();
		threadTest();
		System.out.println("The Start value is "+ViewStreamStartTextField.getAttribute("value"));
		System.out.println("The End value is "+ViewStreamEndTextField.getAttribute("value"));
		assert ViewStreamStartTextField.getAttribute("value").equals("00:01:28:935");
		assert ViewStreamEndTextField.getAttribute("value").equals("00:01:45:060");
		CancelButton.click();

	}

	public void FlipClip() throws InterruptedException {
		threadTest();
		NinebySixteenRatio.click();
		threadTest();
		AutoFlipButton.click();
		Thread.sleep(30000);
		NineBySixteenFinalOP.click();
		DownloadButton.click();
		assert DownloadNotification.isDisplayed();
		//assert SuccessNotification.isDisplayed();
	}
	//-------------------------------------------------------------------------------------
	public static void threadTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String HexCode(){
		Random r = new Random();
		int n = r.nextInt();
		String Hexadecimal = Integer.toHexString(n);
		return Hexadecimal;
	}

	public void fluentWaitForElement(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(60))       // Maximum wait time
				.pollingEvery(Duration.ofSeconds(5))       // Polling interval
				.ignoring(NoSuchElementException.class);    // Ignore specific exceptions

		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
