package server;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class ServerMainUI extends AnchorPane {
    
    protected final Circle circleImg;
    protected final Label lblTitle;
    protected final Button btnServer;
    protected final Button btnUsers;
    private boolean onRun = false;
    Image pause;
    Image start;
    Image hoverStart;
    Image hoverPause;
    
    public ServerMainUI() {
        
        circleImg = new Circle();
        lblTitle = new Label();
        btnServer = new Button();
        btnUsers = new Button();
        
        setId("AnchorPane");
        setPrefHeight(249.0);
        setPrefWidth(320);
        setStyle("-fx-background-color: black;");
        
        circleImg.setFill(javafx.scene.paint.Color.DODGERBLUE);
        circleImg.setLayoutX(161.0);
        circleImg.setLayoutY(125.0);
        circleImg.setRadius(70.0);
        circleImg.setStroke(javafx.scene.paint.Color.BLACK);
        circleImg.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        circleImg.setStrokeWidth(0.0);
        circleImg.getStyleClass().add("circle");
        start = new Image("/assets/img/start.png");
        pause = new Image("/assets/img/hoverPause.png");
        hoverStart = new Image("/assets/img/hoverStart.png");
        hoverPause = new Image("/assets/img/pause.png");
        
        circleImg.setFill(new ImagePattern(start));
        
        lblTitle.setAlignment(javafx.geometry.Pos.CENTER);
        lblTitle.setLayoutX(82.0);
        lblTitle.setLayoutY(14.0);
        lblTitle.setMinHeight(16);
        lblTitle.setMinWidth(69);
        lblTitle.setPrefHeight(46.0);
        lblTitle.setPrefWidth(157.0);
        lblTitle.setText("TIC TAC TOE");
        lblTitle.setTextFill(javafx.scene.paint.Color.WHITE);
        lblTitle.setFont(new Font("Roboto Bold", 20.0));
        
        btnServer.setLayoutX(106.0);
        btnServer.setLayoutY(70.0);
        btnServer.setMnemonicParsing(false);
        btnServer.setOnAction(this::handleButtonAction);
        btnServer.setOnMouseEntered(this::hoverOn);
        btnServer.setOnMouseMoved(this::mouseIn);
        btnServer.setOnMouseExited(this::hoverOut);
        btnServer.setOpacity(0.0);
        btnServer.setPrefHeight(110.0);
        btnServer.setPrefWidth(110.0);
        btnServer.setStyle("-fx-background-radius: 50%;");
        btnServer.getStyleClass().add("btn");
        
        btnUsers.setLayoutX(244.0);
        btnUsers.setLayoutY(204.0);
        btnUsers.setMnemonicParsing(false);
        btnUsers.setTextFill(javafx.scene.paint.Color.WHITE);
        btnUsers.setText("Users");
        btnUsers.getStyleClass().add("btnUsers");
        btnUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String label1 = "Online:";
                String value1 = "2";
                String label2 = "Offline:";
                String value2 = "4";
                String label3 = "Playing:";
                String value3 = "2";

                // Create a custom GridPane to hold labels and values
                GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(15);
                GridPane.setConstraints(gridPane, 50, 50);
                gridPane.getMaxHeight();
                
                // Add labels and values to the GridPane
                gridPane.add(new Label(label1), 0, 0);
                gridPane.add(new Label(value1), 1, 0);
                gridPane.add(new Label(label2), 0, 1);
                gridPane.add(new Label(value2), 1, 1);
                gridPane.add(new Label(label3), 0, 2);
                gridPane.add(new Label(value3), 1, 2);

                // Create an Alert with a custom content
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Players Status");
                alert.setHeaderText(null); // No header text
                // Set the custom GridPane as the content of the alert
                alert.getDialogPane().setContent(gridPane);

                // Show the alert
                alert.showAndWait();
                
            }
        });
        
        getChildren().add(circleImg);
        getChildren().add(lblTitle);
        getChildren().add(btnServer);
        getChildren().add(btnUsers);
        
        new Thread(() -> {
            ServerHandler s = new ServerHandler();
        }).start();
        
    }
    
    protected void handleButtonAction(javafx.event.ActionEvent actionEvent) {
        if (!onRun) {
            circleImg.setFill(new ImagePattern(pause));
            onRun = !onRun;
        } else {
            circleImg.setFill(new ImagePattern(start));
            onRun = !onRun;
        }
    }
    
    protected void hoverOn(javafx.scene.input.MouseEvent mouseEvent) {
        if (!onRun) {
            circleImg.setFill(new ImagePattern(hoverStart));
            
        } else {
            circleImg.setFill(new ImagePattern(hoverPause));
            
        }
        
    }
    
    protected void mouseIn(javafx.scene.input.MouseEvent mouseEvent) {
        if (!onRun) {
            circleImg.setFill(new ImagePattern(hoverStart));
            
        } else {
            circleImg.setFill(new ImagePattern(hoverPause));
            
        }
        
    }
    
    protected void hoverOut(javafx.scene.input.MouseEvent mouseEvent) {
        if (!onRun) {
            circleImg.setFill(new ImagePattern(start));
            
        } else {
            circleImg.setFill(new ImagePattern(pause));
            
        }
        
    }
    
}
