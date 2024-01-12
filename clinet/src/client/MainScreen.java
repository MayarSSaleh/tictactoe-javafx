package client;

//import mainscreen.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainScreen extends BorderPane {

    protected final FlowPane flowPane;
    protected final ImageView XphotoMain;
    protected final ImageView TICTACTOE;
    protected final Button btnOnline;
    protected final Button btnLocal;
    protected final Button btnComputer;
    public Stage stage;

    public MainScreen(Stage stage) {
        this.stage = stage;
        flowPane = new FlowPane();
        XphotoMain = new ImageView();
        TICTACTOE = new ImageView();
        btnOnline = new Button();
        btnLocal = new Button();
        btnComputer = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(257.0);
        flowPane.setPrefWidth(327.0);

        XphotoMain.setFitHeight(244.0);
        XphotoMain.setFitWidth(308.0);
        XphotoMain.setPickOnBounds(true);
        XphotoMain.setPreserveRatio(true);
        XphotoMain.setImage(new Image(getClass().getResource("/assets/Untitled.png").toExternalForm()));
        FlowPane.setMargin(XphotoMain, new Insets(5.0, 100.0, 0.0, 70.0));
        setCenter(flowPane);

        BorderPane.setAlignment(TICTACTOE, javafx.geometry.Pos.CENTER);
        TICTACTOE.setFitHeight(60.0);
        TICTACTOE.setFitWidth(318.0);
        TICTACTOE.setPickOnBounds(true);
        TICTACTOE.setPreserveRatio(true);
        TICTACTOE.setImage(new Image(getClass().getResource("/assets/Group9.png").toExternalForm()));
        BorderPane.setMargin(TICTACTOE, new Insets(20.0, 0.0, 0.0, 0.0));
        setTop(TICTACTOE);

        BorderPane.setAlignment(btnOnline, javafx.geometry.Pos.CENTER);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(31.0);
        btnOnline.setPrefWidth(73.0);
        btnOnline.setText("Online");
        BorderPane.setMargin(btnOnline, new Insets(80.0, 40.0, 100.0, 0.0));
        setRight(btnOnline);

        BorderPane.setAlignment(btnLocal, javafx.geometry.Pos.TOP_RIGHT);
        btnLocal.setMnemonicParsing(false);
        btnLocal.setPrefHeight(31.0);
        btnLocal.setPrefWidth(73.0);
        btnLocal.setText("Local");
        BorderPane.setMargin(btnLocal, new Insets(110.0, 0.0, 0.0, 28.0));
        setLeft(btnLocal);

        btnLocal.setOnAction((e) -> {
            Parent pane = new PlayingScreenDemo(stage);
            stage.getScene().setRoot(pane);
        });

        btnOnline.setOnAction(e -> {
            //to solve (java.lang.IllegalStateException: Not on FX application thread)indicates that you're attempting to 
            //update the JavaFX scene graph from a thread other than the JavaFX Application
            //Thread.All JavaFX UI operations should be performed on the JavaFX Application Thread To fix this issue, 
            //you need to use the Platform.runLater() method to execute the UI - related code on the JavaFX Application Thread.
            class RecordPageMain extends Application {

                @Override
                public void start(Stage stage) throws Exception {
                    Parent root = FXMLLoader.load(getClass().getResource("record.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
                    stage.setScene(scene);
                    stage.show();
                }
            }
            // Create a new thread to launch the new application
            Thread recordPageThread = new Thread(() -> {
                try {
                    // Launch the RecordPageMain application
                    Platform.runLater(() -> {
                        try {// it is better to make inner class
                            new RecordPageMain().start(stage); // 'stage' is my existing stage  
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace(); // Handle the exception according to your needs
                }
            });
            // Start the thread
            recordPageThread.start();
        });
        BorderPane.setAlignment(btnComputer, javafx.geometry.Pos.CENTER);
        btnComputer.setMnemonicParsing(false);
        btnComputer.setPrefHeight(30.0);
        btnComputer.setPrefWidth(120.0);
        btnComputer.setText("Computer");
        BorderPane.setMargin(btnComputer, new Insets(0.0, 0.0, 35.0, 25.0));
        setBottom(btnComputer);
        flowPane.getChildren().add(XphotoMain);
        btnComputer.getStyleClass().add("btnMainScreeen");
        btnLocal.getStyleClass().add("btnMainScreeen");
        btnOnline.getStyleClass().add("btnMainScreeen");

    }
}
