import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank
 */
public class Bank {

    /**
     * 多个银行账户
     */
    private final double[] accounts;
    // 使每一个对象有自己的ReentrantLock对象
    private Lock bankLock = new ReentrantLock();

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 银行交易
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount){
        bankLock.lock();
        try{
            if(accounts[from]<amount) return;
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from , to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }finally{
            bankLock.unlock();
        }
    }

    /**
     * 获取银行总钱数
     * @return
     */
    public double getTotalBalance(){
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }


}