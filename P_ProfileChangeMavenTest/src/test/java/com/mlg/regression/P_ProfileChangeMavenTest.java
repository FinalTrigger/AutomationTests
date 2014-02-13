package com.mlg.regression;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class P_ProfileChangeMavenTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
//Before the test begins, creates a new webdriver and sets the base url
  @Before
  public void setUp() throws Exception {
    driver = new RemoteWebDriver(new URL("http://ddavison:f547602f-836c-4483-bb90-962916d65260@ondemand.saucelabs.com:80/wd/hub"), DesiredCapabilities.chrome());
    baseUrl = "http://gamebattles.majorleaguegaming.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  }

  @Test
  public void testOpen() throws Exception {
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
    //Click on Edit Profile
    System.out.println("Clicking on Edit Profile Button");
    driver.findElement(By.cssSelector("div.button.login")).click();
    driver.findElement(By.xpath("//div[@id='mlg-header']/div/div[3]/div/div[7]/div/div[2]/a")).click();
    //Change description in profile
    System.out.println("Editing the Interests section of profile");
    driver.findElement(By.name("interests")).clear();
    driver.findElement(By.name("interests")).sendKeys("Edit Profile in Selenium Eclipse");
    //Update Profile
    System.out.println("Click on submit to change profile");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    //Verify that update has been applied to profile
    System.out.println("Verifing that change has been made");
    assertEquals("Profile has been updated.", driver.findElement(By.cssSelector("b > b")).getText());
    //Console Output of Assert Statement Above
    System.out.println("Profile has been updated!");
    System.out.println("**P_ProfileChangeTestCase Complete!**");
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
}
