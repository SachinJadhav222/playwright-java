package day1;
//import com.microsoft.playwright.*;

import com.microsoft.playwright.*;

import java.util.HashMap;
import java.util.Map;

public class AliasRequestExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Intercept requests and set an alias for a specific route
            Map<String, Route> routeAliases = new HashMap<>();
            page.route("**/scripts.webcontentassessor.com/scripts/*", route -> {
                Request request = route.request();
                System.out.println("Intercepted request: " + request.url());


                if (request.url().contains("webcontentassessor")) {
                    // Set an alias for this route
                    routeAliases.put("TNT", route);
                }

                // Continue with the intercepted request
                //route.continue_();
            });

            page.navigate("https://www.thesun.co.uk/tvandshowbiz/26332305/stephen-bear-court-georgia-harrison-sex-tape/");
          //  page.waitForTimeout(2000);

            // Access the aliased route later in your code
            Route aliasedRoute = routeAliases.get("TNT");
            if (aliasedRoute != null) {
                System.out.println(routeAliases.get("TNT"));
            }

            // Close the browser
            browser.close();
        }
    }
}
