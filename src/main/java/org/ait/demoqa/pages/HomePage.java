package org.ait.demoqa.pages;

import org.ait.demoqa.pages.AlertFramesPage.AlertPage;
import org.ait.demoqa.pages.BrowserPage.BrowserWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore(){
        clickWithJSExecutor(bookStore,0,300);

        return new SidePanel(driver);
    }




    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement formLink;
    public JSExecutor getFormAuthentification() {
        click(formLink);
        return new JSExecutor(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertLink;

    @FindBy(css = ".show #item-1")
    WebElement alertButton;

    public AlertPage getAlertFrameWindow() {
        clickWithJSExecutor(alertLink,0,300);
        clickWithJSExecutor(alertButton,0,300);
        return new AlertPage(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertLink2;
    public SidePanel getAlertFrameWindow2() {
        clickWithJSExecutor(alertLink2,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css = ".show #item-0")
    WebElement browserWindowButton;
    public BrowserWindow getBrowserWindow() {
        clickWithJSExecutor(alertLink,0,300);
        clickWithJSExecutor(browserWindowButton,0,300);
        return new BrowserWindow(driver);
    }
    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
     clickWithJSExecutor(widgets,0,200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,200);
        return new SidePanel(driver);
    }

    @FindBy(css = ".top-card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,200);
        return new SidePanel(driver);
    }
}
