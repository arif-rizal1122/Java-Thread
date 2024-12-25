package arif.rizal.now;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void mainThread(){
       String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }

    @Test
    void MakeThread(){
        Runnable runnable = () -> {
            System.out.println("HELLO FROM THREAD: " + Thread.currentThread().getName());
        };
        var thread = new Thread(runnable);
        thread.start();   // Thread-0
        // runnable.run();      // main
        System.out.println("proggram selsesai"); // di run secara asynchronus
    }

    @Test
    void ThreadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("helo from thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Proggram selesai");
        Thread.sleep(3_000L);
    }

    @Test
    void ThreadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println("helo from thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("menunggu selesai : ");
        thread.join();
        System.out.println("selesai : ");
    }

    @Test
    void ThreadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("runnable : " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("menunggu selesai : ");
        thread.join();
        System.out.println("selesai : ");
    }


    @Test
    void ThreadInterrupt2() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("runnable : " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("menunggu selesai : ");
        thread.join();
        System.out.println("selesai : ");
    }

    @Test
    void InterruptThreadManual() throws InterruptedException {
        Runnable runnable = () -> {
            // manual check
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()){
                    return;
                }
                System.out.println("runnable : " + i);
                    try {
                        Thread.sleep(1_000L);
                    } catch (InterruptedException e) {
                        return;
                    }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("menunggu selesai : ");
        thread.join();
        System.out.println("selesai : ");

    }


    @Test
    void ThreadName(){
        var thread = new Thread(() -> {
            System.out.println("hello from thread : " + Thread.currentThread().getName());
        });
        thread.setName("arif");
        thread.start();
    }

    @Test
    void ThreadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("hello from thread : " + Thread.currentThread().getName());
        });
        System.out.println(thread.getState());
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }
    @Test
    void ThreadDaemon(){

    }









}
