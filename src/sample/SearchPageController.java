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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SearchPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private TextField searchName;

    @FXML
    private Button searchButton;

    @FXML
    private Button addButton;

    @FXML
    private Text info1;

    @FXML
    private Button patient;

    @FXML
    void initialize() {
       searchButton.setOnAction(event -> {
           String patientName = searchName.getText().trim();
           DataBaseConnect dataBaseConnect = new DataBaseConnect();
        Patient patient = new Patient();
        patient.setFirstname(patientName);
        ResultSet result1 = dataBaseConnect.patientSearch(patient);
           try {
               if (result1.next()) {
                   String firstname = result1.getString(2);
                   String lastname = result1.getString(3);
                   String birthDate = result1.getString(5);
                   String diagnose = result1.getString(7);
                  System.out.println(firstname +" "+ lastname +" "+ birthDate +" "+ diagnose);
                   info1.setText(firstname);
               }
           }catch (SQLException e) {
               e.printStackTrace();
           }


       });
       addButton.setOnAction(event -> {
           addButton.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("PatientSignUp.fxml"));
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



    }
}
