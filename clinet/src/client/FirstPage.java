package client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public  class FirstPage extends AnchorPane {

    protected final Button buttWatch;
    protected final Label label;
    protected final Button buttPlay;
    protected final ImageView imageTic;

    public FirstPage( Stage stage) {

        buttWatch = new Button();
        label = new Label();
        buttPlay = new Button();
        imageTic = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        buttWatch.setLayoutX(327.0);
        buttWatch.setLayoutY(240.0);
//        buttWatch.setOnAction(this::handleButtonAction);
        buttWatch.setPrefHeight(40.0);
        buttWatch.setPrefWidth(150.0);
        buttWatch.setText("Watch My Records");

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        buttPlay.setLayoutX(150.0);
        buttPlay.setLayoutY(240.0);
        buttPlay.setPrefHeight(40.0);
        buttPlay.setPrefWidth(140.0);
        buttPlay.setText("Play New Game");

        imageTic.setFitHeight(133.0);
        imageTic.setFitWidth(449.0);
        imageTic.setLayoutX(76.0);
        imageTic.setLayoutY(97.0);
        imageTic.setPickOnBounds(true);
        imageTic.setPreserveRatio(true);
        imageTic.setImage(new Image(getClass().getResource("Group9_1.png").toExternalForm()));

        getChildren().add(buttWatch);
        getChildren().add(label);
        getChildren().add(buttPlay);
        getChildren().add(imageTic);
        
        
        buttPlay.getStyleClass().add("btnMainScreeen");
        buttWatch.getStyleClass().add("btnMainScreeen");
        
        buttPlay.setOnAction((e) -> {
            Parent pane = new MainScreen(stage);
            stage.getScene().setRoot(pane);
        });    
        
        buttWatch.setOnAction((e) -> {
       Parent pane = new RecordList(stage);
            stage.getScene().setRoot(pane);
        });  
           //to solve (java.lang.IllegalStateException: Not on FX application thread)indicates that you're attempting to 
            //update the JavaFX scene graph from a thread other than the JavaFX Application
            //Thread.All JavaFX UI operations should be performed on the JavaFX Application Thread To fix this issue, 
            //you need to use the Platform.runLater() method to execute the UI - related code on the JavaFX Application Thread.
//            class RecordPageMain extends Application {
//
//                @Override
//                public void start(Stage stage) throws Exception {
//                    Parent root = FXMLLoader.load(getClass().getResource("record.fxml"));
//                    Scene scene = new Scene(root);
//                    scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
//                    stage.setScene(scene);
//                    stage.show();
//                }
//            }
//            // Create a new thread to launch the new application
//            Thread recordPageThread = new Thread(() -> {
//                try {
//                    // Launch the RecordPageMain application
//                    Platform.runLater(() -> {
//                        try {// it is better to make inner class
//                            new RecordPageMain().start(stage); // 'stage' is my existing stage  
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    });
//                } catch (Exception ex) {
//                    ex.printStackTrace(); // Handle the exception according to your needs
//                }
//            });
//            // Start the thread
//            recordPageThread.start();
//        });
//     

    }

 

}
