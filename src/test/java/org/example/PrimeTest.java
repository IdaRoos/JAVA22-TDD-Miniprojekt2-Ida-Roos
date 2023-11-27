package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void resetSystemOut() {
        System.setOut(standardOut);
    }

    // TEST INTERVAL WITH VALID RANGE VALUES

    @Test
    @DisplayName("Test for valid interval")
    void testPrimeValidInterval() {
        Prime prime = new Prime(3, 900);
        assertDoesNotThrow(() -> prime);
        assertEquals(153, prime.getPrimes().size());
    }

    @Test
    @DisplayName("Test max range values in interval")
    void testPrimeIntervalWithMaxRange() {
        Prime prime = new Prime(0, 1000);
        assertDoesNotThrow(() -> prime);
        assertEquals(168, prime.getPrimes().size());

    }

    @Test
    @DisplayName("Test with small interval")
    void testPrimeSmallInterval() {
        Prime prime = new Prime(0, 1);
        assertDoesNotThrow(() -> prime);
    }


    @Test
    @DisplayName("Test with zero as input values")
    void testPrimeZeroValues() {
        Prime prime = new Prime(0, 0);
        assertDoesNotThrow(() -> prime);
    }


    @Test
    @DisplayName("Test interval with no prime numbers")
    void testIntervalWithNoPrimes() {
        Prime prime = new Prime(1, 1);
        assertTrue(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Test interval with a few prime numbers")
    void testCorrectPrimesInInterval() {
        Prime prime = new Prime(10, 20);
        List<Integer> expectedPrimes = List.of(11, 13, 17, 19);
        assertEquals(expectedPrimes, prime.getPrimes());
    }


    @Test
    @DisplayName("Test if only one prime number in interval")
    void testPrimeOnePrimeNumber() {
        Prime prime = new Prime(3, 4);
        List<Integer> expectedPrimes = List.of(3);
        assertEquals(expectedPrimes, prime.getPrimes());
    }
    @Test
    @DisplayName("Test if interval starts and ends with prime number")
    void testPrimeStartsAndEndsWithPrime() {
        Prime prime = new Prime(11, 19);
        List<Integer> expectedPrimes = List.of(11, 13, 17, 19);
        assertEquals(expectedPrimes, prime.getPrimes());
    }



    // BOUNDARY TESTING INVALID INPUT VALUES

    @Test
    @DisplayName("Test for interval when firstNumber is less negative number(out of range)")
    void testPrimeIntervalWithFirstNumberLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 500));
    }

    @Test
    @DisplayName("Test interval when lastNumber is greater than 1000 (out of range)")
    void testPrimeIntervalWithLastNumberGreaterThan1000() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(0, 1001));
    }


    @Test
    @DisplayName("Test interval when firstNumber is greater than lastNumber")
    void testPrimeIntervalWithFirstNumberGreaterThanLastNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(500, 100));

    }

    @Test
    @DisplayName("Test interval when both are negative numbers(out of range)")
    void testPrimeIntervalWithNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(-10, -2));

    }

    // TEST EXCEPTION MESSAGE WHEN INVALID INPUT VALUES

    @Test
    @DisplayName("Test exception message for when firstNumber is out of range")
    void testExceptionMessageForFirstNumberOutOfBoundary() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Prime(-1, 500);
        });
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }

    @Test
    @DisplayName("Test exception message for when lastNumber is out of range")
    void testExceptionMessageForLastNumberOutOfBoundary() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Prime(5, 1001);
        });
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }



    @Test
    @DisplayName("Test exception message when firstNumber is greater than lastNumber")
    void testExceptionWhenFirstNumberGreaterThanLastNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Prime(100, 50);
        });
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }

    @Test
    @DisplayName("Test exception message when interval numbers is negative")
    void testExceptionWhenFirstNumberIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Prime(-10, -3);
        });
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }




    // TESTING GETTERS FOR COUNT AND SUMOFPRIME

    @Test
    @DisplayName("Test count with max range values ")
    void testGetCountWithMaxRange() {
        Prime prime = new Prime(0,1000);
        assertEquals(168, prime.getCount() );
    }

    @Test
    @DisplayName("Test sum of primes with max range values ")
    void testGetSumOfPrimesWithMaxRange() {
        Prime prime = new Prime(0,1000);
        assertEquals(76127, prime.getSumOfPrimes() );
    }

    @Test
    @DisplayName("Test count of primes between 10 and 20")
    void testGetCountOfPrimesBetween10And20() {
        Prime prime = new Prime(10, 20);
        assertEquals(4, prime.getCount());
    }

    @Test
    @DisplayName("Test sum of primes between 10 and 20")
    void testGetSumOfPrimesBetween10And20() {
        Prime prime = new Prime(10, 20);
        assertEquals(60, prime.getSumOfPrimes());
    }


    @Test
    @DisplayName("Test sum if no prime numbers")
    void testGetSumOfPrimesNoPrimes() {
        Prime prime = new Prime(20, 22);
        assertEquals(0, prime.getSumOfPrimes());
    }

    @Test
    @DisplayName("Test count if no prime numbers")
    void testGetCountNoPrimes() {
        Prime prime = new Prime(20, 22);
        assertEquals(0, prime.getCount());
    }

    @Test
    @DisplayName("Test sum if only one prime number")
    void testGetSumOfPrimesOnePrime() {
        Prime prime = new Prime(22, 28);
        assertEquals(23, prime.getSumOfPrimes());
    }

    @Test
    @DisplayName("Test count if only one prime number")
    void testGetCountOnePrime() {
        Prime prime = new Prime(22, 28);
        assertEquals(1, prime.getCount());
    }

    @Test
    @DisplayName("Test count if input values is zeros")
    void testGetCountZeroValues() {
        Prime prime = new Prime(0, 0);
        assertEquals(0, prime.getCount());
    }

    @Test
    @DisplayName("Test sum if input values is zeros")
    void testGetSumOfPrimesZeroValues() {
        Prime prime = new Prime(0, 0);
        assertEquals(0, prime.getSumOfPrimes());
    }



    // TEST PRINTSUM AND PRINTCOUNT METHODS


    @Test
    @DisplayName("Test printCount with valid values")
    void testPrintCount() {
        Prime prime = new Prime(10, 20);
        prime.printCount();
        assertEquals("Hej, det finns 4 primtal mellan 10 och 20!", outputStreamCaptor.toString().trim());
    }


    @Test
    @DisplayName("Test printSum with valid values")
    void testPrintSum() {
        Prime prime = new Prime(10, 20);
        prime.printSum();
        assertEquals("Och den totala summan av dessa primtal är 60.", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test printCount with max range values")
    void testPrintCountMaxRange() {
        Prime prime = new Prime(0,1000);
        prime.printCount();
        assertEquals("Hej, det finns 168 primtal mellan 0 och 1000!", outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("Test printSum with max range values")
    void testPrintSumOfPrimesMaxRange() {
        Prime prime = new Prime(0,1000);
        prime.printSum();
        assertEquals("Och den totala summan av dessa primtal är 76127.", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Test printCount with when values are zero")
    void testPrintCountZeroValues() {
        Prime prime = new Prime(0,0);
        prime.printCount();
        assertEquals("Hej, det finns 0 primtal mellan 0 och 0!", outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("Test printSum with when values are zero")
    void testPrintSumZeroValues() {
        Prime prime = new Prime(0,0);
        prime.printSum();
        assertEquals("Och den totala summan av dessa primtal är 0.", outputStreamCaptor.toString().trim());

    }
    @Test
    @DisplayName("Test printCount when only one prime number")
    void testPrintCountOnePrime() {
        Prime prime = new Prime(3,4);
        prime.printCount();
        assertEquals("Hej, det finns 1 primtal mellan 3 och 4!", outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("Test printSum when only one prime number")
    void testPrintSumOnePrime() {
        Prime prime = new Prime(3,4);
        prime.printSum();
        assertEquals("Och den totala summan av dessa primtal är 3.", outputStreamCaptor.toString().trim());

    }


    @Test
    @DisplayName("Test printCount when no prime numbers")
    void testPrintCountNoPrimeNumbers() {
        Prime prime = new Prime(1,1);
        prime.printCount();
        assertEquals("Hej, det finns 0 primtal mellan 1 och 1!", outputStreamCaptor.toString().trim());

    }

    @Test
    @DisplayName("Test printCount when no prime numbers")
    void testPrintSumNoPrimeNumbers() {
        Prime prime = new Prime(1,1);
        prime.printSum();
        assertEquals("Och den totala summan av dessa primtal är 0.", outputStreamCaptor.toString().trim());

    }

}

