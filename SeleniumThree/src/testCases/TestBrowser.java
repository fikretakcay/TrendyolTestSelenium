package testCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBrowser {
	
	public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
	
	public static void main(String ... args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\GoogleDriver 97.04\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.trendyol.com/");
		
		System.out.println("Browser is Open.");
		
		driver.manage().window().maximize();
		
		System.out.println("Browser is Maximize.");
		
		WebElement clickElement = driver.findElement(By.className("homepage-popup-img"));
		
		clickElement.click();
		
		System.out.println("Gender is Select.");
		
		wait(2000);
		
		
		WebElement SearchBox = driver.findElement(By.className("search-box"));
        
        SearchBox.click();
        
        WebElement SearchBoxSearch = driver.findElement(By.className("search-box"));
        
        SearchBoxSearch.sendKeys("Parfume");
        
        
        wait(1000);
        
        WebElement SearchBoxClick = driver.findElement(By.className("search-icon"));
        
        SearchBoxClick.click();
        
        System.out.println("Product Search is Completed.");
        
        wait(1000);
        
        
        WebElement bestSellerClick = driver.findElement(By.xpath("//option[@value=\"BEST_SELLER\"]"));        
        
        bestSellerClick.click();
        
        System.out.println("Best Sell Products is choosed.");
        
        wait(2000);
        
        String productSelection = driver.findElement(By.xpath("(//button[@class='add-to-basket-button'])[1]")).getText();
        
        if(productSelection.contains("Sepete Ekle")) {
        
        	driver.findElement(By.xpath("(//button[@class='add-to-basket-button'])[1]")).click();
        	
        	System.out.println("Product Is Added To Basket.");
        
        }
        else {
        
        	System.out.println("There is nothing like this button.");
       
        }
        
        wait(6000);

        String countUp = driver.findElement(By.xpath("//div[@class=\"basket-item-count-container visible\"]")).getText();
        
        int basketCountUp = Integer.parseInt(countUp);
        
        if(basketCountUp == 1) {
        	System.out.println("CountUp is Ýncreased.");
        }
        else {
        System.out.println("CountUp Value is Same.");
        }
        
        String goToBasket = driver.findElement(By.xpath("(//p[@class=\"link-text\"])[3]")).getText();
        
        if(goToBasket.contains("Sepetim")) {
        	driver.findElement(By.xpath("(//p[@class=\"link-text\"])[3]")).click();
        	System.out.println("Basket is Loading.");
        }
        else {
        	System.out.println("Basket is not Loading.");
        }
        
        wait(3000);
        
        WebElement basketConfirmTest = driver.findElement(By.xpath("(//a[@class=\"ty-link-btn-primary\"])[1]"));
        
        basketConfirmTest.click();
        
        System.out.println("Confirm Order Page Loading.");
        
        WebElement emailAccountClick = driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
        
        emailAccountClick.click();
        
        WebElement logInEmail = driver.findElement(By.id("login-email"));
        
        logInEmail.sendKeys("fikret_ant_07@hotmail.com");
        
        System.out.println("E-mail is Check...");
        
        WebElement logInPassword = driver.findElement(By.name("login-password"));
        
        logInPassword.sendKeys("123456");
        
        System.out.println("Password is Check...");
        
        WebElement logInAccount = driver.findElement(By.xpath("//button[@class=\"q-primary q-fluid q-button-medium q-button submit\"]"));
        
        logInAccount.click();
        
        System.out.println("Password or Email is Not Correct.");
        
        
        
        
        
        
        
        
        
      
        
        	
        
        
		

	}

}
