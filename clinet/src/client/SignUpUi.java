package client;

import static client.LoginUi.patternMatches;
import com.google.gson.Gson;
import conn.ClintSide;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.RequestDTO;
import model.User;

public class SignUpUi extends BorderPane {

    protected final HBox hBox;
    protected final Label label;
    protected final Label lblResgister;
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final Label label0;
    protected final TextField txtUserName;
    protected final Label lblUserError;
    protected final HBox hBox1;
    protected final Label label1;
    protected final TextField txtEmail;
    protected final Label lblEmailError;
    protected final HBox hBox2;
    protected final Label label2;
    protected final PasswordField txtPass;
    protected final Label lblErrorPass;
    protected final Button btnResgister;
    protected final Rectangle recLogo;
    protected final Image logo;

    public String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private boolean validEmail;
    private boolean validName;
    private boolean validPass;
    private ClintSide s;
    public Stage stage;

    public SignUpUi(Stage stage) {
        this.s = new ClintSide();
        this.stage = stage;
        hBox = new HBox();
        label = new Label();
        lblResgister = new Label();
        vBox = new VBox();
        hBox0 = new HBox();
        label0 = new Label();
        txtUserName = new TextField();
        lblUserError = new Label();
        hBox1 = new HBox();
        label1 = new Label();
        txtEmail = new TextField();
        lblEmailError = new Label();
        hBox2 = new HBox();
        label2 = new Label();
        txtPass = new PasswordField();
        lblErrorPass = new Label();
        btnResgister = new Button();
        recLogo = new Rectangle();
        logo = new Image("/assets/Group9.png");
        validEmail = false;
        validName = false;
        validPass = false;
        ClintSide.startConnection();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(414.0);
        setStyle("-fx-background-color: black;");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(50.0);
        hBox.setPrefWidth(394.0);
        hBox.setStyle("-fx-background-color: black;");

        label.setText(" already have an account?");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(14.0));

        lblResgister.setOnMousePressed(this::login);
        lblResgister.setText("login");
        lblResgister.setTextFill(javafx.scene.paint.Color.valueOf("#433ff1"));
        lblResgister.setFont(new Font(14.0));
        HBox.setMargin(lblResgister, new Insets(0.0, 0.0, 0.0, 10.0));
        setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(294.0);
        vBox.setPrefWidth(394.0);
        vBox.setStyle("-fx-background-color: black;");

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(25.0);
        hBox0.setPrefWidth(342.0);

