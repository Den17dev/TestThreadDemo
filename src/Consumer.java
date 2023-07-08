public class Consumer implements Runnable {

  Q q;

  Consumer(Q q) {
    this.q = q;
  }

  @Override
  public void run() {

    while (Q.count.get() <= 10) {
      q.get();
    }
    System.out.println("Out from consumer");
  }
}