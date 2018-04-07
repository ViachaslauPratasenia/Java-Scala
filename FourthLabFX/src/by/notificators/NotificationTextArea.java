package by.notificators;

import javafx.scene.control.TextArea;

public class NotificationTextArea extends TextArea implements INotificator {
    public void DisplayNotification(String notification) {
        this.appendText(notification + "\n");
    }
}
