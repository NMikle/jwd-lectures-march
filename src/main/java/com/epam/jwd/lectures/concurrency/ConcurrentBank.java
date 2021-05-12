package com.epam.jwd.lectures.concurrency;

import com.epam.jwd.lectures.exception.NotEnoughMoneyException;
import com.epam.jwd.lectures.model.BankAccount;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank {

    private final int[] accounts;

    private final Lock lock;
    private final Condition sufficientFunds;

//    private final Object lock;

    public ConcurrentBank(int amount) {
        this.accounts = new int[amount];
        this.lock = new ReentrantLock();
        sufficientFunds = lock.newCondition();
//        lock = new Object();
    }

    public void transfer(int from, int to, int amount) {
        lock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            accounts[from] -= amount;
            accounts[to] += amount;

            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void transferMoneyWithDeadLock(BankAccount from, BankAccount to, int amount)
            throws NotEnoughMoneyException {
        BankAccount first = from.compareTo(to) > 0 ? to : from;
        BankAccount second = first == from ? to : from;
        synchronized (first) {
            synchronized (second) {
                if (from.getBalance() < amount) {
                    throw new NotEnoughMoneyException();
                } else {
                    from.debit(amount);
                    to.credit(amount);
                }
            }
        }
    }

//    public synchronized void transfer(int from, int to, int amount) throws InterruptedException {
//        while (accounts[from] < amount) {
//            wait();
//        }
//        accounts[from] -= amount;
//        accounts[to] += amount;
//
//        notifyAll();
//    }

//    public void transfer(int from, int to, int amount) throws InterruptedException {
//        synchronized (lock) {
//            while (accounts[from] < amount) {
//                lock.wait();
//            }
//            accounts[from] -= amount;
//            accounts[to] += amount;
//
//            lock.notifyAll();
//        }
//    }

//    public static synchronized int count(int a, int b) throws InterruptedException {
////        synchronized (ConcurrentBank.class) {
////
////        }
//        while (something) {
//            ConcurrentBank.class.wait();
//        }
//
//        ConcurrentBank.class.notifyAll();
//        return a + b;
//    }

    public int checkAmount(int customer) {
        return accounts[customer];
    }

}
