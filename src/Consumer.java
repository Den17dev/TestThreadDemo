public class Consumer implements Runnable {

  private Q q;

  Consumer(Q q) {
    this.q = q;
  }

  @Override
  public void run() {

    while (Q.count.get() < q.getN()) {
      q.get();
    }
    System.out.println("Out from consumer");
  }
}