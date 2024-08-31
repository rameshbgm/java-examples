package dev.ramesh.semaphore;

import java.util.concurrent.Semaphore;

/**
 * This class demonstrates the use of the drainPermits() method to acquire all available permits.
 */
public class DrainPermitsExample {

    // Semaphore initialized with 3 permits
    private final Semaphore semaphore = new Semaphore(3);

    /**
     * Simulates draining all available permits to gain exclusive access to the resource.
     */
    public void exclusiveAccess(String threadName) {
        try {
            // Draining all available permits
            int drainedPermits = semaphore.drainPermits();
            System.out.println(threadName + " drained " + drainedPermits + " permits.");
            // Simulate exclusive work
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Releasing the drained permits after exclusive work is done
            System.out.println(threadName + " releasing all permits.");
            semaphore.release(3);
        }
    }

    public static void main(String[] args) {
        DrainPermitsExample example = new DrainPermitsExample();

        // One thread gains exclusive access by draining all permits
        new Thread(() -> example.exclusiveAccess("Thread-1")).start();

        // Another thread tries to acquire permits but will be blocked
        new Thread(() -> example.exclusiveAccess("Thread-2")).start();
    }
}
