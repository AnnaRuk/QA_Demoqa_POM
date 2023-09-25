package org.ait.demoqa.tests;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.LoginPage;
import org.ait.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{


    @BeforeMethod // move to login Page
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).loginPositive("Anna","Qwerty007!")
                .verifyUserName("Anna");

    }
}
