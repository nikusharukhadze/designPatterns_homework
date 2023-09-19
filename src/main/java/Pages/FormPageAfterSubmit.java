package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormPageAfterSubmit {

    public SelenideElement ThanksSubmitTextItem = $("#example-modal-sizes-title-lg");
    public SelenideElement StudentName = $(By.xpath("//td[contains(text(), 'Student Name')]/following-sibling::td[1]"));

    public SelenideElement Mobile = $(By.xpath("//td[contains(text(), 'Mobile')]/following-sibling::td[1]"));

    public SelenideElement Gender = $(By.xpath("//td[contains(text(), 'Gender')]/following-sibling::td[1]"));

}
