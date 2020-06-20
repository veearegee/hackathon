 package app.pages;

import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;
@RunWith(Karate.class)
@KarateOptions(features="src/test/java/hackathon/features/ProblemStatement.feature")
//@KarateOptions(features="src/test/java/hackathon/features/update-user.feature")
//@KarateOptions(features="src/test/java/hackathon/features/update-user.feature")
public class PageRunner {
}