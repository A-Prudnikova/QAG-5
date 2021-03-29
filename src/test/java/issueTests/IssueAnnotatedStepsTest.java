package issueTests;

import org.junit.jupiter.api.Test;

public class IssueAnnotatedStepsTest {
    private WebSteps steps = new WebSteps();

    private final static String REPOSITORY = "A-Prudnikova/QAG-5";
    private final static int ISSUE_NUMBER = 1;

    @Test
    public void searchIssue() {
        steps.openMainPage();
        steps.goToRepository(REPOSITORY);
        steps.goToIssueTab();
        steps.checkIssue1exists(ISSUE_NUMBER);
    }
}
