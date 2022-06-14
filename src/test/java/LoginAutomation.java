import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sam.rultest2.com/account/");
        driver.findElement(By.xpath("driver.get(\"https://sam.rultest2.com/account/\");")).sendKeys("rakibtorzo");
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys("12345678");
        WebElement login = driver.findElement(By.name("commit"));
        login.click();
    }
}