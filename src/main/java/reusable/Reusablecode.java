package reusable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusablecode {
WebDriver driver;

public Reusablecode(WebDriver driver) {
	this.driver=driver;
}

	public void visibilityOfElement(By element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until( ExpectedConditions.visibilityOfElementLocated(element));
}
	public void visibilityOfWebElement(WebElement logerror) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOf(logerror));
	}
	public void invisibilityOfElement(WebElement web) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(web));
	}
	
	public void elementToBeClickable(By click) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until( ExpectedConditions.elementToBeClickable(click));
	}
	public void elementToBeClickable(WebElement cartclick) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until( ExpectedConditions.elementToBeClickable(cartclick));
	}
		// Wait for loader to disappear(headless)
	    public void waitForLoaderToDisappear() {
	    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    }

	    // SCROLL (important for headless)
	    public void scrollToElement(WebElement logscroll) {
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block: 'center'});", logscroll);
	    
	}//headless
	    public void clickElement(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Scroll into view
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

	        // Wait until clickable
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        try {
	            element.click();
	        } catch (Exception e) {
	            // Fallback for headless issues
	            ((JavascriptExecutor) driver)
	                    .executeScript("arguments[0].click();", element);
	        }
	    }
}