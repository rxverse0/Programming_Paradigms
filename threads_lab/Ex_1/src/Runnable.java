import java.text.SimpleDateFormat;
import java.util.Date;

//--->  Can extend other classes or implement additional interfaces
class TimePrinterRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());
                System.out.println(Thread.currentThread().getName() + ": " + currentTime);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}