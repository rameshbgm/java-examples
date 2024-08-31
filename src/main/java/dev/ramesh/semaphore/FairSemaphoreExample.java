package dev.ramesh.semaphore;

import java.util.concurrent.Semaphore;

/**
 * This class demonstrates the use of a fair semaphore in Java to prevent thread starvation.
 */
public class FairSemaphoreExample {

    // Semaphore with 2 permits and fairness set to true (FIFO order)
    private final Semaphore fairSemaphore = new Semaphore(2, true);

    /**
     * Simulates access to a shared resource by multiple threads with fairness enabled.
     */
    public void accessResource(String threadName) {
        try {
            // Acquiring the permit
            fairSemaphore.acquire();
            System.out.println(threadName + " acquired the permit.");
            // Simulate work by sleeping for a while
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Releasing the permit after the work is done
            System.out.println(threadName + " released the permit.");
            fairSemaphore.release();
        }
    }

    public static void main(String[] args) {
        FairSemaphoreExample example = new FairSemaphoreExample();

        // Creating multiple threads to demonstrate FIFO ordering with fairness
        for (int i = 1; i <= 5; i++) {
            final String threadName = "Thread-" + i;
            new Thread(() -> example.accessResource(threadName)).start();
        }
    }
}
