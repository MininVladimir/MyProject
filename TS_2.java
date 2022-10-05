import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TS_2 {

    @DataProvider
    public Object[][] Value(){
        return new Object[][]{
                {"Vладимир"}, {"Семён"}, {"Екатерина"}, {"Роберт_Z"}, {"Ева Оливия"}, {"Мухаммед-Али"},
                {"1234567890"}, {"!'№;%^&*()"}, {"susan"}, {"GeorgE"}, {"Петрthe1"}, {"Misha 228"}
        };
    }
    @Test(dataProvider = "Value", priority = 1)
    public void TC_5(String Value) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().sendKeys(Value);
                        Thread.sleep(200);
                        driver.switchTo().alert().accept();
                            Thread.sleep(200);
                            Assert.assertTrue(driver.switchTo().alert().getText().contains("Здравствуй, " + Value + "! Нажми «ОК», когда будешь готов начать."));
                            System.out.println("Значение '" + Value + "' задано");
        }
        finally {
            driver.quit();
        }
    }
    @Test(priority = 2)
    public void TC_6() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().dismiss();
                        Thread.sleep(200);
                        Assert.assertTrue(driver.switchTo().alert().getText().contains("Напиши свое имя, пожалуйста"));
                        System.out.println("Кнопка 'Отмена' нажата");
                            driver.switchTo().alert().sendKeys("Владимир");
                            driver.switchTo().alert().accept();
        }
        finally {
            driver.quit();
        }
    }

    @Test(priority = 3)
    public void TC_7() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().sendKeys("");
                        Thread.sleep(200);
                        driver.switchTo().alert().accept();
                        Thread.sleep(200);
                            Assert.assertTrue(driver.switchTo().alert().getText().contains("Напиши свое имя, пожалуйста"));
                            System.out.println("Кнопка 'ОК' нажата");
                                driver.switchTo().alert().sendKeys("Владимир");
                                driver.switchTo().alert().accept();
        }
        finally {
            driver.quit();
        }
    }

    @Test(priority = 4)
    public void TC_8() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().dismiss();
                        Thread.sleep(200);
                        driver.switchTo().alert().dismiss();
                            Thread.sleep(200);
                            Assert.assertTrue(driver.switchTo().alert().getText().contains("Напиши свое имя, пожалуйста"));
                            System.out.println("Кнопка 'Отмена' нажата 2 раза");
                                driver.switchTo().alert().sendKeys("Владимир");
                                driver.switchTo().alert().accept();
        }
        finally {
            driver.quit();
        }
    }

    @Test(priority = 5)
    public void TC_9() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().accept();
                        Thread.sleep(200);
                        driver.switchTo().alert().accept();
                            Thread.sleep(200);
                            Assert.assertTrue(driver.switchTo().alert().getText().contains("Напиши свое имя, пожалуйста"));
                            System.out.println("Кнопка 'ОК' нажата 2 раза");
                                driver.switchTo().alert().sendKeys("Владимир");
                                driver.switchTo().alert().accept();
        }
        finally {
            driver.quit();
        }
    }
}
