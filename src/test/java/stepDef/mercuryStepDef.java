package stepDef;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MercuryToursLoginPage;
import pages.MercuryToursRegisterPage;
import reports.MyListner;

public class mercuryStepDef extends MyListner {
    MercuryToursLoginPage mlp;
    MercuryToursRegisterPage mrp;

    @BeforeTest
    public void beforeTest(String browserName) {
        MyListner listner = new MyListner();
        listner.onStart();
        mlp = PageFactory.initElements(driver, MercuryToursLoginPage.class);
        mrp = PageFactory.initElements(driver, MercuryToursRegisterPage.class);
    }
    @AfterTest
    public void afterTest() {
        System.out.println("in after test");
        mlp = null;
        mrp = null;
    }

    @Given("^login to mercury application$")
    public void login_to_mercury_application() throws Throwable {
        System.out.println("in test method");
        mlp.loadWebPage("http://newtours.demoaut.com");
        mlp.clickRegister();
        mrp.clickUserInfo();
        mrp.clickSignOff();
        String title = mlp.clickLogin();
        Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
        test.log(LogStatus.INFO, "the test tours is passed");
    }}
