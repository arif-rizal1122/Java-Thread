package arif.rizal.now;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {

    private String message = null;

    @Test
    void ThreadCommunicationManual() throws InterruptedException {
        var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                while (message == null) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(message);
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "arif rizal";
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
