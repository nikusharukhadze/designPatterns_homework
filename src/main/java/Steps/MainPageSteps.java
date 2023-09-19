package Steps;
import Pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;


public class MainPageSteps {

    MainPage mainPage = new MainPage();


    @Step
    public MainPageSteps openForm(){

        open("https://demoqa.com");
        mainPage.cardItem.click();
        mainPage.practiceFormBtnItem.click();
        return  this;
    }
}
