package client;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class GetInvetationn extends AnchorPane {

    protected final Rectangle RectBase;
    protected final Rectangle rectangle;
    protected final Button buttonPlay;
    protected final Button buttonNo;
    protected final Label labPlay;
    protected final ImageView ImageTICTACTOE;

    public GetInvetationn(Stage stage) {

        RectBase = new Rectangle();
        rectangle = new Rectangle();
        buttonPlay = new Button();
        buttonNo = new Button();
        labPlay = new Label();
        ImageTICTACTOE = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(500.0);

        RectBase.setArcHeight(5.0);
        RectBase.setArcWidth(5.0);
        RectBase.setFill(javafx.scene.paint.Color.valueOf("#FFFFFF"));
        RectBase.setHeight(220.0);
        RectBase.setLayoutX(150.0);
        RectBase.setLayoutY(105.0);
        RectBase.setStroke(javafx.scene.paint.Color.valueOf("#FFFFFF"));
        RectBase.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        RectBase.setWidth(267.0);

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#292a2c"));
        rectangle.setHeight(121.0);
        rectangle.setLayoutX(127.0);
        rectangle.setLayoutY(198.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(254.0);

        buttonPlay.setLayoutX(168.0);
        buttonPlay.setLayoutY(265.0);
        
//        buttonPlay.setOnAction(this::handleButtonAction);
        
        buttonPlay.setPrefHeight(25.0);
        buttonPlay.setPrefWidth(64.0);
        buttonPlay.setText("Play");
        buttonPlay.setFont(new Font(14.0));

        buttonNo.setLayoutX(270.0);
        buttonNo.setLayoutY(265.0);
//        buttonNo.setOnAction(this::handleButtonAction);
        buttonNo.setPrefHeight(25.0);
        buttonNo.setPrefWidth(64.0);
        buttonNo.setText("No");
        buttonNo.setFont(new Font(14.0));

        labPlay.setLayoutX(154.0);
        labPlay.setLayoutY(217.0);
        labPlay.setPrefHeight(27.0);
        labPlay.setPrefWidth(213.0);
        labPlay.setText("let's PLAY with Mohamed");
        labPlay.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        labPlay.setTextFill(javafx.scene.paint.Color.valueOf("#f2efef"));
        labPlay.setFont(new Font(18.0));

        ImageTICTACTOE.setFitHeight(45.0);
        ImageTICTACTOE.setFitWidth(213.0);
        ImageTICTACTOE.setLayoutX(147.0);
        ImageTICTACTOE.setLayoutY(122.0);
        ImageTICTACTOE.setPickOnBounds(true);
        ImageTICTACTOE.setPreserveRatio(true);
        ImageTICTACTOE.setImage(new Image(getClass().getResource("Group9_1.png").toExternalForm()));

        getChildren().add(RectBase);
        getChildren().add(rectangle);
        getChildren().add(buttonPlay);
        getChildren().add(buttonNo);
        getChildren().add(labPlay);
        getChildren().add(ImageTICTACTOE);

    }


}
