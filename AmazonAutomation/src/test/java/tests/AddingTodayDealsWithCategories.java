package tests;
import pages.*;
import utils.TestConfig;
import org.openqa.selenium.WebElement;  // For WebElement
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;  // For using Duration with WebDriverWait


import java.util.concurrent.TimeUnit;

public class AddingTodayDealsWithCategories {

	 private static WebDriver driver;
	    private HomePage homePage;
	    private TodayDealsPage todayDealsPage;
	    private ProductPage productPage;
	    private CartPage cartPage;
	    private String expectedResult, actualResult, productTitle;

	    @BeforeTest
	    public void setup() {
	    	String chromepath= System.getProperty("user.dir")+"\\resourses\\chromedriver.exe";
	 		
	 		
	 		System.setProperty("webdriver.chrome.driver", chromepath);
	 		driver = new ChromeDriver();
	 		driver.manage().window().setSize(new Dimension(1024, 768));



	        homePage = new HomePage(driver);
	        todayDealsPage = new TodayDealsPage(driver);
	        productPage = new ProductPage(driver);
	        cartPage = new CartPage(driver);

	        homePage.openURL(TestConfig.BASE_URL);
	    }

	    @Test 
	    public void testOpenTodayDeals(){
	        homePage.clickToclosepopup();
	        System.out.println("Today's Deals button is now clickable.");
	        homePage.clickTodayDealsBtn();
	    }

	    @Test ( dependsOnMethods = "testOpenTodayDeals")
	    public void testSelectCategories(){
	       // actualResult = todayDealsPage.getPageTitle();
	        expectedResult = "Today's Deals";
	        todayDealsPage.clickseemorebtn();
	        //todayDealsPage.clickHeadphonesCheckBox();
	        todayDealsPage.clickGroceryCheckBox();
	        //todayDealsPage.clickDiscountBtn();
	        // Define the WebDriverWait and the WebElement to be clicked
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Click the 10% off element with retry mechanism
	        for (int attempts = 0; attempts < 3; attempts++) {
	            try {
	               
	                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[6]/div/span[2]/div/label/span/span")));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	                element.click();
	                break; // Exit loop if click is successful
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, retrying...");
	                
	                try {
	                    Thread.sleep(1000); // Wait for 1 second before retrying
	                } catch (InterruptedException ie) {
	                    ie.printStackTrace();
	                }
	            }
	        }
	       
	    }

	    @Test (dependsOnMethods = "testSelectCategories")
	    public void testSelectFourthPage(){
	    	 for (int i = 0; i < 4; i++) {
	    	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, window.innerHeight);"); // Scroll down by one viewport height
	    	        try {
	    	            TimeUnit.SECONDS.sleep(2); // Wait for 2 seconds between scrolls to allow content to load
	    	        } catch (InterruptedException e) {
	    	            e.printStackTrace();
	    	        }
	    	    }

	    }

	    @Test ( dependsOnMethods = "testSelectFourthPage")
	    public void testSelectProduct() {
	    	todayDealsPage.clicktoselectproduct();

	    }

	    @Test ( dependsOnMethods = "testSelectProduct")
	    public void testAddItemToCart(){
	        productTitle = productPage.getProductTitle();
	        productPage.clickAddToCartBtn();
	    }

	    @Test (dependsOnMethods = "testAddItemToCart")
	    public void testCheckItemAddedToCart(){
	        cartPage.clickCartBtn();
	        String cartProductTitle = cartPage.getCartProductTitle();
	        Assert.assertEquals(cartProductTitle, productTitle, "The selected item didn't added to the cart");
	    }

	    @AfterTest
	    public void teardown() {
	        driver.quit();
	    }
	}
