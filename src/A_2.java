import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class A_2 {

    static ChromeDriver driver;

    public static void main(String[] args) {
        startBrowser();

        driver.get("https://lsf.htwg-konstanz.de/qisserver/rds?state=user&type=0&topitem=&breadCrumbSource=portal&topitem=functions");

        WebElement verButton = driver.findElement(By.className("links2"));
        verButton.click();

        WebElement menue = driver.findElement(By.className("menue"));

        List<WebElement> li_all = menue.findElements(By.tagName("li"));
        li_all.get(2).click();

        WebElement verTitel = driver.findElement(By.id("veranstaltung.dtxt"));
        verTitel.click();
        verTitel.sendKeys("softwarequalitätssicherung");

        WebElement submit = driver.findElement(By.xpath("//input[@name = 'search_start' and @type = 'submit']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", submit);

        WebElement vorlesug = driver.findElement(By.xpath("//a[@href='https://lsf.htwg-konstanz.de/qisserver/rds?state=verpublish&status=init&vmfile=no&publishid=183152&moduleCall=webInfo&publishConfFile=webInfo&publishSubDir=veranstaltung']"));
        vorlesug.click();

        WebElement raum = driver.findElement(By.xpath("//a[@href='https://lsf.htwg-konstanz.de/qisserver/rds?state=verpublish&status=init&vmfile=no&moduleCall=webInfo&publishConfFile=webInfoRaum&publishSubDir=raum&keep=y&raum.rgid=12777']"));
        raum.click();
    }

    static void startBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Maria\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    static ChromeDriver getDriver(){
        return driver;
    }

}