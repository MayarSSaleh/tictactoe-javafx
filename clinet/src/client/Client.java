package client;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = new PlayingScreenDemo(stage );

        // Parent root =new Profile();
//      Parent root =new FirstPage(stage);
//        Parent root = new PlayingOnlineDemo(stage, "", "", 5, 'g');

       Parent root =new RecordList(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
