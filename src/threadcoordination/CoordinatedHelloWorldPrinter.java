package threadcoordination;

public class CoordinatedHelloWorldPrinter {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> System.out.println("Hello World from thread: " + Thread.currentThread().getName());
        Thread thread = new Thread(task, "worker-1");
        System.out.println("Starting hello world printing");
        thread.start();
        thread.join();
        System.out.println("End of printing. This prints always after worker thread ends.");
    }
}
