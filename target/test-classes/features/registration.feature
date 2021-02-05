Feature: registration

Scenario Outline: user who has provided a name should be able to register

Given user is on the general store app registration page
When user enters their "<country>", "<name>", and gender 
And user clicks the let's shop button
Then user should see the products page 

Examples:
|  country	| name 		 	  |
| Burundi	    | Ronnie Wainaina |
