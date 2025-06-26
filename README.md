 NHSBA -Coding Challenge
-------------------------------------------------

I)Technology Used:-
	Java V21,
	Selenium
	Cucumber-User Centric BDD
	PageObjectModel
	Gherkin Language to write the scenario

II)IDE Used to develop the code-IntelliJ IDEA 2024.1.4 (Community Edition)

Instruction to load and run the project:-
------------------------------------------

1)Clone the repository in local,

	https://github.com/bkannapi/Balakrishnan-Kannapiran-NHSBSA

2) Load the project from Java supported IDE from local 

C:\Users\Administrator\Documents\Automation_GIT\Java-NHSBSA\Balakrishnan-Kannapiran-NHSBSA\src\test\java\runner

3)Please refer pom.xml file to check dependencies(Incase code run fail at your end because of dependency issue)	

4)RUN the test:-
	Select the runner from path\Balakrishnan-Kannapiran-NHSBSA\src\test\java\runner  and run runner
    you can see all test PASS, expand the result in test explorer for review.

Purpose of eatch folder,file and coding technique used explained
---------------------------------------------------------------------
5) The URL been read from the config file not hardcoded

	\IdeaProjects\NHSBSA\src\test\java\config\ConfigReader.java
	\IdeaProjects\NHSBSA\src\test\resources\config\environment.json

6)JUnit Hooks been used to handle the config
	\IdeaProjects\NHSBSA\src\test\java\hooks\Hooks.java

7) driver
\IdeaProjects\NHSBSA\src\test\java\driver\DriverManager.java

8)Features Folder
	\IdeaProjects\NHSBSA\src\test\resources\features\test.feature

9)Pages Folder
	\IdeaProjects\NHSBSA\src\test\java\pages\JobSearchPage.java

10)StepDefinitions Folder
	\IdeaProjects\NHSBSA\src\test\java\stepdefinitions\JobSearchStepDefinitions.java

11) Extent report
\IdeaProjects\NHSBSA\src\test\java\report\ExtentReportManager.java
\Balakrishnan-Kannapiran-NHSBSA\target\ExtentReport.html

12) test run pass report screenshot

\Balakrishnan-Kannapiran-NHSBSA\TestRunPassreport.PNG
    
Note:-
    1) Code reusability, page object model been implemented
	2) WebDriverWait been used, so the releavnt action on the webelement will wait until ensure element load.
	3) Extent reprot been used
	4) You can notice some warnings in the terminal window which you can ignore as it's not error
	

	Challenges faced:-
	------------------
	Visibility of the  UI element is not focused/visible
	So used javascript executer to scroll the vertical bar to see the page load fine, thereby to check test run result ok



	
	
	
	


