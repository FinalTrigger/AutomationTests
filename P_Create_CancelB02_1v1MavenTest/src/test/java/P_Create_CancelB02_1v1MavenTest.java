import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Random; 


public class P_Create_CancelB02_1v1MavenTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://gamebattles.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSCreateTeamB021v1() throws Exception {
    System.out.println("**Starting P_Create_CancelB02_1v1**");
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
	//////////////////////////////////////
	//Go to challenged team page - Josh Wing Black Ops 2
    System.out.println("Navigating to Tean Josh Wing Black Ops 2 page");
	System.out.println("Challenge Team: Josh Wing Black Ops 2");
	driver.get("http://gamebattles.majorleaguegaming.com/xbox360/call-of-duty-black-ops-ii/team/josh-wing-black-ops-2");
	//Click Challenge Team
	System.out.println("Click Challenge Team");
	driver.findElement(By.cssSelector("div > a > strong")).click();
	//Set time for challenge ahead of system time
	//System.out.println("Set the time for the challenge ahead of system time");
	//new Select(driver.findElement(By.name("fields[ampm]"))).selectByVisibleText("PM");
	//Select Hardcore Mode Enable (required field, can be disabled)
	driver.findElement(By.id("field_38367_0")).click();
	driver.findElement(By.id("field_38389_0")).click();
	driver.findElement(By.id("field_38390_0")).click();
	driver.findElement(By.id("field_38391_0")).click();
	driver.findElement(By.id("field_38392_0")).click();
	driver.findElement(By.id("field_38394_0")).click();
	driver.findElement(By.id("field_38395_0")).click();
	driver.findElement(By.id("field_38396_0")).click();
	driver.findElement(By.id("field_38563_0")).click();
	driver.findElement(By.id("field_38787_0")).click();
	driver.findElement(By.id("field_38789_0")).click();
	driver.findElement(By.id("field_40154_0")).click();
	//Checkbox for username to participate in challenge
	//System.out.println("Select user on MLGQA team to participate");
	//driver.findElement(By.name("roster[]")).click();
	//Checkbox agree to terms and conditions
	System.out.println("Agree to terms and conditions");
	driver.findElement(By.name("rules")).click();
	//Submit challenge
	System.out.println("Submit Challenge");
	driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	//Verify Challenge complete
	System.out.println("Verify Challnege Complete");
	assertEquals("You have successfully sent a challenge to Josh Wing Black Ops 2.\n\nReturn to your team's profile page", driver.findElement(By.xpath("//div[2]/div[9]/div[2]")).getText());
	System.out.println("Challenge has been made successfully!");
	System.out.println("Cancel Challenge Request In Progress...");
	//Select Singles Ladder to go navigate to team page
	System.out.println("Navigating to team page");
	driver.findElement(By.linkText("Singles Ladder")).click();
	//Go to team profile
	System.out.println("Click 'View Your Team'");
	driver.findElement(By.linkText("View Your Team")).click();
	//Select challenge information
	System.out.println("Click on Challenge information");
	driver.findElement(By.cssSelector("td.txtC > a > img.icon16")).click();
	//Cancel Challenge request
	System.out.println("Cancel Challenge Request");
	driver.findElement(By.name("status")).click();
	//Verify challenge cancel
	System.out.println("Verify Challenge Cancel");
	assertEquals("You have cancelled and removed the challenge.", driver.findElement(By.xpath("//div[@id='subcontainer']/div[9]/div[2]")).getText());
	System.out.println("Challenge has been Cancelled!");
	System.out.println("Re-Challenge in Progress...");
	//Go Back to the Challenged team page
	System.out.println("Navigating to Tean Josh Wing Black Ops 2 page");
	System.out.println("Challenge Team: Josh Wing Black Ops 2");
	driver.get("http://gamebattles.majorleaguegaming.com/xbox360/call-of-duty-black-ops-ii/team/josh-wing-black-ops-2");
	//Click Challenge Team
	System.out.println("Click Challenge Team");
	driver.findElement(By.cssSelector("div > a > strong")).click();
	//Set time for challenge ahead of system time
	//System.out.println("Set the time for the challenge ahead of system time");
	//new Select(driver.findElement(By.name("fields[ampm]"))).selectByVisibleText("PM");
	//Select Hardcore Mode Enable (required field, can be disabled)
	driver.findElement(By.id("field_38367_0")).click();
	driver.findElement(By.id("field_38389_0")).click();
	driver.findElement(By.id("field_38390_0")).click();
	driver.findElement(By.id("field_38391_0")).click();
	driver.findElement(By.id("field_38392_0")).click();
	driver.findElement(By.id("field_38394_0")).click();
	driver.findElement(By.id("field_38395_0")).click();
	driver.findElement(By.id("field_38396_0")).click();
	driver.findElement(By.id("field_38563_0")).click();
	driver.findElement(By.id("field_38787_0")).click();
	driver.findElement(By.id("field_38789_0")).click();
	driver.findElement(By.id("field_40154_0")).click();
	System.out.println("Agree to terms and conditions");
	driver.findElement(By.name("rules")).click();
	//Submit challenge
	System.out.println("Submit Challenge");
	driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	//Verify 2nd Challenge complete
	System.out.println("Verify 2nd Challnege Complete");
	assertEquals("You have successfully sent a challenge to Josh Wing Black Ops 2.\n\nReturn to your team's profile page", driver.findElement(By.xpath("//div[@id='subcontainer']/div[9]/div[2]")).getText());
	System.out.println("Challenge has been made successfully!");
	System.out.println("**P_Create_CancelB02_1v1 Complete!**");

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
