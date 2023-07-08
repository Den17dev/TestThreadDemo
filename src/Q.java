import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Q{


  static AtomicInteger count = new AtomicInteger(1);
  int n;

  static AtomicBoolean valueSet = new AtomicBoolean(false);

  synchronized void put(int n){
    while(valueSet.get()){
      try{
        wait();
      }catch (InterruptedException ex){
        ex.printStackTrace();
      }
    }
    this.n = n;
    valueSet.set(true);
    System.out.println("Отправлено: " + n);
    notify();
  }

  synchronized int get(){
    while(!valueSet.get()){
      try{
        wait();
      }catch (InterruptedException ex){
        ex.printStackTrace();
      }
    }
    System.out.println("Получено: " + n);
    valueSet.set(false);
    notify();
    return n;
  }
}
