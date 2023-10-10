package org.ait.demoqa.tests.BookStore;

import org.ait.demoqa.data.UserData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.BookStore.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {


    @BeforeMethod // move to login Page
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).loginPositive(UserData.USER_NAME,UserData.USER_PASSWORD)
                .verifyUserName("Anna");

    }
}
