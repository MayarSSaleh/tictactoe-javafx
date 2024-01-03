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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import video.Video;

public class AlertBox {

        private MediaView mediaView;
        private MediaPlayer mediaPlayer;

    public void display(String title, String message ,String image , Stage stage , String crown ,String video) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(1000);
        window.setWidth(700);
        window.setHeight(600);

        // Create an ImageView for the background image (Star asset image)
        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream(image)));
        backgroundImage.setFitWidth(100); // Set the width of the background image
        backgroundImage.setFitHeight(100); // Set the height of the background image

        // Create an ImageView for the small image
        ImageView smallImage = new ImageView(new Image(getClass().getResourceAsStream(crown)));
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

        Button closeButton = new Button("play");
        closeButton.getStyleClass().add("btn2");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                window.close();
                mediaPlayer.stop();
            }
        });

        Button stopButton = new Button("cancel");
//                closeButton.setOnAction((e) ->
//                 Parent pane = new mainScreen(stage);
//            stage.getScene().setRoot(pane);
//                );
stopButton.setOnAction((e)->{
        Parent pane = new MainScreen(stage);
           stage.getScene().setRoot(pane);
           mediaPlayer.stop();
           window.close();
});

        stopButton.getStyleClass().add("btn-stop");

        HBox buttonBox = new HBox(10); // Horizontal box for the buttons
        buttonBox.setAlignment(Pos.CENTER); // Center the buttons horizontally
        buttonBox.getChildren().addAll(closeButton, stopButton);

           mediaPlayer = new MediaPlayer(new Media(getClass().getResource(video).toExternalForm()));
           mediaView = new MediaView(mediaPlayer);
         mediaView.setFitWidth(300);
        mediaView.setFitHeight(300);
                   VBox mediaBox = new VBox(10);
                   mediaBox.setAlignment(Pos.CENTER); // Center the images horizontally
        mediaBox.getChildren().addAll(mediaView);
        VBox.setMargin(mediaView, new Insets(-10, 0, 0, 0));
           //mediaPlayer.setAutoPlay(true);
           //mediaView.st
           mediaPlayer.play();


        VBox layout = new VBox(20); // Vertical box
        layout.getStyleClass().add("alert-box");
        layout.getChildren().addAll(imageBox,mediaBox, label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();
        
        
        



        
    }
}


//import client.MainScreen;
//import javafx.application.Platform;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//public class AlertBox {
//
//    private MediaView mediaView;
//    private MediaPlayer mediaPlayer;
//
//    public void display(String title, String message, String image, Stage stage) {
//        
//        playVideo();
//        Stage window = new Stage();
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle(title);
//        window.setMaxWidth(1000);
//        window.setWidth(1000);
//        window.setHeight(700);
//
//        ImageView backgroundImage = new ImageView(new Image(getClass().getResourceAsStream(image)));
//        backgroundImage.setFitWidth(100);
//        backgroundImage.setFitHeight(100);
//
//        ImageView smallImage = new ImageView(new Image(getClass().getResourceAsStream("/assets/crown.png")));
//        smallImage.setFitWidth(50);
//        smallImage.setFitHeight(50);
//
//        VBox imageBox = new VBox(10);
//        imageBox.setAlignment(Pos.CENTER);
//        imageBox.getChildren().addAll(smallImage, backgroundImage);
//        VBox.setMargin(smallImage, new Insets(-10, 0, 0, 0));
//
//        Label label = new Label();
//        label.setText(message);
//        label.getStyleClass().add("alert-label");
//
//        Button closeButton = new Button("Play");
//        closeButton.getStyleClass().add("btn2");
//        closeButton.setOnAction(e -> {
//            stopVideo();
//            window.close();
//        });
//
//        Button stopButton = new Button("Cancel");
//        stopButton.getStyleClass().add("btn-stop");
//        stopButton.setOnAction(e -> {
//            Parent pane = new MainScreen(stage);
//            stage.getScene().setRoot(pane);
//                       // stopVideo();
//            window.close();
//        });
//
//        HBox buttonBox = new HBox(10);
//        buttonBox.setAlignment(Pos.CENTER);
//        buttonBox.getChildren().addAll(closeButton, stopButton);
//
//        mediaView = new MediaView();
//        mediaView.setFitWidth(600);
//        mediaView.setFitHeight(400);
//
//        VBox video = new VBox(20);
//        video.getChildren().add(mediaView);
//
//        VBox layout = new VBox(20);
//        layout.getStyleClass().add("alert-box");
//        layout.getChildren().addAll(imageBox, label, buttonBox, video);
//        layout.setAlignment(Pos.CENTER);
//
//        Scene scene = new Scene(layout);
//        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());
//
//        window.setScene(scene);
//        window.showAndWait();
//    }
//
//    private void playVideo() {
//        if (mediaPlayer == null) {
//            mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/assets/t.mp4").toExternalForm()));
//            mediaView.setMediaPlayer(mediaPlayer);
//            mediaPlayer.setOnError(() -> System.out.println("Media error: " + mediaPlayer.getError()));
//        }
//
//        mediaPlayer.setAutoPlay(true);
//    }
//    
//    private void stopVideo() {
//    if (mediaPlayer != null) {
//        mediaPlayer.stop();
//    }
//}
//}
