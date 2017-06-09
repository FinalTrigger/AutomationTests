import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class P_Create_TeamB02_1v1MavenTest {
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
	System.out.println("**Starting P_Create_TeamB02_1v1**");
	System.out.println("Pulling up gamebattles staging homepage");
	driver.get(baseUrl);
    //Click LogIn
	System.out.println("Clicking Log In");
    driver.findElement(By.cssSelector("div.button.login > a.link")).click();
    //Enter User name
    System.out.println("Entering Username");
    driver.findElement(By.xpath("//input[@id='login']")).sendKeys("MLGQA");
    //Enter Password
    System.out.println("Entering Password");
    driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("AnyPassword");
    //Click LogIn Button
    System.out.println("Submit Log In");
    driver.findElement(By.className("login-button")).click();
    //Verify user name login by echo name to console
    System.out.println("Verify User Log In");
    String text = driver.findElement(By.cssSelector("span.username")).getText();
    System.out.println("Username is :" + text);
	//////////////////////////////////////
    //Go to the CODB02 Page
    driver.get("http://gamebattles.majorleaguegaming.com/xbox360/call-of-duty-black-ops-ii/");
    /*
    //Action below is to Hover over Xbox and then select Xbox360
    System.out.println("Hover to Xbox then select Xbox360");
    Actions actions = new Actions(driver);
    WebElement Xbox = driver.findElement(By.xpath("//table[@id='site-nav']/tbody/tr/td[2]/div/a"));
    WebElement Xbox360 = driver.findElement(By.xpath("//td[2]/div/ul/li[2]/a"));
    actions.moveToElement(Xbox).moveToElement(Xbox360).click().build().perform();
    //Select Call of Duty Black Ops 2 Game Image
    System.out.println("Select Call of duty Black Ops 2");
    driver.findElement(By.xpath("//div[@id='subcontainer']/div[3]/div/div/div/table/tbody/tr/td[4]/a/img")).click();
    */
    //Action below is to hover over BO2 Ladder and select Singles 1v1
    System.out.println("Select Singles 1v1 Ladder");
    Actions actions1 = new Actions(driver);
    WebElement Ladder = driver.findElement(By.xpath("//div[2]/ul/li[2]/a"));
    WebElement onevone = driver.findElement(By.xpath("//div[@id='arena-menu']/ul/li[2]/ul/li[7]/a/span"));
    actions1.moveToElement(Ladder).moveToElement(onevone).click().build().perform();
    //Join ladder to create team
    System.out.println("Join ladder to create team");
    driver.findElement(By.xpath("//a[contains(@href, '/xbox360/call-of-duty-black-ops-ii/teams/create?ladder_id=1163&season_id=5819')]")).click();
    //Create a random number to attach to teamName MLGQA#(17 to fill maximum characters)
    System.out.println("Generating random name along with MLGQA#");
    String rndNumber = RandomStringUtils.randomNumeric(17);
    //Input Team Name MLGQA w/ Random Number
    System.out.println("Input team name");
    driver.findElement(By.id("name")).sendKeys("MLGQA"+rndNumber);
    System.out.println("Store generated name into variable teamName");
    String teamName = driver.findElement(By.id("name")).getAttribute("value");
    System.out.println("Team Name: "+teamName);
    //Regenerate Team URL
    System.out.println("Generating Team URL");
    driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    //Select Xbox Gamertag
    System.out.println("Select Xbox Gamertag to join team");
    driver.findElement(By.cssSelector("img.dhx_combo_img")).click();
    driver.findElement(By.cssSelector("div.dhx_combo_list > div")).click();
    //Confirm Team Creation
    System.out.println("Submit Team Creation");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    //Verify Confirmation
    System.out.println("Verify Team Congrats Alert");
    assertEquals("Congratulations !!!", driver.findElement(By.cssSelector("div.boxContent.clr > b")).getText());
    //Goto team page
    System.out.println("Load team page to verify team profile");
    driver.get("http://gamebattles.majorleaguegaming.com/xbox360/call-of-duty-black-ops-ii/team/${teamName}");
    System.out.println("Team "+teamName+" was created successfully!");
    System.out.println("**P_CreatE_TeamB02_1v1 Test Case Complete**");

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
