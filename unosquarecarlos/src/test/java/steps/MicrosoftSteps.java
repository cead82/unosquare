package steps;

import com.unosquare.test.framework.base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.VisualStudioPage;
import pages.WindowsPage;

import static com.unosquare.test.framework.utils.SeleniumUtils.highLight;
import static com.unosquare.test.framework.utils.SeleniumUtils.highLightTrue;

public class MicrosoftSteps extends BasePage {

    @Then("I validate all menu items are present")
    public void iValidateAllMenuItemsArePresent() {
        currentPage = getInstance(HomePage.class);
        var lnkMenus = currentPage.as(HomePage.class).getAllLinks();

        for (WebElement link:lnkMenus) {
            if (link.getText().contentEquals("Office")||link.getText().contentEquals("Windows")||link.getText().contentEquals("Surface")||
                    link.getText().contentEquals("Xbox")||link.getText().contentEquals("Deals")||link.getText().contentEquals("Support")){
                Assert.assertTrue(highLightTrue(link));
            }
        }
    }

    @When("I print all elements in Windows10 menu")
    public void iPrintAllElementsInWindowsMenu() {
        currentPage.as(HomePage.class).clickWindows();
        currentPage = getInstance(WindowsPage.class);
        currentPage.as(WindowsPage.class).clickWindowsTen();
        var lnkWin10Men = currentPage.as(WindowsPage.class).getAllWinTenLinks();
        for (WebElement element:  lnkWin10Men) {
            highLight(element);
            System.out.println(element.getText());
        }
    }

    @And("Search Visual Studio")
    public void searchVisualStudio() {
        currentPage.as(WindowsPage.class).clickSearchAction();
        currentPage.as(WindowsPage.class).setSearch("Visual Studio");
        currentPage.as(WindowsPage.class).clickSearch();
        currentPage.as(WindowsPage.class).exitModal();
    }

    @And("I choose the first item")
    public void iChooseTheFirstItem() {
        int i=0;
        currentPage = getInstance(VisualStudioPage.class);
        var allPrices = currentPage.as(VisualStudioPage.class).getAllPrices();
        for (WebElement element:  allPrices) {
            highLight(element);
            System.out.println(element.getText());
            if(i==2){
                break;
            }
            i++;
        }
    }
}
