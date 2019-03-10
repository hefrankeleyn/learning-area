package concurrency.synch2;

import java.util.Arrays;

/**
 * Bank
 */
public class Bank {

    private final double[] accounts;

    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account.
     */
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /**
     * Gets the sum of all account balance.
     * @return the total balance
     */
    public synchronized double getTotalBalance(){
        double sum = 0;
        for (double a: accounts){
            sum += a;
        }
        return sum;
    }
    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size(){
        return accounts.length;
    }
}