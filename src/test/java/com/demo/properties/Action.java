package com.demo.properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Action {
   public static Properties properties;
   public static WebDriver driver;
    String userDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String filePaths = userDirectory + pathSeparator + "files" + pathSeparator + "Properties.";
    String filePath = filePaths + "properties";

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

    public void ValueInTextBox(WebElement element,String value)
    {
        if(isElementPresent(element))
        {
            element.clear();
            element.click();
            element.sendKeys(value);
        }
    }

    public void getProperties() {
        File file = new File(filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
            System.out.println("Yes file found:");
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Lunch_Url(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }
}
