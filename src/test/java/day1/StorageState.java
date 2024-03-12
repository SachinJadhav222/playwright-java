package day1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageState {

    public static void main(String[] args) {
        Playwright playwright= Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                .setChannel("chrome")
                //.setChannel("msedge")
        );
        BrowserContext browserContext=browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://www.automationexercise.com/");
        System.out.println(page.title());

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();
       // page.locator("form").filter(new Locator.LocatorOptions().setHasText("Login")).getByPlaceholder("Email Address").click();
       // page.locator("form").filter(new Locator.LocatorOptions().setHasText("Login")).getByPlaceholder("Email Address").fill("sac@test.com");
       // page.pause();
        //page.getByPlaceholder("Email Address").fill("sac@test.com");
        page.locator("//input[@data-qa='login-email']").fill("sac@test.com");
       // page.getByPlaceholder("Password").click();
       // page.getByPlaceholder("Password").fill("sac123");
        page.locator("//input[@data-qa='login-password']").fill("sac123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByText("Logged in as Sachin").isVisible(); // sac@test.com    , sac123

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Contact us")).click();
        page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact Us")).isVisible();


        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("TestState.json")));
        // page.waitForTimeout(5000);
        page.close();
        browser.close();
        playwright.close();
    }
}
