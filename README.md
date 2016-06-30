    
�We can run before and �@After for each scenario�s({ "@smoke" })

### Use Maven

Open a command prompt window navigate to the workspace location and run:

mvn -P selenium-tests clean -Dbrowser=chrome install(change the browser name for cross browser testing)

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunCukesTest`
class tells JUnit to kick off Cucumber.

### tags from command line
mvn clean -Dcucumber.options="--@tag" -Dtest= RunTest -Dbrowser=chrome install





