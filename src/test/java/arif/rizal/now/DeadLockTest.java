package arif.rizal.now;


import org.junit.jupiter.api.Test;

class Balance{
  private Long value;

  public Balance(Long value){
    this.value = value;
  }

  public Long getValue(){
      return value;
  }
  public void setValue(Long value){
      this.value = value;
  }

  public static void transfer(Balance from, Balance to, Long value) throws InterruptedException {
      synchronized (from){
          Thread.sleep(1000L);
          synchronized (to){
              Thread.sleep(1000L);
              from.setValue(from.getValue() - value);
              to.setValue(to.getValue() + value);
          }
      }
  }

}


public class DeadLockTest {
    @Test
    void Deadlock() throws InterruptedException {
       var balance1 = new Balance(1_000_000L);
       var balance2 = new Balance(1_000_000L);

       var thread1 = new Thread(() -> {
           try {
               Balance.transfer(balance1, balance2, 500_000L);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });

        var thread2 = new Thread(() -> {
            try {
                Balance.transfer(balance1, balance2, 500_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balance1.getValue());
        System.out.println(balance2.getValue());
    }


}
