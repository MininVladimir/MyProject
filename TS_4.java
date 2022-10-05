import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS_4 {
    @DataProvider
    public Object[][] allChecked(){
        return new Object[][]{
                {"Glock18", "35 патронов", "AWP", "M249", "Нож"}
        };
    }
    @Test(dataProvider = "allChecked", priority = 1)
    public void TC_18(String allChecked[]) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\ATest\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        try {
            driver.get("http://127.0.0.1:5500/Application/start.html");
                Thread.sleep(200);
                WebElement element1 = driver.findElement(By.xpath("//a[@class = 'questions']"));
                element1.click();
                    Thread.sleep(200);
                    driver.switchTo().alert().sendKeys("Владимир");
                    Thread.sleep(200);
                        driver.switchTo().alert().accept();
                        Thread.sleep(200);
                        driver.switchTo().alert().accept();
                            Thread.sleep(200);
                                for (int i = 0; i < allChecked.length; i++) {
                                    Thread.sleep(200);
                                    WebElement element2 = driver.findElement(By.xpath("//label[text() = '" + allChecked[i] + "']"));
                                    element2.click();
                                }
                                            Thread.sleep(200);
                                            WebElement element3 = driver.findElement(By.xpath("//button[text() = 'Результат']"));
                                            element3.click();
                                                Thread.sleep(200);
                                                driver.switchTo().alert().accept();
                                                    Thread.sleep(200);
                                                    Assert.assertTrue(driver.findElement(By.id("q1")).getAttribute("style").contains("background-color: rgb(0, 0, 0); color: rgb(255, 215, 0);"));
                                                    Assert.assertTrue(driver.findElement(By.id("q2")).getAttribute("style").contains("background-color: rgb(0, 0, 0); color: rgb(255, 215, 0);"));
                                                    Assert.assertTrue(driver.findElement(By.id("q3")).getAttribute("style").contains("background-color: rgb(0, 0, 0); color: rgb(255, 215, 0);"));
                                                    Assert.assertTrue(driver.findElement(By.id("q4")).getAttribute("style").contains("background-color: rgb(0, 0, 0); color: rgb(255, 215, 0);"));
                                                    Assert.assertTrue(driver.findElement(By.id("q5")).getAttribute("style").contains("background-color: rgb(0, 0, 0); color: rgb(255, 215, 0);"));
                                                    System.out.println("Заголовки вопросов имеют параметры стиля: 'background-color: rgb(0, 0, 0); color: rgb(255, 215, 0)'");
        }
        finally {
            Thread.sleep(100);
            driver.quit();
        }
    }
}

