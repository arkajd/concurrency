package racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionSolution {

    private static int count = 0;
    private static final Object lock = new Object();

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        solveRaceConditionUsingLocks();
        solveRaceConditionUsingAtomicInteger();
    }

    // solving race condition using lock synchronization
    private static void solveRaceConditionUsingLocks() throws InterruptedException {
        Runnable task = () -> {

            for (int i=0; i<100000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        };
        Thread firstWorker = new Thread(task);
        Thread secondWorker = new Thread(task);

        firstWorker.start();
        secondWorker.start();
        firstWorker.join();
        secondWorker.join();

        System.out.println(count);
    }

    // solving race condition using atomic integer
    private static void solveRaceConditionUsingAtomicInteger() throws InterruptedException {
        Runnable task = () -> {
            for (int i=0; i<100000; i++) {
                atomicInteger.incrementAndGet();
            }
        };
        Thread firstWorker = new Thread(task);
        Thread secondWorker = new Thread(task);

        firstWorker.start();
        secondWorker.start();
        firstWorker.join();
        secondWorker.join();
        System.out.println(atomicInteger.get());
    }
}
