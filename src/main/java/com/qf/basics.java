package com.qf;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class basics {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        //driver.manage().window().maximize();
        //System.out.println("Window is Maximized");


        WebElement inputElement = driver.findElement(By.name("my-text"));
        inputElement.sendKeys("Priya");

        TakesScreenshot screenshot1 = (TakesScreenshot) driver;
        File srcFile = screenshot1.getScreenshotAs(OutputType.FILE); //take SS
        //Specify the path
        File destFile = new File("C://Users/priya/OneDrive/Desktop/Selenium_practice_SS/screenshot1.png");
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());// Change this path as needed



        String encryptedPassword = "Preethi";
        WebElement passwordElement = driver.findElement(By.name("my-password"));
        passwordElement.sendKeys(encryptedPassword);
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("My name is Priya, I am an Experienced Data Analyst with 7 yrs of Experience in various fields");
        WebElement check1 =driver.findElement(By.id("my-check-1"));
        check1.click();
        /*driver.navigate().to("https://ecommerce-playground.lambdatest.io/");
        driver.navigate().back();
        driver.navigate().forward();
        List<WebElement> special = driver.findElements(By.xpath("//a[@href = 'https://ecommerce-playground.lambdatest.io/index.php?route=product/special']"));
        System.out.println(special); */
        Actions actions = new Actions(driver);
        actions.contextClick(textarea).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //String singlewindow = driver.getWindowHandle();
        //Set<String> allwindows = driver.getWindowHandles();
        //System.out.println(singlewindow);
        //System.out.println(allwindows);
        System.out.println(actions);
        WebElement dropdown = driver.findElement(By.name("my-select"));
                Select select = new Select(dropdown);
                        select.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement submit  = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        submit.click();
        System.out.println("Form has been submitted");
        driver.quit();
    }
}
