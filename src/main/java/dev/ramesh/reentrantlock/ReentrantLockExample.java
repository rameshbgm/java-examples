package dev.ramesh.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();
    private final Lock fairLock = new ReentrantLock(true);  //Pass true to the constructor to create a fair lock that respects FIFO order.
    private int count = 0;
    private int fairLockCount = 0;

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            // Critical section
            count++;
            System.out.println("in increment Count: " + count);
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

    /**
     * Acquires the lock only if it is free at the time of invocation.
     * Acquires the lock if it is available and returns immediately with the value true.
     * If the lock is not available then this method will return immediately with the value false.
     **/
    public void tryLock() {
        if (fairLock.tryLock()) { // Acquire the lock
            try {
                fairLockCount++;
                System.out.println("WithTryLock Count : " + fairLockCount);
            } finally {
                fairLock.unlock(); // Ensure the lock is released
            }
        }
    }


    /**
     * Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
     * If the lock is available this method returns immediately with the value true. If the lock is not available then the current thread becomes disabled for thread scheduling purposes and lies dormant until one of three things happens:
     * The lock is acquired by the current thread; or
     * Some other thread interrupts the current thread, and interruption of lock acquisition is supported; or
     * The specified waiting time elapses
     * If the lock is acquired then the value true is returned.
     * If the current thread:
     * has its interrupted status set on entry to this method; or
     * is interrupted while acquiring the lock, and interruption of lock acquisition is supported,
     * then InterruptedException is thrown and the current thread's interrupted status is cleared.
     * If the specified waiting time elapses then the value false is returned. If the time is less than or equal to zero, the method will not wait at all.
     * @throws InterruptedException
     */
    public void TryLockTimeout() throws InterruptedException {
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            try {
                count++;
                System.out.println("WithTryLock Count : " + count);
            } finally {
                lock.unlock();
            }
        }
    }





    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        Runnable task = example::increment;

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();


        Runnable tryLock = example::tryLock;
        Thread tryLockT1 = new Thread(tryLock);
        Thread tryLockT2 = new Thread(tryLock);

        tryLockT1.start();
        tryLockT2.start();

    }
}