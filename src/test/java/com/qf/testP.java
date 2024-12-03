package com.qf;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class testP {

    WebDriver driver;
    @BeforeClass
    public void classSetup() {
    }
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (priority = 1) //URL
    public void test1() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Web form");

    }
    @Test (priority = 2) //text
    public void test2() throws InterruptedException{
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement inputElement = driver.findElement(By.id("my-text-id"));
        inputElement.sendKeys("Priya");
        Assert.assertEquals(inputElement.getAttribute("value"), "Priya", "The input field value should be 'Priya'.");
    }
    @Test (priority = 3) //screenshot
    public void test3() throws InterruptedException, IOException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        TakesScreenshot screenshotnew = (TakesScreenshot) driver;
        File srcFile = screenshotnew.getScreenshotAs(OutputType.FILE); //take SS
        //Specify the path
        File destFile = new File("C://Users/priya/OneDrive/Desktop/Selenium_practice_SS/screenshotnew.png");
        FileUtils.copyFile(srcFile, destFile);
        Assert.assertTrue(destFile.exists(), "Screenshot file should exist after being saved.");
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());// Chang
    }
    @Test (priority = 4)//password encrypt
    public void test4() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String encryptedPassword = "Preethi";
        WebElement passwordElement = driver.findElement(By.name("my-password"));
        passwordElement.sendKeys(encryptedPassword);
        Assert.assertEquals(passwordElement.getAttribute("value"), encryptedPassword, "The password field should contain the encrypted password.");
        System.out.println(passwordElement.getText());
    }
    @Test (priority = 5) //textarea
    public void test5() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("My name is Priya, I am an Experienced Data Analyst with 7 yrs of Experience in various fields");
        Assert.assertEquals(textarea.getAttribute("value"), "My name is Priya, I am an Experienced Data Analyst with 7 yrs of Experience in various fields");
    }
    @Test (priority = 6) //checkbox
    public void test6() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement check1 =driver.findElement(By.id("my-check-2"));
        check1.click();
        Assert.assertTrue(check1.isSelected(), "The checkbox button should be selected after clicking.");
    }
    @Test (priority = 7) //radio
    public void test7() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement radio1 =driver.findElement(By.id("my-radio-2"));
        radio1.click();
        Assert.assertTrue(radio1.isSelected(),"The radio button should be selected after clicking.");
    }
    @Test (priority = 8) //navigate, forward, back
    public void test8() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/");
        Assert.assertEquals(driver.getTitle(), "Your Store");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(), "Web form");
        System.out.println(driver.getTitle());
    }
    @Test (priority = 9)
    public void test9() throws InterruptedException {
        List<WebElement> special = driver.findElements(By.xpath("//a[@href = 'https://ecommerce-playground.lambdatest.io/index.php?route=product/special']"));
        System.out.println(special);
    }
    @Test (priority = 10) //window handles
    public void test10() throws InterruptedException {
        String singlewindow = driver.getWindowHandle();
        System.out.println(singlewindow);

    }
    @Test (priority = 17)//windowhandles(set)
    public void test17() throws InterruptedException {
        Set<String> allwindows = driver.getWindowHandles();
        System.out.println(allwindows);
    }
    @Test (priority = 11) //select dropdown
    public void test11() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test (priority = 12) //submit button
    public void test12() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement submit  = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        submit.click();
    }
    @Test (priority = 13)   //ecommerce popup
    public void test13() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/");
        Assert.assertEquals(driver.getTitle(), "Your Store");
        System.out.println(driver.getTitle());
        WebElement imac = driver.findElement(By.xpath("//a[@class='text-ellipsis-2']"));
        imac.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement popup = driver.findElement(By.xpath("//a[@href=/#mz-component-983507417/]"));
        popup.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        WebElement popupClose = driver.findElement(By.xpath("//div[@id='mz-component-983507417']//button[@type='button' and @class='close fas mz-modal-close']"));
        Assert.assertTrue(popupClose.isSelected());
    }
    @Test (priority = 14) //alert
    public void test14() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement index = driver.findElement(By.xpath("//a[@href = './index.html']"));
        index.click();
        WebElement dialoguebox = driver.findElement(By.xpath("//a[@href = 'dialog-boxes.html']"));
        dialoguebox.click();
        //WebElement alert1 = driver.findElement(By.id("my-alert"));
        //alert1.click();
        /*Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();*/
    }
    @Test (priority = 15) //mouseover
    public void test15() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement index = driver.findElement(By.xpath("//a[@href = './index.html']"));
        index.click();
        WebElement mouseOver = driver.findElement(By.xpath("//a[@href='mouse-over.html']"));
        mouseOver.click();
        Actions actions = new Actions(driver);
        WebElement elementToHover = driver.findElement(By.id("element-id"));
        actions.moveToElement(elementToHover).perform();
    }
    @Test (priority = 16) //context click & double click
    public void test16() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement index = driver.findElement(By.xpath("//a[@href = './index.html']"));
        index.click();

        /*WebElement doubleClick = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary mb-2']"));
        doubleClick.click();
        Actions actions = new Actions(driver);
        WebElement contextMenu2 = driver.findElement(By.id("context-menu-2"));
        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).build().perform();
        WebElement contextMenu3 = driver.findElement(By.id("context-menu-3"));*/
    }
    @Test (priority = 18) //fileupload
    public void test18() throws InterruptedException, IOException {
        String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(initUrl);
        WebElement inputFile = driver.findElement(By.name("my-file"));
        Path tempFile = Files.createTempFile("tempfiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        //log.debug("Using temporal file {} in file uploading", filename);
        inputFile.sendKeys(filename);
        driver.findElement(By.tagName("form")).submit();
    }
    @Test (priority = 19) //datalist
    public void test19() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement datalist = driver.findElement(By.name("my-datalist"));
        datalist.click();
        WebElement option = driver.findElement(By.xpath("//datalist/option[2]"));
        String optionValue = option.getAttribute("value");
        datalist.sendKeys(optionValue);
        Assert.assertEquals(datalist.getAttribute("New York"), optionValue);
    }
    @Test (priority = 20) //css selector by id(#), by class(.), bgy attribute(similar to xpath)
    public void test20() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        //WebElement textarea1 = driver.findElement(By.cssSelector("#my-text-id")); //css selector by id
        WebElement textarea1 = driver.findElement(By.cssSelector(".form-control"));
        textarea1.sendKeys("My name is Priya, I am an Experienced Data Analyst with 7 yrs of Experience in various fields");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}