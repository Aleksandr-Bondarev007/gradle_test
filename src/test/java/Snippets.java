import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    // элементы управления браузером, самы основные


    @Test
    void browserComandExamples() {
        Configuration.baseUrl = "https://haieronline.ru/";
        open("https://haieronline.ru/");
        open("/terms/trade-in/");
        // авторизация как у нас на сайте
        open("/", AuthenticationType.BASIC,new BasicAuthCredentials("",""));

        // кнопка назад
        Selenide.back();
        // обновить страницу
        Selenide.refresh();
        // очистка КУК
        Selenide.clearBrowserCookies();
        // очистка ЛС
        Selenide.clearBrowserLocalStorage();
        // очистка сесшн сторедж
        executeJavaScript("sessionStorage.clear();");

        // всплываение окон с ОК как в ГП
        Selenide.confirm();
        Selenide.dismiss();

        // закрытие текущего окна
        Selenide.closeWindow();
        Selenide.closeWebDriver();

        // страничка в страничке
        Selenide.switchTo().frame("new");
        // вернутся с фрейма на главную страничу
        Selenide.switchTo().defaultContent();

        Selenide.switchTo().window("The Internet");

        // установить куки на страницу
        open("https://haieronline.ru/");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("new", "cuci"));
        WebDriverRunner.getWebDriver().manage().deleteCookie(new Cookie("new", "cuci"));//удалить куку конкретную
        open("/terms/trade-in/");

    }

    @Test
    void selectorsExamples() {
        $("div").click();
        element("div").click();

        // четвертый элемент
        $("div", 3).click();

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("asd")).click();
        $(withTagAndText("div", "asd")).click();

        $("").parent(); // родитель
        $("").sibling(1); // вниз
        $("").preceding(1); // вверх
        $("").closest("div"); // вверх на уровень
        $("").ancestor(""); // вниз на уровень

        $("div:last-child"); // последний ребенок в диве

        $("div").$("h1").find(byText("ads")).click();

        $(byAttribute("asdf","ads")).click();
        $("[abc=x]").click(); // коротко

        $(byId("id")).click();
        $("#id").click(); // коротко

        $(byClassName("sdf")).click();
        $(".reg").click(); // коротко
    }

    @Test
    void actionsExamples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick(); // правая кнопка

        $("").hover(); // поднести мышь но не кликать

        $("").setValue("asd"); // удалится и напишет
        $("").append("aasd"); // напишет в конец
        $("").clear();
        $("").setValue(""); // clear

        $("div").sendKeys("c"); // hotkey c on element
        actions().sendKeys("c").perform(); //
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); // Ctrl + F

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        // drag and drop
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // dropdown
        $("").selectOption("dropdown_option"); // дропдаун по тексту выбрать
        $("").selectRadio("radio_option");

    }

    @Test
    void assertionsExamples() {
        // стандартный таймаут 4 секунды
        $("").shouldBe(visible);
        $("").shouldNot(visible);
        $("").shouldHave(text("dfsdf"));
        $("").shouldNotHave(text("sdfsgd"));
        $("").should(appear);
        $("").shouldNot(appear);

        // longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30));
    }

    @Test
    void conditionsExamples() {
        $("").shouldBe(visible); // видно
        $("").shouldBe(hidden); // скрыто

        $("").shouldHave(text("sdf")); //просто текст
        $("").shouldHave(exactText("sdf")); // точный текст
        $("").shouldHave(textCaseSensitive("dsfg"));
        $("").shouldHave(exactTextCaseSensitive("sdf"));
        $("").should(matchText("[0-9]asd$")); // сложный текст, по кол-ву букв и части слова

        $("").shouldHave(cssClass("class_name"));// проверяет что хотябы один класс есть
        $("").shouldHave(cssClass("class_name"),cssClass("m-15class_name"));// проверяет что два класса есть
        $("").shouldHave(cssValue("font-size", "22")); //свойства элемента пропертис color cursor и тд
        $("").shouldHave(cssValue("cursor", "pointer")); //форма курсора

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disable"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name","[0-9]asdf$"));

        $("").shouldBe(checked); // for checkboxes включен
        $("").shouldNotBe(checked); // for checkboxes выключен

        $("").should(exist); // элемент есть!
        $("").shouldBe(disabled); //
        $("").shouldBe(enabled); //
    }

    @Test
    void collectionsExamples() {
        $$("div"); // ничего

        $$x("//div"); // by xpath

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        elements("div").first().click();

        $$("div").last().click();
        $$("div").get(2).click();
        $("div", 1).click();
        $$("div").findBy(text("123")).click();

        $$("div").shouldHave(size(0));
        $$("div").shouldBe(CollectionCondition.empty);

        $$("div").shouldHave(texts("a","b","c"));// по порядку
        $$("div").shouldHave(exactTexts("a","b","c"));// точный

        $$("div").shouldHave(textsInAnyOrder("b","c","a")); // порядок не важдный
        $$("div").shouldHave(exactTextsCaseSensitiveInAnyOrder("b","c","a")); // вот так с учетом решистра

        $$("div").shouldHave(itemWithText("gamma")); // неважно в каком тексте

        $$("div").shouldHave(sizeGreaterThan(0)); // больше нуля объектов в коллекции
        $$("div").shouldHave(sizeGreaterThanOrEqual(1)); // больше или равно
        $$("div").shouldHave(sizeLessThan(3));
        $$("div").shouldHave(sizeGreaterThanOrEqual(2));
        $$("div").shouldHave();
    }

    @Test
    void fileOperationsExamples() {
        File file1 = $("a.fileLink").download(); // простой линк
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // работает всегда

        File file = new File("src/test/resources/readMe.txt"); // указать путь
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readMe.txt"); // сразу из ресурса
        // dont forget submit
        $("uploadButton").click();

    }

    @Test
    void javaScriptExamples() {
        executeJavaScript("alert(selenide)"); // запуск любой команды джава скрипта
        executeJavaScript("alert(arguments[0]*arguments[1]);",6.7); // пример работы с аргументами
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];",6,7); // вычесляет
    }
}
