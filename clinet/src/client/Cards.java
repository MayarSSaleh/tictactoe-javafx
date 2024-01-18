package client;

import com.google.gson.Gson;
import conn.ClintSide;
import java.io.IOException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.RequestDTO;

public class Cards extends HBox {

    protected final VBox vBox;
    protected final Label lblName;
    protected final Label lblScore;
    protected final Button btnInvite;

    public Cards(String playerName, int score, Stage stage, String invertingName, int invertingScore) {

        vBox = new VBox();
        lblName = new Label();
        lblScore = new Label();
        btnInvite = new Button();

        setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        setMaxHeight(50.0);
        setPrefHeight(50.0);
        setPrefWidth(280.0);
        setStyle("-fx-background-color: white; -fx-background-radius: 10;");
        setPadding(new Insets(10.0));

        vBox.setPrefHeight(37.0);
        vBox.setPrefWidth(121.0);

        lblName.setPrefHeight(17.0);
        lblName.setPrefWidth(102.0);
        lblName.setText(playerName);
        lblName.setFont(new Font(14.0));

        lblScore.setPrefHeight(17.0);
        lblScore.setPrefWidth(100.0);
        lblScore.setText("Score : " + score);
        lblScore.setFont(new Font(14.0));

        btnInvite.setMinHeight(30.0);
        btnInvite.setMinWidth(80.0);
        btnInvite.setMnemonicParsing(false);
        btnInvite.setStyle("    -fx-background-color: orange;\n"
                + "    -fx-text-fill: white;\n"
                + "    -fx-border-color: orange;\n"
                + "    -fx-border-radius: 5px;\n"
                + "    -fx-padding: 10px 15px;\n"
                + "    -fx-font-size: 14px;");

        btnInvite.setText("Invite");
        btnInvite.setTextFill(javafx.scene.paint.Color.WHITE);
        btnInvite.setOnAction((e) -> {

            RequestDTO requestSendInvetation = new RequestDTO();
            requestSendInvetation.setRoute("sendInvetation");
            requestSendInvetation.setInvetPlayer(playerName);
            requestSendInvetation.setUserName(invertingName);
            requestSendInvetation.setScore(invertingScore);

            Gson SendInvetation = new Gson();
            ClintSide.printedMessageToServer.println(SendInvetation.toJson(requestSendInvetation));
            ClintSide.printedMessageToServer.flush();

            new AlertBox().onlineWaitingAlert("Invetation", "Waiting Player response", stage);

        });
        HBox.setMargin(btnInvite, new Insets(0.0, 0.0, 0.0, 40.0));

        vBox.getChildren().add(lblName);
        vBox.getChildren().add(lblScore);
        getChildren().add(vBox);
        getChildren().add(btnInvite);

    }
}
