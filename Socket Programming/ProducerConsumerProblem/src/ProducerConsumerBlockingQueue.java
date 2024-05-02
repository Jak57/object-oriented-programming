import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> q = new ArrayBlockingQueue<>(4);
        Producer producer1 = new Producer(q, "producer1");
        Consumer consumer1 = new Consumer(q, "consumer1");
        Consumer consumer2 = new Consumer(q, "consumer2");
    }
}
