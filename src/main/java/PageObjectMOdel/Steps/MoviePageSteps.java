package PageObjectMOdel.Steps;

import PageObjectMOdel.Pages.MoviePage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoviePageSteps {

    MoviePage moviePage = new MoviePage();


    @Step
    public MoviePageSteps chooseCavea(){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();;
        js.executeScript("window.scrollBy(0,400)");
        moviePage.caveaBtn.click();
        return this;
    }
    @Step
    public MoviePageSteps checkCavea(){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        for (int i = 0; i < moviePage.options.size(); i++) {
            if (moviePage.options.get(i).getAttribute("aria-selected").equalsIgnoreCase("true"))
                System.out.println("Chosen Option : " + js.executeScript("return arguments[0].innerText;", moviePage.options.get(i)).toString());

        }
        return this;
    }

    @Step
    public MoviePageSteps chooseDateOfMovie(){
        WebElement lastDateOfMovie = moviePage.dateOfMovie.get(moviePage.dateOfMovie.size() - 1);
        lastDateOfMovie.click();
        return this;
    }

    @Step
    public MoviePageSteps chooseSeance(){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();;
        WebElement lastCaveaSeance = moviePage.caveaSeances.get(moviePage.caveaSeances.size() - 1);
        js.executeScript("arguments[0].click();", lastCaveaSeance);
        WebElement lastDateOfMovie = moviePage.dateOfMovie.get(moviePage.dateOfMovie.size() - 1);
        return this;
    }


}
