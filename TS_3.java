import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS_3 {
    @DataProvider
    public Object[][] Answer(){
        return new Object[][]{
                {"Glock18"}, {"Five-Seven"}, {"Desert Eagle"}, {"P228"},
                {"20 патронов"}, {"25 патронов"}, {"30 патронов"}, {"35 патронов"},
                {"Scout"}, {"AWP"}, {"D3/AU-1"}, {"Krieg 550 Commando"},
                {"AWP"}, {"XM1014"}, {"M249"}, {"MP5"},
                {"Нож"}, {"Световая граната"}, {"Осколочная граната"}, {"Дымовая граната"}
        };
    }
    @Test(dataProvider = "Answer", priority = 1)
    public void TC_10(String Answer) throws InterruptedException {
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
                                Thread.sleep(300);
                                WebElement element2 = driver.findElement(By.xpath( "//label[text() = '" + Answer + "']"));
                                    element2.click();
                                        Thread.sleep(200);
                                        Assert.assertTrue(element2.isEnabled());
                                        System.out.println("Ответ " + Answer + " выбран");
        }
        finally {
            driver.quit();
        }
    }
    @DataProvider
    public Object[][] fourValid(){
        return new Object[][]{
               {"Glock18", "35 патронов", "AWP", "M249", "Световая граната"},
               {"Glock18", "35 патронов", "AWP", "M249", "Осколочная граната"},
               {"Glock18", "35 патронов", "AWP", "M249", "Дымовая граната"}
        };
    }
    @Test(dataProvider = "fourValid", priority = 2)
    public void TC_15(String fourValid[]) throws InterruptedException {
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
                                Thread.sleep(300);
                                for (int i = 0; i < fourValid.length; i++) {
                                    WebElement element2 = driver.findElement(By.xpath("//label[text() = '" + fourValid[i] + "']"));
                                        element2.click();
                                }
                                            Thread.sleep(200);
                                            WebElement element3 = driver.findElement(By.xpath("//button[text() = 'Результат']"));
                                            element3.click();
                                                Thread.sleep(200);
                                                Assert.assertTrue(driver.switchTo().alert().getText().contains("Владимир, ты ответил правильно на 4 вопроса, твоя оценка - \"Хорошо\"!!!"));
                                                System.out.println("Подсчет результатов теста (4 ответа валидных)");
        }
        finally {
            driver.quit();
        }
    }
}
