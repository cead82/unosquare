package com.unosquare.test.framework.utils;

import com.unosquare.test.framework.base.DriverFactory;
import com.unosquare.test.framework.config.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SeleniumUtils {
    public static String SSDate;
    public static String SSDateTime;
    public static String file;

    public static void highLight(WebElement element) {
        WaitUtil.waitForElementVisible(element);

        for(int i = 0; i < 3; i++)
        {
            try{
                //Creating JavaScriptExecuter Interface
                JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
                for (int iCnt = 0; iCnt < 3; iCnt++) {
                    //Execute javascript
                    try {
                        js.executeScript("arguments[0].setAttribute('style','background: yellow')", element);
                        Thread.sleep(20);
                        js.executeScript("arguments[0].setAttribute('style','background:')", element);
                    } catch (InterruptedException e) {
                        Assert.fail("Class SeleniumUtils | Method fnHighlightMe | Exception desc: Exception", e);
                    }
                }
            }catch(StaleElementReferenceException e) {
            }
        }

    }

    public static boolean highLightTrue(WebElement element) {
        WaitUtil.waitForElementVisible(element);

        for(int i = 0; i < 3; i++)
        {
            try{
                //Creating JavaScriptExecuter Interface
                JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
                for (int iCnt = 0; iCnt < 3; iCnt++) {
                    //Execute javascript
                    try {
                        js.executeScript("arguments[0].setAttribute('style','background: yellow')", element);
                        Thread.sleep(20);
                        js.executeScript("arguments[0].setAttribute('style','background:')", element);
                    } catch (InterruptedException e) {
                        Assert.fail("Class SeleniumUtils | Method fnHighlightMe | Exception desc: Exception", e);
                    }
                }
            }catch(StaleElementReferenceException e) {
                return false;
            }
        }
        return true;
    }



    public static void scrollToElement(WebElement element) {
        WaitUtil.waitForElementVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Assert.fail("Class SeleniumUtils | Method fnScrollToElement | Exception desc: Exception", e);
        }
    }
    public static String takeSnapShot() {
        SSDateTime = new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
        //file = createFolder(Constants.ScreenShots_Folder)+ "/" + SSDateTime + ".png";
        file = createFolder(Constants.SCREENSHOT_FOLDER) + "/" + SSDateTime + ".png";
        try {
            File scrFile = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(file));
        } catch (Exception e) {
            Assert.fail("Class SeleniumUtils | Method takeSnapShot | Exception desc: " + e.getMessage());
        }
        return file;
    }

    public static void refresh() {
        DriverFactory.getInstance().getDriver().navigate().refresh();
    }

    private static String createFolder(String folderName) {
        File theDir = new File(folderName);
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                new Exception("Class SeleniumUtils | Method createFolder | Exception: " + se.getMessage());
            }
            if (result) {
                System.out.println("DIR created");
            }
        }
        return theDir.toString();
    }
}
