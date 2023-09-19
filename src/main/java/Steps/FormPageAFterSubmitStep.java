package Steps;

import Data.RegistrationFormData;
import Pages.FormPageAfterSubmit;
import Pages.FormsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class FormPageAFterSubmitStep {


    RegistrationFormData registrationFormData = new RegistrationFormData();
    FormPageAfterSubmit formPageAfterSubmit = new FormPageAfterSubmit();


    @Step
    public FormPageAFterSubmitStep validateThanksSubmitForm(){
        formPageAfterSubmit.ThanksSubmitTextItem.shouldHave(Condition.text("Thanks for submitting the form"));
        return this;
    }

    @Step
    public FormPageAFterSubmitStep validateStudentInfo(){
        formPageAfterSubmit.StudentName.shouldHave(Condition.text(registrationFormData.firstName + " " + registrationFormData.lastName));
        formPageAfterSubmit.Mobile.shouldHave(Condition.text(registrationFormData.mobileNumber));
        formPageAfterSubmit.Gender.shouldHave(Condition.text(registrationFormData.gender));
        return this;
    }
}
