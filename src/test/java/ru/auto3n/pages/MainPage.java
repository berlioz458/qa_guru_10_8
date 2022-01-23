package ru.auto3n.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    SelenideElement searchInput = $("#search1");
    // TODO: Вынести в отдельный компонент работу с окном
    SelenideElement geoMessage = $(".geo-data-rage-message");
    SelenideElement getGeoMessageCloseCross = $(".btn.big-cross");
    ResultBrandSearchPage resultBrandSearchPage = new ResultBrandSearchPage();

    public MainPage openPage() {
        open("https://auto3n.ru/");
        return this;
    }


    public ResultBrandSearchPage search(String str) {
        searchInput.setValue(str).pressEnter();

        return resultBrandSearchPage;
    }

    public MainPage closeGeoMessage() {
        getGeoMessageCloseCross.click();

        return this;
    }

    public MainPage acceptGeo() {
        return this;
    }

}
