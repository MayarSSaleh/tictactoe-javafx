package client;

import static client.Profile.threadWork;
import com.google.gson.Gson;
import conn.ClintSide;
import javafx.application.Platform;
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
import model.RequestDTO;

public class AlertBox {

    private MediaView mediaView;
    private MediaPlayer mediaPlayer;

    public void display(String title, String message, String image, Stage stage, String crown, String video, String module) {
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
//                if (module.equals("local")) {
//                    Parent root = new Playinglocal(stage);
//                    stage.getScene().setRoot(root);
//                } else
                if (module.equals("computer")) {
                    Parent root = new PlayingVsComputer(stage);
                    stage.getScene().setRoot(root);

                }
                window.close();
                mediaPlayer.stop();
            }
        });

        Button stopButton = new Button("cancel");
//                closeButton.setOnAction((e) ->
//                 Parent pane = new mainScreen(stage);
//            stage.getScene().setRoot(pane);
//                );
        stopButton.setOnAction((e) -> {
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
        layout.getChildren().addAll(imageBox, mediaBox, label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();

    }

    public void onlineDisplay(String title, String message, String image, Stage stage, String crown, String video,
            String userName, String email, int score) {
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
                Parent pane = new Profile(userName, email, score, stage);
                stage.getScene().setRoot(pane);
                mediaPlayer.stop();
                window.close();

            }
        });

        Button stopButton = new Button("cancel");
//                closeButton.setOnAction((e) ->
//                 Parent pane = new mainScreen(stage);
//            stage.getScene().setRoot(pane);
//                );
        stopButton.setOnAction((e) -> {
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
        layout.getChildren().addAll(imageBox, mediaBox, label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();

    }

    public void onlineWaitingAlert(String title, String message, Stage stage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(400);
        window.setWidth(300);
        window.setHeight(200);

        Label label = new Label(message);
        label.getStyleClass().add("alert-label");

        VBox layout = new VBox(20);
        layout.getStyleClass().add("alert-box");
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();
    }

    public void onlineAcceptanceAlert(RequestDTO recived, Stage stage) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("You Invited to playing X,O");
        window.setWidth(450);
        window.setHeight(250);
        Label label = new Label("let's start new Game with " + recived.getPlayerWhoSendInvetationName() + " His Score: " + recived.getPlayerWhoSendInvetationScore());
        label.getStyleClass().add("alert-label");

        Button yesButton = new Button("Yes");
        yesButton.getStyleClass().add("btn-stop");
        yesButton.setOnAction(e -> {
            try {
//               System.out.print("inside yes to invetation");
                recived.setInvitationRespons(true);
                recived.setRoute("responeOnInvetation");
                Gson json = new Gson();
                //franko:  convert to gson and sent al taer
                ClintSide.printedMessageToServer.println(json.toJson(recived));
                ClintSide.printedMessageToServer.flush();

                window.close();
//                System.out.print("inside yes to invetation and after close window");
                Parent pane = new PlayingScreenDemo(stage, "online", "");
                stage.getScene().setRoot(pane);
//                System.out.print("inside yes to invetation and after shifiting to stage");
            } catch (Exception ex) {
                ex.printStackTrace(); // Handle or log the exception appropriately
            }
        });

        Button noButton = new Button("No");

        noButton.setOnAction(e -> {

            recived.setInvitationRespons(false);
            recived.setRoute("responeOnInvetation");
            Gson json = new Gson();
            // franko:  convert to gson and sent al taer
            ClintSide.printedMessageToServer.println(json.toJson(recived));
            ClintSide.printedMessageToServer.flush();
            threadWork(stage, json);

            window.close();
        });
        noButton.getStyleClass().add("btn-stop");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(yesButton, noButton);

        VBox layout = new VBox(20);
        layout.getStyleClass().add("alert-box");
        layout.getChildren().addAll(label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();
    }

    public void onlineChooseTypeAlert(String title, Stage stage, String userName, String email, int score) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(400);
        window.setWidth(300);
        window.setHeight(200);

        Label label = new Label("Choose ");
        label.getStyleClass().add("alert-label");

        Button yesButton = new Button("X");
        yesButton.setOnAction(e -> {
            // Handle Yes button action
            Parent pane = new PlayingOnlineDemo(stage, userName, email, score, 'X');

            stage.getScene().setRoot(pane);
            window.close();
        });
        yesButton.getStyleClass().add("btn-stop");

        Button noButton = new Button("O");
        noButton.setOnAction(e -> {
            // Handle No button action

            Parent pane = new PlayingOnlineDemo(stage, userName, email, score, 'O');

            stage.getScene().setRoot(pane);
            window.close();
            // Add your logic here
        });
        noButton.getStyleClass().add("btn-stop");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(yesButton, noButton);

        VBox layout = new VBox(20);
        layout.getStyleClass().add("alert-box");
        layout.getChildren().addAll(label, buttonBox);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/styles/alert.css").toExternalForm());

        window.setScene(scene);
        window.showAndWait();
    }
}
