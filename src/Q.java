import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Q {

  public static AtomicInteger count = new AtomicInteger(0);
  public static AtomicBoolean valueSet = new AtomicBoolean(false);

  public int getN() {
    return n;
  }

  private int n;

  Q(int n) {
    this.n = n;
  }

  synchronized void put(int i) {
    while (valueSet.get() && count.get() < n) {
      try {
        wait();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    valueSet.set(true);
    System.out.println("Отправлено: " + count.get());
    notify();
  }

  synchronized int get() {
    while (!valueSet.get() && count.get() < n) {
      try {
        wait();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Получено: " + count.get());
    valueSet.set(false);
    notify();
    return count.get();
  }
}
