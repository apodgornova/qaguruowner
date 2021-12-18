package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import webConfig.WebDriverUtil;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // locators & elements
    private final String URL = "https://demoqa.com/automation-practice-form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            fileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $x("//*[contains(text(), 'Select State')]"),
            stateFirstOption = $("#react-select-3-option-0"),
            citySelect = $x("//*[contains(text(), 'Select City')]"),
            cityFirstOption = $("#react-select-4-option-0"),
            saveRegistrationButton = $(".btn-primary"),
            resultsTable = $(".modal-body"),
            closeModalButton = $("#closeLargeModal");

    public CalendarComponent calendar = new CalendarComponent();
    WebDriverUtil webDriver = new WebDriverUtil();

    // actions
    public RegistrationPage openPage() {
        webDriver.openMainPage();
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender(String value) {

        $x("//*[contains(text(), '" + value + "')]").click();
        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        $x("//*[contains(text(), '" + value + "')]").click();
        return this;
    }

    public RegistrationPage addPhotoFile(File file) {

        fileInput.uploadFile(file);
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setFirstState() {
        stateSelect.click();
        stateFirstOption.click();
        return this;
    }

    public RegistrationPage setFirstCity() {
        citySelect.click();
        cityFirstOption.click();
        return this;
    }

    public RegistrationPage saveRegistration() {
        saveRegistrationButton.click();
        return this;
    }

    public RegistrationPage closeModal() {
        closeModalButton.click();
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.shouldHave(text(key), text(value));
        return this;
    }

}
