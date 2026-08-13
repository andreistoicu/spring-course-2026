package testing_example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    private Example example;

    @BeforeEach //-> utilizat in general pentru setare initiala
    //@AfterEach // -> utilizat in general pentru resetare dupa fiecare test
    void setUp() {
        example = new Example();
    }

    @Test
    @DisplayName("verify if older than 18 in Europe")
    //@Order(0)
    //@Disabled
    void isAdult_Age18_Europe_Older_ReturnTrue() {
        assertTrue(example.isAdult(18, "Europe"));
    }

    @Test
    @DisplayName("verify if older than 21 in US")
    //@Order(1)
    void isAdult_Age21_US_Older_ReturnTrue() {
        assertTrue(example.isAdult(21, "US"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 21, 62, 103, 182, 22})
    @DisplayName("multiple verifies")
    void isAdult_Age21_US_Check(int age) {
        assertTrue(example.isAdult(age, "US"));
    }

    @Test
    @DisplayName("verify if older than 18 in Europe and 21 in US")
    //@Order(2)
    void isAdult_Age18Older_ReturnFalse() {
        assertFalse(example.isAdult(20, "US"));
        assertFalse(example.isAdult(17, "Europe"));
    }

    @Test
    @DisplayName("Exception if age is NOT valid")
    void isAdult_AgeIsValid_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> example.isAdult(-1, "Europe")
        );

        assertEquals(exception.getMessage(), "Age cannot be negative");
    }

    @Test
    void formatUserName_ValidString_TrimAndConvertToUpperCase(){
        String result = example.formatUserName("   Europe   ");
        assertEquals("EUROPE", result);
    }

    @Test
    void formatUserName_NullOrBlank_ReturnAnonymous(){
        assertEquals("ANONYMOUS", example.formatUserName(null));
        assertEquals("ANONYMOUS", example.formatUserName("     "));
    }

    @ParameterizedTest
    //@ValueSource(strings = { null, "    "}) //-> putem sa inlocuim cu cele 2 adnotari de jos
    @NullSource
    @EmptySource
    void formatUserName_NullOrBlank_ReturnAnonymous_Check(String input){
        assertEquals("ANONYMOUS", example.formatUserName(input));
    }
}
