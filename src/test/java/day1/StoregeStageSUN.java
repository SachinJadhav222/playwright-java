package day1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class StoregeStageSUN {

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
        page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");
        System.out.println(page.title());

        page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");
        page.waitForTimeout(2000);
        page.frameLocator("#sp_message_iframe_1015323").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Accept Cookies")).click();

        page.waitForTimeout(3000);

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("TestStateSUN.json")));
         page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();
    }
}
