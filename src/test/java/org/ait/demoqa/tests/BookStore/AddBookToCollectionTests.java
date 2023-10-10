package org.ait.demoqa.tests.BookStore;

import org.ait.demoqa.data.UserData;
import org.ait.demoqa.pages.BookStore.BookStorePage;
import org.ait.demoqa.pages.BookStore.LoginPage;
import org.ait.demoqa.pages.BookStore.ProfilePage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.print.Book;

public class AddBookToCollectionTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        //click on BookStore App
        new HomePage(driver).getBookStore();
        //click on Login button
        new BookStorePage(driver).clickOnLoginButton();
        //login
        new LoginPage(driver).loginPositive(UserData.USER_NAME,UserData.USER_PASSWORD);

    }

    @Test
    public void addBootToCollectionTest(){
        //enter book name
        //click on book name
        //click on add to your collection, accept alert
        //sidePanel -> Profile -> assert an added book
        new BookStorePage(driver).enterBookName(UserData.BOOK_NAME)
                .clickOnBookName()
                .addToCollection();
                new SidePanel(driver).selectProfile();
                new BookStorePage(driver).verifyBookName(UserData.BOOK_NAME);
    }

    @AfterMethod
    public void deleteBookFromCollection(){
        new ProfilePage(driver).deleteBook();
    }

}
