package Steps;
import Data.RegistrationFormData;
import Pages.FormPageAfterSubmit;
import Pages.FormsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FormsPageSteps {

    FormsPage formsPage = new FormsPage();
    RegistrationFormData registrationFormData = new RegistrationFormData();

    @Step
    public FormsPageSteps setNameInForm(){
        formsPage.FirstNameItem.setValue(registrationFormData.firstName);
        return this;
    }

    @Step
    public FormsPageSteps setLastNameInForm(){
        formsPage.LastNameItem.setValue(registrationFormData.lastName);
        return this;
    }

    @Step
    public FormsPageSteps setNumberInForm(){
        formsPage.NumberItem.setValue(registrationFormData.mobileNumber);
        return this;
    }

    @Step
    public FormsPageSteps chooseGenderInFrom(){
        for (int i = 0; i <formsPage.genderCollItem.size() ; i++) {
            if(formsPage.genderCollItem.get(i).getText().equalsIgnoreCase(registrationFormData.gender)) formsPage.genderCollItem.get(i).click();
        }

        return this;
    }

    @Step
    public FormsPageSteps submitForm(){
      formsPage.FormItem.submit();
      return this;
    }


}
