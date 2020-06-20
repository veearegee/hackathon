package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  

public class Challenge1 {  
  
	@org.testng.annotations.Test
	public void Test() throws IOException, InterruptedException { 
        System.setProperty("webdriver.chrome.driver", "/Users/intuit/node_modules/chromedriver/lib/chromedriver/chromedriver");  
          
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          
        driver.navigate().to("https://cpsatexam.org/");  
          
        List<WebElement> options = driver.findElements(By.cssSelector("ul#menu-primary-spacious > li > a"));
        options.get(0).click();
        
        WebElement challenge1 = driver.findElement(By.cssSelector("li#menu-item-207 > a"));
        challenge1.click();

        WebElement closePopup = driver.findElement(By.cssSelector("div#elementor-popup-modal-298 > div:nth-of-type(2) > i"));
        closePopup.click();
        
        sleep(10);
        
        List<WebElement> paraItems = driver.findElements(By.cssSelector("div.elementor-tab-title.eael-accordion-header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeScript("scrollBy(0, 3000)"); 
        
        sleep(10);
        
        String[] value= new String[5];
        int startIndex = 2171;
        for (int i = 0; i < paraItems.size(); i++) {
        	paraItems.get(i).click();
        	sleep(3);
        	WebElement content = driver.findElement(By.cssSelector("div#elementor-tab-content-" + startIndex +" > p:nth-of-type(2)"));
        	value[i] = content.getText();
        	System.out.println("value >>>"+ value[i]);
        	startIndex++;
		}

        for (int i = 0; i < paraItems.size(); i++) {
        	translate(driver, value[i]);
        }
        
        driver.quit();
    }  
    
    public static void translate(WebDriver driver, String content) {
    	driver.navigate().to("https://translate.google.com/"); 
    	
    	WebElement nativeLang = driver.findElement(By.cssSelector("textarea#source"));
    	nativeLang.click();
    	nativeLang.clear();
    	sleep(10);
    	nativeLang.sendKeys(content);
    	sleep(3);
    	
    	WebElement translatedValue = driver.findElement(By.cssSelector(".tlid-translation.translation"));
    	String translatedText = translatedValue.getText();
    	System.out.println("GivenText ::"+content);
    	System.out.println("Trnaslated Text ::" + translatedText);
    	
    }
    
    public static void sleep(int ms) {
    	 try {
 			Thread.sleep(ms * 1000);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}
    }
  
}  