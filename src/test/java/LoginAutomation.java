import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sam.rultest2.com/account/");
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys("rakibtorzo");
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys("12345678");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/div/a")).click();
        Thread.sleep(5000);

        //Course
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[1]/div/div[2]/div/div[1]/div/div/div[2]/div[3]/a/span")).click();
        Thread.sleep(5000);

        //to perform Scroll on application using Selenium
        JavascriptExecutor JE = (JavascriptExecutor) driver;
        JE.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(5000);

        //driver.findElement(By.xpath("//i[contains(@class,'stm_lms_play')]")).click();
        //pause
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/nav/div[1]/button[2]")).click();

        //Scroll to Top
        js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
        Thread.sleep(5000);

        // Back to Dashboard
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/a")).click();

        //Settings
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='float_menu_item__title heading_font'])[2]")).click();
        Thread.sleep(5000);

        //Edit Profile
        WebElement toClear = driver.findElement(By.xpath("//*[@id=\"stm_lms_edit_account\"]/span/form/div[1]/div/div/span[1]/div/div/input"));
        toClear.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        Thread.sleep(5000);

        //Input New Name
        toClear.sendKeys("Rakib Al Torzu");
        Thread.sleep(3000);

        //Upload Picture
        WebElement UploadImg = driver.findElement(By.xpath("//input[contains(@type,'file')]"));
        UploadImg.sendKeys("C:\\Users\\User\\Desktop\\New folder\\mypic.jpg");
        Thread.sleep(5000);

        JavascriptExecutor jE = (JavascriptExecutor) driver;
        jE.executeScript("window.scrollBy(0,700)", "");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"stm_lms_edit_account\"]/span/form/div[3]/div/div/div[1]/button/span")).click();
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
        Thread.sleep(2000);

        //Logout
        driver.findElement(By.xpath("//a[@class='logout-link'][contains(.,'Log out')]")).click();

    }
}

