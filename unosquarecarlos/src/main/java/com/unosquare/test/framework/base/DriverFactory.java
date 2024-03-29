package com.unosquare.test.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    // Thread local driver object for webdriver
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    /**
     * Method to get the driver object and launch the browser
     * @return
     */
    public WebDriver getDriver(){
        return driver.get();
    }

    /**
     * Method to set the driver object and select the browser
     * @param browser
     * @return
     */
    public WebDriver setDriver(BrowserType browser) {
        String getOS = System.getProperty("os.name").toLowerCase();

        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.get();
    }

    /**
     * Method to quits the driver and closes the browser
     */
    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
