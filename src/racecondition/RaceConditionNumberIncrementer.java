package racecondition;

public class RaceConditionNumberIncrementer {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i=0; i<1000; i++) {
                count++;
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
}
