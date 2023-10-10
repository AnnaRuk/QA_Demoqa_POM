package org.ait.demoqa.pages.interactions;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
    pause(1000);
    new Actions(driver).dragAndDrop(dragMe,dropHere).perform();
        return this;
    }




    public DroppablePage assertDropped(String text) {
        Assert.assertTrue(isTextPresent(dropHere,text));
        return this;
    }

    public DroppablePage actionDragMeBy(int x, int y) {
        pause(4000);
        int xMe = dragMe.getLocation().getX();
        int yMe = dragMe.getLocation().getY();
        System.out.println("x1: " + xMe + ", y1: " + yMe);

        int xHere = dropHere.getLocation().getX();
        int yHere = dropHere.getLocation().getY();
        System.out.println("x1: " + xHere+ ", y1: " + yHere);

        xHere = (xHere - xMe) + x;
        yHere = (yHere - yMe) + y;
        System.out.println("x1: " + xHere+ ", y1: " + yHere);

        pause(1000);
        new Actions(driver).dragAndDropBy(dragMe,xHere,yHere).perform();
        return this;
    }
}
