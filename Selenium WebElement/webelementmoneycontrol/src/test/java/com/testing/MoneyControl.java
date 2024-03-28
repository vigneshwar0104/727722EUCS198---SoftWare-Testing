package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoneyControl {

    WebDriver driver;

    @BeforeTest
    public void BeforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void Test()throws Exception
    {
        driver.get("https://www.moneycontrol.com/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        JavascriptExecutor JS=(JavascriptExecutor)driver;
        JS.executeScript("window.scrollBy(0,200,'smooth')", "");
        Thread.sleep(2000);
        String RI=driver.findElement(By.xpath("//*[@id=\"stockName\"]/h1")).getText();
        if(RI.equals("Reliance Industries Ltd."))
        System.out.println(RI+" Found");
        else
        System.out.println("Not Found");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]")).click();
        Thread.sleep(10000);
        JS.executeScript("window.scrollBy(0,1000,'smooth')", "");
        driver.findElement(By.linkText("SIP")).click();
        Thread.sleep(5000);
        
    }

    @AfterTest
    public void AfterTest()
    {
        driver.quit();
    }

}
