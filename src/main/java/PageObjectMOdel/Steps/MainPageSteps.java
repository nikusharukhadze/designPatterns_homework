package PageObjectMOdel.Steps;

import PageObjectMOdel.Pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {
        MainPage mainPage = new MainPage();

        public MainPageSteps goToMovie(){
            open("https://www.swoop.ge/");
            mainPage.cinema.click();
            return this;
        }
    }

