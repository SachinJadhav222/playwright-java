package day1;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;

public class Network {

        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                BrowserType chromium = playwright.chromium();
                Browser browser = chromium.launch();
                Page page = browser.newPage();
                BrowserContext context=  browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("TestStateSUN.json")));
                context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("TestStateSUN.json")));
                page.waitForTimeout(2000);
                page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
                page.onResponse(response -> System.out.println("<<" + response.status() + " " + response.url()));
                //page.navigate("https://example.com");
                page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");

                browser.close();
            }
        }

}
