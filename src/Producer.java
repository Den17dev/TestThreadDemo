public class Producer implements Runnable{

  Q q;

  Producer(Q q){
    this.q = q;
  }
  @Override
  public void run() {

    int i = 1;
    while(Q.count.get() <= 10){
      q.put(i++);
      Q.count.incrementAndGet();
    }
    Q.valueSet.set(false);
    System.out.println("Out from producer");
  }
}