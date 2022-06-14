import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Register {
    static String ExcelPath = "C:\\Users\\User\\Desktop\\New folder\\registration.xlsx";
    static String Username;
    static String email;
    static int Pass;
    static int pass2;
    static String Name;
    static String Phone;
    static int age;
    static String Institution;
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeSetup();
        Register_001();
    }
    public static void ChromeSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver_win32//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sam.rultest2.com/account/");
    }

    public static void Register_001() throws InterruptedException, IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(ExcelPath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        try
        {
            Username = sheet.getRow(0).getCell(0).getStringCellValue();
            Thread.sleep(2000);
            email = sheet.getRow(0).getCell(1).getStringCellValue();
            Thread.sleep(2000);
            Pass = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
            Thread.sleep(2000);
            pass2 = (int) sheet.getRow(0).getCell(3).getNumericCellValue();
            Thread.sleep(2000);
            Name = sheet.getRow(0).getCell(4).getStringCellValue();
            Thread.sleep(2000);
            Phone = sheet.getRow(0).getCell(5).getStringCellValue();
            Thread.sleep(2000);
            age = (int) sheet.getRow(0).getCell(6).getNumericCellValue();
            Thread.sleep(2000);
            Institution = sheet.getRow(0).getCell(7).getStringCellValue();
            Thread.sleep(2000);
        }
        catch (Exception ex){
            System.out.println("not working");
        }
        String Pass2 = String.valueOf(Pass);
        String Age2 = String.valueOf(age);
        String pass2_1 = String.valueOf(pass2);

        driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(Username);
        driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys(Pass2);
        driver.findElement(By.xpath("//input[contains(@name,'password_re')]")).sendKeys(pass2_1);
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(Name);
        driver.findElement(By.xpath("//*[@id=\"stm-lms-register\"]/span/form/div[2]/span[4]/div/div/input")).sendKeys(Phone);

        //Gender
        driver.findElement(By.xpath("(//span[contains(@class,'select2-selection__placeholder')])[1]")).click();
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();

        //Age
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Age2);

        //Designation
        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][contains(.,'Select Designation')]")).click();
        driver.findElement(By.xpath("(//li[contains(@role,'option')])[4]")).click();

        driver.findElement(By.xpath("//input[contains(@name,'institution_name')]")).sendKeys(Institution);

        //Register
        driver.findElement(By.xpath("(//span[contains(.,'Register')])[2]")).click();

        Thread.sleep(3000);
        boolean b = driver.findElements(By.xpath("//a[@href='https://sam.rultest2.com/wp-login.php?action=logout&redirect_to=https%3A%2F%2Fsam.rultest2.com&_wpnonce=5d6ea4068e']")).isEmpty();
        System.out.println(b);
    }
}
