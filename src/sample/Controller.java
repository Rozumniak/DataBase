package sample;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button SignIn_button;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {
            SignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SignUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        SignIn_button.setOnAction(event -> {
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();
            DataBaseConnect dbConnect = new DataBaseConnect();
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            ResultSet result = dbConnect.getUser(user);

            try {
                if (!result.next()) {
                    System.out.println("not login");
                } else {
                        System.out.println("login");
                        String firstname = result.getString(2);
                        String lastname = result.getString(3);
                        String patronymic = result.getString(4);
                        System.out.println(firstname + " " + lastname + " " + patronymic);

                    }
                } catch (SQLException e) {
                e.printStackTrace();
            }

        });
    }
}


