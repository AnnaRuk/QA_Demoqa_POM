package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindow extends BasePage {
    public BrowserWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement newTabButton;

    public BrowserWindow clickOnNewTabButtonAndSwitchToNewTab(int index) {
        click(newTabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "windowButton")
    WebElement newWindowButton;

    public BrowserWindow clickOnNewWindowButtonAndSwitchToNewWindow(int index) {
        click(newWindowButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement title;
    public BrowserWindow verifyTextToNewTab(String text) {
        Assert.assertTrue(isTextPresent(title,text));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement titleNewWindow;
    public BrowserWindow verifyTextToNewWindow(String text) {
        Assert.assertTrue(isTextPresent(titleNewWindow,text));
        return this;
    }

    @FindBy(xpath = "//body[contains(.,'Knowledge')]")
    WebElement body;
    public BrowserWindow verifyNewWindowMessage(String text) {
        Assert.assertTrue(isTextPresent(body, text));
        return this;
    }

    @FindBy(id = "messageWindowButton")
    WebElement messageButton;
    public BrowserWindow clickAndSwitchToNewWindowMessage(int index) {
        clickWithJSExecutor(messageButton,0,300);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
}
