package mainscreen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public  class FXMLDocumentBase extends BorderPane {

    protected final FlowPane flowPane;
    protected final ImageView XphotoMain;
    protected final ImageView TICTACTOE;
    protected final Button btnOnline;
    protected final Button btnLocal;
    protected final Button btnComputer;

    public FXMLDocumentBase() {

        flowPane = new FlowPane();
        XphotoMain = new ImageView();
        TICTACTOE = new ImageView();
        btnOnline = new Button();
        btnLocal = new Button();
        btnComputer = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(257.0);
        flowPane.setPrefWidth(327.0);

        XphotoMain.setFitHeight(244.0);
        XphotoMain.setFitWidth(308.0);
        XphotoMain.setPickOnBounds(true);
        XphotoMain.setPreserveRatio(true);
        XphotoMain.setImage(new Image(getClass().getResource("Untitled.png").toExternalForm()));
        FlowPane.setMargin(XphotoMain, new Insets(5.0, 100.0, 0.0, 70.0));
        setCenter(flowPane);

        BorderPane.setAlignment(TICTACTOE, javafx.geometry.Pos.CENTER);
        TICTACTOE.setFitHeight(60.0);
        TICTACTOE.setFitWidth(318.0);
        TICTACTOE.setPickOnBounds(true);
        TICTACTOE.setPreserveRatio(true);
        TICTACTOE.setImage(new Image(getClass().getResource("Group%209.png").toExternalForm()));
        BorderPane.setMargin(TICTACTOE, new Insets(20.0, 0.0, 0.0, 0.0));
        setTop(TICTACTOE);

        BorderPane.setAlignment(btnOnline, javafx.geometry.Pos.CENTER);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(31.0);
        btnOnline.setPrefWidth(73.0);
        btnOnline.setText("Online");
        BorderPane.setMargin(btnOnline, new Insets(80.0, 40.0, 100.0, 0.0));
        setRight(btnOnline);

        BorderPane.setAlignment(btnLocal, javafx.geometry.Pos.TOP_RIGHT);
        btnLocal.setMnemonicParsing(false);
        btnLocal.setPrefHeight(31.0);
        btnLocal.setPrefWidth(73.0);
        btnLocal.setText("Local");
        BorderPane.setMargin(btnLocal, new Insets(110.0, 0.0, 0.0, 28.0));
        setLeft(btnLocal);

        BorderPane.setAlignment(btnComputer, javafx.geometry.Pos.CENTER);
        btnComputer.setMnemonicParsing(false);
        btnComputer.setPrefHeight(30.0);
        btnComputer.setPrefWidth(83.0);
        btnComputer.setText("Computer");
        BorderPane.setMargin(btnComputer, new Insets(0.0, 0.0, 35.0, 25.0));
        setBottom(btnComputer);

        flowPane.getChildren().add(XphotoMain);
        
        btnComputer. getStyleClass().add("btnMainScreeen");
        btnLocal.getStyleClass().add("btnMainScreeen");
        btnOnline.getStyleClass().add("btnMainScreeen");

    }
}
