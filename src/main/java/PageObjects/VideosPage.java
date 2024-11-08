package PageObjects;

import org.magnifi.App;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideosPage extends App {

//-------------------------------------------------------------------------------------
	@FindBy(xpath = "//div[@class='style_imageContainer__PEZ3M']")
	WebElement VideoThumbnail;




//--------------------------------------------------------------------------------------
	public VideosPage() {
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------
	

	
	public void SelectVideoThumbnail() {
		driver.navigate().refresh();
		threadTest();
		VideoThumbnail.click();
		threadTest();
		System.out.println("This is the title "+ driver.getTitle());
		assert driver.getTitle().contains("Clips"): "Title does not match!";
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
