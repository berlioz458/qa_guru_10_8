package ru.auto3n.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public SelenideElement getGeoMessageCloseCross = $(".btn.big-cross");


    SelenideElement phoneInput = $("[name=\"profile[phone]\"]");
    SelenideElement emailInput = $("[name=\"profile[email]\"]");
    SelenideElement nameInput = $("[name=\"profile[name]\"]");
    SelenideElement lastNameInput = $("[name=\"profile[surname]\"]");
    SelenideElement password = $("[name=\"user[password1]\"]");
    SelenideElement phisRegistrationBtn = $(".physical .registration-btn");
    public SelenideElement errorPhoneMessage = $(byText("Неверный формат телефона"));
    public SelenideElement errorNameMessage = $(byText("Введите свое имя"));

    public RegistrationPage openPage() {
        open("https://auto3n.ru/component/auto/user/registration");

        return this;
    }

    public RegistrationPage setPhoneInput(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmailInput(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setNameInput(String value) {
        nameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setPassword(String value) {
        password.setValue(value);

        return this;
    }

    public RegistrationPage clickRegistration() {
        phisRegistrationBtn.scrollTo().click();

        return this;
    }
}
