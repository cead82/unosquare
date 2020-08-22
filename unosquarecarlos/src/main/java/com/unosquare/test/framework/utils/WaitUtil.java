package com.unosquare.test.framework.utils;

import com.unosquare.test.framework.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WaitUtil {
    private static WebDriverWait wait;
    private static String pageLoadStatus;

    public static void sync(){
        do {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
    }

    public static void waitForElementVisible(final WebElement element){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementPresence(final By element){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitForElementTextVisible(final WebElement element, String text){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilTextDisplayed(final WebElement element, String text){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final WebElement element, String text){
        return webdriver -> element.getText().contains(text);
    }

    public static void waitTime(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static void waitForElementsNumberBeMoreThan(By selector, int numberCountBefore){

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(selector, numberCountBefore));
    }

}
