package PageObjectMOdel.Steps;

import PageObjectMOdel.Pages.EventsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.actions;

public class EventsPageSteps {
    EventsPage eventsPage = new EventsPage();

    @Step
    public EventsPageSteps chooseCinema(){
        eventsPage.movieHoverBtn.click();

        return this;
    }
}
