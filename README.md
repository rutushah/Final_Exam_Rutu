# Final_Exam_Rutu :robot: :robot:

### Prepared By : :octocat:
- [Rutu Shah](#) :girl:

### Prepared For : :octocat:
- [Sakshi Sharma Mam](#) :girl:

### Prepared By : :octocat:
- **Web URL** https://www.saucedemo.com/

### Prerqequiesites :open_book:

- **Tools** :hammer_and_pick:
    - Java (JDK 8+)
    - IDE (Eclipse or IntellijI)
    - Selenium
    - Git
    - Maven

  
- **Technologies** :crossed_swords:
    - Java (Scripting Language)
    - Selenium (Automation Library)
    - TestNG (Test Framework)
    - Maven (Build Management Tool)
    - GitHub (Repository management)

### Setup :notebook_with_decorative_cover:

- Clone this project to your local environment

    `git clone https://github.ocom/rutushah/Final_Exam_Rutu.git`

- Open the cloned project in installed IDE.
- Wait for maven to load all the dependencies. (It may take 2-3 minutes depending on your connection)
    - If you see any error or dependencies not downloaded, run below command on project root directory via Command Prompt or Terminal.

      `mvn clean install -DskipTests=true`
### Framework Introduction :books:
- The following are the directories are defined in the framework.


| Directory        |Description           | 
| ------------- |---------------|
| testng.xml | In this file I have added the code to execute the tests. You can run this file for the test execution.      | 
| src | This is the source directory where all the test sources and classes are defined, src has a certain folder hierarchy for the test framework.|
|src/test/java/com/finalExam| This directory is test project directory where all the test cases and it's configurations are defined.In this directory CartPage class and Login class are defined which extends BrowserConfiguration class.|
|src/test/java/com/finalExam/BrowserConfigurations| This class contains all the reusable common methods for the web automation, it contains common methods like pause(which is Thread.sleep(1000)), @BeforeMethod annotation to launch browser and @AfterMethod annotation to quit browser in automation|
|src/test/java/com/framework/Login| This class contains the test case scripts for verifying PageTitle, invalidLogin and ValidLoginLogout.|
|src/test/java/com/framework/CartPage|This class contains the test case scripts for addProductoCarts, RemoveProductFromCart, Checkout and Continue Shopping|


