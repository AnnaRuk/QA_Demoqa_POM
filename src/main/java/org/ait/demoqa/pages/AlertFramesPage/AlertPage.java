package org.ait.demoqa.pages.AlertFramesPage;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement firstAlertButton;
    public AlertPage clickOnAlertButton() {
        click(firstAlertButton);
        return this;

    }

    @FindBy(xpath = "button[@id='timerAlertButton")
    WebElement secondAlertButton;
    public AlertPage clickOnTimerAlertButton() {
        click(secondAlertButton);
        return this;

    }

    @FindBy(xpath = " //button[@id='confirmButton']")
    WebElement thirdAlertButton;
    public AlertPage clickOnConfirmAlertButton() {
        click(thirdAlertButton);
        return this;

    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertPage verifySuccessResult(String text){
        Assert.assertTrue(shouldHaveText(confirmResult,text,5));
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement inputResult;

    public AlertPage verifySuccessInputResult(String text){
        Assert.assertTrue(isTextPresent(inputResult,text));
        return this;
    }


    public AlertPage acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
        }

        return this;
    }
    public AlertPage acceptAlertWithWait() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException e){

        }
        return this;
    }

    public AlertPage confirmAlert(String confirm) {
if (confirm != null && confirm.equalsIgnoreCase("Ok")){
    driver.switchTo().alert().accept();
} else if (confirm != null && confirm.equalsIgnoreCase("Cancel")){
    driver.switchTo().alert().dismiss();
}
        return this;
    }

    @FindBy(xpath = "//button[@id='promtButton']")
    WebElement promtButton;
    public AlertPage clickOnInputAlertButton() {
        clickWithJSExecutor(promtButton,0,300);
        return this;
    }

    public AlertPage inputAlert(String text) {
            if (text != null) {
                driver.switchTo().alert().sendKeys(text);
            }
        return this;
    }
}
