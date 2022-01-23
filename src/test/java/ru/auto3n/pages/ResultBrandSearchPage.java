package ru.auto3n.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultBrandSearchPage {
    public SelenideElement brandList = $(".offers-brands-list");
    ResultDetailSearchPage resultDetailSearchPage = new ResultDetailSearchPage();


    public ResultDetailSearchPage clickOnBrand(String value) {
        brandList.$(byText(value)).scrollTo().click();

        return resultDetailSearchPage;
    }
}
