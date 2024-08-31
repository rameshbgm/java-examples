package dev.ramesh.semaphore;

import java.util.concurrent.Semaphore;

/**
 * This class demonstrates the use of a Semaphore to manage access to a shared resource
 * (in this case, a printer) by multiple threads.
 */
public class SemaphoreExample {

    // Semaphore with 2 permits, meaning 2 threads can print at the same time
    private final Semaphore semaphore = new Semaphore(2);

    /**
     * Simulates the printing job. Acquires a permit before printing and releases it afterward.
     *
     * @param document The document to print
     */
    public void printDocument(String document) {
        try {
            // Acquire a permit before printing
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is printing: " + document);
            // Simulate the time taken to print the document
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Release the permit after printing
            System.out.println(Thread.currentThread().getName() + " finished printing.");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample printerManager = new SemaphoreExample();

        // Creating and starting multiple threads to simulate concurrent printing
        for (int i = 1; i <= 5; i++) {
            String document = "Document " + i;
            new Thread(() -> printerManager.printDocument(document)).start();
        }
    }
}




