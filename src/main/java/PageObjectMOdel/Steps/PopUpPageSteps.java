package PageObjectMOdel.Steps;

import PageObjectMOdel.Pages.MoviePage;
import PageObjectMOdel.Pages.PopUpPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpPageSteps {

    PopUpPage popUpPage = new PopUpPage();




    public PopUpPageSteps chooseVacantPlace(){
        WebDriverWait w = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"cinema-tickets\"]/div/div/div[2]/div")));

        if(popUpPage.vacantPlaces.size() > 0)
            popUpPage.vacantPlaces.get(0).click();
        else System.out.println("Not Ticket");

        return this;
    }
}
