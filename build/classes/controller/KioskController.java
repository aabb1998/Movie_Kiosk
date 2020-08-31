package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class KioskController extends Controller<Kiosk> {

  @FXML private Button quitBtn;
  
    
  @FXML
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }
  


    @FXML private void handleOpenAdmin(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());
    }

    @FXML private void handleOpenCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Catalogue Menu", new Stage());
    }
    
    @FXML private void handleOpenCustomerRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "Customer Record", new Stage());
    }

    @FXML private void handleOpenTopUpMenu(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml","Top Up Menu", new Stage());
    }
    
    @FXML private void handleOpenFavorites(ActionEvent event) throws Exception {
        ViewLoader.showStage(getKiosk(),"/view/FavouriteMovies.fxml", "Favourite Movies",new Stage());
    }
    
  @FXML
  public void handleQuit(ActionEvent event) {
      stage.close();
  }
  
}
