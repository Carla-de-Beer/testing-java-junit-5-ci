package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

@Tag("model")
public class PersonRepeatedTests implements ModelRepeatedTests {

    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    @DisplayName("Repeated test")
    void repeatedTest() {

    }

    // Test dependency injection in JUnit
    @RepeatedTest(10)
    void repeatedTestWithId(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    @DisplayName("Repeated test assignment")
    void repeatedTestAssignment() {

    }
}
