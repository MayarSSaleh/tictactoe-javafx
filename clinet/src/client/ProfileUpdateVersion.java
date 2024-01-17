package client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ProfileUpdateVersion extends BorderPane {

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
    protected final Button btnRecords;
    protected final HBox hBox5;
    protected final Button btnExit;
    protected final VBox inviteList;
    protected final ListView <String> listOnline;

    public ProfileUpdateVersion() {

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
        btnRecords = new Button();
        hBox5 = new HBox();
        btnExit = new Button();
        inviteList = new VBox();
        listOnline = new ListView();

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
        recProfileImg.setHeight(73.0);
        recProfileImg.setStroke(javafx.scene.paint.Color.BLACK);
        recProfileImg.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        recProfileImg.setWidth(126.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        label.setPrefHeight(20.0);
        label.setPrefWidth(90.0);
        label.setText("User Name : ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(14.0));

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

        txtScore.setStyle("-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: white;");
        txtScore.setFont(new Font(14.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        hBox4.setAlignment(javafx.geometry.Pos.CENTER);
        hBox4.setPrefHeight(100.0);
        hBox4.setPrefWidth(200.0);

        btnRecords.setMnemonicParsing(false);
//        btnRecords.setOnAction(this::viewRecords);
        btnRecords.setText("Records");
        btnRecords.setTextFill(javafx.scene.paint.Color.valueOf("#fffcfc"));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER);
        hBox5.setPrefHeight(100.0);
        hBox5.setPrefWidth(200.0);

        btnExit.setMnemonicParsing(false);
//        btnExit.setOnAction(this::HandleExit);
        btnExit.setPrefHeight(30.0);
        btnExit.setPrefWidth(57.0);
        btnExit.setText("Exit");
        btnExit.setTextFill(javafx.scene.paint.Color.WHITE);
        vBox.setPadding(new Insets(10.0));

        inviteList.setAlignment(javafx.geometry.Pos.CENTER);
        inviteList.setPrefHeight(317.0);
        inviteList.setPrefWidth(287.0);

        listOnline.setPrefHeight(302.0);
        listOnline.setPrefWidth(271.0);    
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
        hBox4.getChildren().add(btnRecords);
        hBox3.getChildren().add(hBox4);
        hBox5.getChildren().add(btnExit);
        hBox3.getChildren().add(hBox5);
        vBox.getChildren().add(hBox3);
        hBox.getChildren().add(vBox);
        inviteList.getChildren().add(listOnline);
        hBox.getChildren().add(inviteList);
        
        //enter the profile , so request show the online user

    }
    

}
