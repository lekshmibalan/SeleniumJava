package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodayDealsPage extends BasePage {
    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//h1[@class=\"a-size-extra-large a-spacing-micro\"]");
    public String getPageTitle() {
        return getTextFromElement(pageTitle);
    }
    private By seemorebtn=By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/button/a");
    public void clickseemorebtn() {
        clickElement(seemorebtn);
    }

   
    private By groceryCheckBox = By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[15]/div/label/i");
    public void clickGroceryCheckBox() {
        clickElement(groceryCheckBox);
    }

    private By discountBtn = By.id("filter-percentOff-10% off or more");
    public void clickDiscountBtn() {
        clickElement(discountBtn);
    }

   
    private By product=By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div");
    public void clicktoselectproduct() {
    	clickElement(product);
    }
}