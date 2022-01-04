@authentification
Feature: Verifier authentification 
    Background: 
    Given je suis sur la page Login 

    Scenario Outline: Verifier authentification 
    When je saisi un username : "<username>" And un password : "<password>" 
    Then "<resultat>"

    Examples:
    |username|password|resultat                                       |
    |admin   |admina  |Invalid username or password.                  |
    |admin   |        |Invalid username or password.                  |
    |admin   |admin   |http://ats.faimerecruiter.com/index.php?m=home |
    
