package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


public class BookingSteps {
    String city;

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();
    }

    @Then("Hotel {string} should be on the Search results page")
    public void hotelApartmentShouldBeOnTheSearchResultsPage(String hotel) {
        $(By.xpath("//span[contains(text(),'Show prices')]")).shouldBe(Condition.visible);
        assertThat($$(".sr-hotel__name").texts(), hasItem(hotel));
    }

    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @Then("Hotel {string} rating is {double}")
    public void hotelHostelUrbanRatingIs(int arg0, int arg1) {
    }
}
