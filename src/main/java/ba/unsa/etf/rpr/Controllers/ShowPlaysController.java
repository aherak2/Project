package ba.unsa.etf.rpr.Controllers;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.PlaysException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ShowPlaysController {
    public static ObservableList<String> list;
    public static int brojac=0;
    @FXML
    public void initialize() {

    }
    public ObservableList<String>getList(){
        return this.list;
    }
    public int getBrojac(){
        return this.brojac;
    }
    public void PlayDesription(ActionEvent actionEvent) throws IOException {
        try{     Button numberButton = (Button) actionEvent.getTarget();
            Stage Secondstage=new Stage();
            FXMLLoader fl=new FXMLLoader(getClass().getResource("/fxml/Info.fxml"));
            Parent root =fl.load();
            InfoController noviprozor=fl.getController();
            noviprozor.setText(DaoFactory.playsDao().searchByPlayName(numberButton.getText()).toString());
            Secondstage.setTitle("Play description");
            Secondstage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
            Secondstage.show();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void buy(ActionEvent actionEvent) throws IOException, PlaysException {
        Button numberButton = (Button) actionEvent.getTarget();
        Stage secondstage=new Stage();
        FXMLLoader fl=new FXMLLoader(getClass().getResource("/fxml/BuyTickets.fxml"));
        Parent root=fl.load();
        BuyTicketsController buyTicketsController=fl.getController();
        buyTicketsController.setPrice(DaoFactory.playsDao().searchByPlayName(numberButton.getText()).get(0).getPrice());
        buyTicketsController.setName(numberButton.getText());
        secondstage.setTitle("Buy tickets");
        secondstage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        secondstage.show();
    }

}
