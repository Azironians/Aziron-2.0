package controller;

import GulkinInterface.Profile;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static Main.BuildStage.azironStage;
import static Main.BuildStage.profile1;
import static Main.BuildStage.profile2;
import static Main.BuildStage.profileController;

public class ControllerAutorization implements Initializable {
    @FXML Pane paneSignIn;
    @FXML Pane paneSignUp;
    @FXML Pane luckSignIn;
    @FXML Pane luckSignUp;
    //1. Панель входа:
    @FXML Text textSignInMessage;
    @FXML TextField textFieldSignIn;
    @FXML PasswordField passwordFieldSignIn;
    @FXML Button buttonSignIn;
    @FXML Button buttonSignUp;
    @FXML Button buttonSignUpToSignIn;
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
            buttonSignIn.setOnMouseClicked(event -> {
                    try {
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
                        switch (profileController) {
                            case 1:
                                profile1 = new Profile(lines.get(0), Byte.parseByte(parts[0]), Integer.parseInt(parts[1]),
                                        Integer.parseInt(lines.get(3)), Integer.parseInt(lines.get(4)), Integer.parseInt(lines.get(5)),
                                        Integer.parseInt(lines.get(6)), Integer.parseInt(lines.get(7)));
                                break;
                            case 2:
                                profile2 = new Profile(lines.get(0), Byte.parseByte(parts[0]), Integer.parseInt(parts[1]),
                                        Integer.parseInt(lines.get(3)), Integer.parseInt(lines.get(4)), Integer.parseInt(lines.get(5)),
                                        Integer.parseInt(lines.get(6)), Integer.parseInt(lines.get(7)));
                                break;
                        }
                        paneSignIn.setVisible(false);
                        luckSignIn.setVisible(true);

                    } catch (Exception e) {
                        textSignInMessage.setText("Неверное имя пользователя или пароль");
                    }
























    });
    }
}
