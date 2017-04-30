package controller;

import Main.Profile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static Main.BuildStage.*;

public class ControllerAutorization implements Initializable {
    @FXML Pane paneSignIn;
    @FXML Pane paneSignUp;
    @FXML Pane luckSignIn;
    @FXML Pane luckSignUp;
    @FXML Text textErrorSignUp;
    @FXML Text textErrorSignIn;
    @FXML TextField textFieldSignIn;
    @FXML TextField textFieldNewName;
    @FXML TextField textFieldNewNameRepeat;
    @FXML PasswordField passwordFieldSignIn;
    @FXML PasswordField passwordFieldNewPassword;
    @FXML PasswordField passwordFieldNewPasswordRepeat;
    @FXML Button buttonSignIn;
    @FXML Button buttonSignUp;
    @FXML Button buttonSignUpToSignIn;
    @FXML Button buttonSignUpOK;
    @FXML ImageView buttonOffBackToMenu;
    @FXML ImageView buttonOnBackToMenu;
    @FXML ImageView panelSignIn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

            //1. Фон:
            panelSignIn.setOnMouseMoved(event -> {
                buttonOnBackToMenu.setVisible(false);
                buttonOffBackToMenu.setVisible(true);
            });
            // Кнопка "Назад в меню"
            buttonOffBackToMenu.setOnMouseMoved(event -> {
                buttonOffBackToMenu.setVisible(false);
                buttonOnBackToMenu.setVisible(true);
            });
            buttonOnBackToMenu.setOnMouseClicked(event -> {
                try {
                    azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml")), 1280, 720));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                profileController = 0;
                azironStage.show();
            });
            //Кнопка "Регистрация"
            buttonSignUp.setOnMouseClicked(event -> {
            paneSignIn.setVisible(false);
            paneSignUp.setVisible(true);
            });
            buttonSignUpToSignIn.setOnMouseClicked(event -> {
                paneSignIn.setVisible(true);
                paneSignUp.setVisible(false);
            });
            //Кнопка "Вход":
            buttonSignIn.setOnMouseClicked(event -> {
                    try {
                        System.out.println("profile: " + profile.getName());
                        System.out.println("поле: " + textFieldSignIn.getText());
                        if ((textFieldSignIn.getText()).equals(profile.getName())){
                            throw new IllegalArgumentException("Такой пользователь уже авторизован");
                        }
                        System.out.println(textFieldSignIn.getText() + ".hoa");
                        BufferedReader bufferedReader = new BufferedReader(new FileReader( new File("src\\Profiles\\" + textFieldSignIn.getText() + ".hoa")));
                        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
                        if (lines.size() != 8) {
                            throw new IllegalArgumentException();
                        }
                        System.out.println("size");
                        if (!textFieldSignIn.getText().equals(lines.get(0))){
                            throw new IllegalArgumentException();
                        }
                        System.out.println("login");
                        if (!passwordFieldSignIn.getText().equals(lines.get(1))){
                            throw new IllegalArgumentException();
                        }
                        System.out.println(passwordFieldSignIn.getText());
                        String[] parts = lines.get(2).split("/");
                        if (Byte.parseByte(parts[0]) > 20 || Byte.parseByte(parts[0]) < 1 || Integer.parseInt(parts[1]) < 0 || Integer.parseInt(parts[1]) > 5000){
                            throw new IllegalArgumentException();
                        }
                        System.out.println("rank");

                        if (Integer.parseInt(lines.get(3)) < 0 || Integer.parseInt(lines.get(4)) < 0 ||
                                Integer.parseInt(lines.get(5)) < 0 || Integer.parseInt(lines.get(6)) < 0 ||
                                Integer.parseInt(lines.get(7)) < 0 ||
                        Integer.parseInt(lines.get(3)) != Integer.parseInt(lines.get(5)) + Integer.parseInt(lines.get(6)) + Integer.parseInt(lines.get(7))){
                            throw new IllegalArgumentException();
                        }
                        System.out.println("wins");
                        profile = new Profile(lines.get(0), Byte.parseByte(parts[0]), Integer.parseInt(parts[1]),
                                Integer.parseInt(lines.get(3)), Integer.parseInt(lines.get(4)), Integer.parseInt(lines.get(5)),
                                Integer.parseInt(lines.get(6)), Integer.parseInt(lines.get(7)));
                        profileController++;
                        try {
                            azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowProfile.fxml")), 1280, 720));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        azironStage.show();

                    } catch (Exception e) {
                        if (e.getMessage().equals("Такой пользователь уже авторизован")){
                            textErrorSignIn.setText(e.getMessage());
                        }else {
                            textErrorSignIn.setText("Неверное имя пользователя или пароль");
                        }
                    }
            });
            //Кнопка: "Зарегистрироваться"
            buttonSignUpOK.setOnMouseClicked(event -> {
                try {
                    if (!textFieldNewName.getText().equals(textFieldNewNameRepeat.getText())){
                        throw new IllegalArgumentException("Имя пользователя не совпадает с текущим");
                    }
                    if (textFieldNewName.getText().equals("")){
                        throw new IllegalArgumentException("Заполните поля с именем пользователя");
                    }
                    System.out.println("Name+");
                    if (!passwordFieldNewPassword.getText().equals(passwordFieldNewPasswordRepeat.getText())){
                        throw new IllegalArgumentException("Пароль пользователя не совпадает с текущим");
                    }
                    System.out.println("Password+");
                    if (new File("src\\Profiles\\" + textFieldNewName.getText() + ".hoa").canRead()){
                        throw new IllegalArgumentException("Такой профиль уже существует");
                    }
                    System.out.println("Профиль+");
                    File newProfile = new File("src\\Profiles\\" + textFieldNewName.getText() + ".hoa");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newProfile));
                    List<String> profileList = Arrays.asList(
                            textFieldNewName.getText(),
                            passwordFieldNewPassword.getText(),
                            "1/0",
                            "0",
                            "0",
                            "0",
                            "0",
                            "0"
                    );
                    int i = 0;
                    for (String line: profileList) {
                        bufferedWriter.write(line);
                        i++;
                        if (i < profileList.size()) bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    System.out.println("Готово+");
                    paneSignUp.setVisible(false);
                    luckSignUp.setVisible(true);
                    //Пауза...
                    luckSignUp.setVisible(false);
                    paneSignIn.setVisible(true);
                } catch (Exception e){
                    textErrorSignUp.setText(e.getMessage());
                }
            });
    }
}
