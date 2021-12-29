package se.bahram.tdd.junitinaction.jumpstart;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test")
class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @DisplayName("Test Add")
    @ParameterizedTest
    @MethodSource("provideAddResults")
    void add(AddResult addResult) {

        assertEquals(addResult.r, calculator.add(addResult.a, addResult.b), 1);
        // assertFalse(true, new MessageSupplier("It should be false"));
    }

    class MessageSupplier implements Supplier<String> {

        String message;

        public MessageSupplier(String message) {
            this.message = message;
        }

        @Override
        public String get() {
            return message;
        }
    }

    @Test
    @Disabled("Under construction")
    void multiple(){

    }


    @Nested
    class BuilderTest {

        @Test
        void testBuilder() {
            assertEquals(1, 1);
        }
    }


    static Stream<AddResult> provideAddResults() {
        return Stream.of(new AddResult(1, 1, 2));
    }

    static class AddResult {
        public final int a;
        public final int b;
        public final int r;

        public AddResult(int a, int b, int r) {
            this.a = a;
            this.b = b;
            this.r = r;
        }
    }
}