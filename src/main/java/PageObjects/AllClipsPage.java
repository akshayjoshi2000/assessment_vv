package PageObjects;

import org.magnifi.App;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AllClipsPage extends App {

//-------------------------------------------------------------------------------------
	@FindBy(xpath = "(//div[@class='style_overlay__bB80w']//div[@class=\"style_row__yaRan style_bottomCtaRow__BxP4s\"]//div[@class=\"style_tag__C8Akh style_ctaTag__aR70W\" and contains(text(), 'Edit')])[1]")
	WebElement VideoThumbnailToEditButton;
	@FindBy(xpath = "(//div[@class='style_overlay__bB80w']//img[@class=\"style_container__31fuK\"])[1]")
	WebElement ThreeDotOptionButton;
	@FindBy(xpath = "(//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//div[@class])[5]")
	WebElement AutoFlipOption;
	@FindBy(xpath = "(//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//div[@class])[5]")
	WebElement MoreActions;
	@FindBy(xpath = "//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']//div[@class='style_dropdownItemTitle__-dQAD']")
	WebElement DeleteButton;
	@FindBy(xpath = "//button[@class='style_primaryButton__DlotR style_primaryButtonClassName__xZoIO']")
	WebElement DeleteConfirmButton;




	//li[@class='ant-menu-item ant-menu-item-active ant-menu-item-selected ant-menu-item-only-child']//div[@class='style_dropdownItemTitle__-dQAD']












//--------------------------------------------------------------------------------------
	public AllClipsPage() {
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------







	public void SelectVideoThumbnailToEdit() {

		Actions a =new Actions(driver);
		a.moveToElement(VideoThumbnailToEditButton).click().perform();
		threadTest();
		System.out.println("This is the title "+ driver.getTitle());
		assert driver.getTitle().contains("Clip info"): "Title does not match!";
	}

	public void SelectAutoFlipOption() throws InterruptedException {
		Thread.sleep(10000);
		driver.navigate().refresh();
		threadTest();
		Actions a =new Actions(driver);
		threadTest();
		a.moveToElement(VideoThumbnailToEditButton).perform();
		threadTest();
		a.moveToElement(ThreeDotOptionButton).click().perform();
		threadTest();
		a.moveToElement(AutoFlipOption).click().perform();
		threadTest();

	}

	//-------------------------------------------------------------------------------------
	public static void threadTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public  void DeleteFromAllClips(){
		Actions a =new Actions(driver);
		a.moveToElement(ThreeDotOptionButton).click().perform();
		a.moveToElement(MoreActions).click().perform();
		a.moveToElement(DeleteButton).click().perform();
		DeleteConfirmButton.click();

	}





}
