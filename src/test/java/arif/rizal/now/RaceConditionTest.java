package arif.rizal.now;

import org.junit.jupiter.api.Test;

//class Counter {
//    private long value = 0L;
//
//    public synchronized void increment() {
//        value++;
//    }
//
//    public synchronized Long getValue() {
//        return value;
//    }
//}

class Counter {
    private long value = 0L;

    public synchronized void increment() {
        value++;
    }

    public synchronized Long getValue() {
        return value;
    }
}

public class RaceConditionTest {
//    @Test
//    void RaceCondition() throws InterruptedException {
//       Runnable runnable = () -> {
//           var counter = new Counter();
//           for (int i = 0; i < 1_000_000; i++) {
//               counter.increment();
//           }
//       };
//
//        var thread1 = new Thread(runnable);
//        var thread2 = new Thread(runnable);
//        var thread3 = new Thread(runnable);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        thread1.join();
//        thread2.join();
//        thread3.join();
//
//        System.out.println(counter.getValue); // race condition
//    }


    @Test
    void RaceCondition() throws InterruptedException {
        var counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }

}
