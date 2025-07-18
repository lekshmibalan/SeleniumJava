package tests;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultsPage;
import utils.TestConfig;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.lang.InterruptedException;

import java.util.concurrent.TimeUnit;

public class AddingProductToCart {
	 private static WebDriver driver;
	    private HomePage homePage;
	    private ResultsPage resultsPage;
	    private ProductPage productPage;
	    private CartPage cartPage;
	    private String expectedResult, actualResult, productTitle;


	    @BeforeTest
	    public void setup() {
	    	String chromepath= System.getProperty("user.dir")+"\\resourses\\chromedriver.exe";
	 		
	 		
	 		System.setProperty("webdriver.chrome.driver", chromepath);
	 		driver = new ChromeDriver();
	 		driver.manage().window().setSize(new Dimension(1024, 768));
	 		driver.get("https://www.amazon.com/");
	 		 try {
	             Thread.sleep(10000); // 10 seconds
	         } catch (InterruptedException e) {
	             e.printStackTrace(); // Handle the exception
	         }
	 		driver.navigate().refresh();



	        homePage = new HomePage(driver);
	        resultsPage = new ResultsPage(driver);
	        productPage = new ProductPage(driver);
	        cartPage = new CartPage(driver);

	        //homePage.openURL(TestConfig.BASE_URL);
	    }

	    @Test 
	    public void testSearchFunction(){
	        homePage.setSearchTxtBox("car accessories");
	        homePage.clickSearchBtn();
	        expectedResult = "\"car accessories\"";
	        actualResult = resultsPage.getSearchResultTitle();

	        Assert.assertEquals(actualResult, expectedResult, "Result of search data is wrong");
	    }

	    @Test ( dependsOnMethods = "testSearchFunction")
	    public void testSelectFirstItem(){
	        expectedResult = resultsPage.getProductLink();
	        resultsPage.clickProductLink();
	        productTitle = productPage.getProductTitle();

	        Assert.assertEquals(productTitle, expectedResult, "The selected item is wrong");
	    }

	    @Test ( dependsOnMethods = "testSelectFirstItem")
	    public void testAddItemToCart(){
	        productPage.clickAddToCartBtn();
	        try {
	            TimeUnit.SECONDS.sleep(5);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test ( dependsOnMethods = "testAddItemToCart")
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