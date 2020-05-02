package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton Admin;

    @FXML
    private RadioButton Doc;

    @FXML
    private RadioButton Registr;

    @FXML
    private RadioButton Nurse;

    @FXML
    private TextField Patronymic;

    @FXML
    private TextField Name;

    @FXML
    private TextField Login;

    @FXML
    private TextField Password;

    @FXML
    private TextField Firstname;

    @FXML
    private Button SignUp;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        BackButton.setOnAction(actionEvent -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Login.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot ();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } );
        SignUp.setOnAction(event -> {
            String login = Login.getText().trim();
            DataBaseConnect dbConnect = new DataBaseConnect();
            User user = new User();
            user.setLogin(login);
            ResultSet result = dbConnect.getLogin(user);
            try {
                if (!result.next()) {
                    signUpNewUser();
                } else {
                    System.out.println("Пользователем с таким логином уже существует");
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
        private void signUpNewUser () {
            DataBaseConnect DBConnect = new DataBaseConnect();


            String post = "";
            if (Admin.isSelected())
                post = "Admin";
            else if (Doc.isSelected())
                post = "Doctor";
            else if (Nurse.isSelected())
                post = "Nurse";
            else if (Registr.isSelected())
                post = "Registrator";

            User user = new User(Firstname.getText(), Name.getText(), Patronymic.getText(), Login.getText(), Password.getText(), post);

            DBConnect.signUpUser(user);


        }
}