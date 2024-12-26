package arif.rizal.now;

import org.junit.jupiter.api.Test;

class SynchronizeMethod{
    private Long value = 0L;
//    public synchronized void increment(){
//        value++;
//    }

    public void increment(){
        synchronized (this){
            value++;
        }
    }

    public Long getValue(){
        return value;
    }

}



public class SynchronizationTest {
    @Test
    void SynchronizedCondition() throws InterruptedException {
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
