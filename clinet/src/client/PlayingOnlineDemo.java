package client;

import static client.Profile.player2Email;
import com.google.gson.Gson;
import conn.ClintSide;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import model.RequestDTO;

public class PlayingOnlineDemo extends BorderPane {

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
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final DropShadow dropShadow;
    protected final DropShadow dropShadow0;

    private char currentPlayer; // Initial player is X
    private char[][] board = new char[3][3];
    static int counterx;
    static int countero;
    Stage stage;
    String email = "omaaar@gmail.com";
    char playerType;
    boolean turn;
    String gameStatus;
    int myScore;
    String userName;

    public PlayingOnlineDemo(Stage stage, String userName, String email, int myScore, char playerType) {

        stage.setTitle("Playing TIC TAC TOE Online");

        this.email = email;
        this.stage = stage;
        this.userName = userName;
        this.myScore = myScore;
        this.playerType = playerType;
        currentPlayer = playerType;
        if (playerType == 'X') {
            turn = true;
        } else {
            turn = false;
        }

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
        imgO = new ImageView();
        lblPlayerO = new Label();
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
        setButtonHandler(btn00, 0, 0);
        setButtonHandler(btn01, 0, 1);
        setButtonHandler(btn02, 0, 2);
        setButtonHandler(btn10, 1, 0);
        setButtonHandler(btn11, 1, 1);
        setButtonHandler(btn12, 1, 2);
        setButtonHandler(btn20, 2, 0);
        setButtonHandler(btn21, 2, 1);
        setButtonHandler(btn22, 2, 2);
        initializeServerListener();

    }

