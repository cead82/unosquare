package steps;

import com.unosquare.test.framework.base.DriverFactory;
import com.unosquare.test.framework.config.Constants;
import com.unosquare.test.framework.utils.WaitUtil;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hook extends DriverFactory {

    @Before
    public void initialize(Scenario scenario) {
        getInstance().getDriver().navigate().to(Constants.URL);
        WaitUtil.sync();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
    }
}
