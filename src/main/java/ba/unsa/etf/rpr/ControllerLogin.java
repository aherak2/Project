package ba.unsa.etf.rpr;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ControllerLogin {
    public Label labels;
    public TextField fieldUsername;
    @FXML
    public void initialize() {
        fieldUsername.getStyleClass().add("poljeNijeIspravno");
        fieldUsername.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                 if (fieldUsername.getText().trim().isEmpty()) {
                     fieldUsername.getStyleClass().removeAll("poljeJeIspravno");
                     fieldUsername.getStyleClass().add("poljeNijeIspravno");
                 } else {
                     fieldUsername.getStyleClass().removeAll("poljeNijeIspravno");
                     fieldUsername.getStyleClass().add("poljeJeIspravno");
                 }
             }
         });

}



    public void ButtonClick(ActionEvent actionEvent) throws IOException {
       try{ if (fieldUsername.getText().isEmpty()){
            return;
        }
        Stage Secondstage=new Stage();
        FXMLLoader fl=new FXMLLoader(getClass().getResource("/fxml/noviProzor.fxml"));
        Parent root =fl.load();
        noviProzor noviprozor=fl.getController();
        noviprozor.labels.setText(noviprozor.labels.getText()+fieldUsername.getText());
        Secondstage.setTitle("Log in");
       Secondstage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        //Alert alert=new Alert(Alert.AlertType.INFORMATION);
        //alert.setTitle("Pozdrav");
        //alert.show();
Secondstage.show();}
       catch(Exception e){
           System.out.println(e);
       }
    }
    public void zatvoriProzorPropuhJe(ActionEvent actionEvent) {
        Stage stage = (Stage) labels.getScene().getWindow();
        stage.close();
    }

}