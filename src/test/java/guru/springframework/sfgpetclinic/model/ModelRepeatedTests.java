package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running test: " + testInfo.getDisplayName() + ": " + repetitionInfo.getTotalRepetitions() +
                " of " + repetitionInfo.getTotalRepetitions());
    }
}
