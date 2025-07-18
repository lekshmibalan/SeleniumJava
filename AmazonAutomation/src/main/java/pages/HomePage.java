package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By searchTxtBox = By.id("twotabsearchtextbox");
    public void setSearchTxtBox(String searchTxt) {
        sendKeysToElement(searchTxtBox, searchTxt);
    }

    private By searchBtn = By.id("nav-search-submit-button");
    public void clickSearchBtn() {
        clickElement(searchBtn);
    }

    private By todayDealsBtn = By.xpath("//*[@id=\"nav-xshop\"]/a[1]");
    public void clickTodayDealsBtn() {
        clickElement(todayDealsBtn);
    }
    private By closepopup = By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input");
    public void clickToclosepopup() {
        clickElement(closepopup);
    }
    
}

