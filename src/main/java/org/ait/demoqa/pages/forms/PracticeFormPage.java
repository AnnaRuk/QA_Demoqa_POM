package org.ait.demoqa.pages.forms;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String ftName, String lName, String email, String phone) {
        type(firstName, ftName);
        type(lastName, lName);
        type(userEmail, email);
        type(userNumber, phone);
        return this;
    }

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(male);
        } else if (gender.equals("Female")) {
            click(female);

        } else {
            click(other);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage enterDate(String dataOfBirth) {
        clickWithJSExecutor(dateOfBirthInput, 0, 400);
        String os = System.getProperty("os.name"); ///chose your operation system
        System.out.println(os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(dataOfBirth);
        dateOfBirthInput.sendKeys(Keys.ENTER);

        return this;
    }


    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage selectSubjects(String[] subjects) {

        for (String subject : subjects) {
            typeWithJSExecutor(subjectsInput, subject, 0, 300);
            subjectsInput.sendKeys(Keys.ENTER);
        }

        return this;
    }


    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String photoPath) {
        uploadPicture.sendKeys(photoPath);
        return this;
    }


    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddress, address, 0, 500);
        return this;
    }

    @FindBy(css = ".css-1hwfws3")
    WebElement state1;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String studentsState) {
        clickWithJSExecutor(state, 0, 300);
        stateInput.sendKeys(studentsState);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;
    public PracticeFormPage selectCity(String StudentCity) {
        clickWithJSExecutor(city, 0, 300);
        cityInput.sendKeys(StudentCity);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;
    public PracticeFormPage submit() {

        driver.manage().window().setSize(new Dimension(800,600));
        clickWithRectangle(submit,2,3);

       // clickWithRectangle(submit,2,3);
        return this;
    }


    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;
    public PracticeFormPage assertSubmit(String string){
        Assert.assertTrue(isTextPresent(modalTitle, string));
        return this;

    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;


    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;


    public PracticeFormPage selectDate(String may, String year, String day) {
        clickWithJSExecutor(dateOfBirthInput, 0, 400);

        new Select(selectMonth).selectByVisibleText(may);
        new Select(selectYear).selectByVisibleText(year);
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='"+day+"']")).click();
        return this;
    }
}
