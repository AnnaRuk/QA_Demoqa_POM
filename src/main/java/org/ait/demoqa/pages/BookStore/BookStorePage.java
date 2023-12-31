package org.ait.demoqa.pages.BookStore;

import org.ait.demoqa.pages.AlertFramesPage.AlertPage;
import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage enterBookName(String book) {
        type(searchBox, book);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement bookName;

    public BookStorePage verifyBookName(String book) {
        Assert.assertTrue(bookName.getText().contains(book));
        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public BookStorePage clickOnBookName() {
        clickWithJSExecutor(bookName,0,300);
        return this;
    }


    @FindBy(css = ".text-right.fullButton")
    WebElement addButton;
    public BookStorePage addToCollection() {
      clickWithJSExecutor(addButton,0,500);
        new AlertPage(driver).acceptAlert();
        return this;
    }

}


