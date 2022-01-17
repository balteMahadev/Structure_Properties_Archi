package com.price.demo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Interface_classes
{
    public String File_Path(String file_Name);
    public void Read_Properties();
    public void Open_Browser(String url);
    public void Search_Box(WebElement element, WebDriver driver);
    public void Enter_Value_Search_Box(WebElement element, WebDriver driver,String Text);
    public void Products(String Products_Name,String Products_Price);
    public void Close_Browser(WebDriver driver);


}
