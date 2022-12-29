import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;


public class polovniAutomobili {

    @Test
    public void case1() throws InterruptedException {
        System.setProperty("webdriver.chrome.diver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();

        String baseUrl = "https://www.polovniautomobili.com/";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(baseUrl);



        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));


        driver.findElement(By.className("_ado-responsiveFooterBillboard-hover")).click();
        driver.findElement(By.xpath("//button[text()='DETALJNA PRETRAGA']")).click();

        WebElement sveMarke = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_brand')]")));
        sveMarke.click();
        sveMarke.findElement(By.xpath("//label[text()='Audi']")).click();
        sveMarke.sendKeys("Audi");

        WebElement sviModeli = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_model')]")));
        sviModeli.click();
        sviModeli.findElement(By.cssSelector(".sumo_model .options > li:nth-of-type(8) > label")).click();
        sviModeli.sendKeys(Keys.TAB);

        WebElement cenaOd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='price_from']")));
        cenaOd.click();
        cenaOd.sendKeys("5000");

        WebElement cenaDo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='price_to']")));
        cenaDo.click();
        cenaDo.sendKeys("8000");

        WebElement karoserija = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_chassis')]")));
        karoserija.click();
        karoserija.findElement(By.cssSelector(".sumo_chassis .options > li")).click();
        karoserija.sendKeys(Keys.TAB);


        WebElement vrstaGoriva = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_fuel')]")));
        vrstaGoriva.click();
        vrstaGoriva.findElement(By.cssSelector(".sumo_fuel .options > li > label")).click();
        vrstaGoriva.sendKeys(Keys.TAB);

        WebElement region = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_region')]")));
        region.click();
        region.findElement(By.cssSelector(".sumo_region .options > li > ul > li > label")).click();
        vrstaGoriva.sendKeys(Keys.TAB);

        WebElement godinaOd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_year_from')]")));
        godinaOd.click();
        godinaOd.findElement(By.cssSelector(".sumo_year_from .options > li:nth-of-type(20) > label")).click();

        WebElement godinaDo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_year_to')]")));
        godinaDo.click();
        godinaDo.findElement(By.cssSelector(".sumo_year_to .options > li:nth-of-type(5) > label")).click();

        WebElement brojVrata = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sumo_door_num')]")));
        brojVrata.click();
        brojVrata.findElement(By.xpath("//*[contains(@class, 'sumo_door_num')]//*[contains(@class, 'options')]/li[3]")).click();

        driver.findElement(By.xpath("//*[@id='submit_1']")).click();

    }
}
