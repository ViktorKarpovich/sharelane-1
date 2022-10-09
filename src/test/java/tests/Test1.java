package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver driver;

    @Test
    public void negativeRegisterWithNoFields(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//a[@href='./register.py']")).click();
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11223344");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email " +
                "was previously used", "Test");

    }
    @Test
    public void negativeRegisterWithNoOneRequiredField(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//a[@href='./register.py']")).click();
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11223344");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Viktor");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("112233@test.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. Some of your fields have invalid data or email " +
                "was previously used", "Test");

    }

    @Test
    public void positiveRegisterWithOnlyRequiredFields(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//a[@href='./register.py']")).click();
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11223344");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Viktor");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("112233@test.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

    }
    @Test
    public void positiveRegisterWithAllFields(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//a[@href='./register.py']")).click();
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("11223344");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Viktor");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Karpovich");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("112233@test.com");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
