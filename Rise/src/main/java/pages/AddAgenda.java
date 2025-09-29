package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtility;
public class AddAgenda {
	WebDriver driver;
	PageUtility utility = new PageUtility();

	public AddAgenda(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'badge badge-status')and contains(@class,'bg-primary-soft')]")
	WebElement createAgenda;
	@FindBy(xpath = "//select[@id='agendaId']")
	WebElement agendaTitle;
	@FindBy(xpath = "//select[@id='unitTypeId']")
	WebElement sezName;
	@FindBy(xpath = "//input[@id='refernceNo']")
	WebElement sequenceNumber;
	@FindBy(xpath = "//textarea[@id='unitNmae']")
	WebElement typeUnitName;
	@FindBy(xpath = "//select[@id='exUnitId']")
	WebElement selectUnitName;
	@FindBy(xpath = "//input[@onclick='saveFormType()']")
	WebElement saveButton;
	@FindBy(xpath = "//button[@class='btn btn-success bootbox-accept']")
	WebElement modal;

	public AddAgenda clickOnCreateAgendaLink() {
		createAgenda.click();
		return this;
	}

	public AddAgenda selectAgendaFromList(String value) {
		utility.selectFromDropDown_ByVisibleText(agendaTitle, value);
		return this;
	}

	public AddAgenda selectSEZnameFromList(String value) {
		utility.selectFromDropDown_ByVisibleText(sezName, value);
		return this;
	}

	public AddAgenda enterSequenceNumber(int num) {
		sequenceNumber.sendKeys(String.valueOf(num));
		return this;
	}

	public AddAgenda enterUnitName(String sezname, String unit) {
		utility.selectFromDropDown_ByVisibleText(sezName, sezname);
		if (sezname.equalsIgnoreCase("SEEPZ SEZ")) {
			utility.selectFromDropDown_ByVisibleText(selectUnitName, unit);
		} else {
			typeUnitName.sendKeys(unit);
		}
		return this;
	}

	public AddAgenda clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public AddAgenda acceptmodal() {
		modal.click();
		return this;
	}
}

