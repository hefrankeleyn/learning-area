package concurrency.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank
 */
public class Bank {

    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally{
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balance.
     * @return
     */
    public double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size(){
        return accounts.length;
    }
}