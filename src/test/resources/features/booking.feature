Feature: Search on Booking.com

  Scenario: Search by city
    Given User is looking for hotels in "Minsk" city
    When User does search
    Then Hotel "Hostel Urban" should be on the "" Search results page
    And Hotel "Hostel Urban" rating is "9,2"

  Scenario Outline: Search by all city
    Given User is looking for hotels in "<City>" city
    When User does search
    Then Hotel "<HotelName>" should be on the "first line" Search results page
    And Hotel "<HotelName>" rating is "<Rating>"

    Examples:
      | City  | HotelName               | Rating |
      | Minsk | Hostel Urban            | 9,2    |
      | Brest | Brest Central Apartment | 9,6    |
      | Gomel | APARTMENT 12 LENINA     | 9,9    |
