package org.ait.demoqa.tests;

import org.ait.demoqa.data.UserData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.JSExecutor;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{


    @Test
    public void isExecutorTest(){
        new HomePage(driver).getFormAuthentification();
        new JSExecutor(driver).enterDataWithJSE(UserData.USER_NAME,
                UserData.USER_PASSWORD)
                .clickOnLoginButtonWithJSE()
                .checkURLWithJSE();

    }
}
