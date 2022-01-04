@createJobOrder    
Feature: Create JobOrder
	
		Scenario Outline: Create JobOrder
		Given je suis sur la page Home
		When je saisi un titre : "<titre>" And une compagny : "<company>" And une ville : "<ville>" And un pays : "<pays>" And un recruteur : "<recruiter>" And un owner : "<owner>" And un type : "<type>" And une openings : "<openings>"
		Then "<resultat>"
		
		Examples:
    |title|company|city |state |recruiter     |owner         |type    |openings|resultat         |
    |Test |tes    |Paris|France|azerty, azerty|azerty, azerty|H (Hire)|2       |PASS             |
    |     |tes    |Paris|France|azerty, azerty|azerty, azerty|H (Hire)|2       |Message erreur   |
    |Test |       |Paris|France|azerty, azerty|azerty, azerty|H (Hire)|2       |Message erreur   |
    |Test |tes    |     |France|azerty, azerty|azerty, azerty|H (Hire)|2       |Message erreur   |
    |Test |tes    |Paris|      |azerty, azerty|azerty, azerty|H (Hire)|2       |Message erreur   |
    |Test |tes    |Paris|France|              |azerty, azerty|H (Hire)|2       |Message erreur   |
    |Test |tes    |Paris|France|azerty, azerty|              |H (Hire)|2       |Message erreur   |
    |Test |tes    |Paris|France|azerty, azerty|azerty, azerty|        |2       |Message erreur   |
    |Test |tes    |Paris|France|azerty, azerty|azerty, azerty|H (Hire)|        |Message erreur   |
