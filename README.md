# TestCrew Automation Task

This is the automation task for test crew and the project includes the below:

- STC website subscription test cases.
- OrangeHRM APIs test cases.

**Tools and libraries Used:**.
- IntelliJ (Download Community Edition):   https://www.jetbrains.com/idea/download/
- Java 17.0.6  (The project will work on higher versions normally).
- Git: https://git-scm.com/downloads.
- Maven.
- Selenium 4.
- Cucumber.
- TestNG.  
- Lombok.

**How to Run the project**
- To run the STC subscription test cases run the below command.   
  `mvn test -Dcucumber.filter.tags=@STCWeb`.

**Report**.   
After running any of the above commands you will find the run report generated in **'target/report/cucumber.html'**.

**Java Configuration**.  
To run the project on higher java versions, change the version number in the pom.xml file.

    <properties>  
    <maven.compiler.source>17</maven.compiler.source> 
    <maven.compiler.target>17</maven.compiler.target>  
    <java.version>17</java.version> 
    </properties>  

**Project Configuration**.  
You can change project configurations through src/resources/config.properties file.

- **timeout**: the configuration for the waits timeout in seconds.
- **stc-url**: the base url for STC subscription page.
- **browser-type**: specify here the browser type for running the tests ("chrome" or "edge" or "firefox".
- **headless**: set to true or false to specify if the browser should be headless or not in test running. default: false.  