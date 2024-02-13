import java.text.SimpleDateFormat;
import java.util.Date;

//----> Is limited to extending only the Thread class
class TimePrinterThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String currentTime = sdf.format(new Date());
                System.out.println(Thread.currentThread() + ": " + currentTime);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
