package by.people;

import by.data.Data;
import by.notificators.INotificator;

/**
 * This class realise writer that write information to data
 */
public class Writer implements Runnable {
    public Data data;
    public INotificator notificator;

    public void write() {
        try{
            notificator.DisplayNotification(data.iterract());
        }
        catch (InterruptedException e) {
            notificator.DisplayNotification(e.getMessage());
        }
    }

    @Override
    public void run() {
        write();
    }
}
