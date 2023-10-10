package org.ait.demoqa.pages.AlertFramesPage;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedIframes() {

        //return number of iframes from main page
        System.out.println("Total numbers of iframes is " + iframes.size());
        // switch to parent iframe
        driver.switchTo().frame(frame1);
        //number from iframes from parent iframe
        System.out.println("Total numbers of iframes in the parent iframe is " + iframes.size());
        //get the text from parent iframe
        System.out.println("Iframe is" + body.getText());
        //switch to child iframe
        driver.switchTo().frame(0);
        //get the text from child iframe
        System.out.println("Iframe is " + body.getText());
        //switch to parent iframe
       // driver.switchTo().parentFrame();

        //switch to main page
        // driver.switchTo().defaultContent();

        return this;
    }
}
