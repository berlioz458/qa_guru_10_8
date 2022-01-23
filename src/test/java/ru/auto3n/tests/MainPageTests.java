package ru.auto3n.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import ru.auto3n.pages.MainPage;
import ru.auto3n.pages.ResultBrandSearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainPageTests {

    MainPage mainPage = new MainPage();
    ResultBrandSearchPage resultBrandSearchPage = new ResultBrandSearchPage();

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        mainPage.openPage();
    }

    @ParameterizedTest(name = "Проверка работоспособности поиска по оему {0}")
    @ValueSource(strings = {"1212", "C110", "OC47"})
    @Tag("Smoke")
    @Tag("Проценка")
    void successSearchOem(String value) {
        mainPage.search(value);
        resultBrandSearchPage.brandList.shouldHave(Condition.text(value));
    }


    @Disabled
    @Test
    @Tag("Smoke")
    void successChangeSettlement() {
    }
}
