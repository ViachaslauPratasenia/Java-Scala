/**
 * <h1>Fourth Lab</h1>
 * The Fourth lab implements an application that
 * realise task variant 9
 * @author Viachaslau Pratasenia
 * @version 1.0
 * @since 2018-04-06
 */

package sample;

import by.data.Data;
import by.notificators.NotificationTextArea;
import by.people.Reader;
import by.people.Writer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab4");
        primaryStage.setResizable(false);

        NotificationTextArea textArea = new NotificationTextArea();

        Data data = new Data();

        Writer writer = new Writer();
        writer.data = data;
        writer.notificator = textArea;

        Reader reader = new Reader();
        reader.data = data;
        reader.notificator = textArea;


        write = new Button("Писать");
        write.setPrefSize(390,20);
        write.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Thread(writer).start();
            }
        });

        read = new Button("Читать");
        read.setPrefSize(390,20);
        read.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Thread(reader).start();
            }
        });



        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        gridpane.add(write, 2, 1);
        gridpane.add(read, 2, 2);
        gridpane.add(textArea, 2,3);

        root.setCenter(gridpane);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private Button write;
    private Button read;
}
