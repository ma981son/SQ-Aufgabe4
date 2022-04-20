import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class A_2_Tests {

    private static ChromeDriver driver;

    @BeforeClass
    void openBrowser(){

    }

    @Test
    void CreateCustomItem(){
        //Setup
        A_2.startBrowser();
        ChromeDriver driver = A_2.getDriver();
        driver.get("https://www.bb-list.com/npmnpn#/");

        //Execute
        WebElement categories = driver.findElement(By.xpath("//a[@href='#/basic-equipment']"));
        categories.click();
        //Verify
        assertEquals(driver.getCurrentUrl(),"https://www.bb-list.com/npmnpn#/basic-equipment");

        //Execute
        WebElement summerClothing = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='categories']/ul/li[2]/a")));
        summerClothing.click();

        //Verify
        //assertEquals(driver.getCurrentUrl(),"https://www.bb-list.com/npmnpn#/products/" + summerClothing.getAttribute("href"));

        //Execute
        WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn rounded-circle rounded-add-button btn-danger']")));
        addButton.click();

        WebElement nameTxt = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='__BVID__46___BV_modal_body_']/div/form/div/input")));
        nameTxt.click();
        nameTxt.sendKeys("Test");

        WebElement urlTxt = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='__BVID__46___BV_modal_body_']/div/form/div[2]/input")));
        urlTxt.click();
        urlTxt.sendKeys("https://www.amazon.de/ref=nav_logo");

        WebElement amountTxt = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='__BVID__46___BV_modal_body_']/div/form/div[3]/input")));
        amountTxt.click();
        amountTxt.clear();
        amountTxt.sendKeys("10");

        // Verify
        assertEquals(nameTxt.getAttribute("value"),"Test");
        assertEquals(urlTxt.getAttribute("value"),"https://www.amazon.de/ref=nav_logo");
        assertEquals(amountTxt.getAttribute("value"),"10");

        //Execute
        WebElement submit = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//footer[@id='__BVID__46___BV_modal_footer_']/button[2]")));
        submit.click();

        //Verify
        WebElement createdItem = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='categories']/ul/li[4]/div/div[2]/a")));
        assertEquals(createdItem.getAccessibleName(),"Test (10)");
        assertEquals(createdItem.getAttribute("href"),"https://www.amazon.de/ref=nav_logo");

    }
}
