import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTest extends TestBase{

  @BeforeAll
  static void beforeAll(){
    Configuration.browserSize = "1920x1080";
    Configuration.browser = "firefox";
  }

    @Test
      void fillFormTest (){
        String userName = "Alex";
      registrationPage.openPage()
              .setFirstName(userName)
              .setUserEmail("sfdsf@fgdfg.fsdg");

        $(".text-center").shouldBe(visible);
        $("#currentAddress").setValue("penyazkova");
        $("#permanentAddress").setValue("fkdsjfsd");
        $("#submit").click();

        $("#output").shouldBe(visible);
    }
}
