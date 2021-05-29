package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    public TextField username;
    public AnchorPane bodybg;
    public Text Teksti_Pa_tekst;
    @FXML
    private TextField password;
    @FXML
    public Button loginButton;

    private static String Username="admin";
    private static String Password="admin";

    public void onSubmitClick() {
        if (!username.getText().equals("") && !password.getText().equals("")) {
            Teksti_Pa_tekst.setVisible(false);
            if (username.getText().equals(Username) && password.getText().equals(Password)) {
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainpage.fxml")));
                    Stage mainStage = new Stage();
                    mainStage.setMinHeight(900);
                    mainStage.setMinWidth(1600);
                    mainStage.setTitle("Siguria në komunikacion");

                    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                    int width = gd.getDisplayMode().getWidth();
                    int height = gd.getDisplayMode().getHeight();

                    Scene scene = new Scene(root, width, height);
                    scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style_main_page.css")).toExternalForm());
                    mainStage.setScene(scene);
                    ((Label) root.lookup("#mylabel")).setText(username.getText());
                    mainStage.show();
                    closeLogin();
                } catch (Exception e) {
                    System.out.println("exception: " + e);
                }

        } else {
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setHeaderText("Kredencialet janë të gabuara");
            error.showAndWait();
        }
    }else {
            Teksti_Pa_tekst.setVisible(true);
        }
    }
    public void closeLogin() {
        loginButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      username.focusTraversableProperty();
    }
}
