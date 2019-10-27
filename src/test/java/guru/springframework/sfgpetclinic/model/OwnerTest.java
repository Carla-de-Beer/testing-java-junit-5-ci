package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");
        assertAll("Properties test",
                () -> {
                    assertAll("Person properties",
                            () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                            () -> assertEquals("Buck", owner.getLastName(), "Last name did not match"));
                    assertAll("Owner properties",
                            () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                            () -> assertEquals("1231231234", owner.getTelephone(), "Telephone did not match"
                            ));
                }
        );

        assertThat(owner.getCity(), is("Key West"));
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("Parameterised test with value source")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String value) {
        System.out.println(value);
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("Parameterised test with enum value source")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("CSV input test")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3"
    })
    void csvTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " " + val2);
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("CSV input test from file")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvTestFromFile(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " " + val2);
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("Method provider")
    @MethodSource("getArgs")
    void fromMethod(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 5, 1),
                Arguments.of("OH", 7, 2),
                Arguments.of("MI", 6, 8));
    }

    @ParameterizedTest(name = "{displayName}: [{index}] {arguments}")
    @DisplayName("Custom provider")
    @ArgumentsSource(CustomArgsProvider.class)
    void customProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " " + val2);
    }
}