package PlayWrightSample.PlayWrightSample;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.*;

public class BaseTest {
  public static Page page;	
	
  @BeforeTest
  public void f() {
	  Playwright playwright = Playwright.create();
	  Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	  
	  Page currentPage = browser.newPage();
	  page = currentPage;
	  currentPage.navigate("https://www.google.com");  
  }
  
  @Test
  public void EnterValueInSearch() {
      page.locator("//*[@id=\"APjFqb\"]").fill("Playwright");
      try {
  		   Thread.sleep(5000);
  	   } catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		   e.printStackTrace();
  	   }
      
       // page.locator("//*[@id=\"Alh6id\"]/div[1]/div/ul/li",new Page.LocatorOptions().setHasText("automation tool")).click();
        try {
		    Thread.sleep(10000);
    	} catch (InterruptedException e) {
	    	// TODO Auto-generated catch block
		    e.printStackTrace();
	    }
        assert(page.locator("//*[@id=\"APjFqb\"]")).isEditable();
	}
  
    @AfterTest
    public void TraceDown() {
    	page.close();
    }
}
