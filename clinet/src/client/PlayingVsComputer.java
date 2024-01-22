package client;

import static client.PlayingScreenDemo.counterx;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayingVsComputer extends BorderPane {

    private FlowPane topFlow;
    private AnchorPane anchorPlayerX;
    private Label lblPlayerX;
    private ImageView imgX;
    private Label lblScoreX;
    private Label lblVs;
    private Label lblScoreO;
    private AnchorPane anchorPlayerO;
    private Label lblPlayerO;
    private ImageView imgO;
    private AnchorPane anchorGame;
    private Rectangle recGame;
    private Rectangle recV1;
    private Rectangle recV2;
    private Rectangle recH1;
    private Rectangle recH2;
    private Button btn00;
    private Button btn01;
    private Button btn02;
    private Button btn12;
    private Button btn11;
    private Button btn10;
    private Button btn22;
    private Button btn20;
    private Button btn21;
    private ImageView imageView;
    private ImageView imageView0;
    private DropShadow dropShadow;
    private DropShadow dropShadow0;

    private char currentPlayer = 'X'; // Initial player is X
    private char[][] board = new char[3][3];
    static int counterX;
    static int counterO;
    private boolean playerTurn = true;
    private boolean gameOver = false;

    Stage stage;

    public PlayingVsComputer(Stage stage) {
        this.stage = stage;
        counterO = 0;
        counterX = 0;
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
        lblPlayerX.setText("Player");
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
        lblScoreO.setText(String.valueOf(counterO));
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
        lblPlayerO.setText("Computer");
        lblPlayerO.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblPlayerO.setTextFill(javafx.scene.paint.Color.valueOf("#FFAB2D"));
        lblPlayerO.setFont(new Font("System Bold", 18.0));

        imgO.setFitHeight(70.0);
        imgO.setFitWidth(80.0);
        imgO.setLayoutX(20.0);
        imgO.setLayoutY(7.0);
        imgO.setPickOnBounds(true);
        imgO.setPreserveRatio(true);
        imgO.setImage(new Image(getClass().getResource("/assets/com.png").toExternalForm()));
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
        // Set button handlers
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
                if (!button.getStyleClass().contains("btnx") && !button.getStyleClass().contains("btno") && playerTurn) {
                    button.getStyleClass().add("btnx");
                    board[row][col] = 'X';
                    checkGameStatus(row, col);
                    playerTurn = false; // <-- This is fine for human player
                    computerMove();
                }
            }
        });
    }

    private void computerMove() {
        if (!gameOver) {
            currentPlayer = 'O';
            // Simulating computer move with a random but intelligent choice
            int[] emptySpot = findEmptySpot();
            if (emptySpot != null) {
                int row = emptySpot[0];
                int col = emptySpot[1];

                Button computerButton = getButton(row, col);
                computerButton.getStyleClass().add("btno");
                board[row][col] = 'O';
                checkGameStatus(row, col);
            }
            // Update currentPlayer after the computer move
            currentPlayer = 'X';
            playerTurn = true;
        }
    }

    private int[] findEmptySpot() {
        List<int[]> emptySpots = new ArrayList<>();

        // Find all empty spots on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    emptySpots.add(new int[]{i, j});
                }
            }
        }

        // Choose a random empty spot
        if (!emptySpots.isEmpty()) {
            return emptySpots.get(new Random().nextInt(emptySpots.size()));
        } else {
            return null; // No empty spot available (board is full)
        }
    }

    private void checkGameStatus(int row, int col) {
        // Update row and col before checking for a win
        if (checkRow(row) || checkColumn(col) || checkDiagonals1() || checkDiagonals2()) {
            // Display winner
            displayWinner();
            resetGame();
        } else if (isBoardFull()) {
            // Handle draw
            displayDraw();
            resetGame();
        }
    }

    private void displayWinner() {
        System.out.println("Player " + currentPlayer + " wins!");
        if (currentPlayer == 'X') {
            new AlertBox().display("The game is over", "You wins! Do you want to play again?", "/assets/Starasset.png", stage, "/assets/crown.png", "/assets/b.mp4");
            counterX++;
        } else if (currentPlayer == 'O') {
            new AlertBox().display("The game is over", "Computer wins! Do you want to try again?", "/assets/com.png", stage, "/assets/crown.png", "/assets/t.mp4");
            counterO++;
        }
        lblScoreO.setText(String.valueOf(counterO));
        lblScoreX.setText(String.valueOf(counterX));
    }

    private void displayDraw() {
        System.out.println("It's a draw!");
        new AlertBox().display("Title of the window", "It's a draw! Do you want to try again?", "/assets/ko.jpg", stage, "", "/assets/t.mp4");
    }

    private boolean checkRow(int row) {

        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            for (int i = 0; i < 3; i++) {
                Button button = new Button();
                button = getButton(row, i);
                button.getStyleClass().add("btnWin");
            }

        }
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    private boolean checkColumn(int col) {

        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            for (int i = 0; i < 3; i++) {
                Button button = new Button();
                button = getButton(i, col);
                button.getStyleClass().add("btnWin");
            }
        }
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    private boolean checkDiagonals1() {
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            for (int i = 0; i < 3; i++) {
                System.out.print(" in dial 1");
                Button button = new Button();
                button = getButton(i, i);
                button.getStyleClass().add("btnWin");
            }
        }

        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer);
    }

    private boolean checkDiagonals2() {
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            System.out.print(" in dial 2");

            for (int i = 0, x = 0, y = 2; i < 3; i++, x++, y--) {
                System.out.print(" in dial 2 in for loop");

                Button button = new Button();
                button = getButton(x, y);
                button.getStyleClass().add("btnWin");
            }
        }

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

    private void resetGame() {
        gameOver = true;
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
        gameOver = false;
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
