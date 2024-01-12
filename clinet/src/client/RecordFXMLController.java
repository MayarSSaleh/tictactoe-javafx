package client;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RecordFXMLController implements Initializable {

    
   @FXML
    private Button btnplayNewGame;
//   @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    @FXML
    private ListView<String> listRecord;
    String[] records = {"Record date: 12/1/2024", "Record date: 1/1/2024", "Record date: 12/12/2023",
        "Record date: 30/5/2023", "Record date: 12/1/2024", "Record date: 1/1/2024", "Record date: 12/12/2023", "Record date: 30/5/2023",
        "Record date: 12/1/2024", "Record date: 1/1/2024", "Record date: 12/12/2023", "Record date: 30/5/2023"};
    String currentRecordDate;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        listRecord.getItems().addAll(records);
        listRecord.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentRecordDate = listRecord.getSelectionModel().getSelectedItem();
                // the logic of redirection
//                if currentRecordDate ==....
            }
        });
    }
}
