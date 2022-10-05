import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS_1 {

    @DataProvider
    public Object[][] validValue(){
        return new Object[][]{
                {"ak47"}, {"aug"}, {"awp"}, {"парные beretta"}, {"d3au1"}, {"desert eagle"}, {"famas"},
                {"five-seven"}, {"световая граната"}, {"galil"}, {"glock18"}, {"осколочная граната"},
                {"kmump45"}, {"нож"}, {"krieg 550 commando"}, {"krieg 552"}, {"m3"}, {"m4a1"}, {"m249"},
                {"mac10"}, {"mp5"}, {"p90"}, {"p228"}, {"scout"}, {"дымовая граната"}, {"tmp"}, {"usp45"}, {"xm1014"}
        };
    }
    @Test (dataProvider = "validValue", priority = 1)
    public void TC_1(String validValue) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.id("search"));
                element1.sendKeys(validValue);
                    Thread.sleep(200);
                    WebElement element2 = driver.findElement(By.id("btn1"));
                    element2.click();
                        Thread.sleep(200);
                        Assert.assertTrue(driver.findElement(By.xpath("//button[text() = 'В главное меню']")).getText().contains("В главное меню"));
                        System.out.println("Объект '" + validValue + "' найден");
        }
        finally {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] invalidValue(){
        return new Object[][]{
                {"грабли"}, {"граб ли"}, {"граб!ли"}, {"ГРАБЛИ"}, {"граб_ли"}, {"граб-ли"},
                {"граб,ли"}, {"грабли_Z"}, {"грабли88"}, {"grubли"}, {"grublee"}, {"grub/lee"},
                {"GrubleE"}, {"grubли1"}, {"grubleё"}, {"1234567890"}, {"!'№;%^&*()"}
        };
    }
    @Test (dataProvider = "invalidValue", priority = 2)
    public void TC_2(String invalidValue) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.id("search"));
                element1.sendKeys(invalidValue);
                    Thread.sleep(200);
                    WebElement element2 = driver.findElement(By.id("btn1"));
                    element2.click();
                        Thread.sleep(200);
                        Assert.assertTrue(driver.switchTo().alert().getText().contains("По вашему запросу ничего не найдено!!!"));
                        System.out.println("Объект '" + invalidValue + "' не найден");
        }
        finally {
            driver.quit();
        }
    }

    @Test (priority = 3)
    public void TC_3() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.id("search"));
                element1.sendKeys("");
                    Thread.sleep(200);
                    WebElement element2 = driver.findElement(By.id("btn1"));
                    element2.click();
                        Thread.sleep(200);
                        Assert.assertTrue(driver.switchTo().alert().getText().contains("Не указан объект поиска!!!"));
                        System.out.println("Не указан объект поиска!!!");
        }
        finally {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] amountSymbols(){
        return new Object[][]{
                {"осколочная гранат"}, {"осколочная граната"}, {"осколочная гранатаа"},
        };
    }

    @Test (dataProvider = "amountSymbols", priority = 4)
    public void TC_4(String amountSymbols) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.id("search"));
                element1.sendKeys(amountSymbols);
                    Thread.sleep(200);
                    Assert.assertTrue(driver.findElement(By.id("search")).getAttribute("value").contains(amountSymbols));
                    System.out.println("Проверка длины поля для значения " + amountSymbols);
        }
        finally {
            driver.quit();
        }
    }
}