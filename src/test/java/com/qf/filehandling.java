package com.qf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filehandling {
    WebDriver driver;

    @Test(dataProvider = "csvDataProvider")
    public void testWebForm(String textInputValue, String textAreaValue) {
        // Set up WebDriver (initialize if not already done)
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        }

        // Locate and populate the fields
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        // /html/body/main/div/form/div/div[2]/button

        // Fill in the form
        textInput.clear();
        textInput.sendKeys(textInputValue);
        textArea.clear();
        textArea.sendKeys(textAreaValue);

        // Submit the form
        submitButton.click();

        // Log output for verification
        System.out.println("Submitted form with Text Input: " + textInputValue + ", Text Area: " + textAreaValue);
    }

    @DataProvider(name = "csvDataProvider")
    public Object[][] csvDataProvider() throws IOException {
        String csvFile = "C:/Users/priya/OneDrive/Desktop/filehandling.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        String cvsSplitBy = ",";
        int rowCount = 0;

        // Read rows from the CSV and count them
        while ((line = br.readLine()) != null) {
            rowCount++;
        }
        br.close();

        // Re-read the file to populate the data
        Object[][] testData = new Object[rowCount - 1][2];
        br = new BufferedReader(new FileReader(csvFile));
        br.readLine(); // Skip header row
        int index = 0;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(cvsSplitBy);
            testData[index][0] = data[0]; // First column: Text input
            testData[index][1] = data[1]; // Second column: Text area
            index++;
        }
        br.close();
        System.out.println(testData.length);
        return testData;
    }
}
