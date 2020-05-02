package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class PatientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField Patronymic;

    @FXML
    private TextField Name;

    @FXML
    private TextField BirthDate;

    @FXML
    private TextField Insurance;

    @FXML
    private TextField FDiagnose;

    @FXML
    private TextField Anamnesis;

    @FXML
    private TextField Diagnostics;

    @FXML
    private TextField Treatment;

    @FXML
    private Button AddPatient;

    @FXML
    private RadioButton Male;

    @FXML
    private ToggleGroup Status;

    @FXML
    private RadioButton Female;

    @FXML
    private Button BackButton;

    @FXML
    private Button Card;

    @FXML
    void initialize() {
        BackButton.setOnAction(event ->{
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
    AddPatient.setOnAction(event ->{
        signUpNewPatient();
    });
    }
    private void signUpNewPatient(){
        DataBaseConnect DBConnect = new DataBaseConnect();
        String gender = "";
        if (Male.isSelected()) gender = "Male";
        else  if (Female.isSelected()) gender = "Female";
        Patient patient = new Patient(FirstName.getText(), Name.getText(), Patronymic.getText(), BirthDate.getText(), Insurance.getText(),
                FDiagnose.getText(), Anamnesis.getText(), Diagnostics.getText(), Treatment.getText(), gender);
        DBConnect.signUpPatient(patient);
    }

}
