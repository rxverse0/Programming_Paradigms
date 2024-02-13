// I placed both
public class Main {
    public static void main(String[] args) {
//----->  Thread class
        new TimePrinterThread().start();
        new TimePrinterThread().start();
        new TimePrinterThread().start();

//-----> Runnable interface
        Thread thread1 = new Thread(new TimePrinterRunnable());
        Thread thread2 = new Thread(new TimePrinterRunnable());
        Thread thread3 = new Thread(new TimePrinterRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

