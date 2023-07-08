public class Producer implements Runnable {

  private Q q;

  Producer(Q q) {
    this.q = q;
  }

  @Override
  public void run() {

    while (Q.count.get() < q.getN()) {
      q.put(Q.count.incrementAndGet());
    }
    System.out.println("Out from producer");
  }
}