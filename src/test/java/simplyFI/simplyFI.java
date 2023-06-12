package simplyFI;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class simplyFI {
	WebDriver wd;
	JavascriptExecutor js;
	String parent;
	SoftAssert softAssert;
	WebDriverWait wait;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://simplyfi.tech/");
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		parent = wd.getWindowHandle();
		softAssert = new SoftAssert();
		js = (JavascriptExecutor) wd;
		wait = new WebDriverWait(wd, 30);

	}

	@Test(priority = 0,description = "verifing the tilte of homepage")
	public void verifySimplifyWebsiteTitle() {
		String title = wd.getTitle();
		Assert.assertTrue(title.equalsIgnoreCase("SimplyFI Softech India Pvt. Ltd."));
	}

	@Test(priority = 1,description = "verifing the header elements in simplyFI homepage")
	public void verifyHeaderElements() {
		softAssert.assertTrue(wd.findElement(By.id("logo")).isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[1]/a")).getText()
				.equalsIgnoreCase("Our Products"));
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[2]/a")).getText()
				.equalsIgnoreCase("Industries"));
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a")).getText()
				.equalsIgnoreCase("Company"));
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[4]/a")).getText()
				.equalsIgnoreCase("Resources"));
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/a/li")).getText()
				.equalsIgnoreCase("SCHEDULE   MEETING"));
		System.out.println("hhh" + wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/a/li")).getText());
		softAssert.assertAll();

	}

	@Test(priority = 2,description = "verifying the simba title")
	public void verifySimbaPageTitle() throws InterruptedException {

		wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[1]")).click();

		WebDriverWait wait = new WebDriverWait(wd, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[1]/ul/li[1]/a"))).click();

		Thread.sleep(6000);
		switchToLastTab();
		Thread.sleep(1500);
		Assert.assertTrue("Title is not correct",
				wd.getTitle().equalsIgnoreCase("Trade Finance Automation: Simba software"));
		wd.close();
		wd.switchTo().window(this.parent);
	}

	@Test(priority =3,description = "verifing the invoizo page")
	public void verify_signup_page_elements_in_Invoizo() throws InterruptedException {
		goTo_signup_for_Invoizo();
		Thread.sleep(4000);
//	  wd.findElement(By.xpath("//*[@id=\"ngb-tab-0-panel\"]/div/div/form/div[5]/div/a/b")).click();
		Thread.sleep(4000);
		softAssert.assertTrue(wd
				.findElement(By.xpath("/html/body/app-root/app-blank-layout/app-register/div/div/div/div[1]/span/img"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[1]/div/select"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[2]/div/input"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[3]/div/input"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"password-field\"]")).isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath("//*[@id=\"password-field2\"]")).isDisplayed());

		js.executeScript("arguments[0].scrollIntoView();", wd.findElement(By
				.xpath("/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[8]/div/a")));
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[7]/div/button"))
				.isDisplayed());
		softAssert.assertAll();

		wd.close();
		wd.switchTo().window(this.parent);

	}

	@Test(priority = 4,description = "verifing the error messages in singup page of Invoizo")
	public void verify_error_message_in_Invoizo_signup_page() throws InterruptedException {
		goTo_signup_for_Invoizo();
		wd.findElement(
				By.xpath("/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[7]/div"))
				.click();
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[1]/div/div/div"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[2]/div/div/div"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[3]/div/div/div"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[4]/div/div/div"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[5]/div/div/div"))
				.isDisplayed());
		softAssert.assertTrue(wd.findElement(By.xpath(
				"/html/body/app-root/app-blank-layout/app-register/div/div/div/div[2]/div/form/div[6]/div/div/div/div"))
				.isDisplayed());
		wd.close();
		wd.switchTo().window(this.parent);

	}

	// method of switching between tabs
	public void switchToLastTab() {

		Set<String> allWindow = wd.getWindowHandles();
		String lastWindow = "";

		for (String handle : allWindow) {
			wd.switchTo().window(handle);
			lastWindow = handle;
		}

		wd.switchTo().window(lastWindow);
	}
    // method for invoizo page
	public void goTo_signup_for_Invoizo() throws InterruptedException {

		wd.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[1]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[1]/ul/li[2]/a"))).click();
		switchToLastTab();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"ngb-tab-0-panel\"]/div/div/form/div[5]/div/a")))
				.click();

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		wd.quit();
	}

}
