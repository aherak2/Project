package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.business.PlaysManager;
import ba.unsa.etf.rpr.exceptions.PlaysException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Controller for ticket sales and description
 * @author Adna Herak
 */
public class ShowPlaysController {
 RegisterController m1;
    LoginController m2;
    PlaysManager playsManager=new PlaysManager();

    public void setM1(RegisterController m1) {
        this.m1 = m1;
    }

    public void setM2(LoginController m2) {
        this.m2 = m2;
    }

    /**
     * opening new window with the description of the selected play
     * @param actionEvent
     * @throws IOException
     */
    public void PlayDesription(ActionEvent actionEvent) throws IOException {
        try{     Button numberButton = (Button) actionEvent.getTarget();
            Stage Secondstage=new Stage();
            FXMLLoader fl=new FXMLLoader(getClass().getResource("/fxml/Info.fxml"));
            Parent root =fl.load();
            InfoController noviprozor=fl.getController();
            noviprozor.setText(playsManager.searchByPlayName(numberButton.getText()).toString());
            Secondstage.setTitle("Play description");
            Secondstage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
            Secondstage.setResizable(false);
            Secondstage.show();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * opening new window to buy tickets
     * firstly it checks if the person has logged in or is registered
     * if not it does not allow to buy tickets
     * @param actionEvent
     * @throws IOException
     * @throws PlaysException
     */
    public void buy(ActionEvent actionEvent) throws IOException, PlaysException {
     if(m1==null && m2==null){
         new Alert(Alert.AlertType.NONE,"You need to have an account and be logged in in order to buy tickets.", ButtonType.OK).show();
     }
     else if(m2.getU()==null){
         new Alert(Alert.AlertType.NONE,"You need to have an account and be logged in in order to buy tickets.", ButtonType.OK).show();
     }
      else{  Button numberButton = (Button) actionEvent.getTarget();
        Stage secondstage=new Stage();
        FXMLLoader fl=new FXMLLoader(getClass().getResource("/fxml/BuyTickets.fxml"));
        Parent root=fl.load();
        BuyTicketsController buyTicketsController=fl.getController();
        buyTicketsController.setPrice(playsManager.searchByPlayName(numberButton.getText()).get(0).getPrice());
        buyTicketsController.setName(numberButton.getText());
        secondstage.setTitle("Buy tickets");
        secondstage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        secondstage.setResizable(false);
        secondstage.show();}
    }

}
