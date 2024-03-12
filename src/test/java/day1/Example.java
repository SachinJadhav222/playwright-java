package day1;
//
//import com.microsoft.playwright.*;
//import com.microsoft.playwright.options.*;
//
//import java.nio.file.Paths;
//
////public class Example {
////    public static void main(String[] args) {
////        try (Playwright playwright = Playwright.create()) {
////            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
////                    .setHeadless(false));
////            BrowserContext context = browser.newContext();
////            Page page = context.newPage();
////            page.navigate("https://demoqa.com/automation-practice-form");
////          //  page.getByPlaceholder("First Name").click();
////            page.getByPlaceholder("First Name").fill("Sachin");
////         //   page.getByPlaceholder("First Name").press("Tab");
////            page.getByPlaceholder("Last Name").fill("JAD");
////         //   page.getByPlaceholder("name@example.com").click();
////            page.getByPlaceholder("name@example.com").fill("test@Test.com");
////            page.getByText("Male").nth(1).click();
////         //   page.getByPlaceholder("Mobile Number").click();
////            page.getByPlaceholder("Mobile Number").fill("1234567899");
////            page.locator("#dateOfBirthInput").click();
////            page.getByRole(AriaRole.COMBOBOX).first().selectOption("2");
////            page.getByRole(AriaRole.COMBOBOX).nth(1).selectOption("2011");
////            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Choose Tuesday, March 1st, 2011")).click();
////            page.locator(".subjects-auto-complete__value-container").click();
////            page.locator("#subjectsInput").fill("Mats");
////           // page.locator("#subjectsContainer div").filter(new Locator.LocatorOptions().setHasText("Mats")).nth(1).click();
////            page.locator("#subjectsInput").fill("Maths");
////            page.locator("#react-select-2-option-0").click();
////            page.getByText("Sports").click();
////            page.getByLabel("Select picture").click();
////            page.pause();
////            page.getByLabel("Select picture").setInputFiles(Paths.get("screen1.jpeg"));
////            page.getByPlaceholder("Current Address").click();
////            page.getByPlaceholder("Current Address").fill("Test ADDSRESS");
////            page.waitForTimeout(5000);
////           // page.close();
////           // browser.close();
////           // playwright.close();
////        }
////        //playwright.close();
////    }
////    //playwright.close();
////}
//
//
//public class Example {
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                    .setHeadless(false));
//            BrowserContext context = browser.newContext();
//            Page page = context.newPage();
//            page.navigate("https://demoqa.com/automation-practice-form");
//            page.getByPlaceholder("First Name").click();
//            page.getByPlaceholder("First Name").fill("SACHIN");
//            page.getByPlaceholder("First Name").press("Tab");
//            page.getByPlaceholder("Last Name").fill("JADHA");
//            page.getByPlaceholder("name@example.com").click();
//            page.getByPlaceholder("name@example.com").fill("Test@Gmail.com");
//            page.getByText("Male").nth(1).click();
//            page.getByPlaceholder("Mobile Number").click();
//            page.getByPlaceholder("Mobile Number").fill("1122334455");
//            page.locator("#dateOfBirthInput").click();
//            page.getByRole(AriaRole.COMBOBOX).nth(1).selectOption("2010");
//            page.getByRole(AriaRole.COMBOBOX).first().selectOption("0");
//            page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Choose Friday, January 1st, 2010")).click();
//            page.locator(".subjects-auto-complete__value-container").click();
//            page.locator("#subjectsInput").fill("maths");
//            page.locator("#react-select-2-option-0").click();
//            page.getByText("Sports").click();
//            page.getByLabel("Select picture").click();
//            page.getByLabel("Select picture").setInputFiles(Paths.get("screen1.jpeg"));
//            page.getByPlaceholder("Current Address").click();
//            page.getByPlaceholder("Current Address").fill("Test Address");
//            //page.waitForTimeout(10000);
//        }
//    }
//}

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");
            page.waitForTimeout(2000);
            page.frameLocator("#sp_message_iframe_1015323").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Accept Cookies")).click();
           // page.waitForTimeout(2000);
            System.out.println(page.title());
            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("TestStateSUN.json")));
            page.waitForTimeout(2000);
        }
    }
}
