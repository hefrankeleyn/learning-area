package com.hef.controller;

/**
 * 首先子线程执行5次，主线程执行10次，如此循环10遍
 *
 * @Date 2019/10/23
 * @Author lifei
 */
public class ThreadMainAndChild {
    public static void main(String[] args) {

        MainAndChildRun mainAndChildRun = new MainAndChildRun();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                mainAndChildRun.childThreadRun(i);
            }
        }).start();
        for (int i = 1; i <= 10; i++) {
            mainAndChildRun.mainThreadRun(i);
        }
    }

}

class MainAndChildRun {
    // 信号灯
    private boolean runFlag = true;

    public synchronized void mainThreadRun(int runTime) {
        if (runFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread run " + Thread.currentThread().getName() + " , i=" + i + " runTime: " + runTime);
        }
        runFlag = true;
        this.notifyAll();
    }

    public synchronized void childThreadRun(int runTime) {
        if (!runFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread run " + Thread.currentThread().getName() + " , i=" + i + " runTime: " + runTime);
        }
        runFlag = false;
        this.notifyAll();
    }
}
