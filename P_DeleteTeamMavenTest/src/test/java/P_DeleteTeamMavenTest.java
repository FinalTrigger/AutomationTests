import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class P_DeleteTeamMavenTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
//Before the test begins, creates a new webdriver and sets the base url
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://gamebattles.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }

  @Test
  public void FireFoxProFileChangeTest() throws Exception {
	System.out.println("**Starting P_ProfileChangeTest**");
    driver.get(baseUrl);
    //Click LogIn
    System.out.println("Clicking Log In");
    driver.findElement(By.cssSelector("div.button.login > a.link")).click();
    //Enter User name
    System.out.println("Entering Username");
    driver.findElement(By.xpath("//input[@id='login']")).sendKeys("MLGQA");
    //Enter Password
    System.out.println("Entering Password");
    driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("M1Gr0x!!");
    //Click LogIn Button
    System.out.println("Submit Log In");
    driver.findElement(By.className("login-button")).click();
    //Verify user name login by echo name to console
    System.out.println("Verify User Log In");
    String text = driver.findElement(By.cssSelector("span.username")).getText();
    System.out.println("Username is :" + text);
    ////////////////////////
    driver.get("arenacp.majorleaguegaming.com");
    driver.switchTo().frame("frame_nav");
    Select menu = new Select(driver.findElement(By.name("arena_id")));
    menu.selectByVisibleText("Call of Duty: Black Ops II");
    driver.findElement(By.partialLinkText("Search Teams")).click();
    
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
