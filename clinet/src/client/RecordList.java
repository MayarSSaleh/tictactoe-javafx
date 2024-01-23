package client;

import com.google.gson.Gson;
import conn.ClintSide;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.RequestDTO;
import model.UsersDTO;

public class RecordList extends AnchorPane {

    protected final Button btnWatch;
    protected final Label txtYourRecordedGames;
    protected final Button btnExit;
    protected final ImageView ImageTICTACTOE;
    protected final ListView<String> listRecord;

    protected ArrayList<String> listRecordsFromDB;

    Record chossedRecord = new Record();

    public RecordList(Stage stage) {

        stage.setTitle("Your Recorded Games List");

        btnWatch = new Button();
        txtYourRecordedGames = new Label();
        btnExit = new Button();
        ImageTICTACTOE = new ImageView();
        listRecord = new ListView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        txtYourRecordedGames.setLayoutX(14.0);
        txtYourRecordedGames.setLayoutY(79.0);
        txtYourRecordedGames.setPrefHeight(32.0);
        txtYourRecordedGames.setPrefWidth(246.0);
        txtYourRecordedGames.setText("Your Recorded Games:");
        txtYourRecordedGames.setTextFill(javafx.scene.paint.Color.valueOf("#ebd7d7"));
        txtYourRecordedGames.setFont(new Font(22.0));

        btnWatch.setLayoutX(487.0);
        btnWatch.setLayoutY(137.0);
        btnWatch.setMnemonicParsing(false);
        btnWatch.setPrefHeight(30.0);
        btnWatch.setPrefWidth(99.0);
        btnWatch.setText("Watch");

        btnExit.setLayoutX(487.0);
        btnExit.setLayoutY(348.0);
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(30.0);
        btnExit.setPrefWidth(99.0);
        btnExit.setText("Exit");
        btnExit.setFont(new Font(15.0));

        ImageTICTACTOE.setFitHeight(53.0);
        ImageTICTACTOE.setFitWidth(298.0);
        ImageTICTACTOE.setLayoutX(152.0);
        ImageTICTACTOE.setLayoutY(18.0);
        ImageTICTACTOE.setPickOnBounds(true);
        ImageTICTACTOE.setPreserveRatio(true);
        ImageTICTACTOE.setImage(new Image(getClass().getResource("Group9_1.png").toExternalForm()));

        listRecord.setLayoutX(90.0);
        listRecord.setLayoutY(123.0);
        listRecord.setPrefHeight(232.0);
        listRecord.setPrefWidth(341.0);
        getChildren().add(btnWatch);
        getChildren().add(txtYourRecordedGames);
        getChildren().add(btnExit);
        getChildren().add(ImageTICTACTOE);
        getChildren().add(listRecord);
        btnExit.getStyleClass().add("btnMainScreeen");
        btnWatch.getStyleClass().add("btnMainScreeen");

        RequestDTO requestRecord = new RequestDTO();
        requestRecord.setRoute("getRecords");
        requestRecord.setEmail(LoginUi.player1Email);
        Gson json = new Gson();
        ClintSide.printedMessageToServer.println(json.toJson(requestRecord));
        ClintSide.printedMessageToServer.flush();
        try {
            String response = ClintSide.listenFromServer.readLine();
            System.out.println(response);
            RequestDTO recived = json.fromJson(response, RequestDTO.class);
            listRecordsFromDB = recived.getAllRecords();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("testing add record");

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Record/ currentRecord date: " + Playinglocal.newRecord.getCurrentDate());

        String dates = date.format(Playinglocal.newRecord.getCurrentDate());
        System.out.println("dateString " + dates);

        listRecord.getItems().add(dates);

//                convert it to json individual and  show time
        for (String StringRecord : listRecordsFromDB) {

            System.out.println("inside enchanced loop of listRecord From DB");
            RequestDTO recived = json.fromJson(StringRecord, RequestDTO.class);

            Record currentRecord = json.fromJson(recived.getRecord(), Record.class);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Record/ currentRecord date: " + currentRecord.getCurrentDate());

            String dateString = dateFormat.format(currentRecord.getCurrentDate());
            System.out.println("dateString " + dateString);

            listRecord.getItems().add(dateString);

        }

//        String recordDate = listRecordsFromDB(0).get;
        btnExit.setOnAction((e) -> {
            Parent pane = new MainScreen(stage);
            stage.getScene().setRoot(pane);

        });
        btnWatch.setOnAction(e -> {
            String selectedRecord = listRecord.getSelectionModel().getSelectedItem();
            for (String StringRecord : listRecordsFromDB) {

                System.out.println("inside enchanced loop of listRecord From DB");
                RequestDTO recived = json.fromJson(StringRecord, RequestDTO.class);

                Record currentRecord = json.fromJson(recived.getRecord(), Record.class);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("Record/ currentRecord date: " + currentRecord.getCurrentDate());

                String dateString = dateFormat.format(currentRecord.getCurrentDate());
                System.out.println("dateString: " + dateString);

                if (selectedRecord.equals(dateString)) {
                    System.out.println("Selected Record: " + selectedRecord);
                    PlayingOnlineDemo.replayTheGame(currentRecord);

                } else {
                    System.out.println("No item selected");
                }
            }
        });

    }
}
