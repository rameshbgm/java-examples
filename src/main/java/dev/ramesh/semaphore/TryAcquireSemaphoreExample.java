package dev.ramesh.semaphore;

import java.util.concurrent.Semaphore;

/**
 * This class demonstrates the use of the tryAcquire() method to perform non-blocking
 * acquisition of permits.
 */
public class TryAcquireSemaphoreExample {

    // Semaphore with 1 permit
    private final Semaphore semaphore = new Semaphore(1);

    /**
     * Tries to access the resource using tryAcquire without blocking.
     */
    public void tryAccessResource(String threadName) {
        if (semaphore.tryAcquire()) {
            try {
                System.out.println(threadName + " successfully acquired the permit.");
                // Simulate work
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(threadName + " released the permit.");
                semaphore.release();
            }
        } else {
            System.out.println(threadName + " could not acquire the permit, doing alternative work.");
            // Perform alternative action if permit is not available
        }
    }

    public static void main(String[] args) {
        TryAcquireSemaphoreExample example = new TryAcquireSemaphoreExample();

        // First thread acquires the permit
        new Thread(() -> example.tryAccessResource("Thread-1")).start();

        // Second thread tries to acquire the permit but may fail due to the first thread
        new Thread(() -> example.tryAccessResource("Thread-2")).start();
    }
}
