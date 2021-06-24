import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class TaskQueue {
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void add(int i) throws InterruptedException {
        while (queue.size() == 10) {
            //等待消费者消费
            this.wait();
        }
        queue.add(i);
        System.out.println("生产：" + i);

        // 通知消费者消费
        this.notify();
    }

    public synchronized int getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            // 等待生产者
            this.wait();
        }
        Integer remove = queue.remove();
        System.out.println("当前队列：" + queue.size() + " 消费：" + remove);

        // 通知生产者
        this.notify();
        return remove;
    }
}
