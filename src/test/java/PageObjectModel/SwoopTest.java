package PageObjectModel;

import PageObjectMOdel.Pages.MainPage;
import PageObjectMOdel.Pages.MoviePage;
import PageObjectMOdel.Pages.PopUpPage;
import PageObjectMOdel.Steps.EventsPageSteps;
import PageObjectMOdel.Steps.MainPageSteps;
import PageObjectMOdel.Steps.MoviePageSteps;
import PageObjectMOdel.Steps.PopUpPageSteps;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Swoop Tests")
@Feature("Swoop Movie Seance Tests")
public class SwoopTest {

    EventsPageSteps eventsPageSteps = new EventsPageSteps();

    MainPageSteps mainPageSteps = new MainPageSteps();

    MoviePageSteps moviePageSteps = new MoviePageSteps();

    PopUpPageSteps popUpPageSteps = new PopUpPageSteps();

    MoviePage moviePage = new MoviePage();
    PopUpPage popUpPage = new PopUpPage();

    @BeforeTest
    public void ConfigTests(){
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = true;
        Configuration.timeout = 8;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));


    }

    @Test(description = "validate actual values of MoviePage To PopUpaPage expected values")
    @Description("Open Swoop Site And Choose Seance Of Movie")
    @Severity(SeverityLevel.NORMAL)
    @Story("Valid Values Of Swoop Test")
    public void openAndGoToMovie() {
        mainPageSteps.goToMovie();
        eventsPageSteps.chooseCinema();
        moviePageSteps.chooseCavea().checkCavea().chooseDateOfMovie().chooseSeance();
        popUpPageSteps.chooseVacantPlace();


    }

    @Test(priority = 1,description = "validate actual values of MoviePage To PopUpaPage expected values")
    @Description("validate actual values of MoviePage To PopUpaPage expected values ")
    @Severity(SeverityLevel.CRITICAL)
    public void validateSeanceInfo() {


        WebElement lastCaveaSeance = moviePage.caveaSeances.get(moviePage.caveaSeances.size() - 1);
        WebElement lastDateOfMovie = moviePage.dateOfMovie.get(moviePage.dateOfMovie.size() - 1);

        String seanceDate = lastDateOfMovie.getText().split(" ")[0];
        String seanceTime = lastCaveaSeance.getText().split("\n")[0];
        String seanceDateTime = seanceDate + " " + seanceTime;
        String seanceTitle =  lastCaveaSeance.getText().split("\n")[1];
        String seanceMovieName = WebDriverRunner.getWebDriver().findElement(By.xpath("//div[@class='info']/p[@class='name']")).getText();

        String popUMovie =  popUpPage.movieSeanceTitle.getText();
        String popUpTitle = popUpPage.seanceTitle.getText();
        String[] popUpDateTimeArr = popUpPage.seanceDateTime.getText().split(" ");
        String popUpDateTime = popUpDateTimeArr[0] + " " + popUpDateTimeArr[2];

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(seanceDateTime,popUpDateTime);
        softAssert.assertEquals(seanceTitle,popUpTitle);
        softAssert.assertEquals(seanceMovieName,popUMovie);
        softAssert.assertAll();

    }

    @AfterTest
    public void close(){
        Configuration.holdBrowserOpen = false;
    }


}
