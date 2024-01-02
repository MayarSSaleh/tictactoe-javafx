/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import video.Video;

public class AlertBox {

    

    public void display(String title, String message ,String image) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(1000);
        window.setWidth(700);
        window.setHeight(400);

        // Create an ImageView for the background image (Star asset image)
        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream(image)));
        backgroundImage.setFitWidth(100); // Set the width of the background image
        backgroundImage.setFitHeight(100); // Set the height of the background image

        // Create an ImageView for the small image
        ImageView smallImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/crown.png")));
        smallImage.setFitWidth(50); // Set the width of the small image
        smallImage.setFitHeight(50); // Set the height of the small image

        // Create a VBox to hold the small image above the background image
        VBox imageBox = new VBox(10);
        imageBox.setAlignment(Pos.CENTER); // Center the images horizontally
        imageBox.getChildren().addAll(smallImage, backgroundImage);
        VBox.setMargin(smallImage, new Insets(-10, 0, 0, 0)); // Set negative top margin to overlap images

        Label label = new Label();
        label.setText(message);
        label.getStyleClass().add("alert-label");

        Button closeButton = new Button("Close");
        closeButton.getStyleClass().add("btn2");
        closeButton.setOnAction(e -> window.close());

        Button stopButton = new Button("Stop");
        stopButton.getStyleClass().add("btn-stop");

        HBox buttonBox = new HBox(10); // Horizontal box for the buttons
        buttonBox.setAlignment(Pos.CENTER); // Center the buttons horizontally
        buttonBox.getChildren().addAll(closeButton, stopButton);

        VBox layout = new VBox(20); // Vertical box
        layout.getStyleClass().add("alert-box");
        layout.getChildren().addAll(imageBox, label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();
        
        
        
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

         

            }
        });
        
    }
}

