package org.ait.demoqa.tests;

import org.ait.demoqa.pages.BrowserWindow;
import org.ait.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBrowserWindow();
    }


    @Test
    public void browserWindowNewTabTest(){
        new BrowserWindow(driver).clickOnNewTabButtonAndSwitchToNewTab(1)
                .verifyTextToNewTab("This is a sample page");
    }

    @Test
    public void browserWindowNewWindowTest(){
        new BrowserWindow(driver).clickOnNewWindowButtonAndSwitchToNewWindow(1)
                .verifyTextToNewWindow("This is a sample page");
    }

/*
    @Test
    public void browserWindowNewWindowMessageTest(){
        new BrowserWindow(driver).clickAndSwitchToNewWindowMessage(1)
                .verifyNewWindowMessage("Knowledge");
    }

 */
}
