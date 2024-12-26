package arif.rizal.now;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    @Test
    void DelayJob() throws InterruptedException {
       var task = new TimerTask(){
           @Override
           public void run() {
               System.out.println("delayed job");
           }
       };

       var timer = new Timer();
       timer.schedule(task, 1000L);
       Thread.sleep(3000L);
    }

    @Test
    void TimerPeriodicJob() throws InterruptedException {
        var task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("periodic job");
            }
        };
        var timer = new Timer();
        timer.schedule(task, 2000, 2000);
        Thread.sleep(10_000L);
    }

}