        label0.setPrefHeight(20.0);
        label0.setPrefWidth(85.0);
        label0.setText("User Name :  ");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(14.0));

        txtUserName.setOnKeyReleased(this::validName);
        txtUserName.setPrefHeight(30.0);
        txtUserName.setPrefWidth(175.0);
        txtUserName.setFont(new Font(14.0));
        txtUserName.getStyleClass().add("txtField");

        lblUserError.setPrefHeight(20.0);
        lblUserError.setPrefWidth(250.0);
        lblUserError.setFont(new Font(14.0));
        lblUserError.setTextFill(javafx.scene.paint.Color.RED);

        VBox.setMargin(lblUserError, new Insets(5.0, 0.0, 10.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(30.0);
        hBox1.setPrefWidth(330.0);

        label1.setPrefHeight(20.0);
        label1.setPrefWidth(85.0);
        label1.setText("Email :    ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(14.0));

        txtEmail.setOnKeyReleased(this::validEmail);
        txtEmail.setPrefHeight(30.0);
        txtEmail.setPrefWidth(175.0);
        txtEmail.setFont(new Font(14.0));
        txtEmail.getStyleClass().add("txtField");

        lblEmailError.setPrefHeight(20.0);
        lblEmailError.setPrefWidth(250.0);
        lblEmailError.setTextFill(javafx.scene.paint.Color.RED);
        lblEmailError.setFont(new Font(14.0));
        VBox.setMargin(lblEmailError, new Insets(5.0, 0.0, 10.0, 0.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(49.0);
        hBox2.setPrefWidth(354.0);

        label2.setPrefHeight(20.0);
        label2.setPrefWidth(85.0);
        label2.setText("Password : ");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font(14.0));

        txtPass.setOnKeyReleased(this::validPass);
        txtPass.setFont(new Font(14.0));
        txtPass.getStyleClass().add("txtField");

        lblErrorPass.setPrefHeight(20.0);
        lblErrorPass.setPrefWidth(250.0);
        lblErrorPass.setTextFill(javafx.scene.paint.Color.RED);
        lblErrorPass.setFont(new Font(14.10));
        lblErrorPass.setPadding(new Insets(5.0, 0.0, 10.0, 0.0));

        btnResgister.setMaxHeight(30.0);
        btnResgister.setMnemonicParsing(false);
        btnResgister.setOnAction(this::signUp);
        btnResgister.setPrefHeight(30.0);
        btnResgister.setPrefWidth(120.0);
        btnResgister.setText("Resgister");
        btnResgister.setFont(new Font(12.0));
        btnResgister.setDisable(true);
        btnResgister.getStyleClass().add("neon-button");
        vBox.setPadding(new Insets(40.0, 20.0, 20.0, 20.0));
        setCenter(vBox);

        BorderPane.setAlignment(recLogo, javafx.geometry.Pos.CENTER);
        recLogo.setArcHeight(5.0);
        recLogo.setArcWidth(5.0);
        recLogo.setFill(javafx.scene.paint.Color.DODGERBLUE);
        recLogo.setHeight(55.0);
        recLogo.setStroke(javafx.scene.paint.Color.BLACK);
        recLogo.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        recLogo.setWidth(265.0);
        setTop(recLogo);
        setPadding(new Insets(10.0));
        recLogo.setFill(new ImagePattern(logo));
        ListView v = new ListView();

        hBox.getChildren().add(label);
        hBox.getChildren().add(lblResgister);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(txtUserName);
        vBox.getChildren().add(hBox0);
        vBox.getChildren().add(lblUserError);
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(txtEmail);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(lblEmailError);
        hBox2.getChildren().add(label2);
        hBox2.getChildren().add(txtPass);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(lblErrorPass);
        vBox.getChildren().add(btnResgister);

    }

    protected void login(javafx.scene.input.MouseEvent mouseEvent) {
          Parent pane = new LoginUi(stage);
        stage.getScene().setRoot(pane);
    }

    protected void validName(javafx.scene.input.KeyEvent keyEvent) {
        String user = txtUserName.getText();

        if (user.length() >= 3) {
            lblUserError.getStyleClass().removeAll("inValid");
            txtUserName.getStyleClass().removeAll("errorFeild");
            lblUserError.setText("Valid User Name");
            txtUserName.getStyleClass().add("validFeild");
            lblUserError.getStyleClass().add("valid");
            validName = true;
        } else {
            lblUserError.getStyleClass().removeAll("valid");
            txtUserName.getStyleClass().removeAll("validFeild");
            lblUserError.setText("User Name must more than 3 carachter ");
            txtUserName.getStyleClass().add("errorFeild");
            lblUserError.getStyleClass().add("inValid");
            validName = false;
        }
        if (validEmail && validPass && validName) {
            btnResgister.setDisable(false);
        } else {
            btnResgister.setDisable(true);
        }

    }

    protected void validEmail(javafx.scene.input.KeyEvent keyEvent) {
        String email = "";
        String Pass = "";
        email = txtEmail.getText();
        if (patternMatches(email, regexPattern)) {
            lblEmailError.getStyleClass().removeAll("inValid");
            txtEmail.getStyleClass().removeAll("errorFeild");
            lblEmailError.setText("Valid Email");
            txtEmail.getStyleClass().add("validFeild");
            lblEmailError.getStyleClass().add("valid");
            validEmail = true;

        } else {
            lblEmailError.getStyleClass().removeAll("valid");
            txtEmail.getStyleClass().removeAll("validFeild");
            lblEmailError.setText("Email inValid");
            txtEmail.getStyleClass().add("errorFeild");
            lblEmailError.getStyleClass().add("inValid");
            validEmail = false;

        }
        if (validEmail && validPass && validName) {
            btnResgister.setDisable(false);
        } else {
            btnResgister.setDisable(true);
        }

    }

    protected void validPass(javafx.scene.input.KeyEvent keyEvent) {
        String pass = txtPass.getText();

        if (pass.length() >= 6) {
            lblErrorPass.getStyleClass().removeAll("inValid");
            txtPass.getStyleClass().removeAll("errorFeild");
            lblErrorPass.setText("Valid password");
            txtPass.getStyleClass().add("validFeild");
            lblErrorPass.getStyleClass().add("valid");
            validPass = true;
        } else {
            lblErrorPass.getStyleClass().removeAll("valid");
            txtPass.getStyleClass().removeAll("validFeild");
            lblErrorPass.setText("password inValid");
            txtPass.getStyleClass().add("errorFeild");
            lblErrorPass.getStyleClass().add("inValid");
            validPass = false;
        }
        if (validEmail && validPass && validName) {
            btnResgister.setDisable(false);
        } else {
            btnResgister.setDisable(true);
        }

    }

    protected void signUp(ActionEvent event) {

        if (validEmail && validName && validPass) {
            RequestDTO requestData = new RequestDTO();
            requestData.setEmail(txtEmail.getText());
            requestData.setUserName(txtUserName.getText());
            requestData.setPass(txtPass.getText());
            requestData.setRoute("signup");
            Gson json = new Gson();
            ClintSide.printedMessageToServer.println(json.toJson(requestData));
            ClintSide.printedMessageToServer.flush();
            new Thread(() -> {
                try {
                    String response = ClintSide.listenFromServer.readLine();
                    System.out.println(response);
                    RequestDTO recived = json.fromJson(response, RequestDTO.class);
                    if ("confirmed".equals(recived.getValidation())) {
                        Platform.runLater(() -> {
                            Parent pane = new LoginUi(stage);
                            stage.getScene().setRoot(pane);

                        });
                    } else if ("invalid".equals(recived.getValidation())) {
                        // Handle the case when validation is invalid
                        Platform.runLater(() -> {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("Invalid");
                            alert.showAndWait();
                        });
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SignUpUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }).start();

            /*User newUser= new User(-1,txtUserName.getText(),txtEmail.getText(),txtPass.getText(),0,"offline");
            Gson json=new Gson();
            String jsonObj=json.toJson(newUser);*/
//            SocketDTO conn=new SocketDTO();
//            conn.signUp(txtEmail.getText(),jsonObj);
//            s.sendMassageTo(json.toJson(conn));
        }

    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

}
