package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;


public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "currentAddress")
    WebElement fieldOne;

    @FindBy(id = "permanentAddress")
    WebElement fieldTwo;

    public TextBoxPage keyBoardEvent(String text) {
   typeWithJSExecutor(fieldOne,text,0,100);

   Actions action = new Actions(driver);

        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        action.sendKeys(Keys.TAB).perform();
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }



    //TODO hw

    @FindBy(css = "p.mb-1#currentAddress")
    WebElement current;
    @FindBy(css = "p.mb-1#permanentAddress")
    WebElement permanent;

    public TextBoxPage assertCopyPastText(String text) {

       String[] currentText =  current.getText().split(":");
       String[] permanentText =  permanent.getText().split(":");
        Assert.assertEquals(currentText[1],permanentText[1]);
        return this;
    }


    @FindBy(id = "submit")
    WebElement submit;
    public TextBoxPage clickToSubmitButton() {
        clickWithJSExecutor(submit,0,400);
        return this;
    }
}
