package issueTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.exist;

public class IssuePureSelenideTest {
    private final static String REPOSITORY = "A-Prudnikova/QAG-5";
    private final static int ISSUE_NUMBER = 1;

    @Test
    void searchForIssue() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").val(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText("#" + ISSUE_NUMBER)).should(exist);
    }
}
