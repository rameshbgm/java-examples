package dev.ramesh.VirtualThread;




import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class VirtualThreadExample {

    private static final int MAX_PLATFORM = 100_000;
    private static final int MAX_VIRTUAL = 20;

    public static void main(String[] args) throws InterruptedException {
        platformThreadDemo1();
        // virtualThreadDemo();
    }

    /*
        To create a simple java platform thread
     */
    private static void platformThreadDemo1(){
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = new Thread(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
        To create platform thread using Thread.Builder
    */
    private static void platformThreadDemo2(){
        var builder = Thread.ofPlatform().name("vins", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> Task.ioIntensive(j));
            thread.start();
        }
    }

    /*
        To create platform daemon thread using Thread.Builder
    */
    private static void platformThreadDemo3() throws InterruptedException {
        var latch = new CountDownLatch(MAX_PLATFORM);
        var builder = Thread.ofPlatform().daemon().name("daemon", 1);
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
    }

    /*
        To create virtual thread using Thread.Builder
        - virtual threads are daemon by default
        - virtual threads do not have any default name
    */
    private static void virtualThreadDemo() throws InterruptedException {
        var latch = new CountDownLatch(MAX_VIRTUAL);
        var builder = Thread.ofVirtual().name("virtual-", 1);
        for (int i = 0; i < MAX_VIRTUAL; i++) {
            int j = i;
            Thread thread = builder.unstarted(() -> {
                Task.ioIntensive(j);
                latch.countDown();
            });
            thread.start();
        }
        latch.await();
    }


}

class Task {



    public static void ioIntensive(int i){

        try {
            System.out.println(("starting I/O task {}. Thread Info: {}" + i + " " + Thread.currentThread()));
            Thread.sleep(Duration.ofSeconds(60));
            System.out.println(("ending I/O task  Thread Info:" + i + " " + Thread.currentThread()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
