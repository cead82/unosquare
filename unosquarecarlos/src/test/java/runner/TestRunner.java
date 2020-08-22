package runner;

import com.unosquare.test.framework.base.BrowserType;
import com.unosquare.test.framework.base.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@CucumberOptions(features = {"src/test/java/features/"},
        glue = {"steps"},
        plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUpClass(String browser) throws MalformedURLException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
    }

    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
        DriverFactory.getInstance().removeDriver();
    }
}
