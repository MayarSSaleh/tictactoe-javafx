/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class Client extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = new FXMLDocumentBase();
        // Parent root = new PlayingScreenDemo(stage , "online");
//        Parent root = new PlayingScreenDemo(stage , "online");
        // Parent root = new PlayingScreenDemo(stage , "local");
        // Parent root = new FXMLDocumentBase();

//        Parent root = new MainScreen(stage);
//        ClintSide c= new ClintSide();
//       c.start();
        //Parent root =new LoginUi(stage);
        // Parent root =new Profile();
//        Parent root = new MainScreen(stage);
      //  Parent root = new SignUpUi(stage);
//        Parent root =new Profile();

        Parent root = new PlayingVsComputer(stage);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
