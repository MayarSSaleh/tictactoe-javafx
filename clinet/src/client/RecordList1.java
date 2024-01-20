package client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class RecordList1 extends AnchorPane {

    protected final Button btnWatch;
    protected final Label txtYourRecordedGames;
    protected final Button btnExit;
    protected final ImageView ImageTICTACTOE;
    protected final ListView<String> listRecord;

    public RecordList1(Stage stage) {

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

        String[] records = {"Record date: 12/1/2024", "Record date: 1/1/2024", "Record date: 12/12/2023",
            "Record date: 30/5/2023", "Record date: 30/5/2023"};
//              System.out.println(newRecord.getCurrentDate());
//            System.out.println("current time " + newRecord.getCurrentTime());

        List<Record> loadedRecords = XmlUtil.loadObjectsFromXml("src/jaxb/Records.xml");
        if (loadedRecords != null) {
            for (Record record : loadedRecords) {
                
                System.out.println("current date: " + record.getCurrentDate());
                System.out.println("current time " + record.getCurrentTime());
            }
        }
        
        
        
        listRecord.getItems().addAll(records);

        
        btnExit.setOnAction((e) -> {
            Parent pane = new MainScreen(stage);
            stage.getScene().setRoot(pane);

        });
        btnWatch.setOnAction(e -> {
//            String selectedRecord = listRecord.getSelectionModel().getSelectedItem();
//            if (selectedRecord != null) {
//                System.out.println("Selected Record: " + selectedRecord);
////                Parent pane = new PlayingScreenDemo(stage, "ReplayGame", newRecord);
////                stage.getScene().setRoot(pane);
//
//            } else {
//                System.out.println("No item selected");
//            }
//            
            
        if (loadedRecords != null) {
            for (Record record : loadedRecords) {
                
                System.out.println("current date: " + record.getCurrentDate());
                System.out.println("current time " + record.getCurrentTime());
            }
        }
        });

    }
}
