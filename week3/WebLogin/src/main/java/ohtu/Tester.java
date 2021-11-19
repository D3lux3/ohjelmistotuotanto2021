package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.UUID;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        
        sleep(2);




        //Testi oikealla käyttäjänimellä, mutta väärällä salasanalla.
/*        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("asd");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);*/

        // Toka testi.
/*        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        element = driver.findElement(By.name("username"));
        String username = UUID.randomUUID().toString();
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys("salis");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salis");

        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();

        sleep(3);*/

        // Kolmas testi
/*
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        element = driver.findElement(By.name("username"));
        String username = UUID.randomUUID().toString();
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys("salis");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salis");

        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();

        sleep(1);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(3);

*/

        
        driver.quit();
    }

    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
