public class Main {


  public static void main(String[] args) throws InterruptedException {
    Q q = new Q();
    Producer producer = new Producer(q);
    Consumer consumer = new Consumer(q);
    Thread thread1 = new Thread(producer, "producer");
    Thread thread2 = new Thread(consumer, "consumer");

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.out.println("In main thread");

  }
}