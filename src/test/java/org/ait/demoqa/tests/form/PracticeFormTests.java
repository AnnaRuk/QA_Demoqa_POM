package org.ait.demoqa.tests.form;

import org.ait.demoqa.data.StudentData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.forms.PracticeFormPage;
import org.ait.demoqa.tests.TestBase;
import org.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void fillStudentFormTest(){
        //enter personal data(name, lastname, email,phone)
        new PracticeFormPage(driver)
                .enterPersonalData(StudentData.FIRST_NAME,
                        StudentData.LAST_NAME,
                        StudentData.EMAIL,
                        StudentData.PHONE)
        //select gende
                .selectGender(StudentData.GENDER)
        //enter date
             .selectDate("May","2001","15") //1 variant
              //.enterDate(StudentData.DATA_OF_BIRTH) //2 variant
        //select subjects
        .selectSubjects(StudentData.SUBJECTS)
        //select hobby
        .selectHobby(StudentData.HOBBIES)
        //upload file
        .uploadFile(StudentData.PHOTO_PATH)
        //enter address
        .enterAddress(StudentData.ADDRESS)
        //select state
        .selectState(StudentData.STATE)
        //select city
        .selectCity(StudentData.CITY)

        //click on submit button
                .submit()
              .assertSubmit("Thanks for submitting the form");

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "studentDataFromCSVFile")
    public void fillStudentFormUsingDataProviderTest(String name,String lastName,String email,String phone,
                                                     String dataOfBirth,String path, String address){
        new PracticeFormPage(driver)
                .enterPersonalData(name,lastName,email,phone)
                .selectGender(StudentData.GENDER)
                .enterDate(dataOfBirth) //2 variant
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(path)
                .enterAddress(address)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit();
        // .assertSubmit("Thanks for submitting the form");

    }



}
