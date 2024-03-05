package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.demo1.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authButton;

    @FXML
    private TextField Login_fieldLog;

    @FXML
    private TextField Password_fieldLog;

    @FXML
    private Button regButton;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {

        authButton.setOnAction(actionEvent -> {
            String loginText = Login_fieldLog.getText().trim();
            String loginPassword = Password_fieldLog.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and password is empty");

        });

        regButton.setOnAction(actionEvent -> {
            regButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/demo1/Register.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    }

    private void loginUser(String loginText, String loginPassword) {
        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter >=1){



        }
        else {
            Shake userLoginAnim = new Shake(Login_fieldLog);
            Shake userPasswordAnim = new Shake(Password_fieldLog);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
        }
    }

}
