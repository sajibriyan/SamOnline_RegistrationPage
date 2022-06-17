import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sam.rultest2.com/account/");
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys("rakibtorzo");
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/div/a")).click();
        Thread.sleep(4000);

        //Course
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[1]/div/div[2]/div/div[1]/div/div/div[2]/div[3]/a/span")).click();
        Thread.sleep(4000);
    }
}

