package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

import actionDriver.Actionclass;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest(groups = {"Smoke", "Sanity", "Regression"})
    public void loadconfig() {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("Configuration/Config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchapp() {
        String browser = prop.getProperty("Browser");
        if (browser.equalsIgnoreCase("Chrome")) {
            // Automatically download the correct version of ChromeDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            // Automatically download the correct version of GeckoDriver
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            // Automatically download the correct version of EdgeDriver
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        Actionclass.implicitWait(driver, 10);
        Actionclass.pageLoadTimeOut(driver, 20);
        driver.get(prop.getProperty("URL"));
        driver.navigate().refresh();
    }

    public static void snaps(String filename) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\akshp\\Downloads\\"
                    + "AmazonProjectTDDFramework\\Screenshots\\" + filename + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
