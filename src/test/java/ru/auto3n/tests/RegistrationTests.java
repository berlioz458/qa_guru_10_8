package ru.auto3n.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.auto3n.pages.RegistrationPage;

import java.util.stream.Stream;

public class RegistrationTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        registrationPage.openPage();
    }

    public static Stream<Arguments> methodParams() {
        return Stream.of(
                Arguments.of("465153", "test2301@mailforspam.com", null, "Test", "1234qwqwe"),
                Arguments.of("9529470960", null, null, "Test", "123ert"),
                Arguments.of(null,null,null,null,null)
        );
    }

    @ParameterizedTest(name = "Check Error on Registration Process {index}")
    @MethodSource("methodParams")
    @Tag("Регистрация клиента")
    void errorRegistrationPage(String phone, String email, String name, String lastName, String password) {
        registrationPage
                .setPhoneInput(phone)
                .setEmailInput(email)
                .setNameInput(name)
                .setLastNameInput(lastName)
                .setPassword(password)
                .clickRegistration();

        registrationPage.errorNameMessage.shouldBe(Condition.visible);
    }
}
