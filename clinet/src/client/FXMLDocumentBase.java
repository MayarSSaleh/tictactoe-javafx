package client;

import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public  class FXMLDocumentBase extends AnchorPane {

    protected final Button button;
    protected final Label label;

    public FXMLDocumentBase() {

        button = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(200);
        setPrefWidth(320);

        button.setLayoutX(126);
        button.setLayoutY(90);
        //    button.setOnAction(e-> new AlertBox().display("title of the window", "do you want to try again"));
        AlertBox ab=new AlertBox();
      //  button.setOnAction(e-> ab.display("title of the window", "do you want to try again"));
        button.setText("Click Me!");

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        getChildren().add(button);
        getChildren().add(label);

    }


}
