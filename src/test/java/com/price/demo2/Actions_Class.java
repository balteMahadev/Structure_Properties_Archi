package com.price.demo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class Actions_Class implements Interface_classes
{
   public static Properties properties;
    public static  WebDriver driver;
    Validations validations = new Validations();
    @Override
    public String File_Path(String file_Name)
    {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "files" + pathSeparator + file_Name;
        String filePath = filePaths+"."+ "properties";
        return filePath;
    }
    @BeforeTest
    @Override
    public void Read_Properties()
    {
        Actions_Class actions_class = new Actions_Class();
        properties = new Properties();
        String file = actions_class.File_Path("Properties1");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            System.out.println(properties.getProperty("base_url"));
        } catch (FileNotFoundException e) {
            System.out.println("File Not found:");
        } catch (IOException e) {
            System.out.println("found null value");
        }
    }
    @Override
    public void Open_Browser(String url)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
    }

    @Override
    public void Search_Box(WebElement element,WebDriver driver)
    {
        if (validations.isElementPresent(element))
        {
            element.click();
            System.out.println("Clicked On Search box");
        }
        else
        {
            System.out.println("Element is not found please check");
        }

    }

    @Override
    public void Enter_Value_Search_Box(WebElement element, WebDriver driver, String Text) {
        if (validations.valueInTextBox(element,Text))
        {
            System.out.println("Entered "+Text+" in Search Box");
        }
        else
        {
            System.out.println("Not Entered:");
        }
    }
    @Override
    public void Products(String Products_Name, String Products_Price)
    {
        String product_name;
        String product_price;
        double least;

        List<WebElement> products_list = driver.findElements(By.xpath(Products_Name));
        List<WebElement> products_price = driver.findElements(By.xpath(Products_Price));

        Map<Double, String> productPrice = new LinkedHashMap<>();
        for (int count =0;count< products_list.size();count++){
            product_name = products_list.get(count).getText();
            product_price = products_price.get(count).getText();
            product_price= product_price.replaceAll("[^0-9.]","");
            least = Double.parseDouble(product_price);
            productPrice.put(least,product_name);
        }
        Set<Double> set = productPrice.keySet();
        ArrayList<Double> list = new ArrayList<>(set);
        Collections.sort(list);
        Double low_price = list.get(0);
        System.out.println(productPrice.get(low_price));
        System.out.println(low_price);
    }
    public void Close_Browser(WebDriver driver)
    {
        driver.quit();
    }
}
