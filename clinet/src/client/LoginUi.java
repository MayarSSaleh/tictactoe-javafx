package client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class LoginUi extends BorderPane {

    protected final HBox hBox;
    protected final Label label;
    protected final Label lblSignIn;
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final Label label0;
    protected final TextField txtEmail;
    protected final Label lblEmailError;
    protected final HBox hBox1;
    protected final Label label1;
    protected final PasswordField txtPass;
    protected final Label lblErrorPass;
    protected final Button btnLogin;
    protected final Rectangle recLogo;
    protected final Image logo;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^(.+)@(\\S+) $.", Pattern.CASE_INSENSITIVE);
    public String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private boolean validEmail;
    private boolean validPass;

    public LoginUi() {

        hBox = new HBox();
        label = new Label();
        lblSignIn = new Label();
        vBox = new VBox();
        hBox0 = new HBox();
        label0 = new Label();
        txtEmail = new TextField();
        lblEmailError = new Label();
        hBox1 = new HBox();
        label1 = new Label();
        txtPass = new PasswordField();
        lblErrorPass = new Label();
        btnLogin = new Button();
        recLogo = new Rectangle();
        logo= new Image("/assets/Group9.png");
        validEmail=false;
        validPass=false;

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(414.0);
        setStyle("-fx-background-color: black;");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setStyle("-fx-background-color: black;");

        label.setText("don\'t have an account?");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(14.0));

        lblSignIn.setText("sign in");
        lblSignIn.setTextFill(javafx.scene.paint.Color.valueOf("#433ff1"));
        lblSignIn.setFont(new Font(14.0));
        lblSignIn.setOnMousePressed(this::resgiter);
        HBox.setMargin(lblSignIn, new Insets(0.0, 0.0, 0.0, 10.0));
        setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setStyle("-fx-background-color: black;");

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(47.0);
        hBox0.setPrefWidth(374.0);

        label0.setPrefHeight(20.0);
        label0.setPrefWidth(75.0);
        label0.setText("Email : ");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(14.0));

        txtEmail.setOnKeyReleased(this::press);
        txtEmail.setPrefHeight(30.0);
        txtEmail.setPrefWidth(175.0);
        txtEmail.setFont(new Font(14.0));
        txtEmail.getStyleClass().add("txtField");

        lblEmailError.setPrefHeight(20.0);
        lblEmailError.setPrefWidth(250.0);
        lblEmailError.setTextFill(javafx.scene.paint.Color.RED);
        lblEmailError.setFont(new Font(14.0));
        VBox.setMargin(lblEmailError, new Insets(5.0, 0.0, 10.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(49.0);
        hBox1.setPrefWidth(354.0);

        label1.setPrefHeight(20.0);
        label1.setPrefWidth(75.0);
        label1.setText("Password : ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(14.0));

        txtPass.setFont(new Font(14.0));
        txtPass.setOnKeyReleased(this::validPass);
        txtPass.getStyleClass().add("txtField");

        lblErrorPass.setPrefHeight(20.0);
        lblErrorPass.setPrefWidth(250.0);
        lblErrorPass.setTextFill(javafx.scene.paint.Color.RED);
        lblErrorPass.setFont(new Font(14.0));
        lblErrorPass.setPadding(new Insets(5.0, 0.0, 10.0, 0.0));

        btnLogin.setMaxHeight(20.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(0.0);
        btnLogin.setPrefWidth(100.0);
        btnLogin.setText("Login");
        btnLogin.setFont(new Font(14.0));
        btnLogin.setOnAction(this::login);
        btnLogin.getStyleClass().add("neon-button");
        btnLogin.setDisable(true);
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

        hBox.getChildren().add(label);
        hBox.getChildren().add(lblSignIn);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(txtEmail);
        vBox.getChildren().add(hBox0);
        vBox.getChildren().add(lblEmailError);
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(txtPass);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(lblErrorPass);
        vBox.getChildren().add(btnLogin);

    }

    protected void login(ActionEvent event)
    {
        System.out.println("dsadsadsad");
    }
    protected  void press(javafx.scene.input.KeyEvent keyEvent)
    {
        String email="";
        String Pass="";
        email=txtEmail.getText();
        if(patternMatches(email,regexPattern))
        {
            lblEmailError.getStyleClass().removeAll("inValid");
            txtEmail.getStyleClass().removeAll("errorFeild");
            lblEmailError.setText("Valid Email");
            txtEmail.getStyleClass().add("validFeild");
            lblEmailError.getStyleClass().add("valid");
            validEmail=true;
                       

            
        
        }
        else
        {
            lblEmailError.getStyleClass().removeAll("valid");
            txtEmail.getStyleClass().removeAll("validFeild");
            lblEmailError.setText("Email inValid");
            txtEmail.getStyleClass().add("errorFeild");
            lblEmailError.getStyleClass().add("inValid");
            validEmail=false;
                        

        }
      if(validEmail && validPass)
      {
          btnLogin.setDisable(false);
      }
      else
      {
          btnLogin.setDisable(true);
      }
        

    }
    
    protected  void resgiter(MouseEvent event)
    {
        System.out.println("dsadsa");
    }
    protected  void validPass(javafx.scene.input.KeyEvent keyEvent)
    {
        
        String pass=txtPass.getText();
    
        if(pass.length()>=6)
        {
             lblErrorPass.getStyleClass().removeAll("inValid");
            txtPass.getStyleClass().removeAll("errorFeild");
            lblErrorPass.setText("Valid password");
            txtPass.getStyleClass().add("validFeild");
            lblErrorPass.getStyleClass().add("valid");
           validPass=true;
        }
        else
        {
            lblErrorPass.getStyleClass().removeAll("valid");
            txtPass.getStyleClass().removeAll("validFeild");
            lblErrorPass.setText("password inValid");
            txtPass.getStyleClass().add("errorFeild");
            lblErrorPass.getStyleClass().add("inValid");
            validPass=false;
        }
        if(validEmail && validPass)
      {
          btnLogin.setDisable(false);
      }
      else
      {
          btnLogin.setDisable(true);
      }
        

    }
public static boolean patternMatches(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
      .matcher(emailAddress)
      .matches();
}

}
