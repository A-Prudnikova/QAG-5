package issueTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.exist;

public class IssueLambdaStepsTest {
    private final static String REPOSITORY = "A-Prudnikova/QAG-5";
    private final static int ISSUE_NUMBER = 1;

    @Test
    void searchForIssue() {
        step("Open the main page", () ->
                open("https://github.com")
        );
        step("Go to repository", () -> {
            $(".header-search-input").click();
            $(".header-search-input").val(REPOSITORY);
            $(".header-search-input").submit();
            $(By.linkText(REPOSITORY)).click();
        });
        step("Go to Issues tab", () ->
                $(withText("Issues")).click()
        );
        step("Check issue #1 exists", () ->
                $(withText("#" + ISSUE_NUMBER)).should(exist)
        );
    }
}
