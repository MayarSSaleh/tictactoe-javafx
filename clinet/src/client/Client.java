
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
        //Parent root = new FXMLDocumentBase();
       // Parent root = new PlayingScreenDemo(stage , "online");
//        Parent root = new PlayingScreenDemo(stage , "online");
         // Parent root = new PlayingScreenDemo(stage , "local");
       // Parent root = new FXMLDocumentBase();
//        ClintSide c= new ClintSide();
//       c.start();

       // Parent root =new Profile();

      Parent root =new SignUpUi(stage);
//        Parent root =new Profile();

//       Parent root =new LoginUi(stage);



//       Parent root = new LoginUi(stage);    

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}



