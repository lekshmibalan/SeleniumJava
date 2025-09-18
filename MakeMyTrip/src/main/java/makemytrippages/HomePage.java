package makemytrippages;

import makemytripbase.BaseTest;
import makemytriputil.TestUtil;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BaseTest{
	

	
	@FindBy(xpath="//a[contains(@href,'/flights/')]/span[2]")
	WebElement flightMenu;
	
	@FindBy(xpath="//li[contains(text(),'Round Trip')]")
	WebElement roundtripMenu;
	
	@FindBy(xpath="//input[@id='fromCity']")
	WebElement fromCityDrop;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement searchFromCity;
	
	@FindBy(xpath="//input[@placeholder='To']")
	WebElement searchToCity;
	
	@FindBy(xpath="//div[contains(@class,'dateFiled')][1]")
	WebElement depatureDrop;
	
	@FindBy(xpath="//div[contains(@class,'dateFiled')][2]")
	WebElement returnDrop;
	
	String departureDate="//div[@aria-label='%replace%' and @aria-disabled='false']";
	String returnDate="//div[@aria-label='%replace%' and @aria-disabled='false']";
			
	@FindBy(xpath="//a[contains(@class,'widgetSearchBtn') and text()='Search']")
	WebElement SearchBtn;
	
	public HomePage() {        //Constructor
		super();
		PageFactory.initElements(driver,this);
	}
		
		public void selectFlightMenu() {
			flightMenu.click();

		}
		
		public void selectRoundTrip() {
			roundtripMenu.click();
		}
		public void enterDepatureCity() {
			fromCityDrop.click();
			searchFromCity.sendKeys(config.getProperty("From"));
			searchFromCity.sendKeys(Keys.TAB);
		
	}
		public void enterReturnCity()
		{
			searchToCity.sendKeys(config.getProperty("To"));
			searchToCity.sendKeys(Keys.TAB);
		}
		
		public void enterDepatureDate() {
			depatureDrop.click();
			TestUtil date = TestUtil.getCurrentDateandReturnDate();
			driver.findElement(TestUtil.customXpath(departureDate, date.departureDate)).click();
			}
	public void enterReturnDate() {
		returnDrop.click();
		TestUtil date = TestUtil.getCurrentDateandReturnDate();
		driver.findElement(TestUtil.customXpath(returnDate, date.returnDate)).click();
		}
	public void searchButton() {
		SearchBtn.click();
	}
	
}
