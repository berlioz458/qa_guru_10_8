package ru.auto3n.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.auto3n.pages.ResultBrandSearchPage;
import ru.auto3n.pages.ResultDetailSearchPage;

import static com.codeborne.selenide.Selenide.open;

public class ResultSearchTests {
    ResultBrandSearchPage resultBrandSearchPage = new ResultBrandSearchPage();
    ResultDetailSearchPage resultDetailSearchPage = new ResultDetailSearchPage();

    @ParameterizedTest
    @CsvSource(value = {
            "AIRTEX;Насос системы охлаждения (помпа)",
            "CEVAM;Комплект пылника, приводной вал",
            "NGK;Свеча зажигания, NGK, 1212"
    },delimiter = ';')
    void successDetailSearch(String brand, String result) {
        open("https://auto3n.ru/offer?keyword=1212");
        resultBrandSearchPage
                .clickOnBrand(brand)
                .title
                .shouldHave(Condition.text(result));
    }
}
