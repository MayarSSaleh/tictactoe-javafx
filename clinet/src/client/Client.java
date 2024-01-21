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
//        Parent root = new PlayingScreenDemo(stage , "online", new Record());
        Parent root = new MainScreen(stage);
//                Parent root = new RecordList1(stage);
//                     Parent root = new PlayingVsComputer(stage); 
        
//           Parent root = new FirstPage (stage);

//        Parent root = new Playinglocal(stage , "local",new Record());
       // Parent root = new FXMLDocumentBase();
//        Parent root = new MainScreen(stage);
       //Parent root =new SignUpUi();
//        Parent root =new Profile();

//                Parent root = new RecordList(stage);

       

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}



