package helloworld;

public class HelloWorldPrinter {

    public static void main(String[] args) {

        Runnable task = () -> System.out.println("Hello World using thread: " + Thread.currentThread().getName());
        Thread thread = new Thread(task);

        System.out.println("Starting printing from thread: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("Ending printing from thread: " + Thread.currentThread().getName());
    }
}
