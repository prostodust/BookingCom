Feature: Search on Booking.com

  Scenario: Search by city
    Given User is looking for hotels in "Minsk" city
    When User does search
    Then Hotel 'Hostel Urban' should be on the Search results page
    #To implement this step:
    #Then Hotel 'Hostel Urban' rating is 9.4

  Scenario Outline: Search by city
    Given User is looking for hotels in "<City>" city
    When User does search
    Then Hotel '<HotelName>' should be on the "first line" Search results page
    Then Hotel '<HotelName>' should be on the first line of the Search results page
    #To implement this step:
    #Then Hotel 'Hostel Urban' rating is 9.4

    Examples:
      | City  | HotelName               |
      | Minsk | Hostel Urban            |
      | Brest | Hampton by Hilton Brest |
      | Gomel | AMAKS Vizit Hotel       |

  Scenario Outline: Search by city
    Given User is looking for hotels in "<City>" city
    When User does search
    Then Hotel '<HotelName>' should be on the "first line" Search results page
    Then Hotel '<HotelName>' should be on the first line of the Search results page
    #To implement this step:
    Then Hotel 'Hostel Urban' rating is 9.4

    Examples:
      | City  | HotelName               |
      | Minsk | Hostel Urban            |
      | Brest | Hampton by Hilton Brest |
      | Gomel | AMAKS Vizit Hotel       |