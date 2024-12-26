import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) throws InterruptedException {

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()-> {
//            System.err.println("sss");
//        });

        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.err.println(queue.offer(4));

        queue.take();

        System.err.println(queue.size());



    }
}
