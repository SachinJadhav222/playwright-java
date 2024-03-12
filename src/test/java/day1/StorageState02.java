package day1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class StorageState02 {
    public static void main(String[] args) {
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

        page.waitForTimeout(5000);
        page.close();
        browser.close();
        playwright.close();
    }
}
