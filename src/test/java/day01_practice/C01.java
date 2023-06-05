package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        WebElement ilkKutucuk=driver.findElement(By.xpath("//input[@id='number1']"));
        //ilkKutucuk olan web elementi once locate ettik, sonra bir Web element'e assign ettik
        ilkKutucuk.sendKeys("20"); //ilk kutucuga 20 girdik
        //ilkKutucuk.sendKeys("20", Keys.TAB,Keys.TAB,"30",Keys.TAB,Keys.ENTER);


        // ikinci kutucuga 30 giriniz
        WebElement ikiciKutucuk=driver.findElement(By.xpath("//input[@id='number2']"));
        ikiciKutucuk.sendKeys("30");


        // calculate'e tıklayınız
        WebElement calculateButonu =driver.findElement(By.xpath("//input[@id='calculate']"));
        //driver.findElement(By.xpath("//input[@id='calculate']")).click();  bu sekildede yazabiliriz
        calculateButonu.click();

        // sonucu yazdırınız
        WebElement sonuc= driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Toplama islemi sonucu: "+ sonuc.getText()); //sonucu direk yazdirirsak bize Hashcode'larini verir
        //bu yuzden getText yazarak String olarak sonuc'u yazmasini istedik.


        // sayfayi kapatiniz
        driver.close();


    }
}

