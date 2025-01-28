import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
        /*
        Тест авторизации
         */

        @Test
        void successfulLoginTest(){
                Configuration.holdBrowserOpen = false;
                Configuration.browser = "firefox";
                Configuration.browserSize = "1920x1080";

                open("https://candy-home.ru/");
                $(".header__func-item.header__user.js-tingle-modal").shouldHave(text("Войти"));
                $(".header__func-item.header__user.js-tingle-modal").click();
//                switchTo().window(0);
                $(".auth__tabs-button.js-focus-visible.js-tab is-active").shouldHave(text("Вход"));


//                $("[name=email]").setValue("qaqurubot@gmai.com");
//                $("[name=password]").setValue("qaqurupassword").pressEnter();

        }

        @Test
        void unsuccessfulLoginTest(){
                open("https://alfabank.ru/");
                $(byText("Вклады")).click();
                $(byText("Вклады")).click();
                $$(byText("Сервисы для накоплений")).find(visible).click();
                $(".aR7Oy1.ER7Oy1.KR7Oy1.YR7Oy1.nQWkTE.aaQWkTE").shouldHave(text("Бесплатные сервисы для накоплений"));

        }
        @Test
        void testTesr(){
                open("https://haieronline.ru/");
                $(".menu__link.js-menu-link.menu__link--parent.js-sublist-trigger").click();
                $$(byText("Гарантия")).find(visible).click(); //клик в дроп даун меню
                $(".buyers-data__caption ").shouldHave(text("Гарантия на технику Haier"));
                $(".search__input.js-search-input").click();
                $$(".search__item-caption.js-search-item-text").find(visible).click();
                $(".u-warranty-block__title").shouldHave(text("Телевизоры"));
        }

        @Test
        void catalog(){
                open("https://haieronline.ru/");
                $(".header__catalog.js-dropdown-trigger-inside").click();
                //actions().moveToElement()
                $(byText("Малая бытовая техника")).hover(); //клик в дроп даун меню
                $$(byText("Соковыжималки")).find(visible).click(); //клик в дроп даун меню
                $(".top__title").shouldHave(text("Соковыжималки Haier"));
                $(".switch__label.js-filter-switcher-label").click();
//                $$(".catalog__count-number js-catalog-count-number").find(visible).click();
                $(".catalog__count-number.js-catalog-count-number").shouldHave(text("1"));
        }

        @Test
        void githubTest() {
                open("https://github.com/search?q=selenide");
//                $("[placeholder=Search or jump to...]").setValue("selenide").pressEnter();
//                $(byXpath("/html/body/div[1]/div[3]/header/div/div[2]/div/div/qbsearch-input")).setValue("selenide").pressEnter();
                $$("div .Box-sc-g0xbh4-0.iwUbcA").first().$("a").click(); //клик на первую ссылку из списка
//                $$("div .Box-sc-g0xbh4-0").get(3).$("a").click(); //клик на четвертую
                $("#repository-container-header").shouldHave(text("selenide / selenide"));

        }

        @Test
        void githubTestBestAttributor() {
                // открыть страницу селенида
                open("https://github.com/selenide/selenide");
                // навести мышку на первого человека
                $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                        .$$("ul li").get(3).hover();
                // проверить текст
                sleep(5000);
                $$(".Popover").findBy(visible).shouldHave(text("rosolko"));

        }
}
