package arif.rizal.now;

public class Main {
    public static void main(String[] args) {
        var thread = new Thread(() -> {
           try {
               Thread.sleep(3000);
               System.out.println("run thread");
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        });
        // thread.setDaemon(true);
        thread.setDaemon(false);
        thread.start();
    }
}
