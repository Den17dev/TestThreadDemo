import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Q {


  public static AtomicInteger count = new AtomicInteger(1);
  public static AtomicBoolean valueSet = new AtomicBoolean(false);
  private int n;

  Q (int n){
    this.n = n;
  }

  synchronized void put(int n) {
    while (valueSet.get() && n < 11) {
      try {
        wait();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    this.n = n;
    valueSet.set(true);
    System.out.println("Отправлено: " + n);
    notify();
  }

  synchronized int get() {
    // todo: добавить проверку что  n<10 (10 не хардкодить а унести в конструктор)
    while (!valueSet.get() && n < 11) {  //true-false
      try {
        wait();
      } catch (InterruptedException ex) {
        System.out.println("is interrapted");
        ex.printStackTrace();
      }
    }
    System.out.println("Получено: " + n);
    valueSet.set(false);
    notify();
    return n;
  }
}
