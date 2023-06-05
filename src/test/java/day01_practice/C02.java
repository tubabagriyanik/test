package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        // arama motorunda nutella yazip aratınız
        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        // pencereyi kapatiniz


        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com/");

        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);


        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin

        //2 tane web element locate'i aldik. bunun icin List e atmaliyiz.
        for (int i = 0; i < 2; i++) {
            List<WebElement> butonlar = driver.findElements(By.xpath("(//a[@tabindex='0'])[8] |  (//a[@tabindex='0'])[15]"));
            butonlar.get(i).click();

            if (driver.getTitle().contains("Amazon")) {
                System.out.println("Title Amazon Iceriyor");

            } else {
                System.out.println("Title Amazon Icermiyor");
            }
            driver.navigate().back();
        }
        // pencereyi kapatiniz
        driver.close();

    }
}


