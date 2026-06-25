package com.pages.forms;

import org.openqa.selenium.*;
import java.io.File;

public class PracticeFormPage extends FormsPage {

    private By inputFirstName = By.id("firstName");
    private By inputLastName = By.id("lastName");
    private By inputEmail = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']");
    private By inputMobile = By.id("userNumber");
    private By inputDOB = By.id("dateOfBirthInput");
    private By inputSubjects = By.id("subjectsInput");
    private By hobbyReading = By.xpath("//label[text()='Reading']");
    private By hobbySports = By.xpath("//label[text()='Sports']");
    private By uploadPicture = By.id("uploadPicture");
    private By inputAddress = By.id("currentAddress");
    private By inputState = By.id("react-select-3-input");
    private By inputCity = By.id("react-select-4-input");
    private By btnSubmit = By.id("submit");
    private By successModalTitle = By.id("example-modal-sizes-title-lg");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillFullForm(String first, String last, String email, String phone, String dob,
                             String subject, String filePath, String address, String state, String city) {
        removeAdds();
        typeReact(inputFirstName, first);
        typeReact(inputLastName, last);
        typeReact(inputEmail, email);
        jsScrollingClick(genderMale);
        typeReact(inputMobile, phone);

        setDateOfBirth(dob);
        typeAndEnter(inputSubjects, subject);
        jsScrollingClick(hobbyReading);
        jsScrollingClick(hobbySports);

        uploadFile(filePath);
        type(inputAddress, address);

        selectDropdown(inputState, state);
        selectDropdown(inputCity, city);
    }

    private void setDateOfBirth(String dob) {
        jsScrollingClick(inputDOB);
        driver.findElement(inputDOB).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(inputDOB).sendKeys(dob);
        driver.findElement(inputDOB).sendKeys(Keys.ENTER);
    }

    private void typeAndEnter(By locator, String text) {
        type(locator, text);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    private void uploadFile(String path) {
        File file = new File(path);
        driver.findElement(uploadPicture).sendKeys(file.getAbsolutePath());
    }

    private void selectDropdown(By dropdownInput, String value) {
        typeAndEnter(dropdownInput, value);
    }

    public void submitForm() {
        jsScrollingClick(btnSubmit);
    }

    public boolean isSubmissionSuccess() {
        return isDisplayed(successModalTitle);
    }
}