    private void initializeServerListener() {
        new Thread(() -> {
            try {
                while (true) {
                    String response = ClintSide.listenFromServer.readLine();
                    System.out.println("Response from server: " + response);
                    Gson json = new Gson();
                    RequestDTO received = json.fromJson(response, RequestDTO.class);
//                currentPlayer = playerType;
//<<<<<<< HEAD
//                
//        updateButton(getButtonAt(received.getRow(), received.getCol()), received.getRow(), received.getCol(), received.getMove());
//        turn = received.isPlayerOneTurn();
//        Platform.runLater(() -> {        
//        if ("xwins".equals(received.getPlayState()) && playerType == 'O') {
//                    System.out.println("client.PlayingOnlineDemo.initializeServerListener()" + userName + email + myScore);
//                    new AlertBox().onlineDisplay("Title of the window", "x wins you lose Do you want to try again?", "/assets/Starasset.png" , stage , 
//                            "/assets/crown.png" , "/assets/GameOver.mp4",userName ,email , myScore);
//=======

                    updateButton(getButtonAt(received.getRow(), received.getCol()), received.getRow(), received.getCol(), received.getMove());
                    turn = received.isPlayerOneTurn();
                    Platform.runLater(() -> {
                        if ("xwins".equals(received.getPlayState()) && playerType == 'O') {

                            new AlertBox().onlineDisplay("Title of the window", "x wins you lose Do you want to try again?", "/assets/Starasset.png", stage,
                                    "/assets/crown.png", "/assets/GameOver.mp4", userName, email, myScore);
                            resetGame();

                        } else if ("owins".equals(received.getPlayState()) && playerType == 'X') {
                            new AlertBox().onlineDisplay("Title of the window", "o wins you lose Do you want to try again?", "/assets/misc.png", stage, "/assets/crown.png", "/assets/GameOver.mp4", userName, email, myScore);
                            resetGame();

                        } else if ("It's a draw!".equals(received.getPlayState())) {
                            new AlertBox().onlineDisplay("Title of the window", "it's draw Do you want to try again?", "/assets/ko.jpg", stage, "", "/assets/t.mp4", userName, email, myScore);
                            resetGame();

                        }
                    });
                }

            } catch (IOException ex) {
                Logger.getLogger(PlayingOnlineDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

    private void sendMoveToServer(int row, int col) {
        RequestDTO requestData = new RequestDTO();
        requestData.setRow(row);
        requestData.setCol(col);
        System.out.println("client.PlayingOnlineDemo.sendMoveToServer()" + currentPlayer + playerType);
        requestData.setMove(playerType);
        requestData.setOpponentEmail(player2Email);
        requestData.setRoute("board");
        requestData.setPlayState(gameStatus);
        Gson json = new Gson();
        String msg = json.toJson(requestData);
        System.out.println("Client online board message: " + msg);

        try {
            ClintSide.printedMessageToServer.println(msg);
            ClintSide.printedMessageToServer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setButtonHandler(Button button, int row, int col) {
        button.setOnAction(event -> {
            if (turn && currentPlayer == playerType && !button.getStyleClass().contains("btnx") && !button.getStyleClass().contains("btno")) {
                if (currentPlayer == 'X') {
                    button.getStyleClass().add("btnx");
                    board[row][col] = 'X';
                    sendMoveToServer(row, col);
                    checkGameStatus(row, col);
                } else if (currentPlayer == 'O') {
                    board[row][col] = 'O';
                    button.getStyleClass().add("btno");
                    sendMoveToServer(row, col);
                    checkGameStatus(row, col);
                }
                // switchPlayer(); // Switch the player after making a move
            }
            turn = false;
        });
    }

    private Button getButtonAt(int row, int col) {
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

    private void updateButton(Button button, int row, int col, char move) {
        System.out.println("client.PlayingOnlineDemo.updateButton()");
        Platform.runLater(() -> {
            if (move == 'X') {
                button.getStyleClass().add("btnx");
                board[row][col] = 'X';
                checkGameStatus(row, col);

                printBoard();
            } else if (move == 'O') {
                button.getStyleClass().add("btno");
                board[row][col] = 'O';
                checkGameStatus(row, col);

                printBoard();

            }
        });
    }

    private void checkGameStatus(int row, int col) {

        if (checkRow(row) || checkColumn(col) || checkDiagonals1() || checkDiagonals2()) {
            // Display winner
            System.out.println("Player " + currentPlayer + " wins!");
            if (currentPlayer == 'X') {
                gameStatus = "xwins";
                sendMoveToServer(row, col);

                new AlertBox().onlineDisplay("Title of the window", "x wins Do you want to try again?", "/assets/Starasset.png", stage, "/assets/crown.png", "/assets/b.mp4", userName, email, myScore);
                counterx++;

            } else if (currentPlayer == 'O') {
                gameStatus = "owins";
                sendMoveToServer(row, col);

                new AlertBox().onlineDisplay("Title of the window", "o wins Do you want to try again?", "/assets/misc.png", stage, "/assets/crown.png", "/assets/b.mp4", userName, email, myScore);
                countero++;
            }
            lblScoreO.setText(String.valueOf(countero));
            lblScoreX.setText(String.valueOf(counterx));
            resetGame();

        } else if (isBoardFull()) {
            // Handle draw
            gameStatus = "It's a draw!";
            sendMoveToServer(row, col);

            System.out.println("It's a draw!");
            resetGame();
            new AlertBox().onlineDisplay("Title of the window", "it's draw Do you want to try again?", "/assets/ko.jpg", stage, "", "/assets/t.mp4", userName, email, myScore);
        } else {
            // Switch player if the game is still ongoing
//        switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    private boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    private boolean checkDiagonals1() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer);
    }

    private boolean checkDiagonals2() {
        return (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private void resetGame() {
        // Clear the board and reset buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
                getButton(i, j).setText("");
            }
        }
        btn00.getStyleClass().removeAll("btno", "btnx");
        btn01.getStyleClass().removeAll("btno", "btnx");
        btn02.getStyleClass().removeAll("btno", "btnx");
        btn10.getStyleClass().removeAll("btno", "btnx");
        btn11.getStyleClass().removeAll("btno", "btnx");
        btn12.getStyleClass().removeAll("btno", "btnx");
        btn20.getStyleClass().removeAll("btno", "btnx");
        btn21.getStyleClass().removeAll("btno", "btnx");
        btn22.getStyleClass().removeAll("btno", "btnx");

        currentPlayer = 'X';
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
