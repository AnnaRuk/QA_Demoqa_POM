package org.ait.demoqa.pages.BookStore;

import org.ait.demoqa.pages.AlertFramesPage.AlertPage;
import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    public ProfilePage verifyUserName(String userName){
        Assert.assertTrue(shouldHaveText(user, userName, 10));
        return this;
    }

    @FindBy(id = "delete-record-undefined")
    List<WebElement> deleteButtons;
    @FindBy(id = "closeSmallModal-ok")
    WebElement modal;
    public ProfilePage deleteBook() {
    deleteButtons.get(0).click();
    click(modal);
    new AlertPage(driver).acceptAlert();
        return this;
    }


}
