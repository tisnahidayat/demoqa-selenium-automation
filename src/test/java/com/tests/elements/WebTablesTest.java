package com.tests.elements;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.elements.webtables.WebTablesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WebTablesTest extends BaseTest {

    private String generateUniqueEmail() {
        return "user_" + System.currentTimeMillis() + "@example.com";
    }

    @Test
    public void testCreateUserData() {
        HomePage homePage = new HomePage(driver);
        WebTablesPage webTablesPage = homePage.goToElementPage().clickWebTables();

        String uniqueEmail = generateUniqueEmail();

        screenshot("before_create");
        webTablesPage.createUserData("example", "example", uniqueEmail, "23", "9000", "Banking");
        screenshot("after_create");

        assertTrue(webTablesPage.isEmailPresent("alden@example.com"), "The email user not found");
    }

    @Test
    public void testEdit() {
        HomePage homePage = new HomePage(driver);
        var webTablePage = homePage.goToElementPage().clickWebTables();

        String uniqueEmail = generateUniqueEmail();

        webTablePage.createUserData("User", "Edit", uniqueEmail, "18", "500", "IT");
        webTablePage.updateUserDataByEmail(uniqueEmail, "23");
        String actual = webTablePage.getAgeByEmail(uniqueEmail);
        String expected = "23";
        assertEquals(actual, expected, "The age shown does not match");
    }

    @Test
    public void testDeleteByEmail() {
        HomePage homePage = new HomePage(driver);
        var webTablesPage = homePage.goToElementPage().clickWebTables();
        String uniqueEmail = generateUniqueEmail();

        webTablesPage.createUserData("User", "Delete", uniqueEmail, "30", "4000", "HR");
        webTablesPage.deleteByEmail(uniqueEmail);
        boolean isEmailPresent = webTablesPage.isEmailPresent(uniqueEmail);
        assertFalse(isEmailPresent, "Email still present after deletion");
    }
}
