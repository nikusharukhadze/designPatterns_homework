package PageFactory;

import PageFactory.Pages.EventsPage;
import PageFactory.Pages.MainPage;
import PageFactory.Pages.MoviePage;
import PageFactory.Pages.PopUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SwoopTest {

    WebDriver driver;
    MainPage mainPage;
    EventsPage eventsPage;
    MoviePage moviePage;
    PopUpPage popUpPage;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.swoop.ge/");
        driver.manage().window().maximize();
    }


    @Test(priority = 0)
    public void SwoopOfCinema(){
        mainPage = new MainPage(driver);
        eventsPage = new EventsPage(driver);
        moviePage = new MoviePage(driver);


        mainPage.goToCinema();
        eventsPage.chooseCinema();
        moviePage.chooseCavea().checkCavea().chooseDateOfMovie().chooseSeance();


    }

    @Test(priority = 1)
    public void validateSeanceInfo() throws InterruptedException {
        Thread.sleep(5000);
        popUpPage = new PopUpPage(driver);

        popUpPage.chooseVacantPlace();

        WebElement lastCaveaSeance = moviePage.caveaSeances.get(moviePage.caveaSeances.size() - 1);
        WebElement lastDateOfMovie = moviePage.dateOfMovie.get(moviePage.dateOfMovie.size() - 1);

        String seanceDate = lastDateOfMovie.getText().split(" ")[0];
        String seanceTime = lastCaveaSeance.getText().split("\n")[0];
        String seanceDateTime = seanceDate + " " + seanceTime;
        String seanceTitle =  lastCaveaSeance.getText().split("\n")[1];
        String seanceMovieName = driver.findElement(By.xpath("//div[@class='info']/p[@class='name']")).getText();

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
    public void pageClose(){
        driver.close();
    }
}
