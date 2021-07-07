package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasToString;


public class BookingSteps {
    private static final String BASE_URL = "https://www.booking.com/";
    private static final String SEARCH_FIELD = "ss";
    private static final String SEARCH_BUTTON = ".sb-searchbox__button";
    private static final String SHOW_PRICES_BUTTON = "//span[contains(text(),'Показать цены')]";
    private static final String HOTEL_NAME = ".sr-hotel__name";
    private static final String RATING = "//*[contains (text(),'%s')]/ancestor::*[@class='sr_property_block_main_row']//*[@class='bui-review-score__badge']";
    String city;

    @Given("User is looking for hotels in {string} city")
    public void userIsLookingForHotelsInCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open(BASE_URL);
        $(By.id(SEARCH_FIELD)).sendKeys(city);
        $(SEARCH_BUTTON).click();
    }

    @Then("Hotel {string} should be on the {string} Search results page")
    public void hotelApartmentShouldBeOnTheSearchResultsPage(String hotel, String isFirstLine) {
        if (isFirstLine.equals("")) {
            $(By.xpath(SHOW_PRICES_BUTTON)).shouldBe(Condition.visible);
            assertThat($$(HOTEL_NAME).texts(), hasItem(hotel));
        } else if (isFirstLine.equals("first line")) {
            $(By.xpath(SHOW_PRICES_BUTTON)).shouldBe(Condition.visible);
            assertThat($(HOTEL_NAME).getText(), hasToString(hotel));
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @And("Hotel {string} rating is {string}")
    public void hotelHostelUrbanRatingIs(String hotel, String rating) {
        $(By.xpath(SHOW_PRICES_BUTTON)).shouldBe(Condition.visible);
        assertThat($$(By.xpath(String.format(RATING, hotel))).texts(), hasItem(rating));
    }
}