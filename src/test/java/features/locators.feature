Feature: Login functionality

@locatorspage
Scenario Outline: Login test
  Given user landed on locators practice page
  When user enters "<username>" as username
  And user enters "<password>" as password
  And click on sign in button
  Then verify user is able to sign in successfully or not

Examples:
  | username | password |
  | rahul    | rahul123 |
  
 @locatorspage2
Scenario Outline: Login test
  Given user landed on locators practice page
  When user clicks on forgot password link
  And user enters "<name>" as name
  And user enters "<Email>" as Email
  And user enters "<number>" as phone number
  And user clicks on reset login button
  And user gets the password text
  And user clicks on got ot Login button
  When user enters "<username>" as valid username
  And user enters password as extracted password
  And user checks check boxes and get text
  And click on sign in button
  Then verify user is able to sign in successfully with valid credentials
  

Examples:
 | name    | Email                   | number     | username |
| Neelima | neelutgd507@gmail.com | 9962278011 | Neelima  | 