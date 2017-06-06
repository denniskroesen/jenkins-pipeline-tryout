package nl.jenkins.test.demo.annotation;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dennis on 6-6-17.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"})
public class AnnotationRunner {
}
