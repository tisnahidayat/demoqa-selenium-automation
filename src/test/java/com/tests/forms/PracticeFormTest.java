package com.tests.forms;

import com.base.BaseTest;
import com.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testSubmitCompleteSuccessfully() {
        HomePage homePage = new HomePage(driver);
        var practiceFormPage = homePage.goToPracticeFormPage().clickPracticeForm();
        practiceFormPage.fillFullForm(
                "Tisna",
                "Hidayat",
                "tisna@example.com",
                "0812345678",
                "10 Sep 2000",
                "Computer Science",
                "src/main/resources/sample.jpg",
                "Jalan Merdeka 123",
                "NCR",
                "Delhi"
        );
        screenshot("before_create");

        practiceFormPage.submitForm();
        assertTrue(practiceFormPage.isSubmissionSuccess(), "Submission modal should appear");
        screenshot("after_create");
    }
}
