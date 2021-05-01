package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import utilities.DriverFactory;

public class Hooks {
    private static final Logger LOGGER = Logger.getLogger(Hooks.class);
    public static String currentRunningScenario;
    public static Scenario scenario;

    @Before
    public void createDriver(Scenario scenario){
        currentRunningScenario = scenario.getName();
    }

    @After
    public void tearDown() {
        DriverFactory.close();
    }
}
