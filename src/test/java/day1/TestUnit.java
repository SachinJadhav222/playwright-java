package day1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class TestUnit {
    Playwright playwright;
    Browser browser;
    Page page;
    @Before
    public void testSetup(){
        playwright= Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                //.setChannel("msedge")
        );
        BrowserContext browserContext=browser.newContext();
       // Page page = browserContext.newPage();
        page = browserContext.newPage();
//        page.navigate("https://www.automationexercise.com/");
//        System.out.println(page.title());
    }

    @After
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
    @Test
    public void LoginTest(){

        page.navigate("https://www.automationexercise.com/");
        System.out.println(page.title());
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();
          page.locator("//input[@data-qa='login-email']").fill("sac@test.com");

        page.locator("//input[@data-qa='login-password']").fill("sac123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByText("Logged in as Sachin").isVisible(); // sac@test.com    , sac123

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Contact us")).click();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact Us")).isVisible();


    }

    @Test
    public void authStorageTest(){
        Playwright playwright= Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                //.setChannel("msedge")
        );

        BrowserContext browserContext=  browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("TestState.json")));
        Page page = browserContext.newPage();
        page.navigate("https://www.automationexercise.com/");
        page.getByText("Logged in as Sachin").isVisible();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact Us")).isVisible();

       // page.waitForTimeout(5000);
//        page.close();
//        browser.close();
//        playwright.close();
    }


    @Test
    public void shadowDomTest(){
        String url="https://selectorshub.com/iframe-in-shadow-dom/";
        //String placeHold="AriaRole.HEADING, new Page.GetByRoleOptions().setName(\"UserName\")";

        page.navigate(url);
        System.out.println(page.title());
        page.pause();
        page.getByPlaceholder("enter name").click();
        //page.getByRole(AriaRole.valueOf(placeHold)).click();
        page.frameLocator("#pact1").getByPlaceholder("Destiny").click();
        page.getByPlaceholder("enter name").click();
        page.getByPlaceholder("enter name").fill("12345");
        page.frameLocator("#pact1").getByPlaceholder("Destiny").click();
        page.frameLocator("#pact1").getByPlaceholder("Destiny").fill("test");
        page.getByPlaceholder("Enter pizza name").click();
        page.getByPlaceholder("Enter pizza name").fill("pep");
        page.locator("#concepts").click();
        page.locator("#concepts").click();
    }

    @Test
    public void selectOptions (){

        page.navigate("https://www.example.com");

        // Replace "selector" with the actual selector of your dropdown
        String dropdownSelector = "selector";

        // Get the options using JavaScript evaluation
        List<String> options = (List<String>) page.evaluate(dropdownSelector + " => Array.from(document.querySelector(" + dropdownSelector + ").options).map(option => option.value)");

        // Print the options
        for (String option : options) {
            System.out.println(option);
        }
    }
}
