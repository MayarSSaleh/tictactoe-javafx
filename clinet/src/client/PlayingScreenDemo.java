package client;

import static client.Record.RecordArray;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class PlayingScreenDemo extends BorderPane {

    protected final FlowPane topFlow;
    protected final AnchorPane anchorPlayerX;
    protected final Label lblPlayerX;
    protected final ImageView imgX;
    protected final Label lblScoreX;
    protected final Label lblVs;
    protected final Label lblScoreO;
    protected final AnchorPane anchorPlayerO;
    protected final Label lblPlayerO;
    protected final ImageView imgO;
    protected final AnchorPane anchorGame;
    protected final Rectangle recGame;
    protected final Rectangle recV1;
    protected final Rectangle recV2;
    protected final Rectangle recH1;
    protected final Rectangle recH2;
    protected final Button btn00;
    protected final Button btn01;
    protected final Button btn02;
    protected final Button btn12;
    protected final Button btn11;
    protected final Button btn10;
    protected final Button btn22;
    protected final Button btn20;
    protected final Button btn21;
    protected final Button btnRecord;
    protected final Button btnPlayRecord;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final DropShadow dropShadow;
    protected final DropShadow dropShadow0;
    private char currentPlayer = 'X'; // Initial player is X
    private char[][] board = new char[3][3];
    static int counterx;
    static int countero;
    Stage stage;
    GamePlay game;
    boolean recordTheGame = false;
//     it will be
//        Record newRecord ;

    Record newRecord = new Record();

    public PlayingScreenDemo(Stage stage, String pageName, Record newRecord) {

        btnRecord = new Button();
        btnPlayRecord = new Button();
        if (pageName.equals("ReplayGame")) {
            System.out.println(" inside if condition of palying screen ,record show");

            btnRecord.getStyleClass().add("btnRecLoc");
            replayTheGame();

        }

        BorderPane.setAlignment(btnRecord, javafx.geometry.Pos.CENTER);
        btnRecord.setMnemonicParsing(false);
        btnRecord.setLayoutX(470.0);
        btnRecord.setLayoutY(239.0);
        btnRecord.setPrefHeight(31.0);
        btnRecord.setPrefWidth(85.0);
        btnRecord.setText("Record");
        setBottom(btnRecord);
        BorderPane.setMargin(btnRecord, new Insets(0.0, 0.0, 0.0, 0.0));
        btnRecord.getStyleClass().add("btnRec");

        btnRecord.setOnAction((e) -> {
            recordTheGame = true;
            System.out.println("record statr");
            newRecord.setCurrentDate(LocalDate.now());
            newRecord.setCurrentTime(LocalTime.now());
        });
        btnPlayRecord.setOnAction((e) -> {
            System.out.println("record show");
            replayTheGame();
            System.out.println(newRecord.getCurrentDate());
            System.out.println("current time " + newRecord.getCurrentTime());

        });

        // the following cod made by mayar for testing the replaying function<keep it>
        BorderPane.setAlignment(btnPlayRecord, javafx.geometry.Pos.CENTER);
        btnPlayRecord.setMnemonicParsing(false);
        btnPlayRecord.setPrefHeight(31.0);
        btnPlayRecord.setPrefWidth(70.0);
        btnPlayRecord.setText("playR");
        BorderPane.setMargin(btnPlayRecord, new Insets(0.0, 0.0, 0.0, 0.0));
        setLeft(btnPlayRecord);
        btnPlayRecord.getStyleClass().add("btnRec");

        game = new GamePlay();
        this.stage = stage;
        countero = 0;
        counterx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        topFlow = new FlowPane();
        anchorPlayerX = new AnchorPane();
        lblPlayerX = new Label();
        imgX = new ImageView();
        lblScoreX = new Label();
        lblVs = new Label();
        lblScoreO = new Label();
        anchorPlayerO = new AnchorPane();
        lblPlayerO = new Label();
        imgO = new ImageView();
        anchorGame = new AnchorPane();
        recGame = new Rectangle();
        recV1 = new Rectangle();
        recV2 = new Rectangle();
        recH1 = new Rectangle();
        recH2 = new Rectangle();
        btn00 = new Button();
        btn01 = new Button();
        btn02 = new Button();
        btn12 = new Button();
        btn11 = new Button();
        btn10 = new Button();
        btn22 = new Button();
        btn20 = new Button();
        btn21 = new Button();
        imageView = new ImageView();
        imageView0 = new ImageView();
        dropShadow = new DropShadow();
        dropShadow0 = new DropShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(topFlow, javafx.geometry.Pos.CENTER);
        topFlow.setPrefHeight(103.0);
        topFlow.setPrefWidth(600.0);

        anchorPlayerX.setPrefHeight(108.0);
        anchorPlayerX.setPrefWidth(116.0);

        lblPlayerX.setAlignment(javafx.geometry.Pos.CENTER);
        lblPlayerX.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        lblPlayerX.setLayoutX(8.0);
        lblPlayerX.setLayoutY(77.0);
        lblPlayerX.setPrefHeight(35.0);
        lblPlayerX.setPrefWidth(101.0);
        lblPlayerX.setText("Player X");
        lblPlayerX.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblPlayerX.setTextFill(javafx.scene.paint.Color.valueOf("#FFAB2D"));
        lblPlayerX.setFont(new Font("System Bold", 18.0));

        imgX.setFitHeight(70.0);
        imgX.setFitWidth(80.0);
        imgX.setLayoutX(20.0);
        imgX.setLayoutY(7.0);
        imgX.setPickOnBounds(true);
        imgX.setPreserveRatio(true);
        imgX.setSmooth(false);
        imgX.setImage(new Image(getClass().getResource("/assets/Starasset.png").toExternalForm()));
        FlowPane.setMargin(anchorPlayerX, new Insets(0.0, 130.0, 0.0, 0.0));

        lblScoreX.setPrefHeight(0.0);
        lblScoreX.setPrefWidth(0.0);
        lblScoreX.setText(String.valueOf(counterx));
        lblScoreX.setFont(new Font("System Bold", 24.0));
        lblScoreX.setTextFill(javafx.scene.paint.Color.valueOf("#FFD56A"));

        FlowPane.setMargin(lblScoreX, new Insets(0.0, 10.0, 0.0, 0.0));

        lblVs.setAlignment(javafx.geometry.Pos.CENTER);
        lblVs.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        lblVs.setPrefHeight(47.0);
        lblVs.setPrefWidth(56.0);
        lblVs.setText("VS ");
        lblVs.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblVs.setFont(new Font("System Bold", 24.0));
        lblVs.setTextFill(javafx.scene.paint.Color.valueOf("#FFAB2D"));
        FlowPane.setMargin(lblVs, new Insets(0.0));

        lblScoreO.setPrefHeight(35.0);
        lblScoreO.setPrefWidth(25.0);
        lblScoreO.setText(String.valueOf(countero));
        lblScoreO.setFont(new Font("System Bold", 24.0));
        lblScoreO.setTextFill(javafx.scene.paint.Color.valueOf("#FFD56A"));

        FlowPane.setMargin(lblScoreO, new Insets(0.0, 133.0, 0.0, 0.0));

        anchorPlayerO.setPrefHeight(108.0);
        anchorPlayerO.setPrefWidth(116.0);

        lblPlayerO.setAlignment(javafx.geometry.Pos.CENTER);
        lblPlayerO.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        lblPlayerO.setLayoutX(8.0);
        lblPlayerO.setLayoutY(77.0);
        lblPlayerO.setPrefHeight(35.0);
        lblPlayerO.setPrefWidth(101.0);
        lblPlayerO.setText("Player O");
        lblPlayerO.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblPlayerO.setTextFill(javafx.scene.paint.Color.valueOf("#FFAB2D"));
        lblPlayerO.setFont(new Font("System Bold", 18.0));

        imgO.setFitHeight(70.0);
        imgO.setFitWidth(80.0);
        imgO.setLayoutX(20.0);
        imgO.setLayoutY(7.0);
        imgO.setPickOnBounds(true);
        imgO.setPreserveRatio(true);
        imgO.setImage(new Image(getClass().getResource("/assets/misc.png").toExternalForm()));
        FlowPane.setMargin(anchorPlayerO, new Insets(0.0));
        setTop(topFlow);

        BorderPane.setAlignment(anchorGame, javafx.geometry.Pos.CENTER);
        anchorGame.setPrefHeight(356.0);
        anchorGame.setPrefWidth(600.0);

        recGame.setArcHeight(5.0);
        recGame.setArcWidth(5.0);
        recGame.setHeight(234.0);
        recGame.setLayoutX(172.0);
        recGame.setLayoutY(20.0);
        recGame.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        recGame.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recGame.setWidth(234.0);
        recGame.getStyleClass().add("rec_game");

        recV1.setArcHeight(12.0);
        recV1.setArcWidth(30.0);
        recV1.setHeight(234.0);
        recV1.setLayoutX(244.0);
        recV1.setLayoutY(20.0);
        recV1.setSmooth(false);
        recV1.setStroke(javafx.scene.paint.Color.WHITE);
        recV1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recV1.setWidth(10.0);
        recV1.getStyleClass().add("rech");
        dropShadow.setColor(Color.ORANGE);
        dropShadow.setHeight(73.38);
        dropShadow.setRadius(27.0475);
        dropShadow.setWidth(36.81);
        recV1.setEffect(dropShadow);

        recV2.setArcHeight(12.0);
        recV2.setArcWidth(30.0);
        recV2.setHeight(234.0);
        recV2.setLayoutX(324.0);
        recV2.setLayoutY(20.0);
        recV2.setSmooth(false);
        recV2.setStroke(javafx.scene.paint.Color.WHITE);
        recV2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recV2.setWidth(10.0);
        recV2.getStyleClass().add("rech");

        dropShadow.setColor(Color.ORANGE);
        dropShadow.setHeight(73.38);
        dropShadow.setRadius(27.0475);
        dropShadow.setWidth(36.81);
        recV2.setEffect(dropShadow);

        recH1.setArcHeight(12.0);
        recH1.setArcWidth(30.0);
        recH1.setHeight(234.0);
        recH1.setLayoutX(284.0);
        recH1.setLayoutY(-17.0);
        recH1.setRotate(90.0);
        recH1.setSmooth(false);
        recH1.setStroke(javafx.scene.paint.Color.WHITE);
        recH1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recH1.setWidth(10.0);
        recH1.getStyleClass().add("rech");

        dropShadow.setColor(Color.ORANGE);
        dropShadow.setHeight(73.38);
        dropShadow.setRadius(27.0475);
        dropShadow.setWidth(36.81);
        recH1.setEffect(dropShadow);

        recH2.setArcHeight(12.0);
        recH2.setArcWidth(30.0);
        recH2.setHeight(234.0);
        recH2.setLayoutX(284.0);
        recH2.setLayoutY(64.0);
        recH2.setSmooth(false);
        recH2.setRotate(90.0);
        recH2.setStroke(javafx.scene.paint.Color.WHITE);
        recH2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        recH2.setWidth(10.0);
        recH2.getStyleClass().add("rech");

        dropShadow.setColor(Color.ORANGE);
        dropShadow.setHeight(73.38);
        dropShadow.setRadius(27.0475);
        dropShadow.setWidth(36.81);
        recH2.setEffect(dropShadow);

        btn00.setAlignment(javafx.geometry.Pos.CENTER);
        btn00.setLayoutX(181.0);
        btn00.setLayoutY(31.0);
        btn00.setMnemonicParsing(false);
        btn00.setPrefHeight(50.0);
        btn00.setPrefWidth(54.0);
        btn00.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn00.setFont(new Font(24.0));
        btn00.getStyleClass().add("btn");

        btn02.setAlignment(javafx.geometry.Pos.CENTER);
        btn02.setLayoutX(342.0);
        btn02.setLayoutY(31.0);
        btn02.setMnemonicParsing(false);
        btn02.setPrefHeight(50.0);
        btn02.setPrefWidth(54.0);
        btn02.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn02.setFont(new Font(24.0));
        btn02.getStyleClass().add("btn");

        btn01.setAlignment(javafx.geometry.Pos.CENTER);
        btn01.setLayoutX(262.0);
        btn01.setLayoutY(31.0);
        btn01.setMnemonicParsing(false);
        btn01.setPrefHeight(50.0);
        btn01.setPrefWidth(54.0);
        btn01.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn01.setFont(new Font(24.0));
        btn01.getStyleClass().add("btn");

        btn12.setAlignment(javafx.geometry.Pos.CENTER);
        btn12.setLayoutX(342.0);
        btn12.setLayoutY(112.0);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(50.0);
        btn12.setPrefWidth(54.0);
        btn12.setFont(new Font(24.0));
        btn12.getStyleClass().add("btn");

        btn11.setAlignment(javafx.geometry.Pos.CENTER);
        btn11.setLayoutX(262.0);
        btn11.setLayoutY(112.0);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(50.0);
        btn11.setPrefWidth(54.0);
        btn11.setFont(new Font(24.0));
        btn11.getStyleClass().add("btn");

        btn10.setLayoutX(181.0);
        btn10.setLayoutY(112.0);
        btn10.setMnemonicParsing(false);
        btn10.setPrefHeight(50.0);
        btn10.setPrefWidth(54.0);
        btn10.setFont(new Font(24.0));
        btn10.getStyleClass().add("btn");

        btn22.setAlignment(javafx.geometry.Pos.CENTER);
        btn22.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn22.setLayoutX(342.0);
        btn22.setLayoutY(193.0);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(50.0);
        btn22.setPrefWidth(54.0);
        btn22.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn22.setFont(new Font(24.0));
        btn22.getStyleClass().add("btn");

        btn20.setAlignment(javafx.geometry.Pos.CENTER);
        btn20.setLayoutX(181.0);
        btn20.setLayoutY(193.0);
        btn20.setMnemonicParsing(false);
        btn20.setPrefHeight(50.0);
        btn20.setPrefWidth(54.0);
        btn20.setFont(new Font(24.0));
        btn20.getStyleClass().add("btn");

        btn21.setAlignment(javafx.geometry.Pos.CENTER);
        btn21.setLayoutX(262.0);
        btn21.setLayoutY(193.0);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(50.0);
        btn21.setPrefWidth(54.0);
        btn21.setFont(new Font(24.0));
        btn21.getStyleClass().add("btn");
        imageView.setFitHeight(38.0);
        imageView.setFitWidth(36.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(244.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        imageView0.setFitHeight(38.0);
        imageView0.setFitWidth(38.0);
        imageView0.setLayoutX(57.0);
        imageView0.setLayoutY(244.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        setCenter(anchorGame);

        anchorPlayerX.getChildren().add(lblPlayerX);
        anchorPlayerX.getChildren().add(imgX);
        topFlow.getChildren().add(anchorPlayerX);
        topFlow.getChildren().add(lblScoreX);
        topFlow.getChildren().add(lblVs);
        topFlow.getChildren().add(lblScoreO);
        anchorPlayerO.getChildren().add(lblPlayerO);
        anchorPlayerO.getChildren().add(imgO);
        topFlow.getChildren().add(anchorPlayerO);
        anchorGame.getChildren().add(recGame);
        anchorGame.getChildren().add(recV1);
        anchorGame.getChildren().add(recV2);
        anchorGame.getChildren().add(recH1);
        anchorGame.getChildren().add(recH2);
        anchorGame.getChildren().add(btn00);
        anchorGame.getChildren().add(btn01);
        anchorGame.getChildren().add(btn02);
        anchorGame.getChildren().add(btn12);
        anchorGame.getChildren().add(btn11);
        anchorGame.getChildren().add(btn10);
        anchorGame.getChildren().add(btn22);
        anchorGame.getChildren().add(btn20);
        anchorGame.getChildren().add(btn21);
        anchorGame.getChildren().add(imageView);
        anchorGame.getChildren().add(imageView0);
        anchorGame.getChildren().add(btnRecord);
        setButtonHandler(btn00, 0, 0);

        setButtonHandler(btn01, 0, 1);
        setButtonHandler(btn02, 0, 2);
        setButtonHandler(btn10, 1, 0);
        setButtonHandler(btn11, 1, 1);
        setButtonHandler(btn12, 1, 2);
        setButtonHandler(btn20, 2, 0);
        setButtonHandler(btn21, 2, 1);
        setButtonHandler(btn22, 2, 2);
    }

    private void setButtonHandler(Button button, int row, int col) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                char ch = ' ';
                if (!((Button) event.getTarget()).getStyleClass().contains("btnx") && !((Button) event.getTarget()).getStyleClass().contains("btno") && game.getCurrentPlayer() == 'X') {
                    ((Button) event.getTarget()).getStyleClass().add("btnx");
                    game.setBoard(row, col, 'X');

                    if (recordTheGame) {
                        newRecord.setclick(row, col, 'X');
                    }

                    ch = game.checkGameStatus(row, col);
                    if (ch == 'N') {
                        game.setCurrentPlayer('O');
                    } else if (ch == 'X') {
                        new AlertBox().display("Game is over", "x wins Do you want to try again?", "/assets/Starasset.png", stage, "/assets/crown.png", "/assets/b.mp4");
                        lblScoreO.setText(String.valueOf(GamePlay.getP2Score()));
                        lblScoreX.setText(String.valueOf(GamePlay.getP1Score()));

                        game.resetGame(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22);

//                        Record.addRecords(newRecord);
                    } else if (ch == 'D') {
                        game.resetGame(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22);
                        new AlertBox().display("Game is over", "it's draw Do you want to try again?", "/assets/ko.jpg", stage, "", "/assets/t.mp4");

//                        Record.addRecords(newRecord);
                    }

                } else if (!((Button) event.getTarget()).getStyleClass().contains("btno") && !((Button) event.getTarget()).getStyleClass().contains("btnx") && game.getCurrentPlayer() == 'O') {
                    ((Button) event.getTarget()).getStyleClass().add("btno");
                    game.setBoard(row, col, 'O');

                    if (recordTheGame) {
                        newRecord.setclick(row, col, 'O');
                    }

                    ch = game.checkGameStatus(row, col);
                    if (ch == 'N') {
                        game.setCurrentPlayer('X');
                    } else if (ch == 'O') {
                        new AlertBox().display("Game is over", "o wins Do you want to try again?", "/assets/misc.png", stage, "/assets/crown.png", "/assets/b.mp4");

                        lblScoreO.setText(String.valueOf(GamePlay.getP2Score()));
                        lblScoreX.setText(String.valueOf(GamePlay.getP1Score()));
                        game.resetGame(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22);

//                        Record.addRecords(newRecord);
                    } else if (ch == 'D') {
                        game.resetGame(btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22);
                        new AlertBox().display("Game is over", "it's draw Do you want to try again?", "/assets/ko.jpg", stage, "", "/assets/t.mp4");
//                        Record.addRecords(newRecord);

                    }
                }
            }
        });
    }

    // it should take the object but for now,it will deal with the current used object
    public void replayTheGame() {

        ArrayList<int[]> gameSteps = newRecord.getRecordTheSteps();
        // this comment and the following is for make delay by another way. 2method make delay
//        Timeline timeline = new Timeline();
        Thread replayThread = new Thread(() -> {
            for (int x = 0; x < gameSteps.size(); x++) {
                ArrayList<Character> signs = newRecord.getRecordTheSign();
                char currentSign = signs.get(x);
                int[] array = gameSteps.get(x);
                int row = array[0];
                int col = array[1];
//            KeyFrame keyFrame = new KeyFrame(
//                    Duration.seconds(x + 0.5), // Add a delay of 0.5 seconds for each step
//                    new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    System.out.println("Replaying step: " + row + ", " + col + " - " + currentSign);
                    Button playButton = getButton(row, col);
                    if (currentSign == 'X') {
                        playButton.getStyleClass().add("btnx");
                        board[row][col] = 'X';
                    } else if (currentSign == 'O') {
                        playButton.getStyleClass().add("btno");
                        board[row][col] = 'O';

//            }}});
//            timeline.getKeyFrames().add(keyFrame);
//        }Start the timeline
//        timeline.play();}
                    }
                });

                try {
                    // Add a delay in the separate thread
                    Thread.sleep(500); // 500 milliseconds (0.5 seconds) delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the replay thread
        replayThread.start();
    }

    private Button getButton(int row, int col) {
        switch (row) {
            case 0:
                switch (col) {
                    case 0:
                        return btn00;
                    case 1:
                        return btn01;
                    case 2:
                        return btn02;
                }
            case 1:
                switch (col) {
                    case 0:
                        return btn10;
                    case 1:
                        return btn11;
                    case 2:
                        return btn12;
                }
            case 2:
                switch (col) {
                    case 0:
                        return btn20;
                    case 1:
                        return btn21;
                    case 2:
                        return btn22;
                }
        }
        return null;
    }
}
