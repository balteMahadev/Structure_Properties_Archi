package com.price.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Action
{
    public static WebDriver driver;
    public static Properties properties;
    public String filePath()
    {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "files" + pathSeparator + "Properties1.";
        String filePath = filePaths + "properties";
        return filePath;
    }
    public Boolean isElementPresent(WebElement element)
    {
        if(element.isDisplayed())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void  valueInTextBox(WebElement element,String text)
    {
        if(isElementPresent(element))
        {
            element.click();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
        }
        else
        {
            System.out.println("Element");
        }
    }
    public void getProperties()
    {
        Action  actions = new Action();
        String file = actions.filePath();
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            System.out.println(properties.getProperty("base_url"));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("check the properties");
        }
    }
    public void Lunch_Url(String url)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
}
