package client;

import com.google.gson.Gson;
import conn.ClintSide;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.RequestDTO;
import model.UsersDTO;

public class Profile extends BorderPane {

    protected final Rectangle recLogo;
    protected final HBox hBox;
    protected final VBox vBox;
    protected final Rectangle recProfileImg;
    protected final HBox hBox0;
    protected final Label label;
    protected final TextField txtuser;
    protected final HBox hBox1;
    protected final Label label0;
    protected final TextField txtEmail;
    protected final HBox hBox2;
    protected final Label label1;
    protected final TextField txtScore;
    protected final HBox hBox3;
    protected final HBox hBox4;
//    protected final Button btnRecords;
    protected final HBox hBox5;
    protected final Button btnExit;
    protected final VBox inviteList;
    protected final ScrollPane scrollPane;
    protected final VBox inviteList0;
    protected final Image profileImg;
    protected final Image logo;
    protected ArrayList<UsersDTO> availablePlayersList;
    static String player2Email;

    public Profile(String userName, String email, int score, Stage stage) {

        recLogo = new Rectangle();
        hBox = new HBox();
        vBox = new VBox();
        recProfileImg = new Rectangle();
        hBox0 = new HBox();
        label = new Label();
        txtuser = new TextField();
        hBox1 = new HBox();
        label0 = new Label();
        txtEmail = new TextField();
        hBox2 = new HBox();
        label1 = new Label();
        txtScore = new TextField();
        hBox3 = new HBox();
        hBox4 = new HBox();
//        btnRecords = new Button();
        hBox5 = new HBox();
        btnExit = new Button();
        inviteList = new VBox();
        scrollPane = new ScrollPane();
        inviteList0 = new VBox();
        logo = new Image("/assets/Group9.png");
        profileImg = new Image("/assets/Starasset.png");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: black;");

        BorderPane.setAlignment(recLogo, javafx.geometry.Pos.CENTER);
        recLogo.setArcHeight(5.0);
        recLogo.setArcWidth(5.0);
        recLogo.setFill(javafx.scene.paint.Color.DODGERBLUE);
        recLogo.setHeight(83.0);
        recLogo.setStroke(javafx.scene.paint.Color.BLACK);
        recLogo.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        recLogo.setWidth(315.0);
        recLogo.setFill(new ImagePattern(logo));
        setTop(recLogo);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(317.0);
        vBox.setPrefWidth(345.0);

        recProfileImg.setArcHeight(5.0);
        recProfileImg.setArcWidth(5.0);
        recProfileImg.setFill(javafx.scene.paint.Color.DODGERBLUE);
        recProfileImg.setHeight(100.0);
        recProfileImg.setStroke(javafx.scene.paint.Color.BLACK);
        recProfileImg.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        recProfileImg.setWidth(100.0);
        recProfileImg.setFill(new ImagePattern(profileImg));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        label.setPrefHeight(20.0);
        label.setPrefWidth(90.0);
        label.setText("User Name : ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(14.0));

        txtuser.setEditable(false);
        txtuser.setText(userName);
        txtuser.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: white;");
        txtuser.setFont(new Font(14.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        label0.setPrefHeight(20.0);
        label0.setPrefWidth(90.0);
        label0.setText("Email : ");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(14.0));

        txtEmail.setEditable(false);
        txtEmail.setText(email);
        txtEmail.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: white;");
        txtEmail.setFont(new Font(14.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(200.0);

        label1.setPrefHeight(20.0);
        label1.setPrefWidth(90.0);
        label1.setText("Score : ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(14.0));

        txtScore.setEditable(false);
        txtScore.setText(String.valueOf(score));
        txtScore.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: white;");
        txtScore.setFont(new Font(14.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        hBox4.setAlignment(javafx.geometry.Pos.CENTER);
        hBox4.setPrefHeight(100.0);
        hBox4.setPrefWidth(200.0);

        hBox5.setAlignment(javafx.geometry.Pos.CENTER);
        hBox5.setPrefHeight(100.0);
        hBox5.setPrefWidth(200.0);

        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(30.0);
        btnExit.setPrefWidth(57.0);
        btnExit.setText("Exit");
        btnExit.setTextFill(javafx.scene.paint.Color.WHITE);
        btnExit.getStyleClass().add("btn2");
        btnExit.setOnAction(e -> {
            Parent pane = new MainScreen(stage);
            stage.getScene().setRoot(pane);

        });

        vBox.setPadding(new Insets(10.0));

        inviteList.setAlignment(javafx.geometry.Pos.CENTER);
        inviteList.setPrefHeight(317.0);
        inviteList.setPrefWidth(287.0);

        scrollPane.setPrefHeight(316.0);
        scrollPane.setPrefWidth(271.0);
        scrollPane.setStyle("-fx-background-color: black;");

        inviteList0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        inviteList0.setPrefHeight(315.0);
        inviteList0.setPrefWidth(255.0);
        inviteList0.setStyle("-fx-background-color: black;");
        inviteList0.setPadding(new Insets(10.0));
        scrollPane.setContent(inviteList0);
        setCenter(hBox);

        vBox.getChildren().add(recProfileImg);
        hBox0.getChildren().add(label);
        hBox0.getChildren().add(txtuser);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(label0);
        hBox1.getChildren().add(txtEmail);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(label1);
        hBox2.getChildren().add(txtScore);
        vBox.getChildren().add(hBox2);
//        hBox4.getChildren().add(btnRecords);
        hBox3.getChildren().add(hBox4);
        hBox5.getChildren().add(btnExit);
        hBox3.getChildren().add(hBox5);
        vBox.getChildren().add(hBox3);
        hBox.getChildren().add(vBox);
        inviteList.getChildren().add(scrollPane);
        hBox.getChildren().add(inviteList);

        RequestDTO requestAviable = new RequestDTO();
        requestAviable.setRoute("getAvialblePlayers");
        Gson json = new Gson();
        ClintSide.printedMessageToServer.println(json.toJson(requestAviable));
        ClintSide.printedMessageToServer.flush();
// to show avialble player in cards
        try {
            String response = ClintSide.listenFromServer.readLine();
//            System.out.println(response);
            RequestDTO recived = json.fromJson(response, RequestDTO.class);
            availablePlayersList = recived.getAvailablePlayers();
            for (UsersDTO avilablePlayer : availablePlayersList) {
//       the following if condition to remove the user from aviable list
                if (!userName.equals(avilablePlayer.getUserName())) {
                    Cards card = new Cards(userName, email, score,
                            avilablePlayer.getUserName(), avilablePlayer.getEmail(), avilablePlayer.getScore(), stage);
//                    System.out.println(userName + email + score + avilablePlayer.getUserName() +
//                            avilablePlayer.getEmail() + avilablePlayer.getScore());
                    VBox.setMargin(card, new Insets(5.0, 0.0, 5.0, 0.0));
                    inviteList0.getChildren().add(card);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        threadWork(stage, json);
    }

    public static void threadWork(Stage stage, Gson json) {
        new Thread(() -> {
            try {
                String response = ClintSide.listenFromServer.readLine();
                System.out.println(response);
                RequestDTO recived = json.fromJson(response, RequestDTO.class);
                switch (recived.getRoute()) {
                    case "youGetInvetation":
//                        System.out.println("i get invetation");
                        Platform.runLater(() -> {
                            new AlertBox().onlineAcceptanceAlert(recived, stage);
                        });
                        break;
                    case "youGetResponeOnInvetation":
                        System.out.println("i get responseOnInvetation in profile");
                        if (recived.isInvitationRespons()) {
                            System.out.println("i get responseOnInvetation by yes");
                            
                            
                            player2Email = recived.getSendInvetationToEmail();
                            
                            
                            Platform.runLater(() -> {

                                new AlertBox().onlineChooseTypeAlert("Choose X or O",
                                        stage, " player2", player2Email, 5);
                                
                                
                                //  Parent pane = new PlayingScreenDemo(stage);
                                //  stage.getScene().setRoot(pane);

                            }
                            );
                        } else {
                            Platform.runLater(() -> {
                                new AlertBox().onlineWaitingAlert("Invitation Response", "Sorry the invitation not accepted, let's player with another one", stage);
                            });
                            System.out.println("i get responseOnInvetation by no");
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Invitation Response");
                            alert.setHeaderText("");
                            alert.getDialogPane().setPrefWidth(650);
                            alert.getDialogPane().setPrefHeight(450);
                            alert.setContentText("Sorry the invitation not accepted, let's player with another one");
//                            alert.showAndWait();

                        }
                        break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

}
