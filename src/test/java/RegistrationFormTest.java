
import Steps.FormPageAFterSubmitStep;
import Steps.FormsPageSteps;
import Steps.MainPageSteps;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ SoftAsserts.class})
public class RegistrationFormTest {
    MainPageSteps mainPageSteps = new MainPageSteps();
    FormsPageSteps formsPageSteps = new FormsPageSteps();
    FormPageAFterSubmitStep formPageAFterSubmitStep = new FormPageAFterSubmitStep();
    @BeforeTest
    public void ConfigTests(){
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.timeout = 8;
        Configuration.assertionMode = AssertionMode.SOFT;

    }
    @Test
    public void openAndGoToForm(){
        mainPageSteps.openForm();
    }

    @Test(priority = 1)
    public void fillFormAndValidate(){
        formsPageSteps.setNameInForm().setLastNameInForm()
                .setNumberInForm().chooseGenderInFrom().submitForm();

        formPageAFterSubmitStep.validateThanksSubmitForm().validateStudentInfo();


    }


    @AfterTest
    public void Close(){
        Configuration.holdBrowserOpen = false;
    }
}
