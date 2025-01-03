import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class checkers {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkersURL() {
        driver.get("https://www.gamesforthebrain.com/game/checkers/");
        Assert.assertEquals(driver.getTitle(), "Checkers");
        //Make_5_moves

    }
     @Test
     public void make_a_move() {
         //for (int i = 0; i < 5; i++) {
         driver.get("https://www.gamesforthebrain.com/game/checkers/");
            /* WebElement orangePawn = driver.findElement(By.xpath("//div//img[@name = 'space62']"));
             orangePawn.click(); */
             //targetcell
             WebElement targetCell = driver.findElement(By.xpath("//div//img[@name = 'space53']"));
             targetCell.click();
             wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Make a move"));
//}
     }

    @Test //Restart game
    public void gameRestart() {
        //driver.get("https://www.gamesforthebrain.com/game/checkers/");
        WebElement restart = driver.findElement(By.xpath("//p//a[@href = './']"));
        restart.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}