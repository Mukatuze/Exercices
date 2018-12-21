/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moniqueproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class MoniqueProjectBK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This  is the location of webdriver path
        System.getProperty("webdriver.gecko.driver","C:\\Program Files\\selenium-server-standalone\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Actions action=new Actions(driver);
        //This is BK website (URL)
        driver.get("https://www.bk.rw");
        WebElement currentSaving, link;
        //link which open homepage
        driver.findElement(By.xpath("//a[@href='https://www.bk.rw/personal']")).click();
        //First click"Current & Saving"
        currentSaving=driver.findElement(By.linkText("CURRENT & SAVINGS"));
        action.moveToElement(currentSaving).perform();
        driver.findElement(By.xpath("//*[@id=\"nav\"]/div/div/div[2]/ul[1]/li[2]/a")).click();
                 
        //Click on special saving under open open account section
       link=driver.findElement(By.xpath("//a[@href ='https://www.bk.rw/personal/checking-saving/special-saving']"));
        action.moveToElement(link).perform();
        link.click();
        
        //Click online banking  under current and savings menu
        driver.findElement(By.xpath("//a[@href='https://www.bk.rw/ways-of-banking/online-banking']")).click();
        
        //Click  on apply now under  onlie banking  current
        driver.findElement(By.xpath("//a[@href='https://www.bk.rw/online-services/apply-for-online-banking']")).click();
        
        //View on USD foreign exchange rate        
        Float buyingPrice=Float.parseFloat(driver.findElement(By.xpath("/html/body/footer/div[1]/div[4]/div/table/tbody/tr[2]/td[2]")).getText());
        Float sellingPrice=Float.parseFloat(driver.findElement(By.xpath("/html/body/footer/div[1]/div[4]/div/table/tbody/tr[2]/td[3]")).getText());
       
        if((sellingPrice>=800) && (sellingPrice>buyingPrice)){
            System.out.println("Rates is ok");
            System.out.println("Buying price is:" +buyingPrice);
            System.out.println("Selling price is :" +sellingPrice);
            
        }else{
                        System.out.println("Rates not ok");

        }
        driver.quit();
           
    }
    
}
    
    
