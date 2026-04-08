package Cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\Cucumber",glue="Cucumbercode",monochrome=true,tags="@Additem",
plugin={"pretty", "html:target/cucu.html"})
public class Testngrunner extends AbstractTestNGCucumberTests{


}
