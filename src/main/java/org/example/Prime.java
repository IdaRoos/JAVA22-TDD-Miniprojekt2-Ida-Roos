package org.example;
import java.util.ArrayList;
import java.util.List;


/**
* This program counts the sum and the number of prime (int) numbers in interval 0-1000
*/
public class Prime {

    private List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;
    private final int firstNumber;
    private final int lastNumber;

    public Prime(int firstNumber, int lastNumber) {

        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;

        if (firstNumber < 0 || lastNumber > 1000 || firstNumber > lastNumber) {
            throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
        }

        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);

    }

    private boolean numIsPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void calculatePrimes(int current, int stop) {
        if (current <= stop) {
            if (current >= 2 && numIsPrime(current)) {
                primes.add(current);
                ++count;
                sumOfPrimes += current;
            }
            calculatePrimes(++current, stop);
        }
    }


    public List<Integer> getPrimes() {
        return primes;
    }

    public int getCount(){
    return count;
    }

    public int getSumOfPrimes(){
        return sumOfPrimes;
    }


    // Here we get amount of prime numbers
    public void printCount() {
        System.out.println("Hej, det finns " + count + " primtal mellan " + firstNumber +  " och " + lastNumber + "!");
    }

    // Here we get the sum of the prime numbers
    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes + ".");
    }

}