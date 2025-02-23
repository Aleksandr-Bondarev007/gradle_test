package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String TITLE_TEXT = "text-box";
    private SelenideElement
            userEmail = $("#userEmail"),
            userName = $("#userName");


    public RegistrationPage openPage(){
        open("/text-box");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        userName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }
}
