import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * BankWithConditionClock
 */
public class BankWithConditionClock {

    /**
     * 多个银行账户
     */
    private final double[] accounts;
    // 使每一个对象有自己的ReentrantLock对象
    private Lock bankLock;

    private Condition sufficientFunds;

    public BankWithConditionClock(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 银行交易
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    public void transfer(int from, int to, double amount) throws InterruptedException{
        bankLock.lock();
        try{
            // 加条件锁
            while(accounts[from]<amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from , to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            // 唤醒处于等待的其他所有线程
            sufficientFunds.signalAll();
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