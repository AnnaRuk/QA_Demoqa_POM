package org.ait.demoqa.tests.alertsFrameWindows;

import org.ait.demoqa.pages.AlertFramesPage.AlertPage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    //PRE
    //1. click  on Alerts, Frame & Windows
    //  .top-card:nth-child(3)
    //2. click on Alerts
    //  .show #item-1

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertFrameWindow();
    }

    //TESTS
//3. first AlertButton   //button[@id='alertButton']
    //test = alert window "ok"
    @Test
    public void acceptAlert(){
        new AlertPage(driver).clickOnAlertButton()
                .acceptAlert();
    }
    //second AlertButton   //button[@id='timerAlertButton']
    //test = alert window "ok" with waiting 5 sek

    @Test
    public void acceptTimerAlert(){
        new AlertPage(driver).clickOnTimerAlertButton()
                .acceptAlertWithWait();
    }
    //third AlertButton   //button[@id='confirmButton']

    //test = alert window "ok" and text "You selected Ok" is present
    @Test
    public void acceptConfirmAlert(){
        new AlertPage(driver).clickOnConfirmAlertButton()
                .confirmAlert("Ok")
                .verifySuccessResult("You selected Ok");
    }

    //forth AlertButton   //button[@id='promtButton']
//test = alert window text "Anna",  "ok" and text "You entered Anna" is present
    @Test
    public void acceptInputAlert(){
        new AlertPage(driver).clickOnInputAlertButton()
                .inputAlert("Anna")
                .acceptAlert()
                .verifySuccessInputResult("You entered Anna");
    }








}
