package factory;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;

	public static WebDriver initializeBrowser(String browserName) {

		if(browserName.equals("chrome")) {
		    WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			driver = new ChromeDriver(chromeOptions);

		}else if(browserName.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();

		}else if(browserName.equals("edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();

		}else if(browserName.equals("safari")) {
			WebDriverManager.chromedriver().setup();
			driver = new SafariDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));

		return driver;

	}

	public static WebDriver getDriver() {

		return driver;

	}





}
