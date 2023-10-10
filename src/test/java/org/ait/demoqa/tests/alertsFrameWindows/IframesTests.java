package org.ait.demoqa.tests.alertsFrameWindows;

import org.ait.demoqa.pages.AlertFramesPage.NestedFramesPage;
import org.ait.demoqa.pages.AlertFramesPage.FramePage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertFrameWindow2();
    }

    @Test
    public void iframesTest(){  /// bad way because index is dynamic parameter. Ad is allways changing
        new SidePanel(driver).selectFrame();
        new FramePage(driver).returnListOfFrames().switchToIframeByIndex(2);

    }

    @Test
    public void switchToIframesByIdTest(){
        new SidePanel(driver).selectFrame();
        new FramePage(driver).switchToIframeById();


    }

    @Test
    public void handleNestedIframeTest(){
        new SidePanel(driver).selectNestedFrames();
        new NestedFramesPage(driver).handleNestedIframes();
    }

}
