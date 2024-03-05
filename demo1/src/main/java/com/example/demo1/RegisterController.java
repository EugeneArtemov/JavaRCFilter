package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Email_fieldReg;

    @FXML
    private TextField Group_fieldReg;

    @FXML
    private TextField Login_fieldReg;

    @FXML
    private TextField Password_fieldReg;

    @FXML
    private Button authButton;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
        DBHandler dbHandler = new DBHandler();

        authButton.setOnAction(actionEvent -> {

            RegNewUser();

        });

    }

    private void RegNewUser() {
        DBHandler dbHandler = new DBHandler();


        String login = Login_fieldReg.getText();
        String email = Email_fieldReg.getText();
        String group = Group_fieldReg.getText();
        String password = Password_fieldReg.getText();

        User user = new User(login, email, group, password);

        dbHandler.RegUser(user);

    }

}

