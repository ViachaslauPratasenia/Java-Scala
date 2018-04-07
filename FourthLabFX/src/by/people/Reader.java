package by.people;

import by.data.Data;
import by.notificators.INotificator;

/**
 * This class realise reader that write information to data
 */
public class Reader implements Runnable {
    public Data data;
    public INotificator notificator;

    public void read() {
        try{
            notificator.DisplayNotification(data.iterract());
        }
        catch (InterruptedException e) {
            notificator.DisplayNotification(e.getMessage());
        }
    }

    @Override
    public void run() {
        read();
    }
}
