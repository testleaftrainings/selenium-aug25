@Leads
Feature: The module is Lead which is used to create, edit, delete the lead and also to convert the lead as opportunity

@Create
Scenario: Create the lead with only mandatory field

Given Login into the Leaftaps application using username as "demosalesmanager" and password as "crmsfa"
When Click on the CRMSFA
And Click on the Leads tab
And Click on the Create Lead link
Given Enter the Company name as "Qeagle"
And Enter the First name as "Gokul"
And Enter the Last name as "Sekar"
When Click on the submit button for create
Then Validate the Lead ID.


@Edit
Scenario: Edit the existing created lead with phonenumber
Given Login into the Leaftaps application using username as "demosalesmanager" and password as "crmsfa"
When Click on the CRMSFA
And Click on the Leads tab
And Click on the Find Lead link
Given Search for the existing lead with phone number
When Click on the first result for the searched phone number
And Click on the Edit button for lead
Given Update the existing company name
When Click on the submit button for edit Lead



@CreateMulti
Scenario Outline: Create the multiple lead with only mandatory field

Given Login into the Leaftaps application using username as "demosalesmanager" and password as "crmsfa"
When Click on the CRMSFA
And Click on the Leads tab
And Click on the Create Lead link
Given Enter the Company name as <companyName>
And Enter the First name as <firstName>
And Enter the Last name as <lastName>
When Click on the submit button for create
Then Validate the Lead ID.


	Examples:
	|firstName|companyName|lastName|
	|"Gokul"|"Qeagle"|"Sekar"|
	|"Babu"|"Qeagle"|"M"|
	|"Hari"|"Testleaf"|"R"|
	
	
#	Examples:
#	|firstName|companyName|lastName|
#	|"Hari"|"Testleaf"|"R"|
#	|"Babu"|"Testleaf"|"M"|
