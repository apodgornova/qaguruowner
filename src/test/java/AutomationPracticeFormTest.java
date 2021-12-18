import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class AutomationPracticeFormTest extends pages.TestBase {

    Faker faker = new Faker(new Locale("en"));
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en"), new RandomService());

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().safeEmailAddress();
    String phone = "7" + fakeValuesService.regexify("[0-9]{9}");
    String address = faker.address().streetAddress();

    RegistrationPage registrationsPage = new RegistrationPage();

    @Test
    void testDemoForm() {

        registrationsPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .chooseGender(TestData.GENDER)
                .typePhone(phone);

        registrationsPage.calendar.setDate(TestData.DAY, TestData.MONTH, TestData.YEAR);

        registrationsPage.setSubject(TestData.SUBJECT_1)
                .setSubject(TestData.SUBJECT_2)
                .setHobby(TestData.HOBBY)
                .addPhotoFile(TestData.PIC_OK)
                .typeAddress(address)
                .setFirstState()
                .setFirstCity()
                .saveRegistration();

        registrationsPage.checkResultsValue("Student name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", TestData.GENDER)
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", TestData.DAY + " " + TestData.MONTH + "," + TestData.YEAR)
                .checkResultsValue("Subjects", TestData.SUBJECT_1 + ", " + TestData.SUBJECT_2)
                .checkResultsValue("Hobbies", TestData.HOBBY)
                .checkResultsValue("Picture", TestData.FILE_NAME)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", TestData.STATE + " " + TestData.CITY);

        registrationsPage.closeModal();

    }
}
